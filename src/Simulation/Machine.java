package Simulation;

public class Machine {
    public final String machineName;
    public final Food foodType;
    private final int capacity ;
    private  int currentLoad =0;

    public Machine(String machineName,Food foodType,int capacity){
        this.machineName=machineName;
        this.foodType=foodType;
        this.capacity=capacity;
    }
    public synchronized  void cook() throws InterruptedException{
        while(currentLoad>=capacity){
            wait();
        }
        currentLoad++;
        System.out.println(machineName+" is cooking "+ foodType.name);

        Thread.sleep(foodType.cookTime); // this is where cooking happens

        currentLoad--;
        System.out.println(machineName + "has finished"+ foodType.name);
        notifyAll(); //signal other cooks that machine is free

    }
}
