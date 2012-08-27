
public class NewtonSolver {

	private Function f;
	private double p_i;
	private double p_i1;
	private double e;
	private final int ABSOLUTE = 20;
	
	
	public NewtonSolver(double myP_0, double myE)
	{
		p_i = myP_0;
		e = myE;
		f = new MyFunction();   //
		 
	}
	
	public double solve(Function f)
	{
		int count = 0;
		p_i1 = p_i - (f.solveFunction(p_i)/f.solveDerivative(p_i));
		
		while ( (count < ABSOLUTE) &&  ((checkError1() == false) || (checkError2() == false)) )
		{
			p_i = p_i1;
			p_i1 = p_i - (f.solveFunction(p_i)/f.solveDerivative(p_i));
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
