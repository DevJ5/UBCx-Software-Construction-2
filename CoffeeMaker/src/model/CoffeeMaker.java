package model;

import model.exceptions.*;

import java.beans.Beans;

/**
 * A coffee maker used to train baristas.
 *
 * Class invariant: cups remaining >= 0, time since last brew >= 0
 */

public class CoffeeMaker {
    private int cupsRemaining;
    private int timeSinceLastBrew;

    public CoffeeMaker(){
        this.cupsRemaining = 0;
        this.timeSinceLastBrew = 0;
    }

    //MODIFIES: this
    //EFFECTS: sets cups remaining to full (20 cups) and time since last brew to 0
    //          throws BeansAmountException if beans are not between 2.4 and 2.6
    //          throws WaterException if water <= 14.75
    public void brew(double beans, double water) throws BeansAmountException, WaterException {
        if (beans < 2.40) throw new NotEnoughBeansException(beans);
        else if (beans > 2.60) throw new TooManyBeansException(beans);
        else if (water <= 14.75) throw new WaterException(water);

        this.cupsRemaining = 20;
        this.timeSinceLastBrew = 0;
    }

    //MODIFIES: this
    //EFFECTS: subtracts one cup from cups remaining
    //          throws NoCupsRemainingException when cupsRemaining <= 0
    //          throws StaleCoffeeException when timeSinceLastBrew >= 60
    public void pourCoffee() throws StaleCoffeeException, NoCupsRemainingException {
        if (this.cupsRemaining <= 0) throw new NoCupsRemainingException();
        else if (this.timeSinceLastBrew >= 60) throw new StaleCoffeeException(timeSinceLastBrew);

        this.cupsRemaining -= 1;
    }

    // EFFECTS: return true if there are coffee cups remaining
    public boolean areCupsRemaining() {
        return this.cupsRemaining > 0;
    }

    // getters

    public int getTimeSinceLastBrew() {
        return this.timeSinceLastBrew;
    }
    public int getCupsRemaining() {
        return this.cupsRemaining;
    }

    // setters

    //REQUIRES: a non-negative integer
    //MODIFIES: this
    //EFFECTS: sets time since last brew
    public void setTimeSinceLastBrew(int time) {
        // Exception ?
        this.timeSinceLastBrew = time;
    }
}
