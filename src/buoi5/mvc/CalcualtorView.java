package buoi5.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import buoi5.mvc.command_processor.AddCommand;
import buoi5.mvc.command_processor.Command;
import buoi5.mvc.command_processor.CommandProcessor;
import buoi5.mvc.observer.Subcriber;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcualtorView extends JFrame implements Subcriber {

    // field
    private String title;
    private JPanel jPanel;
    private JLabel jLabelInput1, jLabelInput2, jLabelOutput;
    private JTextField jTextFieldInput1, jTextFieldInput2;
    private JButton addButton, mulButton, subButton, divButton;
    private CalculatorController calculatorControlRemote;
    private CalculatorModel calculatorModelRemote;
    private MenuController menuControllerRemote  = null;
    private JMenuBar menuBarRemote = null;
    private CommandProcessor commandProcessorRemote = null;

    // function ,method
    CalcualtorView() {
        commandProcessorRemote = CommandProcessor.makeCommandProcessor();
        calculatorModelRemote = new CalculatorModel();
        //dang doi tuong Subcriber voi Publisher
        calculatorModelRemote.subcribe(this);
        calculatorControlRemote = new CalculatorController();
        menuControllerRemote = new MenuController();
        buildMenu();

        buildPanel();
        add(jPanel);
        title = "Frame Viewer";
        setTitle(title);
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void buildPanel() {
        jPanel = new JPanel();
        jLabelInput1 = new JLabel("input1");
        jTextFieldInput1 = new JTextField(10);
        jLabelInput2 = new JLabel("input 2");
        jTextFieldInput2 = new JTextField(10);
        jLabelOutput = new JLabel("output:");
        addButton = new JButton("ADD");
        addButton.addActionListener(calculatorControlRemote);// this === Remote của Calculator Window
        subButton = new JButton("SUB");
        subButton.addActionListener(calculatorControlRemote);

        jPanel.add(jLabelInput1);
        jPanel.add(jTextFieldInput1);
        jPanel.add(jLabelInput2);
        jPanel.add(jTextFieldInput2);
        jPanel.add(jLabelOutput);
        jPanel.add(addButton);
        jPanel.add(subButton);

    }

    public void buildMenu() {
        //tạo object MenuBar
        menuBarRemote = new JMenuBar();
        //đặt MenuBar vào Cửa sổ JFrame
        setJMenuBar(menuBarRemote);
        //
        JMenu calMenuRemote = new JMenu("Calculator");
        //đặt menu vào MenuBar
        menuBarRemote.add(calMenuRemote);
        //ADD menu item
        JMenuItem addJMenuItemRemote = new JMenuItem("ADD");
        //đối tượng phát ra command, event, actions
        addJMenuItemRemote.addActionListener(menuControllerRemote);
        //đặt add menu item vào Menu
        calMenuRemote.add(addJMenuItemRemote);
    }

    class CalculatorController implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double num1 = Double.parseDouble(jTextFieldInput1.getText());
            double num2 = Double.parseDouble(jTextFieldInput2.getText());
            String command = e.getActionCommand();
            if (command.equals("ADD")) {
                calculatorModelRemote.add(num1, num2);//message
               
            } else if (command.equals("SUB")) {
                calculatorModelRemote.sub(num1, num2);
                double outputNum = calculatorModelRemote.getResult();
                jLabelOutput.setText("" + outputNum);
            }
    
        }
    }
    
    class MenuController implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            double num1 = Double.parseDouble(jTextFieldInput1.getText());
            double num2 = Double.parseDouble(jTextFieldInput2.getText());
            Command commandRemote = null;
            String command = e.getActionCommand();
            if (command.equals("ADD")) {
                commandRemote = new AddCommand(calculatorModelRemote, num1, num2);
                //calculatorModelRemote.add(num1, num2);//message
                commandProcessorRemote.execute(commandRemote);
            } else if (command.equals("SUB")) {
                calculatorModelRemote.sub(num1, num2);
                double outputNum = calculatorModelRemote.getResult();
                jLabelOutput.setText("" + outputNum);
            }
        }
        
    }

    @Override
    public void update() {
        double result = calculatorModelRemote.getResult();
        jLabelOutput.setText("" + result);
    }
}
