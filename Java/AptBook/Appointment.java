import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class Appointment implements Comparable<Appointment> {

	private String description;  //description
	private Date aptDay;     //date
	private int startTime;  //start time
	private int endTime;  //end time
	
	public Appointment(String desc, String day, int start, int end) //constructor
	{
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		
		description = desc;
		
		ParsePosition pos = new ParsePosition(0);
		aptDay = dateFormat.parse(day, pos);
			
		startTime = start;
		endTime = end;
		
	}
	
	public int compareTo(Appointment otherObject)
	{
		Appointment other = (Appointment) otherObject;
		
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
		//change Date to String
		String tempString = df.format(aptDay);
		String tempString2 = df.format(other.aptDay);
		
		//change String to String (get rid of slashes) and reordered yyyyMMdd
		String noSlash = tempString.substring(6) + tempString.substring(0, 2) + tempString.substring(3, 5); 
		String noSlash2 = tempString2.substring(6) + tempString2.substring(0, 2) + tempString2.substring(3, 5);
		
		//change String to int
		int tempInt = Integer.parseInt(noSlash);
		int tempInt2 = Integer.parseInt(noSlash2);
		
		if(tempInt < tempInt2) return -1; // if Date 1 is earlier return -1
		else if (tempInt == tempInt2)     //if Date 1 is same date as Date 2
		{              //..then order varies depending on time in a similar fashion
			if(startTime < other.startTime) return -1;
			else if(startTime == other.startTime) return 0;
			else return 1; // if (startTime > other.startTime)
		}
		else return 1; // if (tempInt > tempInt2)   ie Date 1 is at a later date than Date 2
	}
	
	public int getStartTime()
	{
		return startTime;
	}
	public int getEndTime()
	{
		return endTime;
	}
	public Date getAptDay()
	{
		return aptDay;
	}
	public String getDescription()
	{
		return description;
	}
}
