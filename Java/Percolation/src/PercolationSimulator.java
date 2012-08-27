import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class PercolationSimulator {

	public static void main(String[] args) throws FileNotFoundException {
		
		File f = new File("src/input.txt");
		Scanner sc = new Scanner(f);
		int N = sc.nextInt();
		
		double count = 0;
		
		Percolation myP = new Percolation(N);
		int i;
		int j;
		while(!myP.percolates())
		{
			i = (int)(Math.random() * N);
			j = (int)(Math.random() * N);
			
			if(myP.open(i, j))
			{
				count++;
			}
			
			System.out.println("\n" + myP);
		}
		System.out.println("\n" + count / (N*N));
	}

}
