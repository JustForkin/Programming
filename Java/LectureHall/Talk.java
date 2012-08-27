
public class Talk implements Comparable<Talk> {
	
	private int startTime;
	private int endTime;
	
	public Talk(int start, int end)
	{
		startTime = start;
		endTime = end;
	}
	
	public int compareTo(Talk otherObject)  //makes Talks comparable based on star times
	{
		Talk other = (Talk) otherObject;
		if(startTime < other.startTime) return -1;
		else if(startTime == other.startTime) return 0;
		else return 1; // if (startTime > other.startTime)
		
	}
	
	public int getStart()
	{
		return startTime;
	}

	public int getEnd()
	{
		return endTime;
	}

}
