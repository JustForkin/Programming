Michael Rubin   -   mnr2114   -   3/22/12
Quantum Computing, Assignment 3, Programming


To run my MATLAB program from within cunix, navigate to within the DeutschJozsa directory 
and type 'matlab' to run matlab.
From within the matlab prompt, type

DJTester(num)

to run my script, (where 'num' is the 'n' in the domain of f:{0..2^n-1}) which will display test cases
for both the standard DJ algorithm as well as for the modified version.
To test specific functions of your own, edit the DJTester script.

(If you try to run my program from within cunix but not from  within the matlab prompt
it may not work).

The motivation behind how I modified the DJ algorithm can be found on the paper assignment I submitted (or see the file 3b.jpg),
however, in  brief, if f is balanced, outcome  0  has probability  1/4 so in the case where before the
measurement, we're  told that outcome 0 had  probability 1.4, we randomly output 'constant' 3/4 of the time
and 'balanced' 1/4 of the time.   => If f  is constant, we  will  be right 3/4 of the  time >  1/2.

I simulated this by running the algorithm 1000 times on a balanced function and I got that 
the fraction that are balanced is: 0.7470  ~ 3/4
(I left the simulation in my tester script commented-out)

Below is some sample output:  (to see what the functions are check out my code)
For the unmodified algorithm I just outputted the probability for each  outcome, as the DJ algorithm is always correct,
so whenever outcome 0 has probability 1 then f is constant, and if outcome 0 has probability 0 then f is balanced.
For the modified algorithm I just outputted the result.


CONSTANT:
prob that its outcome 0:

ret =

    1.0000

prob that its outcome 1 :

ans =

     0

prob that its outcome 2 :

ans =

     0

prob that its outcome 3 :

ans =

     0

prob that its outcome 4 :

ans =

  1.5407e-033

prob that its outcome 5 :

ans =

     0

prob that its outcome 6 :

ans =

     0

prob that its outcome 7 :

ans =

     0

 
CONSTANT:
prob that its outcome 0:

ret =

    1.0000

prob that its outcome 1 :

ans =

     0

prob that its outcome 2 :

ans =

     0

prob that its outcome 3 :

ans =

     0

prob that its outcome 4 :

ans =

  1.5407e-033

prob that its outcome 5 :

ans =

     0

prob that its outcome 6 :

ans =

     0

prob that its outcome 7 :

ans =

     0

 
BALANCED:
prob that its outcome 0:

ret =

     0

prob that its outcome 1 :

ans =

    1.0000

prob that its outcome 2 :

ans =

     0

prob that its outcome 3 :

ans =

     0

prob that its outcome 4 :

ans =

     0

prob that its outcome 5 :

ans =

  1.5407e-033

prob that its outcome 6 :

ans =

     0

prob that its outcome 7 :

ans =

     0

 
 
~modified~
 
CONSTANT:
prob that its outcome 0:

ret =

    1.0000

result: f is constant
 
BALANCED:
prob that its outcome 0:

ret =

    0.2500

result: f is balanced