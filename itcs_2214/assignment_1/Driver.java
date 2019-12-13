import java.util.*;

public class Driver
{
    public static void main(String[] args)
    {
        /*int time = 0; //holds the amount of time that passes
        int custCount = 0; // number of customers serviced
        Random r = new Random(); 
        int addCust; //holds the value of a random number
        CustomerQueue cq = new CustomerQueue(); //creates customer queue
        Customer current; //current customer being serviced
        
        while(time <= 60)
        {
            addCust = r.nextInt(4) + 1;
            //adds a new customer if random value is 1
            if(addCust == 1)
            {
                cq.enqueue(new Customer());
                System.out.println("New customer added! Queue length is now " + cq.getLength());
            }
            current = cq.getHead(); //gets the customer to be serviced
            if(current != null) //checks if the customer exists
            {
                //goes through the service of the customer and removes them from the queue
                current.decServiceTime();
                if(current.getServiceTime() == 0)
                {
                    cq.dequeue();
                    custCount++;
                    System.out.println("Customer serviced and removed from the queue.  Quest length is now " + cq.getLength());
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
        System.out.println("Max queue length: " + cq.getMax());*/
        
        System.out.println(quest(330, 210));
    }
    public static int quest(int a, int b)
    {
        int rem = a % b;
        if (rem == 0)
            return b;
        else
        {
            a = b;
            b = rem;
            return quest(a, b);
        }
    }
}