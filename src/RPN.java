
/**
 * This RPN class acts as the calculator for LinkedLists of integers
 * @author johanlee20
 * @author georgemm
 */
public class RPN {

    /**
     * Add the two lists
     * @param firstNum the first list of numbers
     * @param secondNum the second list of numbers
     * @return result of the two lists
     */
    public LinkedList<Integer> addLists(LinkedList<Integer> firstNum, LinkedList<Integer> secondNum)
    {
        LinkedList<Integer> returnList = new LinkedList<Integer>();
        
        Node<Integer> curr1 = firstNum.getHead().getNext();
        Node<Integer> curr2 = secondNum.getHead().getNext();

        int carry = 0;
        int total = 0;
        while (curr1.getNext() != null || curr2.getNext() != null)
        {
            int l1Place = 0;
            int l2Place = 0;
        
            if (curr1 != firstNum.getTail())
            {
         
                l1Place = (int) curr1.getData();
                curr1 = curr1.getNext();
       
            }
            if (curr2 != secondNum.getTail())
            {
                l2Place = (int) curr2.getData();
                curr2 = curr2.getNext();
            }
            
            total = l1Place + l2Place + carry;
            carry = total / 10;
            int currentPlace = total % 10;
            returnList.addValueToEnd(currentPlace);
        }
        if (carry != 0)
        {
            returnList.addValueToEnd(carry);
        }
    
        return returnList;
    } 
    

    /**
     * Multiply by one node with a given second node (and its value)
     * @param listToMultiply the input list
     * @param value of the integer
     * @return result of multiplication
     */
    public LinkedList<Integer> multiplyPlace(LinkedList<Integer> listToMultiply, int value)
    {
        LinkedList<Integer> returnList = new LinkedList<Integer>();
        Node<Integer> curr = listToMultiply.getHead().getNext();
        int carry = 0; 
        
        if(curr.getData() != null)
        {
            int total = curr.getData() * value;
            carry = total / 10;
            int onesPlace = total % 10;
            returnList.addValueToEnd(onesPlace);
            
            if (carry != 0)
            {
                returnList.addValueToEnd(carry);
            }

        }
        return returnList; 
    }
    
    /**
     * Multiply one list by traversing by given second node(and its value)
     * @param listToMultiply 
     * @param value 
     * @return 
     */
    public LinkedList<Integer> multiplyTraverseOnce(LinkedList<Integer> listToMultiply, int value)
    {
        LinkedList<Integer> returnList = new LinkedList<Integer>();
        LinkedList<Integer> tempResult = new LinkedList<Integer>();
        Node<Integer> curr = listToMultiply.getHead().getNext();
        int positionCount = 0;
        while (curr.getData() != null)
        {
            LinkedList<Integer> tempDigit = new LinkedList<Integer>();
            tempDigit.addToFront(curr.getData());
            tempResult = multiplyPlace(tempDigit, value);
            for (int i = 0; i < positionCount; i++) 
            {
                tempResult.addToFront(0);
            }
            returnList = addLists(tempResult, returnList);
            
            positionCount++;
            curr = curr.getNext();
        }
        
        return returnList;
        
    }

    
    

//    /**
//     * This method exponentiates two lists of numbers together
//     * @param two 
//     * @return 
//     */
//     public LinkedList<Integer> exponentialOneDigit(LinkedList<Integer> firstNum, LinkedList<Integer> secondNum)
//     {
//         Node<Integer> curr2 = secondNum.getHead().getNext();
//         
//         int trueIfEven = curr2.getData() % 2;
//         int raiseToEvenPower = curr2.getData()/2;
//         int raiseToOddPower = (curr2.getData() - 1)/2;
//         if (trueIfEven == 0) 
//         {
//             //multiply curr1 by itself, then raise to power of (curr2 / 2)
//             if (raiseToEvenPower == 0) 
//             {
//                 LinkedList<Integer> endResult = new LinkedList<Integer>();
//                 endResult.addToFront(1);
//                 return endResult;
//             }
//             LinkedList<Integer> squaredResult = (multiplyOneLists(firstNum, firstNum));
//             LinkedList<Integer> tempResult = squaredResult;
//                 for (int i = 1; i < raiseToEvenPower; i++) 
//                 {
//                     tempResult = multiplyOneLists(squaredResult, tempResult);
//                 }
//             return tempResult;
//         }
//         
//         else //exponent is odd 
//         {
//             if (raiseToOddPower == 0) 
//             {
//                 LinkedList<Integer> tempList = new LinkedList<Integer>();
//                 tempList.addToFront(1);
//                 return multiplyOneLists(firstNum, tempList);
//             }
//             //mutiply curr1 by itself,  then raise to power of (curr2 -1)/2
//             //then multiply by curr1 once after
//             LinkedList<Integer> squaredResult = (multiplyOneLists(firstNum, firstNum));
//             LinkedList<Integer> tempResult = squaredResult;
//                 for (int i = 1; i < raiseToOddPower; i++) 
//                 {
//                     tempResult = multiplyOneLists(squaredResult, tempResult);
//                 }
//             
//             return multiplyOneLists(firstNum, tempResult);
//         }
//         }
//     
     
     

