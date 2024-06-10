package buoi4.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcualtorView extends JFrame {

    // field
    private String title;
    private JPanel jPanel;
    private JLabel jLabelInput1, jLabelInput2, jLabelOutput;
    private JTextField jTextFieldInput1, jTextFieldInput2;
    private JButton addButton, mulButton, subButton, divButton;
    private CalculatorModel calculatorModelRemote;
    private CalculatorController calculatorControllerRemote;

    public JLabel getjLabelOutput() {
        return jLabelOutput;
    }

    public CalculatorModel getCalculatorModelRemote() {
        return calculatorModelRemote;
    }
    public JTextField getjTextFieldInput1() {
        return jTextFieldInput1;
    }

    public JTextField getjTextFieldInput2() {
        return jTextFieldInput2;
    }

    // function ,method
    CalcualtorView() {
        calculatorModelRemote = new CalculatorModel();
        calculatorControllerRemote = new CalculatorController(this);
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
        addButton.addActionListener(calculatorControllerRemote);// this === Remote của Calculator Window
        subButton = new JButton("SUB");
        //subButton.addActionListener(this);

        jPanel.add(jLabelInput1);
        jPanel.add(jTextFieldInput1);
        jPanel.add(jLabelInput2);
        jPanel.add(jTextFieldInput2);
        jPanel.add(jLabelOutput);
        jPanel.add(addButton);
        jPanel.add(subButton);

    }

   
}
