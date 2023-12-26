import static org.junit.Assert.*;
import org.junit.Test;
/**
 * @author Johan Lee
 *
 */
public class RPNTest {
    /**
     * Test
     */
    @Test
    public void test() 
    {
        RPN rpn = new RPN();
        LinkedList<Integer> list = new LinkedList<Integer>();
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        list.addToFront(2);
        list.addToFront(1);
        //list2
        list2.addToFront(3);
        list2.addToFront(1);
        assertEquals(rpn.addLists(list, list2), 22);
        
    }
    
    /**
     * Test
     */
    @Test
    public void testMultiplyPlace() 
    {
        RPN rpn = new RPN();
        LinkedList<Integer> list = new LinkedList<Integer>();
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        list.addToFront(2);
        list.addToFront(2);
        list.addToFront(3);

        //list2

        list2.addToFront(7);
        assertEquals(rpn.multiplyPlace(list, 4), 7); //2394
        
    }

    
    
    /**
     * Test
     */
    @Test
    public void testMultiplyTraverseOnce() 
    {
        RPN rpn = new RPN();
        LinkedList<Integer> list = new LinkedList<Integer>();
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        list.addToFront(3);
        list.addToFront(4);
        list.addToFront(2);
        //list2

        list2.addToFront(7);
        list2.addToFront(7);
        assertEquals(rpn.multiplyTraverseOnce(list, 11), 22);
        
    }
    
    /**
     * Test
     */
    @Test
    public void testMultiplyLists() 
    {
        RPN rpn = new RPN();
        LinkedList<Integer> list = new LinkedList<Integer>();
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        list.addToFront(3);
        list.addToFront(4);
        list.addToFront(1);
        //list2

        list2.addToFront(7);
        
        assertEquals(rpn.multiplyOneLists(list, list2), 22);
        
    }
    
    /**
     * Test
     */
    @Test
    public void test5() 
    {
        RPN rpn = new RPN();
        LinkedList<Integer> list = new LinkedList<Integer>();
//        LinkedList<Integer> list2 = new LinkedList<Integer>();
        list.addToFront(6);
        list.addToFront(1);
        list.addToFront(8);

//        assertEquals(list, 43);
        assertEquals(rpn.multiplyPlace2(list, 7), 43);
        
    }
    
    /**
     * Test multiply two lists
     */
    @Test
    public void test6() 
    {
        RPN rpn = new RPN();
        LinkedList<Integer> list = new LinkedList<Integer>();
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        list.addToFront(6);
        list.addToFront(1);
        list.addToFront(8);
        
        list2.addToFront(1);
        list2.addToFront(0);
        list2.addToFront(1);

//        assertEquals(list, 43);
        assertEquals(rpn.multiplyOneLists(list, list2), 43);
        
    }
 
    /**
     * Test exponent
     */
    @Test
    public void test7() 
    {
        RPN rpn = new RPN();
        LinkedList<Integer> list = new LinkedList<Integer>();
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        list.addToFront(4);
//        list.addToFront(2);

        list2.addToFront(1);
        list2.addToFront(7);

        assertEquals(rpn.exponentLists(list, list2), 43);
    }
    
    
    /**
     * Test toInteger
     */
    @Test
    public void test8() 
    {
        RPN rpn = new RPN();
        LinkedList<Integer> list = new LinkedList<Integer>();
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        list.addToFront(1);
        list.addToFront(0);
        list.addToFront(5);

        assertEquals(rpn.toInteger(list), 105);
    }
    
    
    /**
     * Test toInteger
     */
    @Test
    public void test9() 
    {
        RPN rpn = new RPN();
        LinkedList<Integer> list = new LinkedList<Integer>();
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        list.addToFront(1);
        list.addToFront(0);
        list.addToFront(7);
        int test = 107;

        assertEquals(rpn.toLinkedList(test), list);
    }
    
    
    
