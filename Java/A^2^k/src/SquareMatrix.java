import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/** Class for creating/implementing a square matrix 
 * @author Michael Rubin
 *
 */
public class SquareMatrix {

	private int n;
	private int k;  
	private int exp;
	private double A[][];
	
	/**
	 * Creates a square matrix by reading an input file
	 * @param myFile input file which is read to create matrix.
	 * Must be in the following format:
	 * n
	 * k
	 * row 1
	 * row 2
	 * ...
	 * row n
	 */
	SquareMatrix(File myFile)
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
		exp = (int) Math.pow(2, k);
		A = new double[n][n];
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				A[i][j] = sc.nextDouble();
			}
		}
	}
	
	/**
	 * Creates a square matrix from more primitive arguments
	 * @param size The size of the square matrix (i.e. n)
	 * @param pow The k in 2^k
	 * @param values The elements of the matrix
	 */
	SquareMatrix(int size, int pow, double[][] values)
	{
		n = size;
		k = pow;
		exp = (int) Math.pow(2, k);
		A = values;
	}
	
	/**
	 * Multiplies two square matrices (with this matrix on the left)
	 * @param otherMatrix The matrix we are multiplying by on the RHS
	 * @return product of the multiplication
	 */
	public SquareMatrix leftMultiply(SquareMatrix otherMatrix)
	{
		double[][] product = new double[n][n];
		
		for(int K = 0; K < n; K++) {//for each row of leftmost
			for(int i = 0; i < n; i++) {//for each col of rightmost
				for(int j = 0; j < n; j++) {//for each element in that col
					product[K][i] += A[K][j] * otherMatrix.getValue(j,i);
				}
			}
		}
						
	return new SquareMatrix(n, 0, product);
	}
	
	/**
	 * Gets a specific element of the matrix
	 * @param row
	 * @param col
	 * @return A[row][col]
	 */
	public double getValue(int row, int col)
	{
		return A[row][col];
	}
	
	/**
	 * Gets the 2d array behind the matrix
	 * @return A
	 */
	public double[][] getValue()
	{
		return A;
	}
	
	/**
	 * Prints out the n*n grid of matrix elements
	 */
	public void printValues()
	{
		String report = "";
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				report += A[i][j] + "  ";
			}
			report += "\n";
		}
		System.out.println(report);
	}
	
	/**
	 * Gets size of (square) matrix
	 * @return n
	 */
	public int getN()
	{
		return n;
	}
	
	/**
	 * Gets number of times matrix wants to be squared
	 * @return k
	 */
	public int getK()
	{
		return k;
	}
	
	/**
	 * Gets power to which we wanna raise the matrix (i.e. 2^k)
	 * @return exp (i.e. 2^k)
	 */
	public int getExp()
	{
		return exp;
	}
	
	/**
	 * Prints out a representation of the matrix (n, k, array of elements)
	 */
	public String toString()
	{
		String report = "";
		report += "n = " + n + "\n";
		report += "k = " + k + "\n";
		report += "A = " + "\n";
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				report += A[i][j] + "  ";
			}
			report += "\n";
		}
		return report;
	}
	
	
	
	
	
}
