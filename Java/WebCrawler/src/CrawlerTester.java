import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * @author Michael Rubin
 * Creates searchable word clouds of urls
 */
public class CrawlerTester {

	/**
	 * @param args
	 * @throws IOException 
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {

		String[] urls = new String[3];
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 3; i++)
		{
			if(i == 0)
			{
				System.out.println("Enter a url: (e.g. http://www.gmail.com)");
			}
			else
			{
				System.out.println("Enter another url (up to 3) or press q to stop: ");
			}
			String resp = sc.next();
			if(!resp.equals("q"))
			{
				urls[i] = resp;
			}
			else
			{
				i = 3;
			}
		}
		
		
		Grapher g = null;
		Grapher g1 = null;
		Grapher g2 = null;
		
		ArrayList<Grapher> G = new ArrayList<Grapher>();
		
		if(urls[0] != null)
		{
			g = new Grapher(urls[0], 0);
			G.add(g);
		}
		if(urls[1] != null)
		{
			g1 = new Grapher(urls[1], 0);
			G.add(g1);
		}
		if(urls[2] != null)
		{
			g2 = new Grapher(urls[2], 0);
			G.add(g2);
		}
		
		
		
		boolean quit = false;
		while(quit == false)
		{
			
			//command-line
			String greeting = "\nWhat would you like to do:\n";
			greeting += "0: quit\n";
			greeting += "1: save the graphs to disk\n";
			greeting += "2: load the graphs from disk\n";
			greeting += "3: search for a word (in all urls)";
			System.out.println(greeting);
	
			
			int option = sc.nextInt();
			
			switch(option)
			{
			
			case 0: //quit.  Just terminating may cause an exception
				quit = true;
				break;
				
			case 3: //search
				System.out.print("what do you want to search for? ");
				
				String searchQuer = sc.nextLine();   ///// clear the scanner
				searchQuer = sc.nextLine(); 
				
				for(Grapher gg : G)
				{
					System.out.println(gg.getCrawler().search(searchQuer));
				}
				
				break;
				
			case 1: //save to disk
				try {
					FileOutputStream fos = new FileOutputStream("object");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					
					oos.writeObject(G);
					oos.close();
				} catch (Exception e) {
					System.out.println("Error ");
					e.printStackTrace();
					System.exit(0);
				}
				break;
				
			case 2: //load from disk
				try {
					FileInputStream fis = new FileInputStream("object");
					ObjectInputStream ois = new ObjectInputStream(fis);
					ArrayList<Grapher> newG = (ArrayList<Grapher>)ois.readObject();
					G = newG; //reuse pointer, but new object
					for(Grapher gg : G)
					{
						gg.recreate();
					}
					ois.close();
					
				} catch (Exception e) {
					System.out.println("Error ");
					e.printStackTrace();
					System.exit(0);
				}
				break;
				
			}//end switch
			
		}//end commandline
		
		
		
	    
	} //end main
	
}//end CrawlerTester
