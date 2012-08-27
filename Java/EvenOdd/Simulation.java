
public class Simulation {

	//look at readMe file for optimal strategy, whether it's a fair game, extra credit, etc.
	public static void main(String[] args) {//runs computer simulator: comps play each other many times
		
		final double TRIALS = 1000000;
		
		System.out.println("Welcome to EvensOdds computer simulator!");
		System.out.println("("+(long)TRIALS+" trials)");
		
		Game myGame = new Game(0);   //creates game. 0 means computers playing each other
		for(int i=0; i < TRIALS; i++)
		{
		  myGame.play();		//plays game TRIALS times
		}
		System.out.print(myGame.getOwed()); //prints who owes who how much money.
		//it's irrelevant who won more games; what's important is who won more money.
		
	}
	
	
}
