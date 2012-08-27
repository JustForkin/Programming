
public class FirstBench extends Bench{

	private final int seatsInBench = 2;
	
	private final int WINDOW = 0;
	private final int AISLE = 1;
	
	private Seat[] mySeats;
	
	private boolean fitOne;
	private boolean fitTwo;
	
	private boolean fitWindow;
	private boolean fitAisle;
	
	private boolean[][] fitPassengers = new boolean[seatsInBench][seatsInBench];
	
	/**
	 * Constructs a first class bench which contains 3 seats and sets all seat preferences to available
	 */
	FirstBench()
	{
		mySeats = new Seat[seatsInBench];
		for(int e = 0; e < seatsInBench; e++)
		{
			mySeats[e] = new Seat();
		}
		
		fitOne = false;
		fitTwo = false;
		
		fitWindow = false;
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
		if(mySeats[AISLE].seatTaken() == false)
			{fitAisle = true;}
		else {fitAisle = false;}
		if(mySeats[WINDOW].seatTaken() == false ||  mySeats[AISLE].seatTaken() == false)
			{fitOne = true;}
		else {fitOne = false;}
		if((mySeats[WINDOW].seatTaken() == false) && (mySeats[AISLE].seatTaken() == false))
			{fitTwo = true;}
		else {fitTwo = false;}
		
		if(fitOne == true && fitWindow == true)
		{fitPassengers[1-1][WINDOW] = true;}
		else {fitPassengers[1-1][WINDOW] = false;}
		if(fitOne == true && fitAisle == true)
		{fitPassengers[1-1][AISLE] = true;}
		else {fitPassengers[1-1][AISLE] = false;}
		
		if(fitTwo == true && fitWindow == true)
		{fitPassengers[2-1][WINDOW] = true;}
		else {fitPassengers[2-1][WINDOW] = false;}
		if(fitTwo == true && fitAisle == true)
		{fitPassengers[2-1][AISLE] = true;}
		else {fitPassengers[2-1][AISLE] = false;}
		
		
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
	
	public String drawL()
	{
		String benchPic = "";
		benchPic += mySeats[WINDOW].draw();
		benchPic += mySeats[AISLE].draw();
		benchPic += " ";
		return benchPic;
	}
	public String drawR()
	{
		String benchPic = "";
		benchPic += mySeats[AISLE].draw();
		benchPic += mySeats[WINDOW].draw();
		return benchPic;
	}
}

	

