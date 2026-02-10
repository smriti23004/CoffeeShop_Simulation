package Simulation;
import java.util.*;
public class Simulation {
    public static final List<Order> orderQueue = new LinkedList<>();
    public static Machine grill;
    public static Machine Fryer;
    public static Machine coffeeMaker;

    public static void main(String[] args) {

        int numCustomer = 5;
        int machinecap = 2;
        int numcooks = 2;

        //initialise machine
        grill = new Machine("Grill", Food.Burger, machinecap);
        Fryer = new Machine("Fryer", Food.Fries, machinecap);
        coffeeMaker = new Machine("CoffeeMaker", Food.Coffee, machinecap);

        //start cooks
        for (int i = 0; i < numcooks; i++) {
            new Thread(new Cook("Cook" + i)).start();
        }
        for (int i = 0; i < numCustomer; i++) {
            List<Food> items = Arrays.asList(Food.Burger, Food.Coffee);
            new Thread(new Customer("Customer " + i, items, i)).start();
        }

    }
}