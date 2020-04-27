package model.exceptions;

import model.exceptions.BeansAmountException;

public class NotEnoughBeansException extends BeansAmountException {

    public NotEnoughBeansException(double beans) {
        super(beans, "beans is not enough.");
    }
}
