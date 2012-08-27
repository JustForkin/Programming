import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Michael
 *
 */
public class Node {

	ArrayList<Integer> setIds;
	ArrayList<Integer> missing;
	int  num;
	
	public Node()
	{
		setIds = new ArrayList<Integer>();
		missing  = new ArrayList<Integer>();
		
	}
	
	public void add(int id)
	{
		setIds.add(id);
	}
	
	public  String toString()
	{
		return setIds.toString();
	}
	
	public void setNum(int highestNum)
	{
		num  = highestNum;
	}
	
	public void findMissing()
	{
		for(int i = 0;  i  <  num;  i++)
		{
			if(!setIds.contains(i))
			{
				missing.add(i);
			}
		}
	}
	
	public boolean  isMissing(int id)
	{
		return missing.contains(id);
	}
	
	public  void addd(int id)
	{
		missing.remove(id);
	}
	
	public boolean  isDone()
	{
		return missing.isEmpty();
	}
	
}