     /**
      * This method multiplies two lists together
     * @param firstNum the first list of numbers
     * @param secondNum the second list of numbers
     * @return the result of multiplying both lists
      */
     public LinkedList<Integer> multiplyOneLists(LinkedList<Integer> firstNum, LinkedList<Integer> secondNum)
     {
         Node<Integer> curr2 = secondNum.getHead().getNext();
         LinkedList<Integer> returnList = new LinkedList<Integer>();
         int digitCount = 0;
         while (curr2.getData() != null) 
         {
             LinkedList<Integer> tempResult = new LinkedList<Integer>();
             tempResult.addToFront(curr2.getData());
             
             tempResult = multiplyTraverseOnce(firstNum, curr2.getData());
             for (int i = 0; i < digitCount; i++) 
             {
                 tempResult.addToFront(0);
             }
             returnList = addLists(tempResult, returnList);
             digitCount++;
             curr2 = curr2.getNext();
         }
         
          return returnList;
         
     }
     
     
     
 
     

     /**
      * This method multiplies a LinkedList by a digit value
      * 
     * @param listToMultiply the list to use
     * @param value of the digit in an integer
     * @return a LinkedList of the resultant multiplication
     */
    public LinkedList<Integer> multiplyPlace2(LinkedList<Integer> listToMultiply, int value)
     {
         LinkedList<Integer> returnList = new LinkedList<Integer>();
         Node<Integer> curr = listToMultiply.getHead().getNext();

         int digitPlace =0;

         while(curr.getData() != null)       
         {
             int total = curr.getData() * value;
             int carry = total / 10;
             int onesPlace = total % 10;
             LinkedList<Integer> interimResult = new LinkedList<Integer>();
             if (carry != 0) 
             {
                 interimResult.addToFront(carry);
             }
             interimResult.addToFront(onesPlace);
             
             if (digitPlace > 0) 
             {
                 for (int i =0; i < digitPlace; i++) 
                 {
                     interimResult.addToFront(0);
                 }
             }
             returnList = addLists(returnList, interimResult);
             curr = curr.getNext();
             digitPlace++;

         }
         
         return returnList; 
     }
     
     
     
     
//     /**
//      * gets the linkedlist
//      * converts to an int
//      * checking if odd or even
//      * if odd n-1/2
//      * if even n/2 
//      * convert to linked list
//      * return that
//     * @param exponent 
//     * @return 
//      */
//     public LinkedList<Integer> divideListByTwo(LinkedList<Integer> exponent)
//     {
//         int number = toInteger(exponent);
//         LinkedList<Integer> returnList = new LinkedList<Integer>();
//         if (number == 1) 
//         {
//             returnList = toLinkedList(1);
//             return returnList;
//         }
////         if (number == 0) 
////         {
////             returnList = toLinkedList(0);
////             return returnList;
////         }
//         
//         int trueIfEven = number % 2;
//         if (trueIfEven == 0)
//         {
//             int raiseToEvenPower = number/2;
//             returnList = toLinkedList(raiseToEvenPower);
//             return returnList;
//         }         
//         else
//         {
//             int raiseToOddPower = (number - 1)/2;
//             returnList = toLinkedList(raiseToOddPower);
//             return returnList;
//         }
//
//     }
//     
     
