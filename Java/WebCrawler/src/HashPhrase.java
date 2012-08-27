import java.io.Serializable;

/**
 * 
 */

/**
 * @author Michael Rubin
 * Wraps a word with an additional int attribute (phrase frequency)
 */
public class HashPhrase implements Serializable{

	private static final long serialVersionUID = 8943282643581519314L;
	int frequency;
	HashElmt hPointer;
	
	/**
	 * Creates a HashPhrase with a reference to a HashElmt and an occurrence of 1
	 */
	public HashPhrase(HashElmt h)
	{
		hPointer = h;
		frequency = 1;
	}
		
	/**
	 * Return frequency
	 * @return Number of times this word follows in a 2-word phrase
	 */
	public int getFreq()
	{
		return frequency;
	}
	
	/**
	 * Add 1 to frequency
	 */
	public void incrementFreq()
	{
		frequency++;
	}
	
	/**
	 * Return the String value of the HashElmt contained within
	 * @return
	 */
	public String getVal()
	{
		return hPointer.getVal();
	}
	
	/**
	 * Gets the HashElmt contained within
	 * @return Reference to the HashElmt
	 */
	public HashElmt getPointer()
	{
		return hPointer;
	}
	
	
	/**
	 * Compares HashPhrases and HashElmts based on the String values they contain
	 */
	public boolean equals(Object other)
	{
		if(other instanceof HashElmt)
		{
			return hPointer.equals(other);
		}
		else if(other instanceof HashPhrase)
		{
			return hPointer.equals(((HashPhrase)other).getPointer());
		}
		else if(other instanceof String)
		{
			return this.hPointer.getVal().equals(other);
		}
		else return ((Object)this).equals(other);  //shouldn't happen
	}
	
	/**
	 * resets the frequency of the phrase
	 */
	public void resetFreq()
	{
		frequency = 1;
	}
	
}
