import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Michael Rubin
 * Class for keeping track of words on a webpage
 */
public class HashElmt implements Serializable{

	
	private static final long serialVersionUID = 8654996020730183106L;
	String val;
	int count;
	ArrayList<HashPhrase> children;
	
	/**
	 * Creates a representation of a word on a webpage
	 * @param v The word the HashElmt is representing
	 */
	public HashElmt(String v)
	{
		val = v;
		count = 1;
		children = new ArrayList<HashPhrase>();
	}
	
	/**
	 * Accessor for word's val
	 * @return The value of the String
	 */
	public String getVal()
	{
		return val;
	}
	
	/**
	 * Accessor for count
	 * @return How many times the word appears on the webpage
	 */
	public int getCount()
	{
		return count;
	}
	
	/**
	 * Add 1 to the number of times word has appeared on page
	 */
	public void incrementCount()
	{
		count++;
	}
	
	/**
	 * Adds a phrase child
	 * @param child A word that follows this one on the page
	 */
	public void addChild(HashPhrase child)
	{
		children.add(child);
	}
	
	/**
	 * Accesses the i_th phrase child
	 * @param i Index
	 * @return The child at index i
	 */
	public HashPhrase getChild(int i)
	{
		return children.get(i);
	}
	
	
	public HashPhrase getChild(HashElmt val)
	{
		for(int i = 0; i < children.size(); i++)
		{
			if(children.get(i).equals(val))
			{
				return children.get(i);
			}
			
		}
		return null; //should never happen
	}
	
	public ArrayList<HashPhrase> getChildren()
	{
		return children;
	}
	
	
	/**
	 * Checks if Strings inside are equal
	 */
	public boolean equals(Object other)
	{
		if(other instanceof HashElmt)
		{
			return (this.getVal().equals(((HashElmt) other).getVal()));
		}
		else if(other instanceof HashPhrase)
		{
			return this.equals(  ( (HashPhrase)other ).getPointer() );
		}
		else if(other instanceof String)
		{
			return this.getVal().equals(other);
		}
		else return ((Object)this).equals(other);  //shouldn't happen
	}
	
	/**
	 * Returns the hashcode of the String inside
	 */
	public int hashCode() 
	{
		return val.hashCode();
	}

	/**
	 * Resets the word count
	 */
	public void resetCount()
	{
		count = 1;
	}
	
	
	
}
