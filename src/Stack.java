
/**
 * This Stack class uses LinkedLists to reference the next object in the stack
 *
 * @param <T> the data type of the value inside the stack
 */
public class Stack<T> {

    //Fields-------------------------------------------------------------------------------------
    
    private int size;
    
    /**
     * LinkedList to use to keep track of elements
     */
    public LinkedList<T> element;
    
    
    //Constructor------------------------------------------------------------------------------
    /**
     * Default constructor
     */
    public Stack() 
    {
        element = new LinkedList<T>();
        size = 0;
    }
    
    //Methods----------------------------------------------------------------------------------
    /**
     * Checks if the stack is empty.
     * @return Returns true if the stack is empty.
     */
    public boolean isEmpty() {
        return this.element.size() == 0;
    }
    
    /**
     * Get the size
     * @return size
     */
    public int getSize() 
    {
        //return size;
        return this.element.size();
    }
    /**
     * This method pushes a given integer to the top of the stack
     * @param newEntry 
     */
    public void push(T newEntry)
    {
        this.element.addToFront(newEntry);
        
        size++;
    }
    
    /**
     *This method checks the top of the stack without removing the integer
     * @return the integer on top of the stack
     */
    public T peek()
    {
        if (!(isEmpty()))
        {
            //return top;
            
            return this.element.getHead().getNext().getData();
        }
        else
        {
            return null;
        }
    }
    
    /**
     * This methods removes and returns the integer of the top node
     * @return the integer on top of the stack
     */
    public T pop()
    {
        if (isEmpty())
        {
            return null;
        }
        else 
        {
            T temp  = element.getHead().getNext().getData();
            this.element.remove();
            this.size--;
            return temp;
        }
        
    }
}
