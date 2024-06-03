package buoi3.swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcualtorWindow extends JFrame implements ActionListener {

    // field
    private String title;
    private JPanel jPanel;
    private JLabel jLabelInput1, jLabelInput2, jLabelOutput;
    private JTextField jTextFieldInput1, jTextFieldInput2;
    private JButton addButton, mulButton, subButton, divButton;

    // function ,method
    CalcualtorWindow() {
        buildPanel();
        add(jPanel);
        title = "Frame Viewer";
        setSize(400, 400);
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
        addButton.addActionListener(this);// this === Remote của Calculator Window
        subButton = new JButton("SUB");
        subButton.addActionListener(this);

        jPanel.add(jLabelInput1);
        jPanel.add(jTextFieldInput1);
        jPanel.add(jLabelInput2);
        jPanel.add(jTextFieldInput2);
        jPanel.add(jLabelOutput);
        jPanel.add(addButton);
        jPanel.add(subButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double num1 = Double.parseDouble(jTextFieldInput1.getText());
        double num2 = Double.parseDouble(jTextFieldInput2.getText());

        String command = e.getActionCommand();
        if (command.equals("ADD")) {
            double outputNum = num1 + num2;
            jLabelOutput.setText("" + outputNum);
        } else if (command.equals("SUB")) {
            double outputNum = num1 - num2;
            jLabelOutput.setText("" + outputNum);
        }

    }

}
