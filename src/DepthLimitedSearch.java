import java.util.ArrayList;



public class DepthLimitedSearch {
	
	/**
	 * Checks if goal state can be achieved at certain depth 
	 * 
	 * @param matrix - current state of matrix
	 * @param limit - up to max depth to check
	 * @param path - list of moves 
	 * @param rows - Number of rows
	 * @param columns - Number of columns
	*/
	
	
	public int dls(int[][] matrix, int limit,ArrayList<String> path, int rows, int columns)
	{		
		int retval = rdls(matrix,0,limit,path, rows, columns);
		return retval;
	}
	
	/**
	 * Recursive Depth Limited Search
	 * Checks if goal state can be achieved up to a certain depth by recursion 
	 * 
	 * @param matrix - current state of matrix
	 * @param d - current depth
	 * @param limit - up to max depth to check
	 * @param path - list of moves 
	 * @param rows - Number of rows
	 * @param columns - Number of columns
	*/
	
	public int rdls(int[][] matrix, int currentDepth,int limit, ArrayList<String> path, int rows, int columns)
	{
		boolean cutOffOccurred = false;
		
		Utilities utility = new Utilities();
		
		if(utility.compare(matrix, Main.finalMatrix, rows, columns)) // current state matches goal state
		{
			System.out.println("Final State achieved at depth "+currentDepth);
			return 1;
		}
		else if( currentDepth == limit) 
		{
			
			return -1;
		}
		else
		{
			ArrayList<String> moves = utility.getPossibleMoves(matrix, rows, columns); // get possible moves for current state
			
			for(String move : moves) // for each possible move
			{
				path.add(move);
				int result;				
				
				int[][] cmat = new int[3][3];
				
				utility.copymatrix(matrix, cmat, rows, columns);				
				
				cmat = utility.moveblank(cmat, move, rows, columns); 	//perform current move
				
				result = rdls(cmat, currentDepth+1, limit,path, rows , columns);  // check at next depth for current move
				
				if(result==-1)
				{
					cutOffOccurred = true;
					path.remove(path.size()-1); 	// delete the move from path since cutoff occurred  
				}
				else if(result==1)
				{
					return 1;	
				}
			}
			if(cutOffOccurred)
			{
				return -1;
			}
			else
			{
				
				return 0;
			}
		}
		
		
	}

}
