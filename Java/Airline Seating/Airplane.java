
public class Airplane {

	public final int ECONROWS = 30;
	public final int ECONCOLS = 2;
	public final int FIRSTROWS = 5;
	public final int FIRSTCOLS = 2;
	
	private Bench[][] econBenches;
	private Bench[][] firstBenches; 
	
	/**
	 * Constructs an airplane with a first class seating chart and one for economy class
	 */
	Airplane()
	{
		econBenches = new Bench[ECONCOLS][ECONROWS];
		for (int i = 0; i < ECONCOLS; i++)
		{
			for(int j = 0; j < ECONROWS; j++)
			{
				econBenches[i][j] = new EconBench();
					
			}
		}
		firstBenches = new Bench[FIRSTCOLS][FIRSTROWS];
		for (int q = 0; q < FIRSTCOLS; q++)
		{
			for(int w = 0; w < FIRSTROWS; w++)
			{
				firstBenches[q][w] = new FirstBench();
			}
		}
	}
	
	/**
	 * returns specified bench (comprised of seats) in the economy class seating area
	 * @param i - row
	 * @param j - column
	 * @return specified bench (of seats) in the economy class seating area
	 */
	public Bench getEconBench(int i, int j)
	{
		return econBenches[i][j];
	}
	
	/**
	 returns specified bench (comprised of seats) in the first class seating area
	 * @param i - row
	 * @param j - column
	 * @return specified bench (of seats) in the first class seating area
	 */
	public Bench getFirstBench(int i, int j)
	{
		return firstBenches[i][j];
	}
	
	/**
	 * Draws what the plane looks like with O's and X's to mark empty and reserved seats
	 * @return the String containing the seating charts
	 */
	public String draw()
	{
		
		for (int a = 0; a < ECONCOLS; a++)
		{
			for (int s = 0; s < ECONROWS; s++)
			{
				econBenches[a][s].update();
			}
		}
		for (int a = 0; a < FIRSTCOLS; a++)
		{
			for (int s = 0; s < FIRSTROWS; s++)
			{
				firstBenches[a][s].update();
			}
		}
		
		String pic = "";
		pic += "First class: \n";
		for(int i = 0, u = FIRSTCOLS/2; i < FIRSTCOLS/2 && u > 0; i++, u--)
		{
			for (int j = 0; j < FIRSTROWS; j++)
			{
				
				pic += firstBenches[i][j].drawL();
				pic += firstBenches[u][j].drawR();
				pic += "\n";
			}
		}
		pic += "Economy class: \n";
		for(int i = 0, u = ECONCOLS/2; i < ECONCOLS/2 && u > 0; i++, u--)
		{
			for (int j = 0; j < ECONROWS; j++)
			{
				
				pic += econBenches[i][j].drawL();
				pic += econBenches[u][j].drawR();
				pic += "\n";
			}
		}
		return pic;
			
	}
	
	
	
	
}
