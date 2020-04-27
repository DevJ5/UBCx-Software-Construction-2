package model.exceptions;

public class StaleCoffeeException extends Exception {
    private int timeSinceLastBrew;

    public StaleCoffeeException(int timeSinceLastBrew) {
        super(timeSinceLastBrew +  " " + "is too long ago, the coffee is stale.");
        this.timeSinceLastBrew = timeSinceLastBrew;
    }
}
