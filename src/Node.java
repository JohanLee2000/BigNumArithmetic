
/**
 * This class uses Nodes to contain data
 * 
 * @author johanlee20
 * @author georgemm
 * @param <T> the type of data value stored
 *
 */
 public class Node<T>
 {
        //Fields----------------------------------------------------
        private T data;
        private Node<T> next;
        private Node<T> prev;
        
        //Constructors---------------------------------------------

        /**
         * Initializes a Node with data
         * @param dataPortion integer inside the node
         */
        public Node(T dataPortion)
        {
            data = dataPortion;
            next = null;
        }
        
        /**
         * Initializes a Node with data and points to next node
         * @param newData integer inside the node
         * @param nextNode points to next node
         * @param prevNode 
         */
        public Node (T newData, Node<T> nextNode, Node<T> prevNode)
        {
            this(newData);
            next = nextNode;
            prev = prevNode;
        }
        
        //Methods------------------------------------------------------
        /**
         * Gets the data from the node
         * @return integer inside node
         */
        public T getData()
        {
            return data;
        }
        
        /**
         * Gets the next node
         * @return next node
         */
        public Node<T> getNext() 
        {
            return next;
        }
        
        /**
         * Gets the previous node
         * @return previous node
         */
        public Node<T> getPrev()
        {
            return prev;
        }
        
        /**
         * Sets the next node
         * @param nextNode the node to be set to
         */
        public void setNextNode(Node<T> nextNode)
        {
            next = nextNode;
        }
        
        /**
         * Sets the previous node reference
         * @param prevNode reference to previous node
         */
        public void setPrevNode(Node<T> prevNode)
        {
            prev = prevNode;
        }
        
        /**
         * Sets a new data value in the node
         * @param newData value inside node
         */
        public void setValue(T newData)
        {
            data = newData;
        }
        
    }


