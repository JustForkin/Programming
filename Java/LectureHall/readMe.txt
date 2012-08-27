Lecture Hall (Prof Cannon's program)
--------------------------------------
run the TalkTest.java file in order to execute the program.

TalkTest has a static main method which asks the user and 
takes in start/end times for any number of talks,and checks
that the times are valid. It then calls the algorithm which
ultimately selects that talks will fit into a schedule whose 
purpose is to maximize the number of talks, and then print them.

Talk.java allows for a comparable object Talk to be constructed.
Talks are compared and ordered based on their starting times.
 
Scheduler.java is a class containing static methods. The sort
method sorts an array list of Talks (based on start time). 
addTalk adds a talk to the array list. isNoConflict is a 
method which determines whether two talks are conflicting or
not by seeing which talk starts later and then making sure
that the one that starts later also starts after the other 
one ended. schedTalks is the method that contains 
the algorithm which maximizes the number of talks and then 
prints them out. The algorithm works as such: a temporary 
array list is created. We then try to fill each element of
the temporary array list by: sorting our talks by start time,
outting the one with the earliest start time in the temporary
array, and then going through the rest of our talks to see if 
we can find one that ends (earlies) before the one that starts 
first does. If so, we replace it as the first element in the
temporary array. This works because all that sticking in a 
talk like this will do is leave more room afterwards for another.
Basically, it is contained within the earliest-starting talk.
Then we remove all conflicting talks from our array and sort it
again in order to find the talk that comes earliest after the 
previous talk ended. The process repeats until there are no 
talks left to deal with.

Time.java contains static methods which help deal with issues
relating to the intake of time as integers. There's a method 
which puts the colon in the int representing time for 
aesthetic purposes as well as makes sure the time looks like
it sohuld with standard formatting. Another method makes sure
that the int could represent time, since unlike integers, time 
uses clock arithmetic and certain values such as 65 minutes or
25 o'clock do not exist.

