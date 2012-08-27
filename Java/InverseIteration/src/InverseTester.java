/**
 * 
 */

/**
 * @author Michael Rubin
 *
 */
public class InverseTester {

	/**
	 * Creates a matrix and performs inverse iteration on it
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double[][] elmts = new double[10][10];
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				if(i == j)
					elmts[i][j] = 2;
				else if(Math.abs(i-j) == 1)
					elmts[i][j] = -1;
				else elmts[i][j] = 0;
			}
		}
		Matrix A = new Matrix(10, 10, elmts);
		Matrix[] sol = A.inverseIterate();
		//System.out.println(sol[0]);
		//System.out.print(sol[1]);
		
	}

}
