public class ExactFunction extends Function {

	
	
	public ExactFunction() 
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
		double l = (Math.E)*(Math.pow(Math.E, .5) -1)*Math.pow((Math.E-1),2);
		return l;
	}
	
	
}