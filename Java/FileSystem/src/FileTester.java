import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Michael Rubin - mnr2114
 * The tester class for the File system
 */
public class FileTester {

	
	/** Main method for FileTree class
	 * @param args N/A
	 */
	public static void main(String[] args) {
		
		boolean quit = false;
		
		//Submit starting tree
		System.out.println("Submit a directory to load up a tree into memory   (e.g. src/)");
		Scanner sc = new Scanner(System.in);
		String direct = sc.next();
		File root = new File(direct);  
		FileTree myTree = new FileTree(root);
	
		while(quit == false)
		{
			
			//command-line
			String greeting = "\nWhat would you like to do:\n";
			greeting += "0: quit\n";
			greeting += "1: print the tree (& file sizes)\n";
			greeting += "2: search for a file in the tree\n";
			greeting += "3: save the tree to disk\n";
			greeting += "4: load the tree from disk\n";
			System.out.println(greeting);
	
			
			int option = sc.nextInt();
			
			switch(option)
			{
			
			case 0: //quit
				quit = true;
				break;
				
			case 1: //print
				myTree.print();
				break;
				
			case 2: //search
				System.out.print("what do you want to search for? ");
				
				String searchQuer = sc.nextLine();   ///// clear the scanner
				searchQuer = sc.nextLine(); 
				
				FileNode searchRes = myTree.search(searchQuer);
				if(searchRes != null)
					{System.out.println("search: " + searchRes);} 
				else
					{System.out.println("Error: search query not found");}
				break;
				
			case 3: //save to disk
				try {
					FileOutputStream fos = new FileOutputStream("object");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(myTree);
					oos.close();
				} catch (Exception e) {
					System.out.println("Error ");
					e.printStackTrace();
					System.exit(0);
				}
				break;
				
			case 4: //load from disk
				try {
					FileInputStream fis = new FileInputStream("object");
					ObjectInputStream ois = new ObjectInputStream(fis);
					FileTree newTree = (FileTree)ois.readObject();
					myTree = newTree; //reuse pointer, but new object
					ois.close();
					//System.out.println("After: \n" + myTree);
				} catch (Exception e) {
					System.out.println("Error ");
					e.printStackTrace();
					System.exit(0);
				}
				break;
				
			}//end switch
			
		}//end commandline
		
			
	} //end main
	
	

} //end class


