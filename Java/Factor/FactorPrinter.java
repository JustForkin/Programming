import java.util.Scanner;
public class FactorPrinter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Enter an integer to factor:");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		FactorGenerator myFactor = new FactorGenerator(input);
		
		if (myFactor.factorize() == -2)     //end cycle if composite number finishes printing its factors
		{System.out.print("");}     
		else if (myFactor.factorize() == -1)  //if prime number prints prime
		{System.out.println("prime");}
		/*else
		{System.out.println(myFactor.factorize());}  
		*/
		
		//System.out.println(myFactor.hasMoreFactors());
	}
	
}
		
	


