import java.util.Scanner;

public class CreditCardTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Please enter your 8 digit credit card number:");
		System.out.println("XXXXXXXX");
		Scanner sc = new Scanner(System.in);
		long input = sc.nextLong();
		CreditCard myCard = new CreditCard(input);
		if (myCard.sumValid() == -1)                   //  sumValid() having a value of -1 signifies that the check digit is valid so print that
			System.out.println("Number is valid");
		else
			System.out.println("Number is not valid. Check digit should be " + myCard.sumValid());  //if another value is returned other than -1,
																									//then that value is what check digit should be.
	}

}
