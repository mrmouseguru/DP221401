package buoi5.ecb;

public class CalculatorEntity {
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
