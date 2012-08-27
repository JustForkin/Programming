
public class FactorGenerator {

	private int number;
	
	public FactorGenerator(int numberToFactor)
	{
		number = numberToFactor;
	}
	
	public int factorize()   //combines the next two methods
	{
		
		if (number == 1)  //1 special case
		{return 1;}
		if (number ==2)  //2 special case
		{return 2;}
		if (hasMoreFactors())  //not prime
		{
			while (hasMoreFactors())     //prints factors until last factor is left
			{
				
				System.out.println(nextFactor());
				number = number / nextFactor();
				
			}
			System.out.println(number);  //prints last factor
			return -2;                     //ends method and lets it know that factorization is at the end
		}
		else   //prime
		{
			return -1;   //end method and tells to print out prime
		}
		
	}
	
	public int nextFactor()     //tells what next factor is
	{
		if (hasMoreFactors())   //...only if there are more factors
		{
			
			for (int i = 2; i < number; i++)   //starts at bottom since we want increasing order
			{
				if (number % i == 0)
				{
					int next_factor = i;
					return next_factor;
				}
			}
		}
		return -1;
	}
	
	public boolean hasMoreFactors()  //if prime or 1, return false. otherwise return true.
	{
		int temp = number;
		//number = numberToFactor;
		//int N = number;
		int remainder = 1;
		int square = (int) Math.sqrt(temp);
		for (int i=2; i<=square+1  &&  remainder!=0; i++)
		{
			if (temp%i == 0)  // not prime
			{
				remainder=0;
				return true;
			}
		}
		if (remainder != 0 && temp != 1)  //prime
		{
			return false;
		}
		if (temp==1)  // 1 special case
		{
			return true;
		}
		return true;
	}
	
}
