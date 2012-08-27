import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 */

/**
 * @author Michael
 *
 */
public class SavingsAccountTest {

	private final String NAME = "My Account";
	private final double RATE = .05;
	SavingsAccount myAccount;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		myAccount  = new SavingsAccount(NAME, RATE);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		
	}

	/**
	 * Test method for {@link SavingsAccount#SavingsAccount(java.lang.String, double)}.
	 */
	@Test
	public void testSavingsAccount() {
		assertTrue(myAccount.getName() == NAME);
		assertTrue(myAccount.getRate() == RATE);
		assertTrue(myAccount.getBalance() == 0);
	}

	/**
	 * Test method for {@link SavingsAccount#getName()}.
	 */
	@Test
	public void testGetName() {
		
		assertTrue(myAccount.getName() == NAME);
	}

	/**
	 * Test method for {@link SavingsAccount#getBalance()}.
	 */
	@Test
	public void testGetBalance() {
		assertTrue(myAccount.getBalance() == 0);
	}

	/**
	 * Test method for {@link SavingsAccount#getRate()}.
	 */
	@Test
	public void testGetRate() {
		assertTrue(myAccount.getRate() == RATE);
	}

	/**
	 * Test method for {@link SavingsAccount#getTransactions()}.
	 */
	@Test
	public void testGetTransactions() {
		myAccount.deposit(15);
		myAccount.withdraw(7);
		assertTrue(myAccount.getTransactions().get(0) == 15 && myAccount.getTransactions().get(1) == -7);
	}

	/**
	 * Test method for {@link SavingsAccount#withdraw(double)}.
	 */
	@Test
	public void testWithdraw() {
		myAccount.withdraw(50);
		assertTrue(myAccount.getBalance() == -50);
	}

	/**
	 * Test method for {@link SavingsAccount#deposit(double)}.
	 */
	@Test
	public void testDeposit() {
		myAccount.deposit(50);
		assertTrue(  Math.abs(myAccount.getBalance() - .005) <= 50);
	}

	/**
	 * Test method for {@link SavingsAccount#accrueInt()}.
	 */
	@Test
	public void testAccrueInt() {
		myAccount.deposit(50);
		myAccount.accrueInt();
		assertTrue(myAccount.getBalance() == (50 * (1 + myAccount.getRate()) ));
	}
	
	/**
	 *  Test sequence 1
	 */
	@Test
	public void testSeq1()
	{
		myAccount.deposit(1000);
		myAccount.withdraw(10);
		myAccount.withdraw(20);
		myAccount.withdraw(70);
		assertTrue(myAccount.getBalance() == 900);
	}
	
	/**
	 *  Test sequence 2
	 */
	@Test
	public void testSeq2()
	{
		myAccount.deposit(1000);
		myAccount.withdraw(1010);
		myAccount.withdraw(20);
		myAccount.withdraw(70);
		assertTrue(myAccount.getBalance() == -100);
	}
	
}
