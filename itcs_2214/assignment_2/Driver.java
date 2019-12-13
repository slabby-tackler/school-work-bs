import java.util.*;

public class Driver
{
    public static void main(String[] args)
    {
        int time = 0; //holds the amount of time that passes
        int custCount = 0; // number of customers serviced
        Random r = new Random(); 
        int addCust; //holds the value of a random number
        PriorityQueue pq = new PriorityQueue(); //creates customer queue
        PriorityCustomer current; //current customer being serviced
        
        while(time < 60)
        {
            addCust = r.nextInt(4) + 1;
            //adds a new customer if random value is 1
            if(addCust == 1)
            {
                pq.enqueue(new PriorityCustomer());
                System.out.println("New customer added! Queue length is now " + pq.getLength());
            }
            current = pq.getRoot(); //gets the customer to be serviced
            if(current != null) //checks if the customer exists
            {
                //goes through the service of the customer and removes them from the queue
                current.decServiceTime();
                if(current.getServiceTime() == 0)
                {
                    pq.dequeue();
                    custCount++;
                    System.out.println("Customer serviced and removed from the queue.  Queue length is now " + pq.getLength());
                }
            }
            //print time line
            for(int i = 0; i < time; i++)
            {
                System.out.print("-");
            }
            System.out.println();
            time++; //increments time
        }
        System.out.println("Total customers serviced: " + custCount);
        System.out.println("Max queue length: " + pq.getMax());
        
    }
}