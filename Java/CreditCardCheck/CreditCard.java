
public class CreditCard {

	private long cardNumber;
	public final int NUMBER_LENGTH = 8;
	
	public CreditCard(long inputNumber)
	{
		cardNumber = inputNumber;
	}
	
	public long sum1()   ///sums every other digit starting with rightmost
	{
		long tempNumber = cardNumber;
		long sum = 0;
		while (tempNumber > 0)
		{
			long digit = tempNumber % 10;
			tempNumber /= 100; 
			sum += digit;
		}
		return sum;
	}
	
	public long sum2()  // sums the digits of 2 times every other digit of credit card number starting with 2nd from right
	{
		long tempNumber = cardNumber;
		long sum = 0;
		while (tempNumber > 0)
		{
			tempNumber /= 10;
			long digit = 2 * (tempNumber % 10);
			sum += addDigs(digit);
			tempNumber /= 10;
		}
		return sum;
	}

	public long addDigs(long input)  //adds the digits of the input given to it
	{
		long sum = 0;
		while (input > 0)
		{
			sum += input % 10;
			input /= 10;
		}
		return sum;
	}
	
	public long sum()  //add up the two previous partial sums computed in sum1() and sum2()
	{
		long sum = sum1() + sum2();
		return sum;
	}
	
	public long sumValid()  //checks if the check digit is valid. If not, returns the value it should be. 
							//If it is valid, returns -1 which is an impossible value for the check digit so that tester class knows it was valid.
	{
		long tempNumber = cardNumber;
		if(sum() % 10 == 0)
			return -1;
		else
		{
			long checkDig = ( (tempNumber % 10) + (10 - (sum() % 10) ) ) % 10;
			return checkDig;
		}
	}
	
	
}