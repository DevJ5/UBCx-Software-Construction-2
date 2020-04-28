package test;

import model.CoffeeMaker;
import model.exceptions.BeansAmountException;
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
    public void testBrew() {
        try {
            coffeeMaker.brew(2.5, 15);
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


}
