public class MyFunction extends Function {

	private int H = 10;
	private double maxD2 = 0.382134853805984;
	
	public MyFunction() 
	{
		
	}

	double solveFunction(double t)
	{
		double l = (200)*(t/(t+7))*Math.exp(-2.5*t/H);
		return l;
	}
	
	double getMaxD2()
	{
		return maxD2;
	}
}