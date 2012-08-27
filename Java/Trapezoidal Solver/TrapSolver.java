
public class TrapSolver {

	private double a;
	private double b;
	private double e;
	//private double N;
	private Function f;
	
	public TrapSolver(double myA, double myB, double myE, Function myF)
	{
		a = myA;
		b = myB;
		e = myE;
		f = myF;    
	}
	
	private int findN()
	{
		int N = (int)(Math.sqrt( (1/12.0)*(Math.pow((b-a),3))*(f.getMaxD2())*(1/e)   )    ) +1;
		return N;
		
	}
	
	private double width()
	{
		double w = (b-a)/findN();
		return w;
	}
	
	public double solve()
	{
		double middle = 0;
		for(int i = 1; i < findN(); i++)
		{
			middle += f.solveFunction(a+width()*i);
		}
		double ans = (width()/2.0)*(f.solveFunction(a)+f.solveFunction(b)+2*middle);
		
		return ans;
	}
	
	public String toString()
	{
		String report = "";
		report += "approximation: " + solve();
		return report;
	}
	
	
	
}
