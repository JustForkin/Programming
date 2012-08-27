import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/** Main method for multiplying A^2^k where A is a square matrix
 * @author Michael Rubin
 *
 */
public class A2kTester {

	/** Creates a SquareMatrix from an input file, squares it k times, and outputs result to an output file
	 * @param args args[0] = input, args[1] = output
	 * @throws IOException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		if (args.length != 2) {
			throw new IOException();
		}
		String input_file = args[0];
		String output_file = args[1];
		File inputFile = new File(input_file);
		SquareMatrix A = new SquareMatrix(inputFile);
		System.out.println(A);
		
		
		SquareMatrix temp = A;
		for(int i = 0; i < A.getK(); i++) {
			temp = temp.leftMultiply(temp);
		}
		
		//temp.printValues();
		try {
		    BufferedWriter out = new BufferedWriter(new FileWriter(output_file)); 
		    for(int i = 0; i < A.getN(); i++)
			{
				for(int j = 0; j < A.getN(); j++)
				{
					out.write(temp.getValue(i,j) + "  ");
				}
				out.write("\n");
			}
		    out.close();
		} catch (IOException e) {
		}
	
		System.out.println("A^2^k = A^" + Math.pow(2, A.getK()) + " can be found in " + output_file);
		
	}

}
