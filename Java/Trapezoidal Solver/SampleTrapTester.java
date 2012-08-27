//import java.util.Scanner;

public class SampleTrapTester {

	public static void main(String[] args) {

		
		
		double e = .00000001;
		
		double a = 0;
		
		double b = 10;
		
		Function f = new MyFunction();
		
		TrapSolver mySolver = new TrapSolver(a, b, e, f);
		
		System.out.println(mySolver);
		
		
	}

}
