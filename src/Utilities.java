import java.util.ArrayList;

/**
 * This class handles the basic utilities i.e helper functions.
 * such as - successor functions, counting inversions, printing matrices, etc.
 */


public class Utilities {
	
	
	/**
	 * This is a successor function method.
	 * Generates a list of possible moves for the blank tile in a given state of matrix.
	 * 
	 * @param matrix - Input matrix
	 * @param rows - Number of rows in input matrix
	 * @param columns - Number of columns in input matrix
	 * @return ArrayList containing set of possible moves e.g. left, down etc.
	 */
	
	public ArrayList<String> getPossibleMoves(int[][] matrix, int rows, int columns)
	{
		int i,j;
		ArrayList<String> moves = new ArrayList<String>();
		
		for(i=0;i<rows;i++)
		{
			for(j=0;j<columns;j++)
			{
				if(matrix[i][j]==0)
				{
					if(i<=1)
					{
						moves.add("Down");
					}
					if(i>=1)
					{
						moves.add("Up");
					}
					if(j<=1)
					{
						moves.add("Right");
					}
					if(j>=1)
					{
						moves.add("Left");
					}
					
				}
			}
		}
		return moves;
	}
	
	/**
	 * Counts number of inversions in a matrix
	 * 
	 * @param matrix - Input matrix
	 * @param rows - Number of rows in input matrix
	 * @param columns - Number of columns in input matrix	 
	 */
	
	public boolean countInversions(int[][] matrix,int rows, int columns)
	{
		int i,j,count,index;
		count = 0;
		index = 0;
		int[] temp = new int[rows*columns];
		
		for(i=0;i<rows;i++)
		{
			for(j=0;j<columns;j++)
			{
				temp[index] = matrix[i][j]; // convert the 2-D array in 1-D
				index++;
			}
		}
		
		for(i=0;i<(rows*columns-1);i++)
		{
			if(temp[i]!=0)
			{
				for(j=i+1;j<(rows*columns);j++)
				{
					if(temp[j] !=0 && temp[i]>temp[j])
					{
						count++;		//count number of elements greater than ith element
					}
				}
			}
			
		}
		System.out.println("The number of inversions are "+count);
		
		return (count%2==0);
	}
	
	/**
	 * Moves the blank tile in the desired direction
	 * 
	 * @param matrix - input matrix
	 * @param move - direction in which the blank tile is to be moved
	 * @param rows - Number of rows in input matrix
	 * @param columns - Number of columns in input matrix	 
	 * @return Boolean - True if both matrices are equal else false
	*/
	
	public int[][] moveblank(int[][] matrix, String move, int rows, int columns)
	{
		int i,j, flag=1;
		
		for(i=0;i<rows;i++)
		{
			for(j=0;j<columns;j++)
			{
				if(matrix[i][j]==0 && flag==1)
				{
					if(move.equals("Right"))
					{
						 
						matrix[i][j] = matrix[i][j+1];
						matrix[i][j+1] = 0;
						flag = 0;
					}
					
					if(move.equals("Left"))
					{
						 
						matrix[i][j] = matrix[i][j-1];
						matrix[i][j-1] = 0;
						flag = 0;
					}
					
					if(move.equals("Up"))
					{
						 
						matrix[i][j] = matrix[i-1][j];
						matrix[i-1][j] = 0;
						flag = 0;
					}
					
					if(move.equals("Down"))
					{
						 
						matrix[i][j] = matrix[i+1][j];
						matrix[i+1][j] = 0;
						flag = 0;
					}
				}
			}
		}
		
		return matrix;
	}
	
	
	/** 
	 * Prints the input matrix
	 * 
	 * @param matrix - Input matrix
	 * @param rows - Number of rows in input matrix
	 * @param columns - Number of columns in input matrix
	*/
	
	public void printmatrix(int[][] matrix,int rows,int columns)
	{
		int i,j;
		for(i=0;i<rows;i++)
		{
			for(j=0;j<columns;j++)
			{
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	/**
	 * Compares two matrices to check if they are equal
	 * 
	 * @param matrix1 - first matrix
	 * @param matrix2 - second matrix
	 * @param rows - Number of rows in input matrix
	 * @param columns -  Number of columns in input matrix
	 * @return Boolean - True if both matrices are equal else False
	*/
	
	public boolean compare(int[][] matrix1,int[][] matrix2, int rows, int columns)
	{
		int i,j;
		boolean retval = true;
		for(i=0;i<rows;i++)
		{
			for(j=0;j<columns;j++)
			{
				if(matrix1[i][j]!=matrix2[i][j])
				{
					retval = false;
				}
			}
		}
		return retval;
	}
	
	
	/**
	 * Creates a copy of original matrix
	 * 
	 * @param originalMatrix - input matrix
	 * @param copyMatrix - the matrix in which the numbers are to be copied	 
	 * @param rows - Number of rows
	 * @param columns - Number of columns
	*/
	
	public void copymatrix(int[][] originalMatrix, int[][] copyMatrix,int rows, int columns)
	{
		int i,j;
		for(i=0;i<rows;i++)
		{
			for(j=0;j<columns;j++)
			{
				copyMatrix[i][j] = originalMatrix[i][j];
			}
		}
	}
	
	/**
	 * Prints the path to be traversed to reach goal state
	 * 
	 * @param path - list of moves to be taken
	 * @param matrix - on which the moves are to be performed 
	 * @param rows - Number of rows
	 * @param columns - Number of columns
	*/
	
	public void printpath(ArrayList<String> path, int[][] matrix, int rows, int columns)
	{
		for(String move :path )
		{
			System.out.println(move);
			moveblank(matrix, move, rows,columns);
			printmatrix(matrix, rows, columns);
		}
	}

}
