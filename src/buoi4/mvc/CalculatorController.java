package buoi4.mvc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class CalculatorController implements ActionListener {
    private CalcualtorView calcualtorViewRemote;

    CalculatorController(CalcualtorView calculatorViewRemote){
        this.calcualtorViewRemote = calculatorViewRemote;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField jTextFieldInput1 = calcualtorViewRemote.getjTextFieldInput1();
        JTextField jTextFieldInput2 = calcualtorViewRemote.getjTextFieldInput2();
        JLabel jLabelOutput = calcualtorViewRemote.getjLabelOutput();

        CalculatorModel calculatorModelRemote = calcualtorViewRemote.getCalculatorModelRemote();

        double num1 = Double.parseDouble(jTextFieldInput1.getText());
        double num2 = Double.parseDouble(jTextFieldInput2.getText());

        String command = e.getActionCommand();
        if (command.equals("ADD")) {
            calculatorModelRemote.add(num1, num2);
            double outputNum = calculatorModelRemote.getResult();
            jLabelOutput.setText("" + outputNum);
        } else if (command.equals("SUB")) {
            calculatorModelRemote.sub(num1, num2);
            double outputNum = calculatorModelRemote.getResult();
            jLabelOutput.setText("" + outputNum);
        }

    }


}
