package buoi4;

public class Calculator {
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
