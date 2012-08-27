import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 */

/**
 * @author Michael Rubin
 * Main method for the augmented square k-diagonal matrix
 */
public class KDiagTester {

	/** Creates a KDiagMatrix, prints it, does elimination and prints the result, and
	 * then does back substitution and both prints the result and stores it in a text file
	 * @param args args[0] = input; args[1] = output
	 */
	public static void main(String[] args) {

		File inputFile = new File(args[0]);
		KDiagMatrix A = new KDiagMatrix(inputFile);
		
		//print data+solution to console
		System.out.println("The starting (augmented) matrix:\n" + A);
		A.elimination();
		System.out.println("The matrix, after elimination:\n" + A);
		System.out.println("The solution (vector), after backwards elimination: ");
		for(int i = 0; i < A.getN(); i++)
		{
			System.out.println(A.backSub()[i]);
		}
		
		//output solution to text file
		try {
		    BufferedWriter out = new BufferedWriter(new FileWriter(args[1])); 
		    for(int i = 0; i < A.getN(); i++)
			{
					out.write("" + A.backSub()[i]);
					out.write("\n");
			}
		    out.close();
		} catch (IOException e) {
		}
	
		System.out.println("\nsolution to the system can also be found can be found in " + args[1]);
		

	}

}
