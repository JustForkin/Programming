
public class MyFunction extends Function {

	public MyFunction() 
	{
		
	}

	double solveFunction(double t)
	{
		double l = Math.pow((t-2),2) - Math.log(t);
		return l;
	}
	
	/*
	double solveDerivative(double t)
	{
		double dl =  2*t - 1/t - 4;
		return dl;
	}
	*/
	
}
