package buoi5.mvc.command_processor;

import buoi5.mvc.CalculatorModel;

public class AddCommand extends Command{

    //field
    private double num1;
    private double num2;

    public AddCommand(CalculatorModel calculatorModelRemote,
    double num1, double num2) {
        super(calculatorModelRemote);
        this.num1  = num1;
        this.num2 = num2;
    }

    @Override
    public void execute() {
        calculatorModelRemote.add(num2, num1);
    }

}
