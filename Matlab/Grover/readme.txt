Michael Rubin   -   mnr2114   -   4/22/12
Quantum Computing, Assignment 5, Programming


To run my MATLAB program from within cunix, navigate to within the 'Grover' directory 
and type 'matlab' to run matlab.  (My program works properly on Cunix's version of Matlab, but not the one 
on my computer, as it thinks that e.g.  0.3536 > 0.3536 due to weirdness with how precision is handled).
From within the matlab prompt, type

GroverTester;

to run my script, which will display many test cases.
To test specific input of your own, either edit the GroverTester script or run the 

Grover(n, x0);

function where
% n = number of input bits for the function f
% x0 = the index x0={0,...,2^n-1} for which f(x0)=1

(If you try to run my program from within cunix but not from within the matlab prompt
it may not work).

From the final state, I selected the coordinate m that has the largest magnitude of amplitude, 
ie the most likely outcome. I then verified that f(m)=1 by seeing if m == x0.


SAMPLE OUTPUT is below:

>> GroverTester;

NEW  TEST  CASE: [n=1, x0=0]
f(x_0) = 1 for x_0 =?
Mf =

     0

and this is correct.

NEW  TEST  CASE: [n=1, x0=1]
f(x_0) = 1 for x_0 =?
Mf =

     1

and this is correct.

NEW  TEST  CASE: [n=2, x0=0]
f(x_0) = 1 for x_0 =?
Mf =

     0

and this is correct.

NEW  TEST  CASE: [n=2, x0=1]
f(x_0) = 1 for x_0 =?
Mf =

     1

and this is correct.

NEW  TEST  CASE: [n=2, x0=2]
f(x_0) = 1 for x_0 =?
Mf =

     2

and this is correct.

NEW  TEST  CASE: [n=2, x0=3]
f(x_0) = 1 for x_0 =?
Mf =

     3

and this is correct.

NEW  TEST  CASE: [n=3, x0=0]
f(x_0) = 1 for x_0 =?
Mf =

     0

and this is correct.

NEW  TEST  CASE: [n=3, x0=1]
f(x_0) = 1 for x_0 =?
Mf =

     1

and this is correct.

NEW  TEST  CASE: [n=3, x0=2]
f(x_0) = 1 for x_0 =?
Mf =

     2

and this is correct.

NEW  TEST  CASE: [n=3, x0=3]
f(x_0) = 1 for x_0 =?
Mf =

     3

and this is correct.

NEW  TEST  CASE: [n=3, x0=4]
f(x_0) = 1 for x_0 =?
Mf =

     4

and this is correct.

NEW  TEST  CASE: [n=3, x0=5]
f(x_0) = 1 for x_0 =?
Mf =

     5

and this is correct.

NEW  TEST  CASE: [n=3, x0=6]
f(x_0) = 1 for x_0 =?
Mf =

     6

and this is correct.

NEW  TEST  CASE: [n=3, x0=7]
f(x_0) = 1 for x_0 =?
Mf =

     7

and this is correct.

NEW  TEST  CASE: [n=4, x0=0]
f(x_0) = 1 for x_0 =?
Mf =

     0

and this is correct.

NEW  TEST  CASE: [n=4, x0=1]
f(x_0) = 1 for x_0 =?
Mf =

     1

and this is correct.

NEW  TEST  CASE: [n=4, x0=2]
f(x_0) = 1 for x_0 =?
Mf =

     2

and this is correct.

NEW  TEST  CASE: [n=4, x0=3]
f(x_0) = 1 for x_0 =?
Mf =

     3

and this is correct.

NEW  TEST  CASE: [n=4, x0=4]
f(x_0) = 1 for x_0 =?
Mf =

     4

and this is correct.

NEW  TEST  CASE: [n=4, x0=5]
f(x_0) = 1 for x_0 =?
Mf =

     5

and this is correct.

NEW  TEST  CASE: [n=4, x0=6]
f(x_0) = 1 for x_0 =?
Mf =

     6

and this is correct.

NEW  TEST  CASE: [n=4, x0=7]
f(x_0) = 1 for x_0 =?
Mf =

     7

and this is correct.

NEW  TEST  CASE: [n=4, x0=8]
f(x_0) = 1 for x_0 =?
Mf =

     8

and this is correct.

NEW  TEST  CASE: [n=4, x0=9]
f(x_0) = 1 for x_0 =?
Mf =

     9

and this is correct.

NEW  TEST  CASE: [n=4, x0=10]
f(x_0) = 1 for x_0 =?
Mf =

    10

and this is correct.

NEW  TEST  CASE: [n=4, x0=11]
f(x_0) = 1 for x_0 =?
Mf =

    11

and this is correct.

NEW  TEST  CASE: [n=4, x0=12]
f(x_0) = 1 for x_0 =?
Mf =

    12

and this is correct.

