import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Michael Rubin - mnr2114
 */

/** An iterator class for a super linked list
 * @author Michael Rubin
 * Inspired by the basic doubley linked list code in the Weiss textbook
 */
public class SuperIterator<Node> implements Iterator<Node>{
	
	private LinkedItem<Node> current;
	private boolean isRemovable;
	SuperLinkedLists<Node> myList;
	
	/**
	 * Creates an Iterator over a SLL
	 * @param aList The list to iterate over
	 */
	SuperIterator(SuperLinkedLists<Node> aList)
	{
		myList = aList;
		current = myList.getHead().getNext();
		isRemovable = false;
	}
	
	@Override
	public boolean hasNext() 
	{
		return (current != myList.getTail());
	}

	/** Returns value of current item and iterates to next item
	 * @return Value of current node
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Node next() 
	{
		if(!hasNext())
		{
			throw new NoSuchElementException();
		}
		Node retItem = (Node)current.getData(); //store value of current node
		current = current.getNext(); //iterate current to next item
		isRemovable = true; //turn on removable switch
		return retItem;
	}

	@Override
	public void remove()
	{
		if(!isRemovable)
		{
			throw new IllegalStateException();
		}
		try{
		myList.delete(current.getPrev().getData()); //delete node we last iterated over
		isRemovable = false; //turn off removable switch
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
}//end SuperIterator
