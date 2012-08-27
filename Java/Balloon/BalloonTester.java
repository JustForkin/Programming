//tests Balloon class

public class BalloonTester {

	/**
	 * constructs empty balloon, adds 100cm^3 of air, tests 3 accessor methods, 
	 * and again adds 100cm^3 of air and tests 3 accessor methods
	 * @param args not used
	 */
	public static void main(String[] args) 
	{
		//constructs (empty) balloon
		Balloon myBalloon = new Balloon();
		
		//adds 100cm^3 of air
		myBalloon.addAir(100);
		//tests 3 accessor methods
		System.out.println("Volume: " + myBalloon.getVolume() + "cm^3");
		System.out.println("Radius: " + myBalloon.getRadius() + "cm");
		System.out.println("Surface Area: " + myBalloon.getSurfaceArea() + "cm^2");
		
		//adds 100cm^3 of air again and tests 3 accessor methods again
		myBalloon.addAir(100);
		System.out.println("\nVolume: " + myBalloon.getVolume() + "cm^3");
		System.out.println("Radius: " + myBalloon.getRadius() + "cm");
		System.out.println("Surface Area: " + myBalloon.getSurfaceArea() + "cm^2");
		
	}

}
