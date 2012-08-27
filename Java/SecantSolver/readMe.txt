Michael Rubin   -   mnr2114   -   HW#9

for HW#9: Run the SecantTester file to execute the program.  
The SecantTester takes in a tolerance and two initial points 
from the user and creates a SecantSolver object which uses 
those three values as well as an object which extends the Function 
class to run the Secant algorithm.  The algorithm stops when an 
absolute number (20) approximations have been completed or 
when BOTH methods of calculating error drop below the tolerance 
i.e. |f(p_t)|, |p_t-p| <= E.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
proof for part b)
f(x)=(x-2)^2-ln(x)
0 =(x-2)^2-ln(x)
Intermediate value theorem ==>
f(e) = (e-2)^2 - ln(e)
	= .52 - 1
	--> negative
f(4) = (4-2)^2 - ln(4)
	= 4 - 1.39
	--> positive
==> exists a root in the interval (e,4)
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Sample of starting input:
tolerance:
.00000000001
first starting input:
1.2
second starting input:
1.6

approximation: 1.4123911720272662
