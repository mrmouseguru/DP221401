package buoi3.swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalcualtorWindow extends JFrame{

    //field
    private String title;
    private JPanel jPanel;
    private JLabel jLabelInput1, jLabelInput2, jLabelOutput;
    private JTextField jTextFieldInput1, jTextFieldInput2;
    private JButton addButton, mulButton, subButton, divButton;


    //function ,method
    CalcualtorWindow(){
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

        jPanel.add(jLabelInput1);
        jPanel.add(jTextFieldInput1);
        
    }

}
