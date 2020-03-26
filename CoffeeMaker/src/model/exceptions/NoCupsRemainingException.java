package model.exceptions;

/**
 * NoCupsRemainingException
 */
public class NoCupsRemainingException extends Exception {
    public NoCupsRemainingException() {
        super("There are no cups remaining");
    }
}