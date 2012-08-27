import java.io.File;

/**
 * 
 */

/**
 * @author Michael Rubin
 * Tester class for the Matrix solver 
 */
public class MatrixTester {

	/**
	 * Main method for matrix solver
	 * @param args args[0] The input matrix you wish to solve
	 */
	public static void main(String[] args) {

		File myFile = new File(args[0]);
		Matrix A = new Matrix(myFile);
		System.out.println(A);
		A.forwardElim();
		System.out.println("after forward elim: \n" + A);
		A.backElim();
		System.out.println("after back elim: \n" + A);
		A.division();
		System.out.println("after division: \n" + A);
		System.out.println("rank: " + A.getRank() + "\n");
		//A.findRank();
		//System.out.println("rank: " + A.getRank());

		double[] Xp = A.particSol();
		double[][] Ns = A.nullSpace();
		
		A.solutionType();
		
		if(A.getNumSols() == 1) //1 soln
		{
			String xp = "";
			for(int i = 0; i < A.getCols(); i++)
			{
				xp += Xp[i] + "\n";
			}
			System.out.println(xp);
		}
		
		else if(A.getNumSols() == 2) //inf solns
		{
			//print partic soln
			String xp = "Particular solution:\n";
			for(int i = 0; i < A.getCols(); i++)
			{
				xp += Xp[i] + "\n";
			}
			System.out.println(xp);
			
			//print N(A)
			String ns = "Special solutions (as column vectors):\n";
			for(int k = 0; k < A.getCols(); k++) //rows
			{
				
				for(int j = 0; j < A.getFreeCols(); j++) //free cols
				{
					ns += Ns[k][j] + "   ";
				}
				ns += "\n";
			}
			System.out.print(ns);
		}
				
	}

}
