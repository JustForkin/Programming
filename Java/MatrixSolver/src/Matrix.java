import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Michael Rubin
 * A m by n augmented matrix that can be solved
 */
public class Matrix {

	private int rows;
	private int cols;  
	private double A[][];
	private int rank;
	private int numSols;
	private boolean[] isFree;

	/**
	 * Creates an m by n matrix by reading an input file
	 * @param myFile input file which is read to create matrix
	 * Must be in the following format (separate lines):
	 * m
	 * n
	 * row 1
	 * row 2
	 * ...
	 * row m
	 * b_1
	 * b_2
	 * ...
	 * b_m
	 */
	Matrix(File myFile)
	{
		Scanner sc = null;
		try 
		{
			sc = new Scanner(myFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		rows = Integer.parseInt(sc.nextLine());
		cols = Integer.parseInt(sc.nextLine());
		A = new double[rows][cols+1];
		for(int i = 0; i < rows; i++)
		{
			int j = 0;
			for(j = 0; j < cols; j++)
			{
				A[i][j] = sc.nextDouble();
			}
			//A[i][j] = sc.nextDouble();
		}
		for(int i = 0; i < rows; i++)
		{
			A[i][cols] = sc.nextDouble();
		}
		isFree = new boolean[cols];
	}

	/**
	 * Performs forward elimination on the matrix (in-place)
	 * @return The U matrix
	 */
	public double[][] forwardElim()
	{
		int pivR = 0;
		for(int h = 0; h < cols && pivR < rows; h++) //for each col of A
		{
			if(rowSwap(pivR, h))
			{
				for(int i = pivR+1; i < rows; i++) //for each row below pivot
				{		
					double L = (A[i][h])/(A[pivR][h]);  //sets the (+) L-factor
					for(int j = h; j < cols; j++) //work on elmts of (A's) row
					{
						A[i][j] = A[i][j] - ((A[pivR][j])*L);  //mutates matrix elmt
					}
					A[i][cols] = A[i][cols] - ((A[pivR][cols])*L); //vector b (in col n)
				}
				pivR++;
			}

		}

		return A;
	}


	/**
	 * Performs row swaps (by half-pivoting) when forward-eliminating to move down 0 rows
	 * @param pr Row of the pivot we're dealing with
	 * @param pc Column of the pivot we're dealing with
	 * @return True if the row was successfull swapped or didn't need to be. False if we couldn't
	 */
	private boolean rowSwap(int pr, int pc)
	{
		if(A[pr][pc] == 0) //if pivot is 0
		{
			for(int i = pr+1; i < rows; i++) //for everything underneath pivot
			{
				
				if(A[i][pc] != 0) //if non-0 underneath pivot
				{
					//find max in row ie half-pivot
					int maxI = i;
					for(int p = i+1; p < rows; p++)
					{
						if(A[p][pc] > A[i][pc])
						{
							maxI = p;
						}
					}
					
					//swap rows	
					
					double[] temp = A[pr];
					A[pr] = A[maxI];
					A[maxI] = temp;
	
	
					return true;
				}
				//else { return false; } //whole col is 0's
			}
			return false; //whole col is 0's
		}
		else
		{
			return true;
		}
		
	}

	/**
	 * Performs back elimination to produce a matrix almost in rref (diagonal)
	 * Do this after forwardElim()
	 * @return The further reduced matrix (in-place)
	 */
	public double[][] backElim()
	{ 	
		int pivR;
		for(pivR = rows-1; pivR >= 0; pivR--)
		{
			boolean found = false; ///
			for(int pivC = 0; pivC < cols && pivR >= 0; pivC++)
			{
				
				if(A[pivR][pivC] != 0 && found == false) ///
				{
					found = true; ///
					for(int i = pivR-1; i >= 0; i--) //for each row above pivot
					{		
						double L = (A[i][pivC])/(A[pivR][pivC]);  //sets the (+) L-factor
						for(int j = cols-1; j >= pivC; j--) //work on elmts of (A's) row
						{
							A[i][j] = A[i][j] - ((A[pivR][j])*L);  //mutates matrix elmt
						}
						A[i][cols] = A[i][cols] - ((A[pivR][cols])*L); //vector b (in col n)
					}
					//pivR--; //
				}
				
			}
		}
			
		return A;
	}


	/**
	 * Takes the diagonal matrix and turns it into rref
	 * As well as calculates the rank of the matrix
	 * Do so after backElim()
	 * @return The matrix R
	 */
	public double[][] division()
	{
		rank = 0;
		int pivR = 0;
		for(int h = 0; h < cols && pivR < rows; h++) //for each col of A
		{
			if(A[pivR][h] != 0) //there's a pivot in this col
			{	
				rank++;
				double denom = A[pivR][h]; //thing to divide by
				for(int i = 0; i < cols+1; i++)
				{
					A[pivR][i] /= denom; 


				}
				pivR++;
			}
		}
		if(rank == cols) {numSols = 1;}
		else if(rank < cols) {numSols = 2;}
		return A;
	}

	

	/**
	 * Finds the particular solution to the system if there is one
	 * As well as finds which vars are free/pivot
	 * Use after using division()
	 * @return The particular solution to the system.
	 * Returns null if there is no solution
	 */
	public double[] particSol()
	{
		double[] ans = new double[cols]; 
		//boolean cont = true;
		
		int pivR = 0;
		int i;
		for(i = 0; i < cols && pivR < rows; i++)
		{
			
			if(A[pivR][i] != 0)  // if there's a pivot
			{
				isFree[i] = false; //
				ans[i] = A[pivR][cols]; //pivot col  (know b_pivR since set all free vars to 0)
				pivR++;

			}	
			else // "pivot" == 0
			{
				if(!(isZeroRow(pivR) && A[pivR][cols] != 0)) // !(0-row and soln elmt not 0)
				{
					isFree[i] = true; //
					ans[i] = 0;  //free col
				}

			}
			
			for(int j = 0; j < rows; j++) //go through rows
			{
				if(isZeroRow(j) && A[j][cols] != 0) // 0-row and soln not 0
				{
					numSols = 0;
					return null; //no solution
				}
			}
		}
		while(i < cols) //fill in free cols that weren't hit
		{
			isFree[i] = true; 
			i++;
		}
		
		return ans;

	}
	
	
	/**
	 * Finds the special solutions to the system
	 * Use after particSol()
	 * @return Outputs a matrix whose cols are the special solutions
	 * or returns null if there are no solutions or the nullspace is trivial
	 */
	public double[][] nullSpace()
	{
		int freeCols = getCols() - getRank();
		double[][] ans = new double[getCols()][freeCols];
		
		if(numSols == 1 || numSols == 0)  //no nullspace if 0 solns and trivial nullspace if 1 soln
		{return null;}
		
		//if there're infinite solutions
		int freeCount = 0;
		for(int k = 0; k < cols; k++) //for each column
		{
			if(isFree[k] == true) //if it's a free col  -> spec soln
			{
				int pivIter = 0;
				//create specialSolution_freecount
				for(int t = 0; t < cols; t++) //set each val of spec sol ie col
				{
					//if t-th elmt is pivot var ie  the t-th col is a p-col
					if(!isFree[t])
					{
						ans[t][freeCount] = -1*A[pivIter][k]; //the t-th elmt of the spec sol = neg. the next value in the k-th col of A's rref
						pivIter++;
					}
					else //if t-th elmt is free
					{
						if (t == k)
							{ans[t][freeCount] = 1;}
						else
							{ans[t][freeCount] = 0;}
					}
				}
				freeCount++;
			}
		}
		return ans;
	}
	

	/**
	 * Tells you whether a given row is all 0s or not
	 * @param myRow The row to test
	 * @return True if the row is all 0s
	 */
	private boolean isZeroRow(int myRow)
	{
		for(int i = 0; i < cols; i++)
		{
			if(A[myRow][i] != 0)
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * Returns the number of free columns in a rref matrix
	 * Use only after calculating the rank (division())
	 * @return The number of free vars in the matrix
	 */
	public int getFreeCols()
	{
		return (getCols() - getRank());
	}
	
	/**
	 * Accesses the rank of A
	 * @return rank The rank
	 */
	public int getRank()
	{
		return rank;
	}

	/**
	 * Accesses the number of rows of A
	 * @return n The number of rows
	 */
	public int getRows()
	{
		return rows;
	}

	/**
	 * Accesses the number of cols of A
	 * @return n The number of cols  (not augmented)
	 */
	public int getCols()
	{
		return cols;
	}

	/**
	 * Tells you whether a specific column/variable is free or not (pivot)
	 * Use only after particSol() where you set compute this
	 * @param num The column you are checking 
	 * @return True if the column is a free column
	 */
	public boolean getIsFree(int num)
	{
		return isFree[num];
	}
	
	/**
	 * Tells you whether there is 0, 1 or inf solutions to the system.
	 * Use only after particSol()
	 * @return 0: no sol. 1: one sol. 2: inf solutions
	 */
	public int getNumSols()
	{
		return numSols;
	}
	
	/**
	 * Outputs how many solutions the system has
	 * Use only after particSol()
	 */
	public void solutionType()
	{
		String ret = null;
		if(numSols == 0) {ret = "The are no solutions.";}
		else if(numSols == 1) {ret = "There is one solution: (The nullspace is trivial: {0})";}
		else if(numSols == 2) {ret = "There are infinite solutions.";}
		System.out.println(ret);
	}
	
	/**
	 * Prints out a representation of the matrix (m, n, augmented matrix)
	 */
	public String toString()
	{
		//DecimalFormat df = new DecimalFormat("0.00");
		String report = "";
		report += "m = " + rows + "\n";
		report += "n = " + cols + "\n";
		report += "[ | ] = " + "\n";
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < cols+1; j++)
			{
				report += /*df.format*/(A[i][j]) + "  ";
			}
			report += "\n";
		}
		return report;
	}



}
