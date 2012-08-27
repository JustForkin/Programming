import java.util.Scanner;

public class prime 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("What natural number would you like to determine? ");
		int N = sc.nextInt();
		int remainder = 1;
		int square = (int) Math.sqrt(N);
		
		for (int i=2; i<=square  &&  remainder!=0; i++)
		{
			if (N%i == 0)
			{
				remainder=0;
				System.out.println("Not prime. Factor: " + i);
				
			}
		}
		if (remainder != 0 && N != 1)
		{
			System.out.println("Prime");
		}
		if (N==1)
			System.out.println("Not prime");
		
		
			
		
	}
}
