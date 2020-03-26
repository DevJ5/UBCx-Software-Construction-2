package model.exceptions;

/**
 * WaterException
 */
public class WaterException extends Exception {
    private double cupsOfWater;

    public WaterException(double cupsOfWater) {
        super("Not enough water.");
        this.cupsOfWater = cupsOfWater;
    }
}