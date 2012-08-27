import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 
 */

/**
 * @author Michael Rubin
 * A file or directory in a file system
 */
public class FileNode implements Serializable{
	
	private File data;
	private LinkedList<FileNode> children = new LinkedList<FileNode>();
	private FileNode parent;
	private long size;
	
	/**
	 * Constructs a node with a parent and a File
	 * @param aFile The data of the node
	 * @param p The parent node
	 */
	public FileNode(File aFile, FileNode p)
	{
		parent = p;
		data = aFile;
	}
	
	/**
	 * Constructs a node containing a File
	 * @param aFile The data of the node
	 */
	public FileNode(File aFile)
	{
		parent = null;
		data = aFile;
	}
	
	/**
	 * Constructs an empty node with a parent
	 * @param p The node's parent node
	 */
	public FileNode(FileNode p)
	{
		parent = p;
		data = null;
	}
	
	/**
	 * Creates a new child node for this node and connects the links
	 * @return The new child node
	 */
	public FileNode newChild()
	{
		FileNode newNode = new FileNode(this);
		this.addChild(newNode);
		return newNode;
	}
	
	/*
	/**
	 * Gets the amount of memory a file or a directory takes up
	 * @param dir The File object to get the size of
	 * @return The size in memory of the File (bytes)
	 */
	/*private long getDirSize(File dir) {
		long size = 0;
		if(dir.isFile())  //if File is a file
		{
			size = dir.length();
		} 
		else  //if it is a directory...
		{
			for(File file : dir.listFiles())  //...add the sizes of its children
			{
				if(file.isFile()) 
				{
					size += file.length();
				} 
				else 
				{
					size += getDirSize(file);
				}
			}
		}
	return size;
	}
	*/ 
	
	/*/**
	 * Gets the size of the data in this node
	 * @return The size of the data in this node
	 */
	/*public long getDirSize() 
	{
		return getDirSize(data);
	}
	*/
	
	/**
	 * Mutates the data in this node
	 * @param aFile The new File to give to this node
	 */
	public void setData(File aFile)
	{
		data = aFile;
	}
	
	/**
	 * Mutates the parent link
	 * @param p The new parent of this node
	 */
	public void setParent(FileNode p)
	{
		parent = p;
	}
	
	/**
	 * Adds a child to this node
	 * @param c The child to be added
	 */
	public void addChild(FileNode c)
	{
		children.add(c);
	}
	
	/**
	 * Mutates the size in memory of the node (bytes)
	 * @param aSize The size to set the node's size var to
	 */
	public void setSize(long aSize)
	{
		size = aSize;
	}
	
	/**
	 * Accessor for the size of the node
	 * @return The size of the node (in bytes)
	 */
	public long getSize()
	{
		return size;
	}
		
	/**
	 * Accesses the data in the node
	 * @return The File in the node
	 */
	public File getData()
	{
		return data;
	}
	
	/**
	 * Accesses the parent link of this node
	 * @return This node's parent
	 */
	public FileNode getParent()
	{
		return parent;
	}
	
	/**
	 * Accesses all the children of this node
	 * @return a LL of this node's children
	 */
	public LinkedList<FileNode> getChildren()
	{
		return children;
	}
	
	/**
	 * A String representation of this object, ie the String representation of the 
	 * File inside of it (the path) and the size
	 */
	public String toString()
	{
		return data.toString() + " " + size;
	}
	
}
