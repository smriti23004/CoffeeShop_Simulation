package Simulation;


public class Cook implements  Runnable {
    public final String name;

    public Cook(String name){
        this.name = name;
    }
    @Override
    public void run(){
        try{
            while(true){
                Order order;
                synchronized (Simulation.orderQueue){
                    while(Simulation.orderQueue.isEmpty()){
                        Simulation.orderQueue.wait();
                    }
                    order = Simulation.orderQueue.remove(0);
                }
                System.out.println( name + "Started order #"+ order.orderId);

                for(Food item : order.items){
                    if(item.name.equals("Burger")) Simulation.grill.cook();
                    if(item.name.equals("Fries"))Simulation.Fryer.cook();
                    if(item.name.equals("Coffee")) Simulation.coffeeMaker.cook();
                }

                //notify the customer
                synchronized (order){
                    order.isCompleted=true;
                    order.notifyAll();
                }

            }
        }catch (InterruptedException e){
            System.out.println(name+ "is going home");
        }
    }
}
