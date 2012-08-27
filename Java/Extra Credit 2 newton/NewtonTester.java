import java.util.Scanner;

public class NewtonTester {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.println("tolerance:");
		double e = s.nextDouble();
		System.out.println("starting input:");
		double p = s.nextDouble();
		
		NewtonSolver mySolver = new NewtonSolver(p, e);
		
		System.out.println(mySolver);
		
		
	}

}
