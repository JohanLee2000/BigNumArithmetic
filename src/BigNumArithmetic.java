import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
// On my honor:
// - I have not used source code obtained from another student,
//   or any other unauthorized source, either modified or
//   unmodified.
//
// - All source code and documentation used in my program is
//   either my original work, or was derived by me from the
//   source code published in the textbook for this course.
//
// - I have not discussed coding details about this project
//   with anyone other than my partner (in the case of a joint
//   submission), instructor, ACM/UPE tutors or the TAs assigned
//   to this course. I understand that I may discuss the concepts
//   of this program with other students, and that another student
//   may help me debug my program so long as neither of us writes
//   anything during the discussion or modifies any computer file
//   during the discussion. I have violated neither the spirit nor
//   letter of this restriction.
/**
 * This BigNumArithmetic class reads an input file and outputs a file given a series of
 * expressions and operators.
 * 
 * @author johanlee20
 * @author georgemm
 */
public class BigNumArithmetic {
    /**
     * The main method checks for one argument and prints calculations
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 1) {
            throw new IllegalArgumentException(
                "Exactly one argument needed: file-input");
        }
        String inputFilePath = args[0];
        // We could do all this in a static way, but then we would
        // need to reset our static variables for every test!
        // Let's avoid that by using the object approach like so: 
        BigNumArithmetic superCalc = new BigNumArithmetic();
        superCalc.printCalculations(inputFilePath);
    }
    /**
     * Default constructor
     */
    public BigNumArithmetic() {
        // If I had any fields, I'd initialize them here
    }
    

    /**
     * This method converts an integer into a DLLinkedList
     * @param numberToConvert the string of numbers to change 
     * @return a LinkedList of integers
     */
    public LinkedList<Integer> toDLList(String numberToConvert)
    {
        LinkedList<Integer> newList = new LinkedList<Integer>();
        while (numberToConvert.length() > 0) 
        {
            String remainder = numberToConvert.substring(1, numberToConvert.length());
            newList.addToFront(Integer.parseInt(numberToConvert.substring(0,1)));
            numberToConvert = remainder;
        }
        //System.out.println(newList.toString());
        return newList;
    }
    
    /**
     * This method parses through the file and takes the numbers, operating on them
     * as needed, to return a series of expressions to the output file
     * @param filepath the path to the file for input
     * @throws FileNotFoundException if there is no file
     */
    public void printCalculations(String filepath) throws FileNotFoundException {
        Scanner scanIn = new Scanner(new File(filepath));
        RPN rpn = new RPN();
        while (scanIn.hasNextLine()) {
        	Stack<LinkedList<Integer>> MainStack = new Stack<LinkedList<Integer>>();
            String line = scanIn.nextLine();
            String[] words = line.split("\\s+");
            if(words.length > 1) {
                System.out.println("Input Line: " + line);
	            for (int i = 0; i < words.length; i++) {
	            	if(!words[i].equals("")) {
		                String word = words[i];
		                System.out.println("Input word: " + word + "  " + MainStack.getSize());
		                if(words[i].equals("+")) {
		                	LinkedList<Integer> temp1 = MainStack.pop();
		                	LinkedList<Integer> temp2 = MainStack.pop();
		                	MainStack.push(rpn.addLists(temp1, temp2));
		                	System.out.println(rpn.addLists(temp1, temp2).toLargeNumber());
		                }
		                else if(words[i].equals("*")) {
		                	LinkedList<Integer> temp1 = MainStack.pop();
		                	LinkedList<Integer> temp2 = MainStack.pop();
		                	MainStack.push(rpn.multiplyOneLists(temp1, temp2)); ;
		                }
		                else if(words[i].equals("^")) {
		                	LinkedList<Integer> exponent = MainStack.pop();
		                	LinkedList<Integer> x = MainStack.pop();
		                	MainStack.push(rpn.exponentLists(x, exponent)) ;
		                }
		                else {
		                	System.out.println("number\n");
		                	LinkedList<Integer> tempStack = toDLList(word);
		                	MainStack.push(tempStack);
		                }
		            }
	            }
	            for(int x = 0; x < words.length; x++) {
	            	System.out.print(words[x] + " ");
	            }
	            System.out.println("= " + MainStack.pop().toLargeNumber() + "\n");
            }
            
        }
        scanIn.close();
    }
}