import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;


public class Schedule {

	private ArrayList<Appointment> aptBook = new ArrayList<Appointment>();

	public Schedule()
	{
		//empty
	}
	
	public void printDay(Date aptDay)   
	{  //prints all appts for a given day
		String report = "";
		sort();
		
		for(int i=0; i<aptBook.size(); i++)
		{
			//reformat each appointment to a string:
			Appointment currentApt = aptBook.get(i);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
			Date tempDate = currentApt.getAptDay(); 
			String tempString = df.format(tempDate);
		
			int counter=1; //keep track of appointment number relative to day as opposed to absolute chronological order of appt. (Serves an aesthetic purpose.)
			 
			if (tempDate.equals(aptDay))  //if date of an appt equals the given day,
			{ //..collect it's info to print
				report += "--------- Appointment " + counter + " ---------\n";
				report += "Description: " + currentApt.getDescription() + "\n";
				report += "Date: " + tempString + "\n";
				report += "Start time: " + Time.addColon(currentApt.getStartTime()) + "\n";
				report += "End time: " + Time.addColon(currentApt.getEndTime()) + "\n";
				counter++;
			}
		}
		
		if (report == "")  //if no appointments on a given day tell user that
		{
			System.out.println("No appointments for that day.\n");
		}
		else  //..otherwise print all the appointments on the chosen day's info
		{
			System.out.println(report);
		}
	}
	
	public static boolean isNoConflict(Appointment a, Appointment b)
	{
		//check dates
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
		//change Date to String
		String tempString = df.format(a.getAptDay());
		String tempString2 = df.format(b.getAptDay());
		
		//change String to String (get rid of slashes)
		String noSlash = tempString.substring(0, 2) + tempString.substring(3, 5) + tempString.substring(6);
		String noSlash2 = tempString2.substring(0, 2) + tempString2.substring(3, 5) + tempString2.substring(6);
		
		//change String to int
		int tempInt = Integer.parseInt(noSlash);
		int tempInt2 = Integer.parseInt(noSlash2);
		
		if(tempInt != tempInt2) return true; // if Date 1 is not the same as Date 2
		
		//if dates are the same,
		else  ////make sure the times don't conflict
		{  
			if (a.getStartTime() > b.getStartTime()) //if a starts later than b does,
			{
				if (a.getStartTime() >= b.getEndTime()) //..make sure it starts later (or =) than b ends,
				{
					return true;
				}
				else return false; //..or else they conflict
			}
			else if (a.getStartTime() < b.getStartTime()) //if a starts before b does,
			{
				if (a.getEndTime() <= b.getStartTime()) //..make sure it ends before (or =) b starts,
				{
					return true;
				}
				else return false; //..or else they conflict
			}
			else return false; //if they start at same time then they conflict
		}
	}
	
	public void addApt(Appointment newApt)   ///add an appointment
	{
		sort();    
		
		
		int index = Collections.binarySearch(aptBook, newApt);    
		//uses binary search to find the location which you will use to determine where to put the new appointment
		
		index = ((index+1)*(-1))-1; //reconfigures what the pre-existing binary search returns to make it easier to work with
		
		
		if(newApt.getStartTime() >= newApt.getEndTime())  //invalid appt if it ends before it starts
		{
			System.out.println("Sorry, but appointment must end after it begins.\n");
		}
		else
		//check for no conflict and then add new appt. if there's a conflict appt isn't added. If there is none:
		//special cases
		if(aptBook.size() == 0)   //only 1 elmt in arraylist
		{
			aptBook.add(newApt);
			System.out.println("You have successfully added an appointment!\n");
		}
		else if (index < 0) //new appt placed at beginning of array list
		{
			if (isNoConflict(aptBook.get(index+1), newApt))
					{
					aptBook.add(newApt);
					System.out.println("You have successfully added an appointment!\n");
					}
			else System.out.println("Sorry, there is a conflict.");	
		}
		else if (index >= aptBook.size()-1)  //new appt placed at end of arraylist
		{
			if (isNoConflict(aptBook.get(index), newApt))
					{
					aptBook.add(newApt);
					System.out.println("You have successfully added an appointment!\n");
					}
			else System.out.println("Sorry, there is a conflict.");	
		}
		//standard	-- check appt before AND after to make sure no conflict
		else if (isNoConflict(aptBook.get(index), newApt) && isNoConflict(aptBook.get(index+1), newApt))
		{
			aptBook.add(newApt);
			System.out.println("You have successfully added an appointment!\n");
			
		}
		else
		{
			System.out.println("Sorry, there is a conflict.");
		}
		
		sort();
	}
	
	private void sort() //select sort   
   {
        int floor;
        Appointment temp;
        for(int i=0; i<aptBook.size()-1;i++)
        {
           floor=i;
           for(int j=i+1;j<aptBook.size();j++)
           {
              if(aptBook.get(j).compareTo(aptBook.get(floor))<0)
                floor=j;
           } 
           temp=aptBook.get(floor);
           aptBook.set(floor,aptBook.get(i));
           aptBook.set(i,temp);

           } 
   } 

	
}
