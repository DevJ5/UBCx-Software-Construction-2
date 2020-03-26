package model.exceptions;

public class BeansAmountException extends Exception {
    private double beans;


   public BeansAmountException(double beans) {
        super(beans + " is not the right amount of beans.");
        this.beans = beans;
    }
    // getter
    public double getBeans() {
        return this.beans;
    }
}  