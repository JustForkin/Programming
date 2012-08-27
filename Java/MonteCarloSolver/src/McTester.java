import java.util.Scanner;

public class McTester {

	public static void main(String[] args) {

		//user input
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter number of random numbers you wish to use: ");
		int n = s.nextInt();
		
		Function f = new MyFunction();
		
		System.out.println("user input:");
		McSolver mySolver = new McSolver(n, f);
		System.out.println(mySolver + "\n");
		
		//hard-coded
		System.out.println("10^2:");
		McSolver mySolver2 = new McSolver(100, f);
		System.out.println(mySolver2 + "\n");
		
		System.out.println("10^3:");
		McSolver mySolver3 = new McSolver(1000, f);
		System.out.println(mySolver3 + "\n");
		
		System.out.println("10^4:");
		McSolver mySolver4 = new McSolver(10000, f);
		System.out.println(mySolver4 + "\n");

		System.out.println("10^5:");
		McSolver mySolver5 = new McSolver(10000, f);
		System.out.println(mySolver5 + "\n");

		System.out.println("10^6:");
		McSolver mySolver6 = new McSolver(10000, f);
		System.out.println(mySolver6 + "\n");
	}

}
