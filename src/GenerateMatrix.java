import java.util.Random;

/**
 * Generates a 3 X 3 matrix with numbers 0 - 8
 * 0 denotes a blank tile in the 8 - tile matrix.
 */

public class GenerateMatrix {
	
	
	public int[][] generateMatrix()
	{
		int[][] initialMatrix = new int[3][3];
		int[] pos = new int[9];
		int i,j,flag,rand;
		
		for(i=0;i<3;i++)
		{
			for(j=0;j<3;j++)
			{
				initialMatrix[i][j] = -1;
			}
		}
		
		/*
		 * iterate the matrix row wise. Generate a random number between 0-8 for each cell 
		 */
		for(i=0;i<3;i++)
		{
			for(j=0;j<3;j++)
			{
				flag = 1;
				while(flag==1)
				{
					rand = randInt(0, 8);
					if(pos[rand]==0) 	//rand number not already present in matrix
					{
						pos[rand]=1;
						initialMatrix[i][j] = rand;
						flag = 0;
					}
				}
			}
		}
		
		return initialMatrix;
	}
	
	
	

	/**
	 * Returns a pseudo-random number between min and max, inclusive.
	 * The difference between min and max can be at most
	 * <code>Integer.MAX_VALUE - 1</code>.
	 *
	 * @param min Minimum value
	 * @param max Maximum value.  Must be greater than min.
	 * @return Integer between min and max, inclusive.
	 * @see java.util.Random#nextInt(int)
	 */
	public int randInt(int min, int max) {

	    // NOTE: Usually this should be a field rather than a method
	    // variable so that it is not re-seeded every call.
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}

}
