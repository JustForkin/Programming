import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author Michael Rubin
 *
 */
public class Tumors {

	/**
	 * Runs the nearest neighbor in addition to 3,5,7 nearest neighbor.
	 * Reads the data into a 2D array by splitting it where commas are found.
	 * Then randomizes data and puts 80% in training array, and the rest in testing array.
	 * Then tests all the testing data against the training data by using a static method and then computes the accuracy.
	 * @param args n/a
	 */
	public static void main(String[] args)  {
		
		for (int K = 1; K < 8; K+=2)
		{
		System.out.println("nearest "+K+" neighbor");
		
			final int TIMES = 100;  //100
			double accur = 0.0;
			for (int b = 0; b < TIMES; b++)
			{
			
				final int INSTANCES = 569;   //569
				final int DIMENSIONS = 30;
						
				File inFile = new File("wdbc.data");
				Scanner input = null;
				try {
					input = new Scanner(inFile);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				
				String[][] data;
				data = new String[INSTANCES][DIMENSIONS+1];
				
				for (int i = 0; i < INSTANCES; i++)
				{
					String[] temp = input.next().split(",");
					for (int j = 0; j < DIMENSIONS+1; j++)
					{	
						data[i][j] = temp[j+1];   //puts data in array		
					}
				
				}
				
				Algorithms.randomize(data);
				
				int percent = (INSTANCES*8/10);
				String[][] training = new String[percent][DIMENSIONS+1];
				String[][] testing = new String[INSTANCES-percent][DIMENSIONS+1];
				
				for (int g = 0; g < percent; g++)
				{
					for (int j = 0; j < DIMENSIONS+1; j++)
					{	
						training[g][j] = data[g][j];
					}
				}
				
				for (int g = percent; g < INSTANCES; g++)
				{
					for (int j = 0; j < DIMENSIONS+1; j++)
					{	
						testing[g-percent][j] = data[g][j];	
					}
				}
				
				double numT = 0.0;
				double numF = 0.0;
				
				for (int i = 0; i < INSTANCES-percent; i++)
				{
					if (K == 1){
						if(Algorithms.label(training, testing[i])[0] == "T")
							numT++;
						else numF++;
					} else {
						if(Algorithms.label(training, testing[i], K)[0] == "T")
							numT++;
						else numF++;
					}
				}
				accur += (numT/(numT+numF));
				
			} //end trial
			double percAcc = (accur/TIMES)*100;
			System.out.println("percent accuracy: "+percAcc+"%\n");
			
		} //end k neighbor
		
	} //end method

} //end class
