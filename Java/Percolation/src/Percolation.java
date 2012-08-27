
public class Percolation {

	private int size;
	private int[][] grid;
	private WeightedQuickUnionUF uf;
	private WeightedQuickUnionUF uf2;
	
	public Percolation(int N) { // create N-by-N grid, with all sites blocked
		
		size = N;
		grid = new int[size][size];
		
		for (int i = 0; i < size; i++)
		{
			for (int j = 0; j < size; j++)
			{
				grid[i][j] = 0;
			}
		}
		
		uf = new WeightedQuickUnionUF(size * size + 2);
		uf2 = new WeightedQuickUnionUF(size * size + 1);
		
		for (int i = 0; i < size; i++)
		{
			uf.union(size * size, i);
		}
		
		for (int i = 0; i < size; i++)
		{
			uf.union(size * size + 1, size * size - 1 - i);
		}
		
		for (int i = 0; i < size; i++)
		{
			uf2.union(size * size, i);
		}
	}
	
	public boolean open(int i, int j) { // open site (row i, column j) if it is not already
		
		if (i >= 0 && j >= 0 && i < size && j < size)
		{
			if (!isOpen(i, j))
			{
				grid[i][j] = 1;
				
				if (j+1 >= 0 && j+1 < size)
				{
					if (isOpen(i, j+1))
					{
						uf.union(size * i + j, size * i + j+1);
						uf2.union(size * i + j, size * i + j+1);
					}
				}
				
				if (j-1 >= 0 && j-1 < size)
				{
					if (isOpen(i, j-1))
					{
						uf.union(size * i + j, size * i + j-1);
						uf2.union(size * i + j, size * i + j-1);
					}
				}
				
				if (i+1 >= 0 && i+1 < size)
				{
					if (isOpen(i+1, j))
					{
						uf.union(size * i + j, size * (i+1) + j);
						uf2.union(size * i + j, size * (i+1) + j);
					}
				}
				
				if (i-1 >= 0 && i-1 < size)
				{
					if (isOpen(i-1, j))
					{
						uf.union(size * i + j, size * (i-1) + j);
						uf2.union(size * i + j, size * (i-1) + j);
					}
				}
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			throw new IndexOutOfBoundsException("Coordinates do not exist.");
		}
	}
	
	public boolean isOpen(int i, int j) { // is site (row i, column j) open?
		
		return grid[i][j] == 1 || grid[i][j] == 2;
	}
	
	public boolean isFull(int i, int j) { // is site (row i, column j) full?
		
		return uf2.connected(size * i + j, size * size);
	}
	
	public boolean percolates() { // does the system percolate?
		
		return uf.connected(size * size, size * size + 1);
	}
	
    public String toString() {
    	String str = new String();
    	for (int i = 0; i < size; i++)
    	{
    		for (int j = 0; j < size; j++)
    		{
    			if (!isFull(i, j))
    			{
    				str += grid[i][j];
    			}
    			else
    			{
    				if (isOpen(i, j))
    				{
    					str += "*";
    				}
    				else
    				{
    					str += "0";
    				}
    			}
    		}
    		str += "\n";
    	}
    	return str;
    }
}
