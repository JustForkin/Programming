
public class Algorithms {
/**
 * mixes around many random pairs of data so the 80/20 split is done randomly
 * @param data The 2D array of data whose rows will be mixed around
 * @return data the array after it's randomized
 */
	public static String[][] randomize(String[][] data)
	{
		for (int i = 0; i < 1000; i++) {
			int temp1 = (int) (Math.random() * data.length);
			int temp2 = (int) (Math.random() * data.length);
			String[] temp = new String[data[0].length];
			
			temp = data[temp1];
			data[temp1] = data[temp2];
			data[temp2] = temp;
			
		}
		return data;
	}
	
	/**
	 * The algorithm for nearest neighbor strictly (k=1). 
	 * It compares the distance of a piece of testing data from each training data based on all the dimensions,
	 * keeps track of the closest, and then returns the closest's label in addition to T or F if the nearest neighbor guess was right or wrong.
	 * @param trainer The 2D array of the training data (80%)
	 * @param tester The single row of testing data that is being tested via nearest neighbor algorithm
	 * @return Returns an array containing the label assigned to the test data and whether that label was right or not
	 */
	public static String[] label(String[][] trainer, String[] tester)
	{
		String[] results = new String[2];
		String nearest[] = new String[trainer[0].length];
		double closest = -1;
		
		for (int q = 0; q < trainer.length; q++)   //each instance of trainer
		{
			double sum = 0;
			for (int i = 1; i < trainer[0].length; i++)
			{
				sum += Math.pow((Double.parseDouble(trainer[q][i])-Double.parseDouble(tester[i])),2);
			}
			if (sum < closest || closest == -1)
			{
				closest = sum;
				nearest = trainer[q];
			}
		}
		
		results[1] = nearest[0];
		
		if (nearest[0].charAt(0) ==  tester[0].charAt(0) )
			results[0] = "T";
		else results[0] = "F";
		
		return results;
	}
	
	/**
	 * The more general nearest neighbor algorithm for any k-neighbor. (strict nearest neighbor has k=1)
	 * Similar to strict nearest neighbor algorithm, but it takes k closest data points and
	 * by a majority vote determines how to label the testing set.
	 * @param trainer The 2D array of the training data (80%)
	 * @param tester The single row of testing data that is being tested via nearest neighbor algorithm
	 * @param K represents how many data points are 'voting' on the label the testing set gets
	 * @return Returns an array containing the label assigned to the test data and whether that label was right or not
	 */
	public static String[] label(String[][] trainer, String[] tester, int K) 
	{
		int majority = 0; 
		String[] results = new String[2];
		
		for (int u = 0; u < K; u++)
		{
			
			String nearest[] = new String[trainer[0].length];
			double closest = -1;
			
			for (int q = 0; q < trainer.length; q++)   //each instance of trainer
			{
				double sum = 0;
				for (int i = 1; i < trainer[0].length; i++)
				{
					sum += Math.pow((Double.parseDouble(trainer[q][i])-Double.parseDouble(tester[i])),2);
				}
				if (sum < closest || closest == -1)
				{
					closest = sum;
					nearest = trainer[q];
				}
			}
			
			
			if (nearest[0] == "B")
				majority++;
			else if (nearest[0] == "M") 
				majority--;
		
		//}//
			
		if (majority > 0)
			results[1] = "B";
		else if (majority < 0)
			results[1] = "M";
		
		if (results[1] == tester[0])
			results[0] = "T";
		else results[0] = "F";
		
		}//
		
		//System.out.println(tester[0]+","+results[1]+","+results[0]); //////////
		return results;
	}

	
	
}
