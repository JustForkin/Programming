import java.util.Scanner;
public class Test {

	
	public static void main(String[] args) {  //allows game to be played, comp vs comp or human vs comp
		boolean again = true;
		System.out.println("Welcome to EvensOdds!");
		System.out.println("Would you like to play against a computer or have 2 computers play?");
		Scanner sc;
		int input;
		do{  //makes sure a valid number is entered to select which mode of testing to perform
		System.out.println("Enter 1 to play a computer, and 0 to have two computers play.");
		sc = new Scanner(System.in);
		input = sc.nextInt();
		} while (input != 0 && input != 1);  //only accept 0 or 1 as valid input
		
		Game myGame = new Game(input); //creates game
		do //allows multiple rounds of game
		{
		myGame.play();   //plays round of game
		System.out.println(myGame);   //prints output from game round
		System.out.println("Press 1 for another round.");
		Scanner sc2 = new Scanner(System.in);
		if (sc2.nextInt()!=1)  //if user wishes to end session and stop creating more rounds of game
		{
			again = false;
		}
		} while(again); 
		
		System.out.println("\n");
	}

}
