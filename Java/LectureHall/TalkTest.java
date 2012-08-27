import java.util.ArrayList;
import java.util.Scanner;


public class TalkTest {

	public static void main(String[] args) {
		
		ArrayList<Talk> mySched = new ArrayList<Talk>(); 
		Scanner s = new Scanner(System.in);
		boolean choice=true;
		while(choice == true) //they want to add another talk
		{
			System.out.println("Enter the start and end times for a talk. (In 24 hour time, integers only.) The lecture hall is available from 800 to 1800.");
			boolean invalidA = true;
			boolean invalidB = true;
			int start = -1;   //initialized out of necessity to meaningless value
			int end = -1;
			//take in start/end values and validate them
			while (invalidA == true)
			{
				System.out.print("Start time:\n");
				Scanner sc = new Scanner(System.in);
				start = sc.nextInt();
				if (start >= 800 && start <= 1800 && Time.isValid(start))  //make sure start time is a valid time AND fits in the allotted lecture times
				{
					invalidA = false; //..or else user needs to give a value that'll work
				}
			}
			while (invalidB == true)
			{
				System.out.print("End time:\n");
				Scanner sc = new Scanner(System.in);
				end = sc.nextInt();
				if (end >= 800 && end <= 1800 && start < end && Time.isValid(end))
				{ //make sure end time is valid time AND fits in the allotted lecture times and occurs after lecture starts
					invalidB = false;  //..or else user needs to give a valid end time
				}
			}
			Talk myTalk = new Talk (start, end);  //makes talk using start/end times
			Scheduler.addTalk(mySched, myTalk);  //adds it to sched
			//check to see if user wishes to add another talk
			System.out.println("Do you wish to enter another talk? (1 to affirm, 0 to quit and print out a list containing max number of nonconflicting talks.)");
			if (s.nextInt() == 0)  //0 quits
			{
				choice = false;
			}
		}
		Scheduler.schedTalks(mySched); //schedules and prints talks
		
		
		
	}
}
