import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.StringTokenizer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


/**
 * @author Michael Rubin
 * Crawls the webpage and gathers data for graph
 */
public class Crawler implements Serializable{

	private static final long serialVersionUID = -4553859543871281815L;

	public int elmtsToKeep; 
	
	Hashtable<Integer, HashElmt> words;
	CrawlerGraph cg;
	ArrayList<HashElmt> allVals; 
	HashElmt[] freqVals;
	String url;
	
	/**
	 * Crawls the page, extracts characters in lowercase, and graphs & hashes 
	 * the most frequent of them, and their phrases
	 * @param myUrl The URL to crawl
	 * @param all  If 0: graph all elmts.  else: graph spec number 
	 * @throws IOException
	 */
	public Crawler(String myUrl, int all) throws IOException
	{
		url = myUrl;
		words = new Hashtable<Integer, HashElmt>();
		allVals = new ArrayList<HashElmt>();

		Document doc = Jsoup.connect(url).get();
		String text = doc.body().text().toString();
		String s=text;

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < s.length(); i++) 
		{
			Character ch = s.charAt(i);
			if(Character.isSpaceChar(ch) || ((ch>=65)&&(ch<=90)) || ((ch>=97)&&(ch<=122))) 
			{
				sb = sb.append(Character.toLowerCase(s.charAt(i)));
			}
		}

		text = sb.toString();
			
		
		StringTokenizer st = new StringTokenizer(text, " ", false);
		while(st.hasMoreTokens())
		{
			String nextTok = st.nextToken();
			if(!Character.isSpaceChar(nextTok.charAt(0)) && nextTok.length() > 0 && nextTok.length() < 20)
			{
				allVals.add(new HashElmt(nextTok.trim()));
			}
		}
		
		if (all == 0){   
		elmtsToKeep = allVals.size();   
		}
		else {
			elmtsToKeep = all;
		}
		insertAll(allVals); //put them all from ArrayList (allVals) into HashTable (words)
		Collection<HashElmt> temp = words.values(); //take HT values (no duplicates)
		freqVals = temp.toArray(new HashElmt[0]); //into array (freqVals)
		freqVals = maxK(freqVals, elmtsToKeep); //trim array to most frequent
		words = new Hashtable<Integer, HashElmt>();
		for(int i = 0; i < freqVals.length; i++)  //make new trimmer hash table (words)
		{
			insert(freqVals[i]);
		}
		
		cg = new CrawlerGraph(url, freqVals); //create graph from array
	}
	
	/**
	 * Returns the maximum k elements of an array of HashElmts, 
	 * or the listsize # of elmts if there are fewer than k elmts in the list
	 * @param list Array of HashElmts
	 * @param k Number to take
	 * @return
	 */
	private HashElmt[] maxK(HashElmt[] list, int k)  
	{
		int size;
		HashElmt[] sol; 
		if(list.length >= k)
		{
			size = k;
			
		}
		else
		{
			size = list.length;
		}
		sol = new HashElmt[size];
		
	    for(int i = 0; i < size; i++) //i from 1 to size
		{
	    	int maxIndex = i;
		    int maxValue = list[i].getCount();
		    for(int j = i+1; j < list.length; j++) //j from i+1 to n
		    {    
		    	if(list[j].getCount() > maxValue)
		        {
		    		maxIndex = j;
		            maxValue = list[j].getCount();
		        }
		    }		    
		    //swap
		    HashElmt temp = list[i];
		    list[i] = list[maxIndex];
		    list[maxIndex] = temp;
		}
		for(int m = 0; m < size; m++)
		{
			sol[m] = list[m];
		}
	    return sol;
	}
	
	/**
	 * Searches the hashtable for the desired word, and if found, 
	 * also returns the phrases it is part of
	 * @param s The String to search for
	 * @return A string containing a word, its count, 
	 * its phrases, and those phrases' frequencies
	 */
	public String search(String s)
	{
		String report;
		if(!words.containsKey(s.hashCode()))
		{
			if(allVals.size() > elmtsToKeep)
			{
				report = "\"" + s + "\"\n" + "is not within the\nmost frequent " + elmtsToKeep + "\nwords or is not on \n" + url + ".";
			}
			else
			{
				report = "\"" + s + "\"\n" + "is not on \n" + url + ".";
			}
		}
		else  //word is on page and  frequent
		{
			report = "** " + s + " **\n       |count: " + words.get(new HashElmt(s).hashCode()).getCount();
			report += "\nURL: \n" + "       " + url;
			report += "\nPhrase Children: \n";
			for(int i = 0; i < words.get(new HashElmt(s).hashCode()).getChildren().size(); i++)
			{
				HashElmt elmt = words.get(new HashElmt(s).hashCode());
				report += "       " + elmt.getChild(i).getVal() + " |freq: " + elmt.getChild(i).getFreq() + "\n";
				
			}
			report += "Phrase Parents: \n";
			for(int i = 0; i < freqVals.length; i++)
			{
				if(freqVals[i].getChildren().contains(new HashElmt(s)))
				{
					report += "       " + freqVals[i].getVal() + " |freq: " + freqVals[i].getChild(new HashElmt(s)).getFreq() + "\n";
				}
			}
			
		}
		return report;
	}
	
	/**
	 * Hashes unique words into a hashtable, and keeps count of duplicates
	 * @param allVals An ArrayList of values to hash
	 */
	private void insertAll(ArrayList<HashElmt> allVals)
	{
		/*for(HashElmt hh : allVals)
		{
			hh.resetCount();
			for(HashPhrase hpp : hh.getChildren())
			{
				hpp.resetFreq();
			}
		}*/
		
		HashElmt future = allVals.get(0);
		HashElmt present;
		for(int i = 0; i < allVals.size(); i++)
		{
			present = future;
			future = allVals.get(i);
			
			if(i != 0)
			{
				if(!words.containsValue(present))
				{
					present.addChild(new HashPhrase(future));
					insert(present);
				}
				else //contains present
				{
					words.get(present.hashCode()).incrementCount();
					if(words.get(present.hashCode()).getChildren().contains(words.get(future.hashCode()))) //already has it as a child
					{
						words.get(present.hashCode()).getChild(words.get(future.hashCode())).incrementFreq();
					}
					else //doesn't have future as a child
					{
						words.get(present.hashCode()).addChild(new HashPhrase(future));
					}
				}
			}
			if(i == allVals.size()-1)
			{
				if(!words.containsValue(future))
				{
					insert(future);
				}
				else //contains last element
				{
					words.get(future.hashCode()).incrementCount();
				}
			}
		}
	}
	
	/**
	 * Puts the specified HashElmt into the HashTable
	 * @param s The HashElmt to insert
	 */
	private void insert(HashElmt s)
	{
		words.put(s.hashCode(), s);
	}
	
	/**
	 * Accesses the HashTable
	 * @return The HashTable
	 */
	public Hashtable<Integer, HashElmt> getHT()
	{
		return words;
	}
	
	/**
	 * Accesses the graph
	 * @return The graph
	 */
	public CrawlerGraph getGraph()
	{
		return cg;
	}
	
	/**
	 * Accesses the Crawler's url
	 * @return The URL
	 */
	public String getURL()
	{
		return url;
	}
	
	
	
}
