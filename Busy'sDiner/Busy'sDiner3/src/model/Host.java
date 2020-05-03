package model;

import java.util.List;

public class Host extends Employee {
    // A Host greets customers, brings them to their table, describes the menu and delivers food.
    // private static final String ERROR = "ERROR!! ";
    private static final String PREFIX = "HOST - ";

    public Host(Dish dish) {
        super(dish);
    }

    @Override
    public String getPrefix() {
        return PREFIX;
    }
}
