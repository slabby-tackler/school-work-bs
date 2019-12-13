public class CustomerQueue
{
    private Customer head;
    private Customer tail;
    private int length;
    private int maxLength = 0;
    
    public CustomerQueue()
    {
        head = null;
        tail = null;
        length = 0;
    }
    
    public void enqueue(Customer c)
    {
        if(!isEmpty())
        {
            tail.setNext(c);
            tail = c;
        }
        else
        {
            head = c;
            tail = c;
        }
        length++;
        if(maxLength < length)
        {
            maxLength = length; //set the new max length if needed
        }
    }
    
    public void dequeue()
    {
        head = head.getNext();
        length--;
    }
    
    public int getLength()
    {
        return length;
    }
    
    public boolean isEmpty()
    {
        return head == null;
    }
    
    public Customer getHead()
    {
        return head;
    }
    
    public int getMax()
    {
        return maxLength;
    }
}