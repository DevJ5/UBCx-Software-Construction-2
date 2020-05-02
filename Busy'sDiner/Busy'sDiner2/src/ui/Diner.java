package ui;

import model.Chef;
import model.Dish;
import model.Server;
import model.Order;

import java.util.ArrayList;
import java.util.List;

public class Diner {

    public static void main(String[] args) {
        Dish dish = generateTurkeyClubSandwich();
        Server server = new Server(dish);
        Chef chef = new Chef();

        for (int i=0; i < 2 ; i++) {
            System.out.println("Table " + (i + 1) + ":\n");

            server.greet();
            server.describeDish(dish);
            Order order = server.takeOrder();

            System.out.println();
            chef.makeDish(order);

            doOrderRoutine(server, order);
            System.out.println();
        }

        System.out.println();
        chef.doDishes();
    }

    private static void doOrderRoutine(Server s, Order order) {
        System.out.println();
        if (order.isReadyToBeServed())
            s.deliverFood(order);
        if(order.isReadyToBePaid())
            s.takePayment(order);
    }

    private static Dish generateTurkeyClubSandwich() {
        List<String> ingredients = new ArrayList<>();
        ingredients.add("avocado");
        ingredients.add("sriracha");
        ingredients.add("cheddar cheese");
        ingredients.add("bread");
        ingredients.add("lettuce");
        ingredients.add("tomato");
        ingredients.add("turkey");
        ingredients.add("bacon");
        return new Dish("Turkey club sandwich",
                        "\"Our trendy sandwich has avocado, sriracha sauce, cheese, veggies, turkey and bacon.\"",
                        ingredients,
                        "\t1. Pour sriracha\n\t2. Spread avocado\n\t3. Stack meat\n\t4. Place veggies");
    }

}
