import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Michael Rubin
 * Parabola-fitting class.
 * It fits a parabola to given data (data representing a slightly perturbed parabola)
 */
public class Parabola {

	private int m;
	private double C;
	private double D;
	private double E;
	private double t[];
	private double y[];
	private double b[];
	private double C2;
	private double D2;
	private double E2;
	
	/**
	 * Creates a parabola fit based on data read from File.
	 * We give input, perturb its output and find a new parabola to fit the new data
	 * @param myFile contains the following on separate lines:
	 * m - number of data points
	 * C - parabola's 0th-order coefficient
	 * D - parabola's 1st-order coefficient
	 * E - parabola's 2nd-order coefficient
	 * 
	 */
	public Parabola(File myFile)
	{
		Scanner sc = null;
		try 
		{
			sc = new Scanner(myFile);
			} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		m = Integer.parseInt(sc.nextLine());
		C = Double.parseDouble(sc.nextLine());
		D = Double.parseDouble(sc.nextLine());
		E = Double.parseDouble(sc.nextLine());
		t = new double[m];
		y = new double[m];
		b = new double[m];
		
		for(int i = 0; i < m; i++)
		{
			t[i] = i;
		}
		for(int i = 0; i < m; i++)
		{
			y[i] = solveFn(t[i]);
		}
		for(int i = 0; i < m; i++)
		{
			b[i] = y[i] + random();
		}
	}
	
	/**
	 * The algorithm that finds the new coefficients for the parabola that fits the data.
	 * It computes A_trans * A,  A_trans * b, and then uses them to solve for x(^) with GJ elim
	 * since the partial derivatives of ||Ax-b||^2 = 0 when
	 *    (A_trans) * (A) * (x_^) = (A_trans) * (b)
	 */
	public void fitData()
	{
		Matrix A = new Matrix(m, 3, new double[m][3]);  
		for(int i = 0; i < 3; i++) //cols
		{
			for(int j = 0; j < m; j++) //rows
			{
				A.set(j, i, Math.pow(t[j], i));
			}
		}
		
		Matrix At = A.clone();
		At.transpose();
		
		Matrix B = new Matrix(m, 1, new double[m][1]);
		for(int i = 0; i < m; i++) //rows
		{
			B.set(i, 0, b[i]);
		}
		
		Matrix lhs = At.leftMultiply(A);
		Matrix rhs = At.leftMultiply(B);
		
		Matrix augmented = new Matrix(At.getRows(), A.getCols()/*+1*/, new double[At.getRows()][A.getCols()+1]);
		for(int i = 0; i < lhs.getRows(); i++)
		{
			int j = 0;
			for(j = 0; j < lhs.getCols(); j++)
			{
				//System.out.println(i + " " + j); /////////////
				augmented.set(i, j, lhs.getValue(i, j));
			}
		}
		for(int i = 0; i < augmented.getRows(); i++)
		{
			augmented.set(i, augmented.getCols(), rhs.getValue(i, 0));
		}
		
		double[] xHat = augmented.solve();
		C2 = xHat[0];
		D2 = xHat[1];
		E2 = xHat[2];
	}
	
	/**
	 * The formula for the initial parabola (before we mutate the coefficients)
	 * @param t The input value (ie the x value)
	 * @return The output (ie the y value) of the parabola
	 */
	private double solveFn(double t)
	{
		double y;
		y = C + D*t + E*t*t;
		return y;
	}
	
	/**
	 * Generates a small random number
	 * @return A random number between -1 and 1
	 */
	private double random()
	{
		double add = Math.random();
		int sign;
		sign = (add < 0.5) ?  1 : -1;
		return sign*Math.random();
	}
	
	/**
	 * Returns the old parabola coefficients as well as the new ones
	 * @override
	 */
	public String toString()
	{
		String report = "";
		report += "m: " + m  + "\n";
		report += "C: " + C  + "\n";
		report += "D: " + D  + "\n";
		report += "E: " + E  + "\n";
		report += "C': " + C2  + "\n";
		report += "D': " + D2  + "\n";
		report += "E': " + E2  + "\n";
		return report;
	}
	
} //end class
