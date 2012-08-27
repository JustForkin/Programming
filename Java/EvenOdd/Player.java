import java.util.Scanner;
public class Player {

	private int number;
	private boolean isHuman;
	private int dollars;
	private int compType;
	
	public Player(int type)
	{
		if (type == 0)  //type 0: player is human, 
			isHuman = true;  
		else    //type > 1: player is comp
		{
			isHuman = false;
			compType = type;    // 1 or 2
		}
		number = 0;
		dollars = 0;
	}
	private void playHuman()  //how a human player's number is selected
	{
		Scanner sc = new Scanner(System.in);
		int input;
		boolean check = false;  //checks if input is acceptable
		do { //make sure either 1 or 2 is entered as input number
			System.out.println("Declare a number: either 1 or 2");
			input = sc.nextInt();
			if (input == 1 || input == 2) 
			{
				number = input;
				check = true;               // input is acceptable
			}
		} while (!check);  //repeat query if input is not acceptable
	}
	
	private void playComputer()  //how a comp player's number is selected
	{
		double randomNum = Math.random();
		double t;
		if (compType == 1)  //assigning diff comp types diff t switches
			t = 0.5833;      //optimal strategy for odd player is to pick 1  7/12ths or .583333 of the time
		else  //comp type = 2
			t = 0.5;         //optimal strategy for even player is same as odd player; this will limit his losses to 1/12
		
		if (randomNum > t) //based on t, comp guesses either 1 or 2; t is used as a switch
			number = 2;
		else 
			number = 1;
	}


	public void play()  //determines how number is selected based on whether player is human or comp
	{
		if (isHuman)
			playHuman();
		else
			playComputer();
	}


	public int getNumber()
	{
		return number;
	}
	
	public int getDollars()
	{
		return dollars;
	}
	
	public void addDollars(int addition)  //add money to one player's pot
	{
		dollars = dollars + addition;
	}
}
