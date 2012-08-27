import java.util.Scanner;
public class RemoveRepeated {

	final static int MAX_LENGTH = 1000;
	
	public static int[] getArray()   //gets array based on user input
	{
		System.out.println("Please enter the array you wish to edit, followed by a non-integer to signify the end of the array:");
		
		int[] values = new int[MAX_LENGTH];
		Scanner sc = new Scanner(System.in);
		int i = 0;
		while(/*sc.hasNext() &&*/ sc.hasNextInt() && i < MAX_LENGTH)   //assigns values to array as long as valid ones are being entered. And doesn't let array go over it's length limit.
		{
			values[i] = sc.nextInt();
			i++;
		}
		int[] temp = new int[i];      //cuts array down from it's max size to the size used
		for (int q = 0; q < i; q++)
			{temp[q] = values[q];}
		return temp;
	}
	
	public static void editArray(int[] values)   //the algorithm
	{
		int counter = 1;
		int[] newArray = new int[values.length];   //makes an array to store post-algorithm values in
		newArray[0] = values[0];
		
		for (int i = 1; i < values.length; i++)
		{
			boolean give_val = true;
			for (int j = 0; j < i; j++)
			{
				
				if (values[i] == values[j])   //before accepting element, makes sure it has no equal integers preceding it in the passed array
				{
					give_val = false;
					
				}
			}
			if (give_val == true)
			{
				newArray[counter] = values[i];  //accepted elements are given to the new array
				counter++;
			}
		}
		int[] finalArray = new int[counter];    //cuts down new array size from max to what's needed
		for (int i = 0; i < finalArray.length; i++)
		{
			finalArray[i] = newArray[i];
		}
		
		for (int p = 0; p < finalArray.length; p++)  //prints post-algorithm array
		System.out.print(finalArray[p] + " ");
	}
	
}
