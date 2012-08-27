Michael Rubin - mnr2114

To run my java program, compile the project and run the HWTest file with one 
command line argument (the input file to parse; tokens separated by spaces), 
as per the Extra Credit.

A summary of what each class (and method) does can be found in the javadoc I created,
but in sum:

HWTest - the main method of the class that prints a list of 100 random numbers and
	another list taken from a text file, along with their frequencies. Numbers
	in parentheses denote the number of times that element occurred.
	
SuperLinkedList - the LinkedList-like class responsible for handling nodes. It can do
	things like insert, delete, find, reverse the list

LinkedItem - the class that represents the (String) nodes.  It handles each nodes
	value/data and it's counter.
	
SuperIterator - the class that iterates through the SuperLinkedList. (not really used
			for hw completion purposes; more in there for show)
	
SLException - the class that handles deletion errors caused by the target node not
	being in the SuperLinkedList. (other, built-in exceptions are also used in the project)
	
	
/* RUNNING TIMES for methods in SuperLinkedList class */

public void clear(): O(1)  //just assignments (and constructors, which are also constant; see below)

public boolean isEmpty(): O(1)  //just a comparison

public String set(int, String): same as LinkedItem findNode(int) thus O(n)
//(plus constant time for getters/setters); i'm not necessarily gonna mention this each time from now on

public boolean insert(String): same as void insert(int, String) directly below: O(n)
public void insert(int, String): same as void insertBefore(LinkedItem, String) plus
						LinkedItem findNode(int, int, int) below, thus: 2*O(n) => O(n)
private void insertBefore(LinkedItem, String): O(n)  since the for loops runs n times (to see
	if we have the value before adding it again) and the 'if' statement within it 
	contains all constant methods. The other 'if' also contains all constant 
	getters/setters. This method is general, not only for insertion at head or tail
	of list.
	
public String delete(int): same as String delete(LinkedItem) + LinkedItem findNode(int)
					thus O(n)+O(n) => O(n)
public void delete(String): O(n)  since there's a for loop that runs n times to look for the 
	element to delete, and the rest of the methods it calls are constant time (such 
	as delete(LinkedItem) directly below)
private String delete(LinkedItem): same as boolean isInList(LinkedItem)  ie O(1)   //see below
	
private boolean isInList(LinkedItem): O(1)  calls an accessor and makes comparisons

public String find(int): same as LinkedItem findNode(int) directly below (plus constant 
	accessor time which doesn't add complexity), thus O(n)				
private LinkedItem findNode(int)/(int, int, int): O(n/2) => O(n)  since it iterates through
	(half) the list once whichever if/else path it takes
	
public void reverse(): O(n) since iterator goes through list once (plus constant g/setters) and
	it changes each node's pointers in one sweep
	
public LinkedItem getHead(): O(1)  constant accessor
public LinkedItem getTail(): O(1)  constant accessor
public int getSize(): O(1)  constant accessor

public void print(): same as void print(int) directly below
public void print(int): O(n)  since we must iterate through the list once to get each node's 
					   info, plus spend the cost of toString (look below) which is also
					   linear, hence O(n)

public String toString(): O(n)  since we must must iterate through each node to get its info

constructors: O(1)   //(just assignments)