NEW  TEST  CASE: [n=4, x0=13]
f(x_0) = 1 for x_0 =?
Mf =

    13

and this is correct.

NEW  TEST  CASE: [n=4, x0=14]
f(x_0) = 1 for x_0 =?
Mf =

    14

and this is correct.

NEW  TEST  CASE: [n=4, x0=15]
f(x_0) = 1 for x_0 =?
Mf =

    15

and this is correct.

NEW  TEST  CASE: [n=5, x0=0]
f(x_0) = 1 for x_0 =?
Mf =

     0

and this is correct.

NEW  TEST  CASE: [n=5, x0=1]
f(x_0) = 1 for x_0 =?
Mf =

     1

and this is correct.

NEW  TEST  CASE: [n=5, x0=2]
f(x_0) = 1 for x_0 =?
Mf =

     2

and this is correct.

NEW  TEST  CASE: [n=5, x0=3]
f(x_0) = 1 for x_0 =?
Mf =

     3

and this is correct.

NEW  TEST  CASE: [n=5, x0=4]
f(x_0) = 1 for x_0 =?
Mf =

     4

and this is correct.

NEW  TEST  CASE: [n=5, x0=5]
f(x_0) = 1 for x_0 =?
Mf =

     5

and this is correct.

NEW  TEST  CASE: [n=5, x0=6]
f(x_0) = 1 for x_0 =?
Mf =

     6

and this is correct.

NEW  TEST  CASE: [n=5, x0=7]
f(x_0) = 1 for x_0 =?
Mf =

     7

and this is correct.

NEW  TEST  CASE: [n=5, x0=8]
f(x_0) = 1 for x_0 =?
Mf =

     8

and this is correct.

NEW  TEST  CASE: [n=5, x0=9]
f(x_0) = 1 for x_0 =?
Mf =

     9

and this is correct.

NEW  TEST  CASE: [n=5, x0=10]
f(x_0) = 1 for x_0 =?
Mf =

    10

and this is correct.

NEW  TEST  CASE: [n=5, x0=11]
f(x_0) = 1 for x_0 =?
Mf =

    11

and this is correct.

NEW  TEST  CASE: [n=5, x0=12]
f(x_0) = 1 for x_0 =?
Mf =

    12

and this is correct.

NEW  TEST  CASE: [n=5, x0=13]
f(x_0) = 1 for x_0 =?
Mf =

    13

and this is correct.

NEW  TEST  CASE: [n=5, x0=14]
f(x_0) = 1 for x_0 =?
Mf =

    14

and this is correct.

NEW  TEST  CASE: [n=5, x0=15]
f(x_0) = 1 for x_0 =?
Mf =

    15

and this is correct.

NEW  TEST  CASE: [n=5, x0=16]
f(x_0) = 1 for x_0 =?
Mf =

    16

and this is correct.

NEW  TEST  CASE: [n=5, x0=17]
f(x_0) = 1 for x_0 =?
Mf =

    17

and this is correct.

NEW  TEST  CASE: [n=5, x0=18]
f(x_0) = 1 for x_0 =?
Mf =

    18

and this is correct.

NEW  TEST  CASE: [n=5, x0=19]
f(x_0) = 1 for x_0 =?
Mf =

    19

and this is correct.

NEW  TEST  CASE: [n=5, x0=20]
f(x_0) = 1 for x_0 =?
Mf =

    20

and this is correct.

NEW  TEST  CASE: [n=5, x0=21]
f(x_0) = 1 for x_0 =?
Mf =

    21

and this is correct.

NEW  TEST  CASE: [n=5, x0=22]
f(x_0) = 1 for x_0 =?
Mf =

    22

and this is correct.

NEW  TEST  CASE: [n=5, x0=23]
f(x_0) = 1 for x_0 =?
Mf =

    23

and this is correct.

NEW  TEST  CASE: [n=5, x0=24]
f(x_0) = 1 for x_0 =?
Mf =

    24

and this is correct.

NEW  TEST  CASE: [n=5, x0=25]
f(x_0) = 1 for x_0 =?
Mf =

    25

and this is correct.

NEW  TEST  CASE: [n=5, x0=26]
f(x_0) = 1 for x_0 =?
Mf =

    26

and this is correct.

NEW  TEST  CASE: [n=5, x0=27]
f(x_0) = 1 for x_0 =?
Mf =

    27

and this is correct.

NEW  TEST  CASE: [n=5, x0=28]
f(x_0) = 1 for x_0 =?
Mf =

    28

and this is correct.

NEW  TEST  CASE: [n=5, x0=29]
f(x_0) = 1 for x_0 =?
Mf =

    29

and this is correct.

NEW  TEST  CASE: [n=5, x0=30]
f(x_0) = 1 for x_0 =?
Mf =

    30

and this is correct.

NEW  TEST  CASE: [n=5, x0=31]
f(x_0) = 1 for x_0 =?
Mf =

    31

and this is correct.