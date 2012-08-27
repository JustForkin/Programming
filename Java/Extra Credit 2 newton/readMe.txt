Michael Rubin   -   mnr2114   -   EC#2

for EC#2: Run the NewtonTester file to execute the program.  The NewtonTester takes in a tolerance and an initial point from the user and creates a NewtonSolver object which uses those two values as well as an object which extends the Function class to run the Newton algorithm.  The alogrithm stops when an absolute number (20) approximations have been completed or when BOTH methods of calculating error drop below the tolerance i.e. |f(p_t)|, |p_t-p| <= E.  
Try an initial point of like .01, and your final answer will be around 0.6749917159071183 %
 as the maximum interest rate.