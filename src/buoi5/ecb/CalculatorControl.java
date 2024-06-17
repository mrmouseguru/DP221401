package buoi5.ecb;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class CalculatorControl implements ActionListener {
    private CalcualtorBoundary calcualtorBoundaryRemote;
    private CalculatorEntity calculatorEntityRemote;


    CalculatorControl(CalcualtorBoundary calculatorBoundaryRemote){
        this.calcualtorBoundaryRemote = calculatorBoundaryRemote;
        calculatorEntityRemote = new CalculatorEntity();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField jTextFieldInput1 = calcualtorBoundaryRemote.getjTextFieldInput1();
        JTextField jTextFieldInput2 = calcualtorBoundaryRemote.getjTextFieldInput2();
        JLabel jLabelOutput = calcualtorBoundaryRemote.getjLabelOutput();


        double num1 = Double.parseDouble(jTextFieldInput1.getText());
        double num2 = Double.parseDouble(jTextFieldInput2.getText());

        String command = e.getActionCommand();
        if (command.equals("ADD")) {
            calculatorEntityRemote.add(num1, num2);//message
            double outputNum = calculatorEntityRemote.getResult();
            jLabelOutput.setText("" + outputNum);
        } else if (command.equals("SUB")) {
            calculatorEntityRemote.sub(num1, num2);
            double outputNum = calculatorEntityRemote.getResult();
            jLabelOutput.setText("" + outputNum);
        }

    }


}
