import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;


/**
 * 
 */

/**
 * @author Michael Rubin
 *
 */
public class Problem1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> nums =  new ArrayList<Integer>();
		ArrayList<String> words = new ArrayList<String>();


		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your input: ");
		String input = sc.nextLine();
		
		Scanner sc2 = new Scanner(input.trim());
		
		StringTokenizer st = new StringTokenizer(input, " ");
		boolean[] isInt = new boolean[st.countTokens()];
		
		int i  = 0;
		while (sc2.hasNext()  ) 
		{
			


			if(sc2.hasNextInt())
			{
				// Yes an integer
				
				isInt[i] = true;
				
				nums.add(sc2.nextInt());
			} 
			else 
			{
				// Not an integer
				isInt[i] = false;
				
				words.add(sc2.next());
			}
			

			i++;
		}

		Collections.sort(nums);
		Collections.sort(words);

		Iterator<Integer> numIt = nums.iterator();
		Iterator<String> wordIt = words.iterator();

		
		String report = "";
		for(int j = 0; j < isInt.length; j++)
		{
			if(j != 0)
			{
				report += " ";
			}
			if(isInt[j] == true && numIt.hasNext())
			{
			
				report += numIt.next().toString();
			}
			else if(isInt[j] == false && wordIt.hasNext())
			{
				

				report += wordIt.next().toString();
			}
		}

		System.out.print(report);


	}  //end main

}  //end class
