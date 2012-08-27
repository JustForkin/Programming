import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class AppointmentTester {

	
	public static void main(String[] args) {

		//make new sched
		Schedule mySched = new Schedule();
		//variable to check whether user wishes to perform multiple actions
		boolean cont = true; 
		//CHOICE
		Scanner s = new Scanner(System.in);
		int choice;
		
		do {  //loop which allows multiple adds/prints
		
		//see if user wants to add an appointment or print appointments
		System.out.println("Do you want to add an appointment or print appointments for a particular day? (0-add, 1-print, 2-quit)");
		choice = s.nextInt();
		while (choice != 0 && choice != 1 && choice != 2)  //check for valid choice (assuming integer)
		{
			System.out.println("Please enter 0 to add, 1 to print, or 2 to quit");
			choice = s.nextInt();
		} 
		
		if (choice == 2)
		{
			cont = false;  //quit
		}
		
		//make scanner
		Scanner sc = new Scanner(System.in);
		//ADD
		if (choice == 0)  //add
		{
			boolean repeat, repeat2 = false;
			//GET INFO
			//description
			System.out.println("Describe the appointment:");
			String description = sc.nextLine();
			//date
			System.out.println("What day is the appointment? (mm/dd/yyyy formatting please)");
			String date = sc.nextLine();
			//start time (validated)
			int startTime;
			do{
			System.out.println("When does the appointment start? (24 hour time, integers only please)");
			startTime = sc.nextInt();
			if(Time.isValid(startTime) == false) 
				{repeat = true;}
			else repeat = false;
			}while (repeat == true);
			//end time (validated)
			int endTime;
			do{
			System.out.println("When does the appointment end? (24 hour time, integers only please)");
			endTime = sc.nextInt();
			if(Time.isValid(endTime) == false) 
			{repeat2 = true;}
			else repeat2 = false;
			}while (repeat2 == true);
			//make new appointment with that info
			Appointment newApt = new Appointment(description, date, startTime, endTime);
			//actually add the appointment to sched
			mySched.addApt(newApt);
			
		}
		//PRINT
		else if (choice == 1)  //print
		{
			//ask for date to print appointments of
			System.out.println("Please choose a day. (mm/dd/yyyy formatting please)");   
			String day = sc.next();
			//make a Date and convert date stored in String to it
			Date aptDay;
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
			ParsePosition pos = new ParsePosition(0);
			aptDay = dateFormat.parse(day, pos);
			//do the actual printing
			mySched.printDay(aptDay);
			//System.out.print("\n");
		}
		
		} while (cont == true); //end loop which allows multiple adds/prints
		
		
	}

}
