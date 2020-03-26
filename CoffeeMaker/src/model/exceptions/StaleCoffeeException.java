package model.exceptions;

/**
 * StaleCoffeeException
 */
public class StaleCoffeeException extends Exception {
    private int timeLastBrew;

    public StaleCoffeeException(int timeLastBrew) {
        super("The coffee has been sitting for too long.");
        this.timeLastBrew = timeLastBrew;
    }

    // getter
    public int getTimeLastBrew() {
        return timeLastBrew;
    }
}