    /**
     * Test EXPONENT
     */
    @Test
    public void test10() 
    {
        RPN rpn = new RPN();
        LinkedList<Integer> list = new LinkedList<Integer>();
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        LinkedList<Integer> returnList = new LinkedList<Integer>();

        for(int i = 0; i < 3; i++)
        {
            list.addToFront(3);
            list2.addToFront(5);
        }
        LinkedList<Integer> temp = rpn.exponentLists(list, list2);

        System.out.println(temp.toLargeNumber());
        returnList.addToFront(16);

    }
    
    
    /**
     * Test divide List by two
     */
    @Test
    public void test11() 
    {
        RPN rpn = new RPN();
        LinkedList<Integer> list = new LinkedList<Integer>();
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        LinkedList<Integer> returnList = new LinkedList<Integer>();
        list.addToFront(0);



        returnList.addToFront(16);
        //assertEquals(rpn.divideListByTwo(list), returnList);
    }
    
/**
 * Test exponentiateHelper
 */
    @Test
    public void test12() 
    {
        RPN rpn = new RPN();
        LinkedList<Integer> list = new LinkedList<Integer>();
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        LinkedList<Integer> returnList = new LinkedList<Integer>();
        list.addToFront(1);
        list.addToFront(1);
        
        list2.addToFront(1);
        list2.addToFront(9);



        returnList.addToFront(16);
        assertEquals(rpn.exponentHelper(list, list2), returnList);
    }
    
    
    
//    LinkedList<Integer> returnList = new LinkedList<Integer>();
//    LinkedList<Integer> tempResult = new LinkedList<Integer>();
//    Node<Integer> curr = listToMultiply.getHead().getNext();
//    int positionCount = 0;
//    while (curr.getData() != null)
//    {
//        LinkedList<Integer> tempDigit = new LinkedList<Integer>();
//        tempDigit.addToFront(curr.getData());
//        tempResult = multiplyPlace(tempDigit, value);
//        for (int i = 0; i < positionCount; i++) 
//        {
//            tempResult.addToFront(0);
//        }
//        returnList = addLists(tempResult, returnList);
//        
//        positionCount++;
//        curr = curr.getNext();
//    }
//    
//    return returnList;
    
    
    
//    
//    /**
//     * This method exponentiates two lists of numbers together
//     * @param two 
//     * @return 
//     */
//     public LinkedList<Integer> exponentialLists(LinkedList<Integer> firstNum, LinkedList<Integer> secondNum)
//     {
//         Node<Integer> curr2 = secondNum.getHead().getNext();
//         LinkedList<Integer> totalResult = new LinkedList<Integer>();
//         LinkedList<Integer> tempResult = new LinkedList<Integer>();
//         while(curr2.getData() != null) 
//         {
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
//             else 
//             {
//                 LinkedList<Integer> squaredResult = (multiplyOneLists(firstNum, firstNum));
//                 tempResult = squaredResult;
//                 for (int i = 1; i < raiseToEvenPower; i++) 
//                 {
//                     tempResult = multiplyOneLists(squaredResult, tempResult);
//                 }
//             }
//             
//         }
//
//         
//         else //exponent is odd 
//         {
//             if (raiseToOddPower == 0) 
//             {
//                 LinkedList<Integer> tempList = new LinkedList<Integer>();
//                 tempList.addToFront(1);
//                 tempResult = multiplyOneLists(firstNum, tempList);
//             }
//             //mutiply curr1 by itself,  then raise to power of (curr2 -1)/2
//             //then multiply by curr1 once after
//             else
//             {
//                 LinkedList<Integer> squaredResult = (multiplyOneLists(firstNum, firstNum));
//                 tempResult = squaredResult;
//                 for (int i = 1; i < raiseToOddPower; i++) 
//                 {
//                     tempResult = multiplyOneLists(squaredResult, tempResult);
//                 }
//             
//             tempResult = multiplyOneLists(firstNum, tempResult);
//             }
//         }
//         
//         totalResult = multiplyOneLists(totalResult, tempResult);
//         curr2 =curr2.getNext();
//         }
//
//         return totalResult;
//         }
//     
    //------------------------------------------------------------------------------------------------------
    /**
     * EXPONENTIATE BY ONE NODE
     */
    /**
     * This method exponentiates two lists of numbers together
     * @param two 
     * @return 
     */
//     public LinkedList<Integer> exponentialLists(LinkedList<Integer> firstNum, LinkedList<Integer> secondNum)
//     {
//         Node<Integer> curr2 = secondNum.getHead().getNext();
//         LinkedList<Integer> totalResult = new LinkedList<Integer>();
//         LinkedList<Integer> tempResult = new LinkedList<Integer>();
//         while(curr2.getData() != null) 
//         {
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
//             else 
//             {
//                 LinkedList<Integer> squaredResult = (multiplyOneLists(firstNum, firstNum));
//                 tempResult = squaredResult;
//                 for (int i = 1; i < raiseToEvenPower; i++) 
//                 {
//                     tempResult = multiplyOneLists(squaredResult, tempResult);
//                 }
//             }
//             
//         }
//
//         
//         else //exponent is odd 
//         {
//             if (raiseToOddPower == 0) 
//             {
//                 LinkedList<Integer> tempList = new LinkedList<Integer>();
//                 tempList.addToFront(1);
//                 tempResult = multiplyOneLists(firstNum, tempList);
//             }
//             //mutiply curr1 by itself,  then raise to power of (curr2 -1)/2
//             //then multiply by curr1 once after
//             else
//             {
//                 LinkedList<Integer> squaredResult = (multiplyOneLists(firstNum, firstNum));
//                 tempResult = squaredResult;
//                 for (int i = 1; i < raiseToOddPower; i++) 
//                 {
//                     tempResult = multiplyOneLists(squaredResult, tempResult);
//                 }
//             
//             tempResult = multiplyOneLists(firstNum, tempResult);
//             }
//         }
//         
//         totalResult = multiplyOneLists(totalResult, tempResult);
//         curr2 =curr2.getNext();
//         }
//
//         return totalResult;
//         }
//     
}
