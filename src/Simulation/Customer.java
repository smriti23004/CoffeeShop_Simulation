package Simulation;
import java.util.List;

public class Customer implements Runnable {
    public final String name;
    public final List<Food> orderItems;
    public final Order myOrder;

    public Customer(String name , List<Food> orderItems,int id){
        this.name=name;
        this.orderItems=orderItems;
        this.myOrder= new Order(id,orderItems);
    }
    @Override
   public  void run(){
        System.out.println(name+ " placed an order");

        synchronized (Simulation.orderQueue){
            Simulation.orderQueue.add(myOrder);
            Simulation.orderQueue.notifyAll(); //wake up the cook
        }

        synchronized (myOrder){
            while(!myOrder.isCompleted){
                try{
                    myOrder.wait();
                }catch (InterruptedException e){}
            }
        }
        System.out.println(name+ "received their order");
    }
}
