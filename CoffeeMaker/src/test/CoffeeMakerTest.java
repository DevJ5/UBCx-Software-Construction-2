package test;

import model.CoffeeMaker;
import model.exceptions.BeansAmountException;
import model.exceptions.NoCupsRemainingException;
import model.exceptions.StaleCoffeeException;
import model.exceptions.WaterException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CoffeeMakerTest {
    private CoffeeMaker coffeeMaker;

    @BeforeEach
    public void setUp(){
        coffeeMaker = new CoffeeMaker();
    }

    @Test
    public void testContructor() {
        assertEquals(0, coffeeMaker.getCupsRemaining());
        assertEquals(0, coffeeMaker.getTimeSinceLastBrew());
    }

    @Test
    public void testBrewShouldPass() {
        try {
            succesfulBrew();
            coffeeMaker.brew(2.4, 15);
            coffeeMaker.brew(2.6, 15);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testNotEnoughBeans(){
        try {
            coffeeMaker.brew(2.3, 15);
            fail("This should have thrown a not enough beans exception.");
        } catch (BeansAmountException beansException) {
            System.out.println(beansException.getMessage());
        }
    }

    @Test
    public void testTooManyBeans() {
        assertThrows(BeansAmountException.class, () -> coffeeMaker.brew(2.7, 15),
                     "This should have thrown a too many beans exception.");
    }

    @Test
    public void testNotEnoughWater() {
        assertThrows(WaterException.class, () -> coffeeMaker.brew(2.5, 14.75));
    }

    @Test
    public void testPourCoffeeShouldPass() {
        try {
            succesfulBrew();
            coffeeMaker.pourCoffee();
            assertEquals(19, coffeeMaker.getCupsRemaining());
            coffeeMaker.setTimeSinceLastBrew(59);
            coffeeMaker.pourCoffee();
            assertEquals(18, coffeeMaker.getCupsRemaining());
        } catch (StaleCoffeeException | NoCupsRemainingException | BeansAmountException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testStaleCoffee() throws StaleCoffeeException, NoCupsRemainingException, BeansAmountException {
        succesfulBrew();
        coffeeMaker.pourCoffee();
        assertEquals(0, coffeeMaker.getTimeSinceLastBrew());
        coffeeMaker.setTimeSinceLastBrew(60);
        assertThrows(StaleCoffeeException.class, () -> coffeeMaker.pourCoffee());
    }

    @Test
    public void testNoCupsRemaining() throws BeansAmountException, StaleCoffeeException, NoCupsRemainingException {
        assertThrows(NoCupsRemainingException.class, () -> coffeeMaker.pourCoffee());
        succesfulBrew();
        assertEquals(20, coffeeMaker.getCupsRemaining());
        pour20Cups();
        assertThrows(NoCupsRemainingException.class, () -> coffeeMaker.pourCoffee());
    }

    public void succesfulBrew() throws BeansAmountException, WaterException {
        coffeeMaker.brew(2.5, 15);
    }

    public void pour20Cups() throws StaleCoffeeException, NoCupsRemainingException {
        for (int i = 0; i < 20; i++) {
            coffeeMaker.pourCoffee();
        }
    }
}
