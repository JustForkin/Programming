import java.io.File;

/**
 * 
 */

/**
 * @author Michael Rubin   -   mnr2114
 * hw#4
 * Tests the parabola-fitting class
 */
public class ParabolaTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		File myFile = new File(args[0]);
		Parabola myP = new Parabola(myFile);
		myP.fitData();
		System.out.println(myP);
		
	}

}
