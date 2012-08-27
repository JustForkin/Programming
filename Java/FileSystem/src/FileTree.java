import java.io.File;
import java.io.Serializable;
import java.util.LinkedList;

/**
 * 
 */

/** 
 * @author Michael Rubin
 * A tree to hold a file system
 */
public class FileTree implements Serializable{

	private File home;
	private FileNode root;
	
	/**
	 * Constructs a file system tree 
	 * @param aFile The root directory that we want to store in the tree
	 */
	public FileTree(File aFile)
	{
		home = aFile;
		root = new FileNode(home);
		
		initialize();
	}
	
	/**
	 * Store the file system in a tree, postorder-ly, and set the node 'sizes'
	 * @param aFile The file (and children) to store in tree
	 * @param aNode Location in tree to store the files
	 */
	private void initialize(File aFile, FileNode aNode)  
	{
		//if file is a F, then insert and break
		if(aFile.isFile())
		{
			aNode.setData(aFile);
			aNode.setSize(aNode.getData().length()); /////
			return;
		}
		//if file is a D, then insert and call this on each child
		else
		{
			aNode.setData(aFile);
			long tempSize = 0;////
			for(File f : aFile.listFiles())
			{
				FileNode newNode = aNode.newChild();
				initialize(f, newNode);
				tempSize += newNode.getSize(); ///
			}
			aNode.setSize(tempSize); ///
		}
		
	}
	
	/**
	 * Stores a file system starting in the root of the tree
	 * @param aFile
	 */
	private void initialize(File aFile)
	{
		initialize(aFile, root); 
	}
	
	/**
	 * Stores the root of the file system in the root of the tree
	 * @param aFile
	 */
	private void initialize()
	{
		initialize(home, root); 
	}
	
	
	private String ret = new String();
	/**
	 * Recursively (in breath-order) returns the tree (and file sizes) as a string 
	 * in a way suitable for printing
	 * @param fn The node to add to the string representation
	 * @param depth Keeps track of how much to indent
	 * @return The tree file system as a string in a way suitable for printing
	 */
	public String toString(FileNode fn, int depth)
	{
		LinkedList<FileNode> myQ = new LinkedList<FileNode>();
		myQ.add(fn);
		
		while(myQ.peekFirst() != null)
		{
			FileNode temp = myQ.poll();
			ret += spaces(depth) + temp + "\n";  ///
			depth++; 
			for(FileNode f : fn.getChildren())
			{
				toString(f, depth);
			}
		}
		
		return ret; 
	}
	
	/**
	 * Returns the whole tree as a string in a method suitable for printing
	 * @return The whole tree as a string in a method suitable for printing
	 */
	public String toString()
	{
		return toString(root, 0);
	}
	
	/**
	 * Recursively (in breath-order) prints the tree (and file sizes)
	 * @param fn The node to print
	 * @param depth Keeps track of indentation
	 */
	private void print(FileNode fn, int depth)
	{
		LinkedList<FileNode> myQ = new LinkedList<FileNode>();
		myQ.add(fn);
		
		while(myQ.peekFirst() != null)
		{
			FileNode temp = myQ.poll();
			System.out.println(spaces(depth) + temp); ///
			depth++; 
			for(FileNode f : fn.getChildren())
			{
				print(f, depth);
			}
		}
		
	}
	
	/**
	 * Recursively prints the whole tree
	 */
	public void print()
	{
		print(root, 0);
	}
	
	/**
	 * Creates a number of 'tabs' ie white-space in a line
	 * @param num The number of tabs you wish to indent
	 * @return A string of white-space proportional to the number requested
	 */
	private String spaces(int num)
	{
		String ret = new String();
		for(int i = 0; i < num; i ++)
		{
			ret += "   ";
		}
		return ret;
	}
	
	private boolean found;
	/**
	 * Wraps recursive search method so we can keep track of whether or not we found the file
	 * @param fileName The name of the file we're searching for
	 * @param fn Where we're beginning our search
	 * @return The file if we found it, or null
	 */
	private FileNode searcher(String fileName, FileNode fn)
	{	
		found = false;
		FileNode res = null;
		
		return search(fileName, fn, res);
	}
	
	/**
	 * Searches (in breadth-order) for the first occurrence of a file name in tree
	 * @param fileName The file name we are searching for
	 * @param fn Where we're beginning our search
	 * @param res The result of our search, thus far
	 * @return The node containing the file with the specified file name, or null if it's not found
	 */
	private FileNode search(String fileName, FileNode fn, FileNode res)
	{
		LinkedList<FileNode> myQ = new LinkedList<FileNode>();
		myQ.add(fn);
		
		while(myQ.peekFirst() != null)
		{
			FileNode temp = myQ.poll();
			
			if(temp.getData().getName().equals(fileName) && found == false)
			{
				res = temp;
				found = true;
			}
			else
			{
				for(FileNode f : fn.getChildren())
				{
					res = search(fileName, f, res);  /////f/f/f////
				}
			}
		}
		return res;
		
	}
	
	/**
	 * Search whole tree for specified file name
	 * @param fileName The name we're searching for
	 * @return The node containing the File with specified name
	 */
	public FileNode search(String fileName)
	{
		return searcher(fileName, root);
	}
	
	/**
	 * Accessor for root file in given directory
	 * @return home The starting directory
	 */
	public File getHome()
	{
		return home;
	}
	
	/**
	 * Accessor for the root of the tree
	 * @return root The root node of the file system tree
	 */
	public FileNode getRoot()
	{
		return root;
	}
	
	
}
