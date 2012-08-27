Programming Assignment #6

Extra Credit: java doc -- completed.
Extra Credit: k nearest neighbor -- completed.

Run tumors.java, which is the tester class. 
It will perform the nearest neighbor algorithm and print it (k=1) and then perform the k nearest neighbor algorithm for three values of k, 3 5 and 7 and print them.  The data from the text file is split up and stored in a 2d array. Then it is divided 80/20 to be used as training/testing.  All the testing data is tested 100 times by using the static nearest neighbor algorithm and the accuracies are computed.

Algorithms.java contains static methods. randomize will switch around many random pairs of data so the training/testing split among the data is random. label is overloaded; the first instance of it works only for nearest neighbor. It compares the distance of a piece of testing data from each training data based on all the dimensions, keeps track of the closest, and then returns the closest's label in addition to T or F if the nearest neighbor guess was right or wrong. The more general label method performs the k-nearest neighbor algorithm for any k. The k closest data points 'vote' on how the piece of testing data should be labelled, and the majority wins.