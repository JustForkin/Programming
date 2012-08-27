import java.util.Scanner;

/**
 * Runs the even odds game.
 * @author Joseph
 *
 */
public class EvenOddTester {

	/**
	 * Tests the game.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("How many rounds do you want to play?");
		Scanner sc = new Scanner(System.in);
		long rounds = sc.nextLong();
		Game myGame = new Game();
		System.out.println(myGame); //
		myGame.playGame(rounds);

	}

}
