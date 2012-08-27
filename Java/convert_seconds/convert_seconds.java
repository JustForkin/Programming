import java.util.Scanner;

public class convert_seconds 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int hours = 0;
		int days = 0;
		int years = 0;
		int seconds = 0;
		
		System.out.println("How many hours, days, and years would you like to be converted to seconds?");
		System.out.println("Hours: ");
		hours = sc.nextInt();
		System.out.println("Days: ");
		days = sc.nextInt();
		System.out.println("Years: ");
		years = sc.nextInt();
		
		seconds = hours*3600 + days*86400 + years*31556926;
		System.out.println("Total number of seconds: " + seconds);
		
	}
}
