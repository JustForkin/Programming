
public class Time {

	//adds a colon to integer times to make eg 1230 into 12:30
	public static String addColon(int time)
	{
		String tempBeg = "" + time/100;   //get hour value
		String tempEnd = "" + time%100;  //get minute value
		//(prevent x:00 from becoming x:0 , x:05 from becoming x:50 , etc)
		if ((time%100) < 10 && (time%100) >= 0)  //if minutes are single digit
		{
			tempEnd = "0" + tempEnd;  //add the zero in
		}
		
		String report = tempBeg + ":" + tempEnd;  //adds the colon
		return report;
	}

	public static boolean isValid(int time)
	{
		int beg = time/100;  //gets hour value
		int end = time%100;  //gets minute value
		//make sure hour value is from 1-24 and minute value goes from 0-59
		if (beg>0 && beg<25 && end >=0 && end<60)
		{
			return true;
		}
		else return false;
	}
}
