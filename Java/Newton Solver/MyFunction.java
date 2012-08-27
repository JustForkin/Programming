
public class MyFunction extends Function {

	public MyFunction() 
	{
		
	}

	double solveFunction(double t)
	{
		double l = ( 9 * (Math.exp(-t)) * (Math.cos(2*Math.PI*t)) ) - 3;
		return l;
	}
	
	double solveDerivative(double t)
	{
		double dl =  (-9)*(Math.exp(-t))*( (2*Math.PI*Math.sin(2*Math.PI*t)) + (Math.cos(2*Math.PI*t)) );
		return dl;
	}
	
}
