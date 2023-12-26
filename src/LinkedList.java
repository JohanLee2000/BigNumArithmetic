
/**
 * This LinkedList class uses sentinel nodes for the head and tail
 * 
 * @param <T> the data value type
 */
public class LinkedList<T> {

  
    
    //Fields--------------------------------------------------------------------------------------------------
    /**
     * How many nodes are in the list
     */
    private int size;

    /**
     * The first node in the list. THIS IS A SENTINEL NODE AND AS SUCH DOES NOT
     * HOLD ANY DATA
     */
    private Node<T> head;

    /**
     * The last node in the list. THIS IS A SENTINEL NODE AND AS SUCH DOES NOT
     * HOLD ANY DATA
     */
    private Node<T> tail;

    //Constructor---------------------------------------------------------------------------------------------
    /**
     * Create a new DLList object.
     */
    public LinkedList() 
    {
        head = new Node<T>(null);
        tail = new Node<T>(null);
        head.setNextNode(tail);
        tail.setPrevNode(head);
        size = 0;
    }




    //Methods--------------------------------------------------------------------------------------
    /**
     * Checks if the array is empty
     *
     * @return true if the array is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Gets the number of elements in the list
     *
     * @return the number of elements
     */
    public int size() {
        return size;
    }
    
    /**
     * This method returns the head
     * @return 
     */
    public Node<T> getHead()
    {
        return head;
    }
    
    /**
     * This method returns the tail
     * @return 
     */
    public Node<T> getTail()
    {
        return tail;
    }


    /**
     * Removes all of the elements from the list
     */
    public void clear() {
        head = new Node<T>(null);
        tail = new Node<T>(null);
        head.setNextNode(tail);
        tail.setPrevNode(head);
        size = 0;
    }
    

    /**
     * Checks if the list contains the given object
     *
     * @param obj
     *            the object to check for
     * @return true if it contains the object
     */
    public boolean contains(T obj) {
        return lastIndexOf(obj) != -1;
    }


    /**
     * Gets the object at the given position
     *
     * @param index
     *            where the object is located
     * @return The object at the given position
     * @throws IndexOutOfBoundsException
     *             if there no node at the given index
     */
    public T get(int index) {
        return getNodeAtIndex(index).getData();
    }


    /**
     * This method pushes a given integer to the top of the stack
     * @param newEntry the new data to be stored
     */
    public void addToFront(T newEntry)
    {
        Node<T> temp = new Node<T>(newEntry);
        if (isEmpty()) 
        {
            head.setNextNode(temp);
            temp.setPrevNode(head);
            temp.setNextNode(tail);
            tail.setPrevNode(temp);
        
        }
        else 
        {
            Node<T> movedElement = head.getNext();
            head.setNextNode(temp);
            temp.setPrevNode(head);
            temp.setNextNode(movedElement);
            movedElement.setPrevNode(temp);
        }
        size++;
    }

    /**
     * This method gets the node at that index
     * 
     * @param index the index to reference
     * @return node at index
     */
    private Node<T> getNodeAtIndex(int index) {
        if (index < 0 || size() <= index) {
            throw new IndexOutOfBoundsException("No element exists at "
                + index);
        }
        Node<T> current = head.getNext(); // as we have a sentinel node
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    /**
     * Gets the last time the given object is in the list
     *
     * @param obj
     *            the object to look for
     * @return the last position of it. -1 If it is not in the list
     */
    public int lastIndexOf(T obj) {
        /*
         * We should go from the end of the list as then we an stop once we find
         * the first one
         */
        Node<T> current = tail.getPrev();
        for (int i = size() - 1; i >= 0; i--) {
            if (current.getData().equals(obj)) {
                return i;
            }
            current = current.getPrev();
        }
        return -1; // if we do not find it
    }


    /**
     * This method returns a string of the doubly linked list
     *  @return a string representation of the list
     */
    public String toString()
    {
        
        if (this.isEmpty())
        {
            return "[empty]";
        }
        
        Node<T> curr = head.getNext();
        StringBuilder retVal = new StringBuilder(" head <=> ");
        
        while (curr != this.tail)
        {
            T element = curr.getData();
            retVal.append(element.toString());
            retVal.append(" <=> ");
            curr = curr.getNext();
        }
        retVal.append(" tail ");
        return retVal.toString();
    }
    
    
    /** 
     * This method prints out a number as a string
     * @return the string representation of the number
     */
    public String toLargeNumber()
    {
        if (this.isEmpty())
        {
            return "no number";
        }
        
        Node<T> curr = tail.getPrev();
        StringBuilder retVal = new StringBuilder("");
        
        while (curr != this.head)
        {
            T element = curr.getData();
            retVal.append(element.toString());
            curr = curr.getPrev();
        }
        return retVal.toString();
    }
    
    /**
     * This method adds value to the end
     * @param value the data value to be added
     */
    public void addValueToEnd(T value)
    {
        
        Node<T> temp = new Node<T>(value);
        if(isEmpty())
        {
            tail.setPrevNode(temp);
            temp.setNextNode(tail);
            temp.setPrevNode(head);
            head.setNextNode(temp);
        }
        else
        {
            Node<T> temp2 = tail.getPrev();
            temp2.setNextNode(temp);
            temp.setPrevNode(temp2);
            temp.setNextNode(tail);
            tail.setPrevNode(temp);
        }
        this.size++;
    }
    
    /**
     * This method removes from the start of list
     * @return the removed node
     */
    public Node<T> remove()
    {
        if (isEmpty())
        {
            return tail;
        }
        else if(size == 1)
        {
            Node<T> temp = head.getNext();
            
            head.setNextNode(tail);
            tail.setPrevNode(head);
    
            this.size = 0;
            return temp;
        }
        else 
        {
            Node<T> temp = head.getNext();

            head.setNextNode(head.getNext().getNext());
            head.getNext().setPrevNode(head);
            
            this.size--;
            return temp;
        }
    }
    
    

}
