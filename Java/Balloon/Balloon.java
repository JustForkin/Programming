
public class Balloon {

	/** creates a balloon that air can be added to, which affects the 
	volume, radius, and surface area */
	
	private double air;

	public Balloon()    //creates empty balloon
	{
		air = 0;
	}
	
	public void addAir (double amount)   //adds an amount of air to balloon
	{
		air = air + amount;
	}

	public double getVolume()   //returns volume of balloon ie how many cm^3 of air are in it
	{
		double volume = air;
		return volume;
	}
	
	public double getRadius ()  //returns radius of balloon calculated based on V=(4/3)*pi*r^3
	{
		double radius = Math.cbrt(air*3/4/Math.PI);
		return radius;
	}
	
	public double getSurfaceArea() //returns SA of balloon based on SA=4*pi*r^2
	{
		double surfaceArea = 4*Math.PI*Math.sqrt(getRadius());
		return surfaceArea;
	}
}
