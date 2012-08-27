Michael Rubin   -   mnr2114   -   4/5/12
Quantum Computing, Assignment 4, Programming


To run my MATLAB program from within cunix, navigate to within the QuantumPhaseEstimation directory 
and type 'matlab' to run matlab.
From within the matlab prompt, type

PEtester;

to run my script, which will display test cases we used in class.
To test specific input of your own, either edit the PEtester script or run the 
QPhaseEstim(U, u, n, epsilon) 
function on your U matrix, u eigenvector, precision, and prob of failure.

(If you try to run my program from within cunix but not from  within the matlab prompt
it may not work).

I followed the remarks on the handout which somewhat simplified the program. Instead of dealing with
the U matrices, I derived lambda and used that (lambda^2^j) on the top register, before finally 
tensoring the qbits together, applying the inverse QFT matrix, and selecting the coordinate where 
the magniitude of the amplitude is largest (the most likely outcome). I output this state in binary and decimal
as well as the probability.  (You can then use the binary representation of the state to get the eigenvalue, 
which is equal to e^(2pi*i*phi) where phi=0.phi_1...) 

Below are some sample test runs:


*NEW TEST CASE*


The state that produces the eigenvalue of the m = 2 qubit matrix
U =

     1     0
     0    -1

for the eigenvector
u =

     0
     1

with precision 0.25 and a failure probability of at most 25% is: 
state =

1000

i.e. state 8, with a probability 1

*NEW TEST CASE*


The state that produces the eigenvalue of the m = 4 qubit matrix
U =

   0.0000 + 1.0000i        0                  0                  0          
        0             0.5000 + 0.8660i        0                  0          
        0                  0             0.7071 + 0.7071i        0          
        0                  0                  0             0.8090 + 0.5878i

for the eigenvector
u =

   0.0000 + 1.0000i
        0          
        0          
        0          

with precision 0.25 and a failure probability of at most 25% is: 
state =

0100

i.e. state 4, with a probability 1

*NEW TEST CASE*


The state that produces the eigenvalue of the m = 4 qubit matrix
U =

   0.0000 + 1.0000i        0                  0                  0          
        0             0.5000 + 0.8660i        0                  0          
        0                  0             0.7071 + 0.7071i        0          
        0                  0                  0             0.8090 + 0.5878i

for the eigenvector
u =

        0          
   0.5000 + 0.8660i
        0          
        0          

with precision 0.25 and a failure probability of at most 25% is: 
state =

0011

i.e. state 3, with a probability 0.827584

*NEW TEST CASE*


The state that produces the eigenvalue of the m = 4 qubit matrix
U =

   0.0000 + 1.0000i        0                  0                  0          
        0             0.5000 + 0.8660i        0                  0          
        0                  0             0.7071 + 0.7071i        0          
        0                  0                  0             0.8090 + 0.5878i

for the eigenvector
u =

        0          
        0          
   0.7071 + 0.7071i
        0          

with precision 0.25 and a failure probability of at most 25% is: 
state =

0010

i.e. state 2, with a probability 1

*NEW TEST CASE*


The state that produces the eigenvalue of the m = 4 qubit matrix
U =

   0.0000 + 1.0000i        0                  0                  0          
        0             0.5000 + 0.8660i        0                  0          
        0                  0             0.7071 + 0.7071i        0          
        0                  0                  0             0.8090 + 0.5878i

for the eigenvector
u =

        0          
        0          
        0          
   0.8090 + 0.5878i

with precision 0.0625 and a failure probability of at most 25% is: 
state =

000110

i.e. state 6, with a probability 0.756875