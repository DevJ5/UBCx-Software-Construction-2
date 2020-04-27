package main;

import model.exceptions.StaleCoffeeException;
import model.exceptions.TooManyBeansException;
import model.Bear;
import model.exceptions.WaterException;

public class Main {

    public static void main(String[] args) {
        Bear Bobby = new Bear();
        System.out.println(Bobby.name);
        Bobby.roar();
        try {
            System.out.println(5/0);
            throw new StaleCoffeeException(10);
        } catch (RuntimeException | StaleCoffeeException e) {
            System.out.println(e.getMessage());
        }
    }


}