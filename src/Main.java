/**
* The program solves the 8-tile problem using Iterative Deepening Search (IDS).
* It first calculates the number of inversions and if even, generates the steps(moves)
* to reach final state of matrix from initial state.
*
* @author  Sameer Sonawane
* @version 1.0
* @last modified 2016-03-01
*/


import java.util.ArrayList;


public class Main {
	
	public static GenerateMatrix generateMatrixObject = new GenerateMatrix();	
	public static int[][] initialMatrix = generateMatrixObject.generateMatrix(); // Generates a random 3x3 matrix
	public static int[][] finalMatrix = new int[][]{{1,2,3},{4,5,6},{7,8,0}};	 // Denotes the final(goal) state of matrix
	
	public static void main(String[] args)
	{
						
		Utilities utility = new Utilities();
		
		System.out.println("Initial matrix is :");
		utility.printmatrix(initialMatrix, 3, 3);		
		
		boolean proceed;
		proceed = utility.countInversions(initialMatrix, 3, 3); // returns true if number of inversions even
		
		if(proceed)		// proceed if the number of inversions is even 
		{			
			DepthLimitedSearch dlsobj = new DepthLimitedSearch();
			int result=-1;
			int depth = 0;
			
			ArrayList<String> path = new ArrayList<String>();
			
			while(result!=1 )
			{
							
				path.clear();
				
				result = dlsobj.dls(initialMatrix,depth,path, 3,3);	// check if goal state can be achieved at depth using DLS
				if(result!=1)
				{
					System.out.println("Goal State cant be achieved at depth"+depth);
				}
				else if(result==1)
				{
					utility.printpath(path,initialMatrix, 3, 3);
				}
				
				depth++;
			}
				
		}
		else
		{
			System.out.println("Not solvable due to odd number of inversions");
		}
		
	}
}
