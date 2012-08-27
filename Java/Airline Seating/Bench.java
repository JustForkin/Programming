
public abstract class Bench {

	
	/**
	 * updates which seats are available based on user preferences
	 */
	abstract void update();
	
	/**
	 * Returns whether seats with specified preferences are available
	 * @param people number of people
	 * @param preference window/center/aisle
	 * @return true or false
	 */
	public abstract boolean check(int people, int preference);
	
	/**
	 * fills seat in a bench that has specified position on bench
	 * @param position
	 * @return that seat was filled
	 */
	public abstract String takeSeat(int position);
	
	/**
	 * fills seat in a bench that has specified position on bench
	 * @param position1
	 * @param position2
	 * @return that seats were filled
	 */
	public abstract String takeSeat(int position1, int position2); 
	
	/**
	 * fills seat in a bench that has specified position on bench
	 * @param position1
	 * @param position2
	 * @param position3
	 * @return that seats were filled
	 */
	public abstract String takeSeat(int position1, int position2, int position3);
	
	/**
	 * returns whether a window seat is available
	 * @return true or false
	 */
	public abstract boolean getFitWindow();
	
	/**
	 * returns whether an aisle seat is available
	 * @return true or false
	 */
	public abstract boolean getFitAisle();
	
	/**
	 * draws left column of benches
	 * @return diagram of left column of benches
	 */
	public abstract String drawL();
	
	/**
	 * draws right column of benches
	 * @return diagram of right column of benches
	 */
	public abstract String drawR(); 
	

}
