import java.util.ArrayList;


public class SavingsAccount {

	private ArrayList<Double> myTrans = new ArrayList<Double>();
	private double balance;
	private double rate;
	private String name;
	
	public SavingsAccount(String anOwner, double aRate)
	{
		name = anOwner;
		rate = aRate;
		balance = 0;
	}
	
	
	public String getName()
	{
		return name;
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	public double getRate()
	{
		return rate;
	}
	
	public ArrayList<Double> getTransactions()
	{
		return myTrans;
	}
	
	public void withdraw(double amount)
	{
		balance = balance - amount;
		myTrans.add(-amount);
	}
	
	public void deposit(double amount)
	{	
		balance = balance + amount;
		myTrans.add(amount);
	}
	
	public void accrueInt()
	{
		balance = balance * (1+rate);
	}
	
}
