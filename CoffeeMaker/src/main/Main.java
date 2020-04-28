package main;

import model.CoffeeMaker;
import model.exceptions.BeansAmountException;
import model.exceptions.NoCupsRemainingException;
import model.exceptions.StaleCoffeeException;
import model.exceptions.WaterException;

public class Main {

    public static void main(String[] args) {
        // Dummy code
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        try {
            coffeeMaker.brew(2.4, 50);
            coffeeMaker.pourCoffee();
            assert(coffeeMaker.getCupsRemaining() == 19);
        } catch (BeansAmountException beansException) {
            System.out.println(beansException.getMessage());
        } catch (WaterException waterException) {

        } catch (NoCupsRemainingException cupsException) {

        } catch (StaleCoffeeException staleException) {

        }
    }


}