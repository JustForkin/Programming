Michael Rubin   mnr2114
Programming Assignment #2

To use my program, compile it and then run it with no command line arguments 
(the command-line in the main method will prompt you for everything).

The cost of building the tree, of printing it, of searching through it, or of saving it to disk/loading it from disk
are all O(n) because we must traverse the entire tree at most once to perform any of 
them (if we calculate and store the size of each folder as we build up the tree post-orderly).