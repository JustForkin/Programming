Michael Rubin   -   mnr2114   -   12/15/11
WebCrawler assignment
(+ extra credit)

Remarks:
~~~~~~~
-  To run my program, run the CrawlerTester.java file with no commandline arguments.
-  While I displayed the word clouds for each url in a different frame
in order to reduce the clutter, searching for a word through the command line
console will perform a search on all the urls.  This is in contrast to 
using the GUI search on each graph which will instead only search 
that particular url. (note: search results through the gui will only be displayed for 
the most frequent words on the page, unlike through the command line)
-  On a related note, in order to adjust how many words are filtered out, 
one can do so through the GUI and it will be represented on the graph (EXTRA CREDIT).
The graph starts with all the words so this is advised in order to make it more
readable.
-  On the graphs, the vertices are sized according to how frequently they appear
on the webpage.  (If you want the actual number of times it appeared, then search
for the word in the search box or through the command line.) The edges are labeled 
with 'count' (i.e. how many times a popular word appeared) and 'phrase freq' (i.e. 
the number of times the one word follows the other).  The popular words are colored 
black, and the ones on the graph only because they are part of a popular word's phrase 
are in gray.  The url's are in blue and when you search for a word it highlights in 
yellow (whether or not it's popular).
-  I put together a sample webpage with only a few elements on it
http://www.columbia.edu/~mnr2114/test.html
in case the grader wishes to check my program on a smaller sample
-  Some code borrowed from recitation. Used Java's built-in HashTable.


Runtimes:
~~~~~~~~
- Crawling is a linear process since one must traverse the webpage some constant 
number of times to extract the words, change them to lowercase, etc.
- Filtering the k most popular words costs O(kn) where n is the total number of words, 
since my implementation basically runs a selection sort [O(n^2)] but stops when k elmts 
are sorted.
- Inserting V elmts into a hashtable costs O(V) since you are performing a 
constant operation V times.
- Labeling the vertices of the graph costs O(V), and labeling the edges costs O(E)
[i.e. for each child of each vertex]
- Searching for the word itself costs O(1) since we're using a hashtable.
  Getting its children (outgoing nodes) costs O(c) where c is the number of children 
it has (or only constant cost if you just return the arraylist of them, as this data 
is contained within the hashable elmts themselves, like an adjacency list
  Getting the ingoing nodes costs O(E) since we must check each of the children of
each vertex to see if they contain our query