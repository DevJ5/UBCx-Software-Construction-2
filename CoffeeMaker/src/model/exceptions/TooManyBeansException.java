package model.exceptions;

import model.exceptions.BeansAmountException;

public class TooManyBeansException extends BeansAmountException {
    public TooManyBeansException(double beans) {
        super(beans, "beans is too many.");
    }
}
