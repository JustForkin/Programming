/**
 * @author Michael Rubin
 */

/** A class for super linked list Nodes
 * @author Michael Rubin
 * Inspired by the basic doubley linked list code in the Weiss textbook
 */
public class LinkedItem<Node> {

	private LinkedItem<Node> next;
	private LinkedItem<Node> prev;
	private String data;
	private int count;
	
	/**
	 * Creates a SLL node and assigns it values
	 * @param value The node's data
	 * @param p Pointer to the previous node
	 * @param n Pointer to the next node
	 */
	public LinkedItem(String value, LinkedItem<Node> p, LinkedItem<Node> n)
	{
		next = n;
		prev = p;
		data = value;
		count = 1;
	}
	
	/**
	 * Mutates 'next' pointer
	 * @param myItem  Node that comes next
	 */
	public void setNext(LinkedItem<Node> myItem)
	{
		next = myItem;
	}
	
	/**
	 * Mutates pointer to previous node
	 * @param myItem Node that comes right before
	 */
	public void setPrev(LinkedItem<Node> myItem)
	{
		prev = myItem;
	}
	
	/**
	 * Accesses node's data
	 * @return Value of node's data
	 */
	public String getData()
	{
		return data;
	}

	/**
	 * Mutates the node's data
	 * @param value New value to give to node to hold
	 */
	public void setData(String value) 
	{
		data = value;
	}
	
	/**
	 * Accesses previous node
	 * @return previous node
	 */
	public LinkedItem<Node> getPrev()
	{
		return prev;
	}
	
	/**
	 * Accesses next node
	 * @return next node
	 */
	public LinkedItem<Node> getNext()
	{
		return next;
	}
	
	/**
	 * Accesses node's count 
	 * @return How many node there are with same data
	 */
	public int getCount()
	{
		return count;
	}

	/**
	 * Mutates the node's count
	 * @param value New value to give to node's count variable to hold
	 */
	public void setCount(int value) 
	{
		count = value;
	}
	
	/**
	 * Adds 1 to the node's count
	 */
	public void setCount()
	{
		count++;
	}
	
	/**
	 * Subtracts 1 from the node's count
	 */
	public void decCount()
	{
		count--;
	}
	
	/**
	 * Returns a String representation of the node
	 * @return The value in the node and it's count
	 */
	@Override
	public String toString()
	{
		String report = "";
		report += getData() + "("+getCount()+") ";
		return report;
	}
	
	
}
