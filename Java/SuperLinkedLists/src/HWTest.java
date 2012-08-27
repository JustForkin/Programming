import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;


/**
 * 
 * @author Michael Rubin
 * A tester class for the Super Linked List
 */
public class HWTest {

	/**
	 * @param args arg[0] Input file to parse
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {

		System.out.println("note: Each node\'s \'counter\' is in ( ) after the node\'s value:\n");
		
		/* Step 5: 100 random #s */
		System.out.println("/* Step 5: 100 random #s between 0-23 */\n");
		
		SuperLinkedLists<String> myList = new SuperLinkedLists<String>();
			//SuperIterator<String> myIter = myList.iterator();
		String[] myNums = new String[100];
		
		for(int i = 0; i < 100; i++) //get 100 random #s from 0-23
		{
			myNums[i] = "" + ((int)(Math.random() * 24)); 
		}
				
		for(int i = 0; i < 100; i++) //insert numbers
		{
			myList.insert(myNums[i]);
		}
		
		myList.print();
		
		
		/* EXTRA CREDIT: parse a text file */
		System.out.println("/* EXTRA CREDIT: parse a commandline text file (input_file.txt)*/\n");
		
		SuperLinkedLists<String> myList2 = new SuperLinkedLists<String>();
		
		File myFile = new File(args[0]);
		Scanner sc = new Scanner(myFile);
		String elmts = sc.nextLine();
		StringTokenizer st = new StringTokenizer(elmts);
		
		int total = 0;
		while(st.hasMoreTokens())
		{
			total++;
			myList2.insert(st.nextToken());
			
		}
		
		myList2.print(total);
		System.out.println("total items in list (sum of counters): " + total);
		
		System.out.println("\n** Now we'll reverse the (latter) list and print it:");
		myList2.reverse();
		myList2.print(total);
		
		System.out.println("\n** Now we'll delete an element (elmt number 1) from the current list and print it:");
		myList2.delete(1);
		myList2.print(total-1);
		System.out.println("\nIf the element contained multiple nodes with that same " +
				"value then the counter was decremented. Else it was deleted.");
		
	}

}
