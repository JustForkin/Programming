import java.util.Random;


public class PizzaGame {
    final int SIZE;
    final double PROB;
    public PizzaGame(int size, double prob){
	PROB = prob;
	SIZE = size;
    }
    /*
     * array of ints 1..x
     * randomly choose one number form 1..x 
     * shuffle array
     * while n < NUMBEROFPEOPLE and again
     * pick 2^n people from pointer reset pointer
     * flip coin free pizz?
     * if inGroup
     * if pizza return 1
     * else 0
     * else 
     * if pizza return -1
     * else {}
     */
    
    /**
     * Simulate the pizza game 1 time
     * Return:
     * 1  I got a pizza
     * 0  I didn't get a pizza (and was picked)
     * -1  I didn't get picked (and someone else won pizza)
     * -2  Game disqualified since there weren't enough ppl to pick (long game)
     */
    public int simulate(){
	Random rand = new Random();
	//make people
	int[] people = new int[SIZE];
	///fill array
	for(int i=0; i<SIZE; i++){
	    people[i] = i;
	}
	//pick me
	int me = rand.nextInt(SIZE);
	//shuffle
	for(int i=0; i<SIZE; i++){
	    int index = rand.nextInt(SIZE-i)+i;
	    int temp = people[i];
	    people[i] = people[index];
	    people[index] = temp;
	}
	//simulate game
	int n = 1;
	boolean again = true;
	boolean isMe = false;
	boolean pizza = false;

	while(again){
	    for(int i=n-1; i < (n*2-1) ; i++){
		if(i==SIZE) return -2;
		if(people[i] == me)isMe = true;
	    }
	    double flip = rand.nextDouble();
	    if(flip < PROB){
		pizza = true;
	    }
	    else{
		pizza = false;
	    }
	    //comment
	    if(isMe){
		if(pizza) return 1;
		else return 0;
	    }
	    else{
		if(pizza) return -1;
	    }
	    
	    n*=2;
	}
	return -2;
    }

    /**
     * Answers the pizza paradox
     * @param number The number of simulations to run
     * @return [0] Fraction of times I won a pizza after being picked
     * [1] Games counted
     * [2] Number of games where I get called
     */
    public double[] run(int number){
		double[] ret =  new double[3];
	    int noPizzaSum = 0; 
		int pizzaSum = 0;
		int disqualified = 0;
		for(int i=0; i< number; i++){
		    if(simulate() == 0) noPizzaSum++;
		    else if(simulate() == 1) pizzaSum++;
		    else if(simulate() == -2) disqualified++;
		}
		ret[0] = (double)pizzaSum/(pizzaSum+noPizzaSum);
		ret[1] = (double) (pizzaSum+noPizzaSum);
		ret[2] = disqualified;
		return ret;
    }
    
}
