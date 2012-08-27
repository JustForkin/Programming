
/**
 * @author Michael Rubin - mnr2114
 */

/** A super linked list class
 * @author Michael Rubin
 * Inspired by the basic doubley linked list code in the Weiss textbook
 */
public class SuperLinkedLists<Node> implements Iterable<Node>{

	private LinkedItem<Node> head;
	private LinkedItem<Node> tail;
	private int size;
	
	/**
	 * Creates a SLL and resets it
	 */
	public SuperLinkedLists()
	{
		clear();
	}
	
	/**
	 * Resets the list, and links the head to the tail
	 */
	public void clear()
	{
		head = new LinkedItem<Node>(null, null, null);
		tail = new LinkedItem<Node>(null, head, null);
		head.setNext(tail);  //connect head to tail
		size = 0;
	}
	
	/**
	 * Is the list empty?
	 * @return T if list is empty, F is not (i.e. list size is not 0)
	 */
	public boolean isEmpty()
	{
		return (getSize() == 0);
	}
	
	/**
	 * Change the data contained in a node at specified index to specified value
	 * @param index The position of the node whose data we wish to overwrite
	 * @param newVal The new data we wish to give to the node at the index
	 * @return The value of the old data (that we overwrote)
	 */
	public String set(int index, String newVal)
	{
		LinkedItem<Node> myItem = findNode(index);
		String oldVal = myItem.getData(); //store old data to return
		myItem.setData(newVal);
		return oldVal;
	}
	
	/**
	 * Inserts a value at the end of the list (treated as a regular case ie
	 * not optimized for 'end of the list')
	 * @param value The value of the node we're adding
	 * @return True if method completed
	 */
	public boolean insert(String value)
	{
		insert(getSize(), value);
		return true;
	}
	
	/**
	 * Inserts a value at the specified position on the list
	 * @param index Where we want to add the node
	 * @param value The value of the node we want to add
	 */
	public void insert(int index, String value)
	{
		insertBefore(findNode(index, 0, getSize()), value);
	}
	
	/**
	 * Adds a node before the specified node myItem, and shifts items at that
	 * position or after over by one to make room
	 * @param myItem The LinkedItem that we're adding a node before
	 * @param value Value to give to new node
	 */
	private void insertBefore(LinkedItem<Node> myItem, String value)
	{
		boolean found = false; //flag to tell us when value was found in list
		LinkedItem<Node> tempNode = head.getNext();
		for(int i = 0; (i < getSize()) && (found == false); i++)
		{
			//step 3:
			if(tempNode.getData().equals(value)) //if we find the value
			{
				tempNode.setCount(); //increment counter
				found = true; //we found value elsewhere in list!
			}
			tempNode = tempNode.getNext();  //iterate through list
		}
		
		if(found == false) //if value is not already represented in list, add it
		{
			LinkedItem<Node> newItem = new LinkedItem<Node>(value, myItem.getPrev(), myItem); //create newItem and set it's pointers
			newItem.getPrev().setNext(newItem); //connect to the back of newItem
			myItem.setPrev(newItem); //connect to the front of newItem
			size++;
		}
	}
	
	/**
	 * Removes a node at specified index
	 * @param index Location of node you wish to delete
	 * @return The value of the data of the deleted node
	 * @throws SLException if specified node is not in the list
	 */
	public String delete(int index) throws SLException
	{
		return delete(findNode(index));
	}
	
	/**
	 * Deletes a node by value
	 * @param value Value that we want to remove from SLL
	 * @throws SLException If node with specified value is not in the list
	 */
	public void delete(String value) throws SLException
	{
		if(getSize() == 0) //no elements in list
		{
			throw new SLException();
		}
		else if(value == null)
		{
			throw new SLException();
		}
		else
		{
			boolean removed = false; //flag to indicate if we removed value
			LinkedItem<Node> tempNode = head.getNext();
			for(int i = 0; i < getSize(); i++)
			{
				if(tempNode.getData().equals(value)) //if we found element
				{
					delete(tempNode); //call delete(LinkedItem<Node>) method
					removed = true;
				}
				tempNode = tempNode.getNext();  //iterate through list
			}
			if(removed == false)
			{
				throw new SLException();
			}
		}
	}
	
