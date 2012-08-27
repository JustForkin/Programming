import java.util.ArrayList;
import java.util.Collections;


public class Scheduler {

	
	/*public Scheduler()
	{
		//empty
	}
	*/
	
	public static void sort(ArrayList<Talk> roster)  //sort array list (in this case it will be by start time)
	{
		Collections.sort(roster);
	}

	public static void addTalk(ArrayList<Talk> roster, Talk newTalk) //add Talk to array list of talks (and then sort them)
	{
		roster.add(newTalk);
		sort(roster);
	}
	
	//ALGORITHM which schedules max number of talks and then prints them
	public static void schedTalks(ArrayList<Talk> roster) 
	{
		ArrayList<Talk> temp = new ArrayList<Talk>();  //make array list 'temp' which optimal talks are stored in
		
		for (int w=0; roster.size() > 0; w++)  //w will represent which element in temp we are trying to fill
		{	
			sort(roster); //sort roster by earliest start time
			
			temp.add(w, roster.get(0)); //make Wth temp = earliest start time in roster
	
			for(int i = 0; i<roster.size(); i++) //find end time before end time of first talk
			{
				if(roster.get(i).getEnd() < temp.get(w).getEnd()) //if an elmt in roster ends earlier than temp[w] 	
				{                            
					temp.set(w, roster.get(i)); //make it temp[w]
				}
			}
				roster.remove(temp.get(w));  //remove temp[w] from roster since we already have it saved
				
			//remove from roster elmts that conflict with most recently saved elmt since we know we won't be using them	
			for (int k=0; k<roster.size(); k++)   
			{ 
				if (isNoConflict(temp.get(w), roster.get(k)) == false)
				{
					roster.remove(roster.get(k));
					
				}
			}
			
		}		
		
		//print talks
		System.out.println("Schedule:   start     end\n~~~~~~~~~   -----     ---");
		for (int m=0; m < temp.size(); m++)
		{ 
			System.out.println("talk " + (m+1) + ":     " + Time.addColon(temp.get(m).getStart()) + "     " + Time.addColon(temp.get(m).getEnd()) );
		}
		
	}
	
	public static boolean isNoConflict(Talk a, Talk b)  //makes sure two talks don't conflict
	{   
		if (a.getStart() > b.getStart()) //if a starts later than b does,
		{
			if (a.getStart() >= b.getEnd())  //..make sure it starts later (or =) than b ends,
			{
				return true;
			}
			else return false;  //..or else they conflict
		}
		else if (a.getStart() < b.getStart())  //if a starts before b does,
		{
			if (a.getEnd() <= b.getStart())  //..make sure it ends before (or =) b starts,
			{
				return true;
			}
			else return false;  //..or else they conflict
		}
		else return false;  //if they start at same time then they conflict
	
	}
	
}
