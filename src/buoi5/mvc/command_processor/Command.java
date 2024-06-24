package buoi5.mvc.command_processor;

import buoi5.mvc.CalculatorModel;

public abstract class Command {
    //field
    protected CalculatorModel calculatorModelRemote = null;

    public Command(CalculatorModel calculatorModelRemote) {
        this.calculatorModelRemote = calculatorModelRemote;
    }



    public abstract void execute();

}
