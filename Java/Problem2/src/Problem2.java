import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Michael Rubin
 *
 */
public class Problem2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int numCenters;
		
		Scanner sc =  new Scanner(System.in);
			
		numCenters =  sc.nextInt();
		sc.nextLine();///
		ArrayList<Node> inputList = new ArrayList<Node>(numCenters);
		
		int highestNum =  0;
		int i  =  0;
		while(i  <  numCenters)
		{
			Node newNode =  new Node();
			String temp = sc.nextLine();
			//sc.nextLine();//burn
			Scanner scc  =  new Scanner(temp);
			while(scc.hasNextInt())
			{
				int thisInt = scc.nextInt(); 
				if(thisInt>highestNum)
				 	{highestNum  = thisInt;}
				newNode.add(thisInt);
			}
			
			newNode.setNum(highestNum);
			newNode.findMissing();
			inputList.add(newNode);
			
			i++;
		}
		
		//System.out.print(inputList);
		for(int  y  = 0; y <  numCenters;  y++)
		{
			while(inputList.get(y).isDone()  == false)
			{
				for(int j  = 0; j  <  numCenters;  j++) //for each center
				{
					
					for(int k = 0;  k <  highestNum;  k++) //for each id
					{
						if(inputList.get(j).isMissing(k))  //center missing id
						{
							for(int jj  = 0; jj  <  numCenters;  jj++) //check centers for id
							{
								if(!inputList.get(jj).isMissing(k))  //if  not missing
								{
									System.out.println(k  +  " "  +  jj  + " " + j);
									inputList.get(j).addd(k);
								}
							}
						}
					}
					
				}
			}
		}
		System.out.print("done");
		
	}

}
