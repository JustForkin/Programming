
public class ExtraCreditFunction extends Function {

	public ExtraCreditFunction() 
	{
		
	}
	
	double solveFunction(double t)
	{
		double l0 = (  (1000/t)*(1-Math.pow( (1+t),(-360) ) ) )-135000;
		return l0;
	}
	
	double solveDerivative(double t)
	{
		double l =  (360000/(t *Math.pow((1 + t),361))) - (1000* (1 - Math.pow((1 + t),(-360))))/Math.pow(t,2);
		return l;
	}

	/*
	double solveDerivative(double t)
	{
		double dl = (2000* (1-1/Math.pow((t+1),360)))/Math.pow(t,3)-720000/(Math.pow(t,2) *Math.pow((t+1),361))-129960000/(t*Math.pow( (t+1),362));
		return dl;
	}
	*/
}
