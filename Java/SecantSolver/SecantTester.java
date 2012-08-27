import java.util.Scanner;

public class SecantTester {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.println("tolerance:");
		double e = s.nextDouble();
		System.out.println("first starting input:");
		double p0 = s.nextDouble();
		System.out.println("second starting input:");
		double p = s.nextDouble();
		
		SecantSolver mySolver = new SecantSolver(p0, p, e);
		
		System.out.println(mySolver);
		
		
	}

}
