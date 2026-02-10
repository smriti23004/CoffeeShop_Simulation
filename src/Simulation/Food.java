package Simulation;

public class Food {
    public final String name;
    public final int cookTime;

    public Food(String name,int cookTime){
        this.name=name;
        this.cookTime= cookTime;
    }

    public static final Food Burger = new Food("Burger",600);
    public static  final Food Fries =new Food("Fries",450);
    public static final Food Coffee =new Food("Coffee",150);

}
