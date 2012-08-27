import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Michael Rubin  -  mnr2114
 * Class for making an augmented square k-diagonal matrix
 */
public class KDiagMatrix {

	private int n;
	private int k;  
	private double A[][];
	
	/**
	 * Creates a k-diagonal augmented matrix by reading an input file
	 * @param myFile input file which is read to create matrix.
	 * Must be in the following format:
	 * n
	 * k
	 * row 1
	 * row 2
	 * ...
	 * row n
	 */
	KDiagMatrix(File myFile)
	{
		Scanner sc = null;
		try 
		{
			sc = new Scanner(myFile);
			} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		n = Integer.parseInt(sc.nextLine());
		k = Integer.parseInt(sc.nextLine());
		A = new double[n][n+1];
		for(int i = 0; i < n; i++)
		{
			int j = 0;
			for(j = 0; j < n; j++)
			{
				A[i][j] = sc.nextDouble();
			}
			A[i][j] = sc.nextDouble();
		}
	}
	
	/**
	 * Performs elimination on the k-diag matrix
	 * The algorithm is optimized for bounded matrices such as the ones in the hw
	 * (for more info see the readme)
	 * @return The new eliminated matrix
	 */
	public double[][] elimination()
	{
		for(int h = 0; h < n; h++) //for each col of A
		{
			for(int i = h+1; i <= (h+(k-1)/2) && i < n; i++) //for each row below h (there are (k-1)/2 of them)
			{
				double L = (A[i][h])/(A[h][h]);  //sets the (+) L-factor
				for(int j = h; j <= h+k-1 && j < n; j++) //work on elmts of (A's) row (there are k of them)
				{
					A[i][j] = A[i][j] - ((A[h][j])*L);  //mutates matrix elmt
				}
				A[i][n] = A[i][n] - ((A[h][n])*L); //vector b (in col n)
			}
		}
		return A;
	}
	
	/**
	 * Performs back substitution on the k-diagonal matrix. 
	 * The algorithm is optimized for bounded matrices such as the ones in the hw
	 * (for more info see the readme)
	 * @return The solution to the system
	 */
	public double[] backSub()
	{
		double[] ans = new double[n]; 
	    ans[n-1] = A[n-1][n]/A[n-1][n-1]; //start with last row and back-sub
	    for(int i = n-2; i >= 0; i--) //go from bottom row to top row
	    {
	    	double sum = 0;
	    	for(int j = i+1;  j < (i+1+k) && j < n; j++) //work on row (at most k elmts in it)
	    	{
	    		sum += A[i][j] * ans[j]; //sum the terms we already know the values of
	    	}
	    	ans[i] = ((A[i][n]-sum)/A[i][i]); //solve for an x_i
	    }
		
		return ans;
	}
	
	/**
	 * Accesses the size of the square n*n matrix
	 * @return n The size of the matrix (not augmented)
	 */
	public int getN()
	{
		return n;
	}
	
	/**
	 * Prints out a representation of the matrix (n, k, array of elements)
	 */
	public String toString()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		String report = "";
		report += "n = " + n + "\n";
		report += "k = " + k + "\n";
		report += "[A|b] = " + "\n";
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n+1; j++)
			{
				report += df.format(A[i][j]) + "  ";
			}
			report += "\n";
		}
		return report;
	}
	
	
}
