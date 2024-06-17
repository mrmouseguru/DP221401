package buoi5.mvc;

import buoi5.mvc.observer.Publisher;

public class CalculatorModel extends Publisher{
    //field
    private double result;

    //method
    public void add(double a, double b) {
        this.result =  a + b;
    }

    public void sub(double a, double b){
        this.result =  a - b;
    }

    public double getResult() {
        return result;
    }

}
