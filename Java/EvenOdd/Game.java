
public class Game {

	private Player p1;
	private Player p2;
	private int winner; //1 or 2 for player 1 or 2 winning
	
	public Game(int gameType)  //tester will only allow 0 or 1 to be entered
	{
		if (gameType == 1) //human vs comp
		{
			p1 = new Player(0);  //human
			p2 = new Player(1);  //comp type 1
		}
		else //comp vs comp  ... gameType == 0
		{
			p1 = new Player(1); //comp type 1
			p2 = new Player(2); //comp type 2
		}
		
	}
	
	public void play()  //runs a round of the game by getting players' numbers and determining winner
	{
		winner = 0; //tie
		p1.play();  //mutates p1's number
		p2.play();  //mutates p2's number
		determineWinner();
	}
	
	public void determineWinner() //determines who wins based on whether sum is even or odd. Also gives money to winner.
	{
		int result = p1.getNumber() + p2.getNumber();
		
		if (result == 3)  //odd then player 1 wins
		{
			winner = 1;
			p1.addDollars(result); //and gets money
		}
		else  // even then player 2 wins
		{
			winner = 2;
			p2.addDollars(result); // and gets money
		}
	}
	
	public int getWinner()
	{
		return winner;
	}
	
	private int owedDollars()  //difference in money paid
	{
		int owed = Math.abs(p1.getDollars() - p2.getDollars());  
		return owed;
	}
	
	private int moreDollars()  //returns who is owed money ie who has more money in their pot
	{
		int more;
		if(p1.getDollars() > p2.getDollars())  //player 1 has more money
			more = 1;
		else if(p2.getDollars() > p1.getDollars())  //player 2 has more money
			more = 2;
		else                //same amount of money
			more = 0;
		return more;
	}
	
	public String toString()  //output
	{
		String report;
		report = "Player 1 guessed " + p1.getNumber() + ".\n";   //what #s the players guessed in the round
		report += "Player 2 guessed " + p2.getNumber() + ".\n";
		if (winner == 1)   //who won the round
			{
			report += "Player 1 wins!\n";
			}
		else
			{
			report += "Player 2 wins!\n";
			}
		if (moreDollars() == 1)     //outputs who owes who money and how much money he owes (based on difference in their money pots
			{
			report += "In total, player 2 owes player 1 $" + owedDollars() + ".\n";
			}
		else if (moreDollars() == 2)
			{
			report += "In total, player 1 owes player 2 $" + owedDollars() + ".\n";
			}
		else 
			report += "Player 1 and player 2 have broken even!\n";
		return report;
	}
	
	public String getOwed()  //for use by simulator. it's irrelevant who won more games; what's important is who won more money
	{
		String report;     //outputs strictly who owes who money and how much
		if (moreDollars() == 1)
		{
			report = "Player 2 owes player 1 $" + owedDollars() + ".\n";
		}
		else if (moreDollars() == 2)
		{
			report = "Player 1 owes player 2 $" + owedDollars() + ".\n";
		}
		else 
		{
			report = "Player 1 and player 2 have broken even!\n";
		}
		return report;
	}
	
}
