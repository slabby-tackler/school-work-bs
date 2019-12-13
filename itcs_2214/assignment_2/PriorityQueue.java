public class PriorityQueue
{
    private PriorityCustomer[] pc;
    private int maxLength = 0;
    private int length = 0;
    
    public PriorityQueue()
    {
        pc = new PriorityCustomer[20];
        length = 0;
    }
    
    public void enqueue(PriorityCustomer c)
    {
        if(!isEmpty())
        {
            int index = length + 1;
            pc[index] = c;
            
            while(index > 1)
            {
                int childValue = pc[index].getPriority();
                int parentValue = pc[index / 2].getPriority();
                
                if(parentValue < childValue && index / 2 != 1)
                {
                    PriorityCustomer temp = pc[index / 2];
                    pc[index / 2] = pc[index];
                    pc[index] = temp;
                    index = index / 2;
                }
                else
                {
                    break;
                }
            }
        }
        else
        {
            pc[1] = c;
        }
        length++;
        if(maxLength < length)
        {
            maxLength = length; //set the new max length if needed
        }
    }
    
    public void dequeue()
    {
        int index = length;
        
        pc[1] = pc[index];
        pc[index] = null;
        index = 1;
        
        while(index * 2 < length)
        {
            int leftChild = pc[index * 2].getPriority();
            int rightChild = -1;
            
            if((index * 2) + 1 < length)
            {
                rightChild = pc[index * 2 + 1].getPriority();
            }
            
            if(pc[1].getPriority() < Math.max(leftChild, rightChild))
            {
                if(leftChild > rightChild)
                {
                    PriorityCustomer temp = pc[index * 2];
                    pc[index * 2] = pc[index];
                    pc[index] = temp;
                    index = index * 2;
                }
                else
                {
                    PriorityCustomer temp = pc[index * 2];
                    pc[index * 2 + 1] = pc[index];
                    pc[index] = temp;
                    index = index * 2 + 1;
                }
            }
            else
            {
                break;
            }
        }
        length--;
    }
    
    public int getLength()
    {
        return length;
    }
    
    public boolean isEmpty()
    {
        return pc[1] == null;
    }
    
    public PriorityCustomer getRoot()
    {
        return pc[1];
    }
    
    public int getMax()
    {
        return maxLength;
    }
}