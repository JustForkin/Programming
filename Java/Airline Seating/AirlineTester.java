import java.util.Scanner;

/**
 * 
 * @author Michael
 *
 */
public class AirlineTester {
/**
 * Tester class for flight booking mechanism. Allows user to add passengers, show seating, or quit.
 * @param args
 * @throws InvalidInputException
 */
	public static void main(String[] args) throws InvalidInputException{
		
		final int ECON = 0;
		final int FIRST = 1;
		
		final int WINDOW = 0;
		final int CENTER = 1;
		final int AISLE = 2;
		
		final int WINDOW1st = 0;
		final int AISLE1st = 1;
		
		TravelAgent myAgent = new TravelAgent();
		
		int status, number, preference;
		int choice;
		boolean quit = false;
		while(quit == false)
		{
			System.out.println("Would you like to reserve seats [0], print seats [1], or quit? [2]");
			Scanner s = new Scanner(System.in);
			choice = s.nextInt();
			if (choice == 2)
			{
				quit = true;
				System.out.println("Have a nice day!");
			}
			
			else if (choice == 0)
			{
				
				System.out.println("Would you like to fly economy class [0] or first class [1]?");
				status = s.nextInt();
				
				if(status == ECON)
				{
					System.out.println("How many people in your party? 1, 2 or 3?");
					number = s.nextInt();
					System.out.println("What are your seating preferences? window[0], center[1] or aisle[2]?");
					preference = s.nextInt();
					if(number!=1 && number!=2 && number!=3)
					{
						throw new InvalidInputException("Must enter valid group size: 1, 2 or 3");
					}
					if(preference!=WINDOW && preference!=CENTER && preference!=AISLE)
					{
						throw new InvalidInputException("Must enter valid seating preference: window[0], center[1] or aisle[2]");
					}
					System.out.println(myAgent.bookSeats( status,  number,  preference) );
				}
				else if (status == FIRST)
				{
					System.out.println("How many people in your party? 1 or 2?");
					number = s.nextInt();
					System.out.println("What are your seating preferences? window[0] or aisle[1]?");
					preference = s.nextInt();
					if(number!=1 && number!=2)
					{
						throw new InvalidInputException("Must enter valid group size: 1 or 2");
					}
					if(preference!=WINDOW1st && preference!=AISLE1st)
					{
						throw new InvalidInputException("Must enter valid seating preference: window[0] or aisle[1]");
					}
					System.out.println(myAgent.bookSeats( status,  number,  preference) );
				}
				else
				{
					throw new InvalidInputException("Must enter valid flight class: Economy class [0] or first class [1]");
				}
			}
			
			else if(choice == 1)
			{
				
				System.out.println(myAgent.draw(myAgent.getMyPlane()));
				
			}
			else 
			{
				throw new InvalidInputException("Must enter valid input: reserve seats [0], print seats [1], or quit [2]");
			}
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
