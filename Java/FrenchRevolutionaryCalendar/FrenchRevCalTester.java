


public class FrenchRevCalTester {
/**
 * Tester class for FrenchRevolutionaryCalendar
 * @param args
 */
	public static void main(String[] args)
	{
		System.out.print("Create Calendar: ");
		FrenchRevolutionaryCalendar myCal = new FrenchRevolutionaryCalendar();
		System.out.println(myCal);
		
		System.out.print("Change year to 2011: ");
		myCal.set(FrenchRevolutionaryCalendar.YEAR, 2011);
		System.out.println(myCal);
		
		System.out.print("Add 3 months: ");
		myCal.add(FrenchRevolutionaryCalendar.MONTH, 3);
		System.out.println(myCal);
		
		System.out.print("Roll down 1 second: ");
		myCal.roll(FrenchRevolutionaryCalendar.SECOND, false);
		System.out.println(myCal);
		
		System.out.print("Fastforward 3 days: ");
		myCal.add(FrenchRevolutionaryCalendar.DAY_OF_WEEK, 3);
		System.out.println(myCal);
		
		System.out.print("Go back in time 2 days: ");
		myCal.add(FrenchRevolutionaryCalendar.DAY_OF_WEEK, -2);
		System.out.println(myCal);
		
		System.out.print("Roll up 1 second: ");
		myCal.roll(FrenchRevolutionaryCalendar.SECOND, true);
		System.out.println("\n   " + myCal); 
		
		System.out.print("Compute time in milliseconds since epoch/default date: ");
		myCal.computeTime();
		System.out.println("\n   " + myCal.getTimeInMillis());
		
		System.out.print("Convert back to date fields from the time just computed since epoch/default date: ");
		myCal.computeFields();
		System.out.println("\n   " + myCal);
		
		System.out.print("Roll down 1 second: ");
		myCal.roll(FrenchRevolutionaryCalendar.SECOND, false);
		System.out.println(myCal); 
		
		System.out.print("Roll down 1 second: ");
		myCal.roll(FrenchRevolutionaryCalendar.SECOND, false);
		System.out.println(myCal); 
		
		System.out.print("Subtract 2005 from year: ");
		myCal.add(FrenchRevolutionaryCalendar.YEAR, -2005);
		System.out.println(myCal);  
		
		System.out.print("Set date to 123456789 millis from epoch/default date: ");
		myCal.setTimeInMillis(123456789);
		System.out.println(myCal); 
		
		System.out.print("Compute date fields from the time since epoch/default date: ");
		myCal.computeFields();
		System.out.println(myCal);
		
		System.out.print("Subtract 33 days from weekday: ");
		myCal.add(FrenchRevolutionaryCalendar.DAY_OF_WEEK, -33); 
		System.out.println(myCal);
		
		System.out.print("Add 8 hours: ");
		myCal.add(FrenchRevolutionaryCalendar.HOUR, 8); 
		System.out.println(myCal);
	}
	
}
