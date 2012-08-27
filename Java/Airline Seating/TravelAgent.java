
public class TravelAgent {

	private final int ECON = 0;
	//private final int FIRST = 1;
	
	private final int WINDOW = 0;
	private final int CENTER = 1;
	private final int AISLE = 2;
	
	private final int AISLE1st = 1;
	
	private Airplane myPlane;
	
	/**
	 * Constructs a travel agent with an airplane to work on
	 */
	TravelAgent()
	{
		myPlane = new Airplane();
	}
	
	/**
	 * Draws an empty/vacant seating chart for a plane which contains 2 classes made up of benches made up of seats
	 * @param myPlane
	 * @return Diagram of seating charts of a specified plane
	 */
	public String draw(Airplane myPlane)
	{
		return myPlane.draw();
	}
	
	/**
	 * Takes in a user's preferences and runs the algorithm to find them seating. Tells user whether or not the specified seating was available.
	 * @param status - first or economy class
	 * @param number - 1/2/3 passengers
	 * @param preference - window/center/aisle seat
	 * @return whether the seats were booked or unavailable
	 */
	public String bookSeats(int status, int number, int preference)
	{
		if(status == ECON)
		{
			for(int i = 0; i < getMyPlane().ECONCOLS; i++)
			{
				for(int j = 0; j < getMyPlane().ECONROWS; j++)
				{
					if(getMyPlane().getEconBench(i, j).check(number, preference) ==  true)
					{
						
						if(number == 1 && preference == WINDOW)
						{return getMyPlane().getEconBench(i, j).takeSeat(WINDOW);}
						else if(number == 1 && preference == CENTER)
						{return getMyPlane().getEconBench(i, j).takeSeat(CENTER);}
						else if(number == 1 && preference == AISLE)
						{return getMyPlane().getEconBench(i, j).takeSeat(AISLE);}
						
						else if(number == 2 && preference == WINDOW)
						{
							return getMyPlane().getEconBench(i, j).takeSeat(WINDOW, CENTER);
						}
						else if(number == 2 && preference == CENTER)
						{
							if(getMyPlane().getEconBench(i, j).getFitWindow() == true)
								{return getMyPlane().getEconBench(i, j).takeSeat(WINDOW, CENTER);}
							else {return getMyPlane().getEconBench(i, j).takeSeat(AISLE, CENTER);}
								
						}
						else if(number == 2 && preference == AISLE)
						{
							return getMyPlane().getEconBench(i, j).takeSeat(AISLE, CENTER);
						}
					
						else if(number == 3)
						{
							return getMyPlane().getEconBench(i, j).takeSeat(WINDOW, CENTER, AISLE);
						}
						
					}
					
					
				}
			}
			return "Sorry, seat not available.";
		}
		
		else
		{
			
			for(int i = 0; i < getMyPlane().FIRSTCOLS; i++)
			{
				for(int j = 0; j < getMyPlane().FIRSTROWS; j++)
				{
					if(getMyPlane().getFirstBench(i, j).check(number, preference) ==  true)
					{
						
						if(number == 1 && preference == WINDOW)
						{return getMyPlane().getFirstBench(i, j).takeSeat(WINDOW);}
						else if(number == 1 && preference == AISLE1st)
						{return getMyPlane().getFirstBench(i, j).takeSeat(AISLE1st);}
					
						else if(number == 2)
						{
							return getMyPlane().getFirstBench(i, j).takeSeat(WINDOW, AISLE1st);
						}
						
					}
	
				}
			}
			return "Sorry, seat not available.";
		}	
		
	}

/**
 * Accesses the plane being worked on
 * @return the plane being worked on
 */
	public Airplane getMyPlane() {
		return myPlane;
	}
	
	
}
		
		
		
		
		
		
	
	
	
	
	
	

