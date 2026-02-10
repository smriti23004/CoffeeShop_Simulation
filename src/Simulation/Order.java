package Simulation;
import java.util.List;
public class Order {
    public final int orderId;
    public final List<Food> items ;
    public boolean isCompleted = false;

    public Order(int orderId,List<Food>items){
        this.orderId=orderId;
        this.items=items;
    }
}
