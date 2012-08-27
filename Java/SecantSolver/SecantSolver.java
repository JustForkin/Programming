
public class SecantSolver {

	private Function f;
	private double p_0;
	private double p_i;
	private double p_i1;
	private double e;
	private final int ABSOLUTE = 20;
	
	
	public SecantSolver(double myP_0, double myP, double myE)
	{
		p_0 = myP_0;
		p_i = myP;
		e = myE;
		f = new MyFunction();   //
		 
	}
	
	public double solve(Function f)
	{
		int count = 0;
		p_i1 = p_i - (f.solveFunction(p_i)/((f.solveFunction(p_i)-f.solveFunction(p_0))/(p_i-p_0)));
		
		while ( (count < ABSOLUTE) &&  ((checkError1() == false) || (checkError2() == false)) )
		{
			p_i = p_i1;
			p_i1 = p_i - (f.solveFunction(p_i)/((f.solveFunction(p_i)-f.solveFunction(p_0))/(p_i-p_0)));
			count++;
		}
		
		return p_i1;
		
	}
	
	public String toString()
	{
		String report = "";
		report += "approximation: " + solve(f);
		return report;
	}
	
	private boolean checkError1()
	{
		if ( ( Math.abs( f.solveFunction(p_i1) ) ) <= e )
		{
			return true;
		}
		else {return false;}
	}
	
	private boolean checkError2()
	{
		if ((Math.abs(p_i1) - Math.abs(p_i)) <= e)
		{
			return true;
		}
		else {return false;}
	}
	
	
}
