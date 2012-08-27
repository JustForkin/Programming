/**
 * 
 */

/**
 * @author Michael Rubin
 * A general matrix
 */
public class Matrix {

	private int rows;
	private int cols;
	private double A[][];
	
	/**
	 * Constructs a matrix
	 * @param m Number of rows
	 * @param n Number of columns
	 * @param a Array of elements
	 */
	public Matrix(int m, int n, double[][] a)
	{
		rows = m;
		cols = n;
		A = a;
		
		isFree = new boolean[cols];
	}
	
	/**
	 * Constructs a matrix
	 * @param m Number of rows
	 * @param n Number of columns
	 */
	public Matrix(int m, int n)
	{
		rows = m;
		cols = n;
		//A = null;
		
		isFree = new boolean[cols];
	}
	
	/**
	 * Sets an element of the matrix
	 * @param x The row index
	 * @param y The col index
	 * @param val The value to give the element
	 */
	public void set(int x, int y, double val)
	{
		A[x][y] = val;
	}
	
	/**
	 * Multiplies this matrix by another, on the left
	 * @param otherMatrix The matrix on the right side of the multiplication
	 * @return The product of the matrices
	 */
	public Matrix leftMultiply (Matrix otherMatrix)
	{
		if(this.getCols() != otherMatrix.getRows())
		{
			throw new IllegalMatrixMultiplicationException();
		}
		double[][] product = new double[this.getRows()][otherMatrix.getCols()];
		
		for(int K = 0; K < this.getRows(); K++) {//for each row of leftmost
			for(int i = 0; i < otherMatrix.getCols(); i++) {//for each col of rightmost
				for(int j = 0; j < otherMatrix.getRows(); j++) {//for each element in that col
					product[K][i] += A[K][j] * otherMatrix.getValue(j,i);
				}
			}
		}
						
		return new Matrix(this.getRows(), otherMatrix.getCols(), product);
	}
	
	/**
	 * Performs in=place transpos-ition of the matrix
	 */
	public void transpose()
	{
		double A2[][] = new double[cols][rows];
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < cols; j++)
			{
				A2[j][i] = A[i][j];	
			}
		}
		int temp2 = rows;
		rows = cols;
		cols = temp2;
		
		A = A2;
		
		return;
	}
	
	/**
	 * Accessor for number of rows
	 * @return The number of rows
	 */
	public int getRows()
	{
		return rows;
	}
	
	/**
	 * Accessor for the number of columns
	 * @return The number of cols
	 */
	public int getCols()
	{
		return cols;
	}
	
	/**
	 * Accessor for an element of the matrix
	 * @param x The row of the elmt you want to access
	 * @param y The col of the elmt you want
	 * @return The element you wish to access
	 */
	public double getValue(int x, int y)
	{
		return A[x][y];
	}
	
	/**
	 * @override
	 */
	public Matrix clone()
	{
		double[][] cloneA = A.clone();
		Matrix myClone = new Matrix(rows, cols, cloneA);
		return myClone;
	}
	
	/**
	 * Returns the rows, cols, and elmts of the matrix
	 * @override
	 */
	public String toString()
	{
		String report = "";
		report += "rows = " + rows + "\n";
		report += "cols = " + cols + "\n";  ////
		report += "A = " + "\n";
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < cols+1; j++)   ////
			{
				report += A[i][j] + "  ";
			}
			report += "\n";
		}
		return report;
	}
	
	/////////////GAUSS-JORDAN ELIMINATION/////////////////
	
	/**
	 * Solves a matrix using G-J elimination
	 * @return The solution vector to the system, i.e. the coefficients of the fitted parabola
	 */
	public double[] solve()
	{
		forwardElim();
		//System.out.println("after forward elim: \n" + this);
		backElim();
		//System.out.println("after back elim: \n" + this);
		division();
		//System.out.println("after division: \n" + this);
		double[] xHat = particSol();
		return xHat;
	}
	
	private int rank;
	private int numSols;
	private boolean[] isFree;
	
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

	
	
} //end class