	/**
	 * Removes the specified node from the list, or decrements its counter if multiple
	 * @param myItem Node to be removed
	 * @return The value of the item removed
	 * @throws SLException if specified node is not in the list
	 */
	private String delete(LinkedItem<Node> myItem) throws SLException
	{
		if(!isInList(myItem)) //Step 2: if item's not in list, throw error
		{
			throw new SLException();
		}
		if(myItem.getCount() == 1) //if there's only 1 of that node, delete it 
		{
			myItem.getNext().setPrev(myItem.getPrev()); //connect the node after myItem to the one before it
			myItem.getPrev().setNext(myItem.getNext()); //connect the node before myItem to the one after it
			size--;
		}
		else //if there's more than 1 of that node, decrement its counter
		{
			myItem.decCount();
		}
		return myItem.getData();
	}
	
	
	/**
	 * Returns whether specified Node is in the list or not
	 * @param myItem The node that we are determining if it's in the list or not
	 * @return True if item is in list, false otherwise
	 */
	private boolean isInList(LinkedItem<Node> myItem)
	{
		if(myItem == null)
		{
			return false;
		}
		else if(myItem.getCount() > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
		/*if(getSize() == 0) //no elements in list
		{
			return false;
		}
		else if(myItem == null)
		{
			return false;
		}
		else
		{
			LinkedItem<Node> tempNode = head.getNext();
			for(int i = 0; i < getSize(); i++)
			{
				if(tempNode.getData().equals(myItem.getData()))
				{
					return true;
				}
				tempNode = tempNode.getNext();
			}
			return false;
		}*/
	}
	
	/**
	 * Finds the node at the specified position in the list
	 * @param index Position of element we wish to find
	 * @return The value of the node we were searching for
	 */
	public String find(int index)
	{
		return findNode(index).getData();
	}
	
	/**
	 * Gets the LinkedItem at specified position, ranging from 0 to size-1
	 * @param index Position we're looking for a node at
	 * @return The node at the specified index
	 */
	private LinkedItem<Node> findNode(int index) //
	{
		return findNode(index, 0, getSize()-1);
	}
	
	/**
	 * Gets the LinkedItem at the specified position, ranging from lower to upper
	 * @param index We're searching for the node at this position
	 * @param lower Lowest valid index
	 * @param upper Highest valid index
	 * @return The node at specified index
	 * @throws IndexOutOfBoundsException if index is not in list (not between 0 and size)
	 */
	private LinkedItem<Node> findNode(int index, int lower, int upper)
	{
		LinkedItem<Node> temp;
		if(index < lower || index > upper) //if specified index is out of list's range
		{
			throw new IndexOutOfBoundsException("findNode index: "+index+"; size: "+getSize());
		}
		if(index < getSize() / 2) //if it's in the front half of the list
		{
			temp = head.getNext();
			for(int i = 0; i < index; i++)
			{
				temp = temp.getNext(); //iterate through list forwards until temp pointer gets to it
			}
		}
		else //if it's in the back half of the list
		{
			temp = tail;
			for(int i = getSize(); i > index; i--)
			{
				temp = temp.getPrev(); //iterate through list backwards until temp pointer gets to it
			}
		}
		return temp;
	}
	
	/**
	 * Mutator method that reverses the SLL 
	 * (for step 4 of the hw)
	 */
	public void reverse()
	{
		LinkedItem<Node> oldHead = head;
		LinkedItem<Node> myIterator = head;
		LinkedItem<Node> temp = null;
		while(myIterator != null)
		{   //swap next and prev pointers
			temp = myIterator.getNext(); 
			myIterator.setNext(myIterator.getPrev());
			myIterator.setPrev(temp);
			
			if(myIterator.getPrev() == null) //reached end of SLL
			{
				head = myIterator;  //head must point to (old) last node
				tail = oldHead; //tail must point to (old) first node
			}
			
			myIterator = myIterator.getPrev(); //iterate
		}
		
	}
	
	/**
	 * Accesses size of list
	 * @return Number of elements in the list
	 */
	public int getSize()
	{
		return size;
	}
	
	/**
	 * Accessor to return head of list
	 * @return head
	 */
	public LinkedItem<Node> getHead()
	{
		return head;
	}
	
	/**
	 * Accessor to return tail of list
	 * @return tail
	 */
	public LinkedItem<Node> getTail()
	{
		return tail;
	}
	
	/**
	 * Prints the list along with the number of each element in parentheses, 
	 * followed by the list along with its frequency count
	 * @param total Numer of elements in the list
	 */
	public void print(int total)
	{
		System.out.println(toString());  //prints list
		String report = "\n";
		LinkedItem<Node> tempNode = head.getNext(); //ie findNode(0)
		for(int i = 0; i < getSize(); i++)
		{
			report += tempNode.getData() + " " + (double)tempNode.getCount()*100.0/total+"%\n"; //computes frequency
			tempNode = tempNode.getNext();  //iterate through list
		}
		System.out.println(report); //prints frequencies
	}
	
	/**
	 * Prints the 100 element list along with the number of each element in parentheses, 
	 * followed by the 100 element list along with its frequency count
	 */
	public void print()
	{
		print(100);
	}
	
	/**
     * Returns a String representation of this collection.
     * @return The data in all the nodes in the SLL and their counts in parentheses
     */
	@Override
    public String toString( )
    {
        String report = "[ ";
        LinkedItem<Node> tempNode = head.getNext();
        for(int i = 0; i < getSize(); i++) //for each node
        {
        	report += tempNode.toString() + " "; //return its data (val/count)
        	tempNode = tempNode.getNext();
        }
        report += "]";
    
        return report;
    }
	
    @Override
	public SuperIterator<Node> iterator() 
	{
		return new SuperIterator<Node>(this);
	}
    
	
	
	
}//end SuperLinkedLists


