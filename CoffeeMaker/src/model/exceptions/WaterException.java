package model.exceptions;

public class WaterException extends RuntimeException {
    private double amountOfWater;

    public WaterException(double amountOfWater) {
        super(amountOfWater + " " + "is not enough water.");
        this.amountOfWater = amountOfWater;
    }
}
