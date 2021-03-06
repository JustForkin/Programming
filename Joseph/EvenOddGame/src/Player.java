import java.util.Scanner;


/**
 * A player for a even odds game. 
 * @author Joseph
 *
 */
public class Player {
	public static final boolean HUMAN = true;
	public static final boolean COMPUTER = false;
	private int chosenNumber;
	private boolean isHuman;
	
	/**
	 * Constructs a human player.
	 */
	public Player()
	{
		isHuman = HUMAN;
	}
	
	/**
	 * Creates a computer player
	 * @param thresh Sets the threshold for the computer's choice of numbers.
	 */
	public Player(double thresh)
	{
		isHuman = COMPUTER;
		compThreshold = thresh;
	}
	
	/**
	 * Decides which choose method to run.
	 * @return The value of the chosen method.
	 */
	public int chooseNumber()
	{
		int func;
		if (isHuman == HUMAN)
		{
			func = chooseHumanNumber();
		}
		else
		{
			func = chooseCompNumber();
		}
		return func;
	}
	
	/**
	 * The method that allows the human to choose a number.
	 * @return The chosen number.
	 */
	private int chooseHumanNumber()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Pick 1 or 2: ");
		chosenNumber = sc.nextInt();
		return chosenNumber;
	}

	double compThreshold;
	
	/**
	 * The method that allows the computer to choose a number.
	 * @return The chosen number.
	 */
	private int chooseCompNumber()
	{
		double rand = Math.random();
		if (rand > compThreshold)
		{
			chosenNumber = 2;
		}
		else
		{
			chosenNumber = 1;
		}
		return chosenNumber;
	}
	
	public String toString()
	{
		String report = "";
		report += "is human: " + isHuman + "."; 
		return report;
	}
	
}