     /**
      * exponentiate helper
     * @param firstList 
     * @param number 
     * @param exponent 
     * @return 
      */
     public LinkedList<Integer> exponentHelper(LinkedList<Integer> firstList, LinkedList<Integer> exponent)
     {
         int number = toInteger(exponent);
         LinkedList<Integer> returnList = new LinkedList<Integer>();
         returnList = firstList;
         for (int i = 1; i < number; i++) 
         {
             returnList = multiplyOneLists(returnList, firstList);
         }
         
         return returnList;
     }
     
     
     /**
      * This method exponentiates two lists together
     * @param firstList the first list to use, or the index
     * @param exponent the list to exponentiate by
     * @return the result of exponentiating the two lists
      */
     public LinkedList<Integer> exponentLists(LinkedList<Integer> firstList, LinkedList<Integer> exponent)
     {
         //convert to int
         int checkNumber = toInteger(exponent);
         LinkedList<Integer> returnList = new LinkedList<Integer>();
         returnList = firstList;
         if (checkNumber == 0) 
         {
             returnList.clear();
             returnList.addToFront(1);
             return returnList;
         }
         else if (checkNumber == 1) 
         {
             return returnList;
         }
         else if (checkNumber % 2 == 0) //even case
         {
             //returnList = exponentLists(firstList, divideListByTwo(exponent));
             //returnList = exponentLists(multiplyOneLists(firstList, firstList), divideListByTwo(exponent));
//             LinkedList<Integer> tempList = multiplyOneLists(returnList, divideListByTwo(exponent));
             //returnList = multiplyOneLists(exponentLists(firstList, divideListByTwo(exponent)), returnList);
//             return multiplyOneLists(tempList, tempList);
             //return multiplyOneLists(returnList, returnList);
             checkNumber = checkNumber/2;
             LinkedList<Integer> exponentList = toLinkedList(checkNumber);
             LinkedList<Integer> res = exponentHelper(returnList, exponentList);
             return multiplyOneLists(res, res);
         }
         else //odd case
         {
//             return multiplyOneLists(tempList, returnList);
             //return multiplyOneLists(returnList, returnList);
             checkNumber = (checkNumber-1)/2;
             LinkedList<Integer> exponentList = toLinkedList(checkNumber);
             LinkedList<Integer> res = exponentHelper(returnList, exponentList);
             LinkedList<Integer> tempRes = multiplyOneLists(res, res);
             return multiplyOneLists(tempRes, returnList);
         }
     }
     
     

     /**
      * This method converts an integer into a DLLinkedList
      * @param numberToConvert the input integer
      * @return a LinkedList representation of the integer
      */
     public LinkedList<Integer> toLinkedList(int numberToConvert)
     {
         LinkedList<Integer> newList = new LinkedList<Integer>();
         while (numberToConvert != 0) 
         {
             int remainder = numberToConvert % 10;
             newList.addValueToEnd(remainder);
             numberToConvert = numberToConvert/10;
         }
         return newList;
     }
     
     /**
      * This method converts a LinkedList to an integer
      * @param listToConvert the input list
      * @return a integer representation of the list
      */
     public int toInteger(LinkedList<Integer> listToConvert) 
     {
         int newInteger = 0;
         int digitPlace = 0;
         while(!listToConvert.isEmpty()) 
         {
             int digitToPop = listToConvert.getHead().getNext().getData();
             listToConvert.remove();
             newInteger = newInteger + (digitToPop * ((int)Math.pow(10, digitPlace)));
             digitPlace++;
         }
         return newInteger;
         
     }
     
     
}

