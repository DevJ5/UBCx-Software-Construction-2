package model.exceptions;

public class BeansAmountException extends Exception {
    private double beans;

    public BeansAmountException(double beans) {
        super(beans + " beans is not the correct amount");
        this.beans = beans;
    }

    protected BeansAmountException(double beans, String message) {
        super(beans + " " + message);
        this.beans = beans;
    }

    // getter
    public double getBeans() {
        return this.beans;
    }
}
