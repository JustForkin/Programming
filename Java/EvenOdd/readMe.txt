In order to play the game, run the Test.java file. 
This will allow you to play the game either computer vs computer or 
human vs computer, depending on what you choose.

In order to run the simulator, run the Simulation.java file. 
By adjusting the number of TRIALS and the t-values in Player.java, 
one can implement a simulation experiment that determines whether this is a 
fair game in terms of monetary balance.

As it turns out, the game is not fair and the odd player (player 1) can 
utilize a strategy that leads to a positive balance in the long run 
no matter what the other player does. The optimal strategy (*EXTRA CREDIT*):
Let p1 and p2 be the fractions of rounds in which Odd (player 1) 
picks one and two, respectively. 
Rounds are either p1 or p2, so p1 + p2 = 1. If Even (player 2) opts for '1', 
then the return for Odd is -2 (if he picked 1) or 3 (if he picked 2). 
Thus on average, he may expect a payoff of -2p1 + 3p2.  If Player 2 opts for '2', 
then Player 1's expectation is 3p1 - 4p2. 
If we seek an expected payoff of at least V regardless of Player 2's strategy, 
then it follows that 2p1 + 3p2 = V and 3p1 - 4p2 = V. Minimally, 
considering them to be equal, 
V = -2p1 + 3p2 = 3p1 - 4p2 ==> 7p2 = 5p1 ==> 7(1 - p1) = 5p1 ==> 7 = 12p1 
==> 7/12 = p1 ==> p2 = 5/12.  
==> V = 1/12 [ since -2( 7/12 ) + 3( 5/12 ) = 1/12 = 3( 7/12 ) - 4( 5/12 )]. 
So  Odd (player 1) can guarantee an expected return of 1/12 per play with a 
large number of trials by picking '1'  7/12ths of the time and picking '2'  5/12ths of the time. 
Using the same argument, Even (player 2) can minimize his losses at 1/12 per play 
by also picking '1' and '2' at a 7:5 ratio.
This does not mean that Odd will win more games than Even. 
In fact, this is not the case. But Odd /will/ make money from this game over 
a large period of time.

Player.java creates a player which can be either human or computer. 
If human, the player chooses whether to play a 1 or a 2. If computer, the number 
is selected based on whether a random number chosen is above 
or below the value of its "t," a switch whose value can be adjusted to 
optimize strategy. (7/12 = .583333).  
Game.java creates a game which takes the players' numbers and 
determines who wins based on the sum of the numbers. The winner receives 
money equal to the sum. Then, it calculates and outputs who owes who money 
and how much money he owes.
Test.java allows the user to select the type of game he wishes to run, 
and then creates and plays rounds of the game. (And output is printed.)   
Simulation.java runs the computer simulator many times and calculates and 
prints who owes who how much money. This can be used to determine optimal 
strategies, as discussed above.