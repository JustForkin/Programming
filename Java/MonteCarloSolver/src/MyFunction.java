public class MyFunction extends Function {

	
	
	public MyFunction() 
	{
		
	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @return
	 */
	double solveFunction(double x, double y, double z)
	{
		double l = 0.5*Math.pow(Math.E,(x+y+1+0.5*z));
		return l;
	}
	
	
}