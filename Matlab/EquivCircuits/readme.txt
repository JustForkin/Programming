Michael Rubin   -   mnr2114   -   2/26/12
Quantum Computing, Assignment 2, Programming


To run my MATLAB program, navigate to within the EquivCircuits directory 
and type 'matlab' to run matlab.
From within the matlab prompt, type

EquivCircuitsTester

to run my script, which will display test cases.
To test specific input, either edit the EquivCircuitsTester script or run my

EquivCircuits(a, b, c, d);

function with your own 2x2 matrix containing [a b; c d].
(If you try to run my program from within cunix but not from  within the matlab prompt
it may not work).

Since |||psi>|| = 1, the max ||C1 |psi> - C2 |psi>|| < epsilon is the norm || C1 - C2||.

Here is the output of my test runs, with epsilon = 10^(-4)

X
YES
 
Y
YES
 
Z
YES
 
H
YES
 
S
NO
 
T
NO