import java.util.Scanner;

public class TrapTester {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter your error bound: ");
		double e = s.nextDouble();
		
		System.out.println("Enter your starting point: ");
		double a = s.nextDouble();
		
		System.out.println("Enter your ending point: ");
		double b = s.nextDouble();
		
		Function f = new MyFunction();
		
		TrapSolver mySolver = new TrapSolver(a, b, e, f);
		
		System.out.println(mySolver);
		
		
	}

}
