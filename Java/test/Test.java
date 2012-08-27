/**
 * 
 * @author Michael Rubin
 *
 */

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int count  = 0;
		int i = 0;
		do
		{
			count += i;
			i++;
			if(count>5) break;
		} while (i<=4);
		System.out.print(count);
	}
}
