
public class Seat {

	private boolean state;
	
	/**
	 * Constructs a vacant seat
	 */
	Seat()
	{
		state = false;	
	}
	
	
	/**
	 * Returns whether the seat is taken or not yet taken
	 * @return true or false
	 */
	public boolean seatTaken()
	{
		if (state == true) {return true;}
		else {return false;}
		
	}
	
	/**
	 * Puts a person in the seat
	 */
	public void fillSeat()
	{
		state = true;
	}
	
	/**
	 * Draws a picture of the seat with an X to mean it's taken and an O if it's vacant
	 * @return diagram of seat
	 */
	public String draw()
	{
		if(seatTaken() == true)
		{
			return "X";
		}
		else return "O";
	}
	
}
