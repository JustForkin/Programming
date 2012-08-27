import java.io.File;
//import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class McSolver {

	public static final double REAL = 5.2064465538380191752869907033875949767274187235708703513411;
	private Function f;
	private int n;
	private int count;
	
	McSolver(int myN, Function myF)
	{
		n = myN;
		f = myF;
		count = 0;
	}
	
	public double solve()
	{
		double ans = 0;
		double sum = 0;
		for(int i = 0; i < n; i++)
		{
			sum += f.solveFunction(Math.random(), Math.random(), Math.random());
		}
		ans = (1.0/n)*sum;
		return ans;
	}
	
	public double solveR() throws FileNotFoundException
	{
		double ans = 0;
		double sum = 0;
		for(int i = 0; i < n; i++)
		{
			sum += f.solveFunction(getRan(), getRan(), getRan());
		}
		ans = (1.0/n)*sum;
		return ans;
	}
	
	private double getRan() throws FileNotFoundException
	{
		
		File myFile = new File("RanNums.txt");
		Scanner s = new Scanner(myFile);
		double[] nums = new double[3*n];
		for(int i = 0; i < 3*n; i++)
		{
			nums[i] = (s.nextDouble());
		}
		count++;
		//System.out.println(count-1);
		return nums[count-1];
		
		
	}
	
	
	private String printa()
	{
		String report = "";
		double temp = solve();
		report += "pseudo random approximation: " + temp;
		report += "\nabs error = " + Math.abs((temp-REAL)) + "\n";
		report += "1.0/sqrt(n) = "+Math.sqrt(1.0/n) + "\n";
		return report;
	}
	private String printb()
	{
		String report = "";
		try {
			double temp = solveR();
			report += "true random approximation: " + temp;
			report += "\nabs error = " + Math.abs((temp-REAL));
			report += "\n1.0/sqrt(n) = "+Math.sqrt(1.0/n);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return report;
	}
	public String toString()
	{
		System.out.print(printa());
		System.out.print(printb());
		return "";
	}
	
}
