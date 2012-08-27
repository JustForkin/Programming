
public class EconBench extends Bench{

	private final int seatsInBench = 3;
	
	private final int WINDOW = 0;
	private final int CENTER = 1;
	private final int AISLE = 2;
	
	private Seat[] mySeats = new Seat[seatsInBench];
	
	private boolean fitOne;
	private boolean fitTwo;
	private boolean fitThree;
	private boolean fitWindow;
	private boolean fitCenter;
	private boolean fitAisle;
	
	private boolean[][] fitPassengers = new boolean[seatsInBench][seatsInBench];
	
	/**
	 * Constructs an economy class bench which contains 2 seats and sets all seat preferences to available
	 */
	EconBench()
	{
		mySeats = new Seat[seatsInBench];
		for(int e = 0; e < seatsInBench; e++)
		{
			mySeats[e] = new Seat();
		}
		
		fitOne = false;
		fitTwo = false;
		fitThree = false;
		fitWindow = false;
		fitCenter = false;
		fitAisle = false;
		
		fitPassengers = new boolean[seatsInBench][seatsInBench];
		for (int i = 0; i < seatsInBench; i++)
			{
				for (int j = 0; j < seatsInBench; j++)
				{
					
					fitPassengers[i][j] = false;
				}
			}
					
		
	}
	
	public void update()
	{
		if(mySeats[WINDOW].seatTaken() == false)
			{fitWindow = true;}
		else {fitWindow = false;}
		if(mySeats[CENTER].seatTaken() == false)
			{fitCenter = true;}
		else {fitCenter = false;}
		if(mySeats[AISLE].seatTaken() == false)
			{fitAisle = true;}
		else {fitAisle = false;}
		if(mySeats[WINDOW].seatTaken() == false || mySeats[CENTER].seatTaken() == false || mySeats[AISLE].seatTaken() == false)
			{fitOne = true;}
		else {fitOne = false;}
		if((mySeats[WINDOW].seatTaken() == true) ^ (mySeats[CENTER].seatTaken() == true) ^ (mySeats[AISLE].seatTaken() == true))
			{fitTwo = true;}
		else {fitTwo = false;}
		if(mySeats[WINDOW].seatTaken() == false && mySeats[CENTER].seatTaken() == false && mySeats[AISLE].seatTaken() == false)
			{fitThree = true;}
		else {fitThree = false;}
		
		if(fitOne == true && fitWindow == true)
		{fitPassengers[1-1][WINDOW] = true;}
		else {fitPassengers[1-1][WINDOW] = false;}
		if(fitOne == true && fitCenter == true)
		{fitPassengers[1-1][CENTER] = true;}
		else {fitPassengers[1-1][CENTER] = false;}
		if(fitOne == true && fitAisle == true)
		{fitPassengers[1-1][AISLE] = true;}
		else {fitPassengers[1-1][AISLE] = false;}
		if(fitTwo == true && fitWindow == true)
		{fitPassengers[2-1][WINDOW] = true;}
		else {fitPassengers[2-1][WINDOW] = false;}
		if(fitTwo == true && fitCenter == true)
		{fitPassengers[2-1][CENTER] = true;}
		else {fitPassengers[2-1][CENTER] = false;}
		if(fitTwo == true && fitAisle == true)
		{fitPassengers[2-1][AISLE] = true;}
		else {fitPassengers[2-1][AISLE] = false;}
		if(fitThree == true)
		{
			fitPassengers[3-1][WINDOW] = true;
			fitPassengers[3-1][CENTER] = true;
			fitPassengers[3-1][AISLE] = true;
		}
		else
		{
			fitPassengers[3-1][WINDOW] = false;
			fitPassengers[3-1][CENTER] = false;
			fitPassengers[3-1][AISLE] = false;
		}
		
		
	}
	
	public boolean check(int people, int preference)
	{
		update();
		if(fitPassengers[people-1][preference] == true)
		{return true;}
		else {return false;}
	}
	
	public String takeSeat(int position)
	{
		mySeats[position].fillSeat();
		return "seat booked.";
	}
	public String takeSeat(int position1, int position2)
	{
		mySeats[position1].fillSeat();
		mySeats[position2].fillSeat();
		return "seats booked.";
	}
	public String takeSeat(int position1, int position2, int position3)
	{
		mySeats[position1].fillSeat();
		mySeats[position2].fillSeat();
		mySeats[position3].fillSeat();
		return "seats booked.";
	}
	
	public boolean getFitWindow()
	{
		return fitWindow;
	}
	public boolean getFitAisle()
	{
		return fitAisle;
	}
	/**
	 * returns whether a center seat is available
	 * @return true or false
	 */
	public boolean getFitCenter()
	{
		return fitCenter;
	}
	
	public String drawL()
	{
		String benchPic = "";
		benchPic += mySeats[WINDOW].draw();
		benchPic += mySeats[CENTER].draw();
		benchPic += mySeats[AISLE].draw();
		benchPic += " ";
		return benchPic;
	}
	
	public String drawR()
	{
		String benchPic = "";
		benchPic += mySeats[AISLE].draw();
		benchPic += mySeats[CENTER].draw();
		benchPic += mySeats[WINDOW].draw();
		return benchPic;
	}
}
