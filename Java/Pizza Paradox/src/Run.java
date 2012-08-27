public class Run {
    public static void main(String[] args) {
	
    final int ROUNDS = 250000;
    final int POPULATION =  10000;
    final double PROBABILITY = .25;
	PizzaGame game = new PizzaGame(POPULATION,PROBABILITY);
	double[] output = game.run(ROUNDS);
	System.out.println("answer: " + output[0]);
	System.out.println("games disqualified: " + output[2]/ROUNDS);
	System.out.println("games where I get called: " + output[1]);
    }
}