package blobapp;

public class Grid
{
	protected int rows; // number of grid rows
	protected int cols; // number of grid columns
 
	protected boolean [][] grid; // the grid containing blobs
	private boolean [][] visitedGrid;

	public Grid(int rows, int cols, boolean[][] grid){
		this.rows = rows;
		this.cols = cols;
		this.grid = grid;
		this.visitedGrid = new boolean[rows][cols];
	}

	public String toString(){
		String gridString = "";
		for (int i = 0; i < rows; i++){
			for (int j = 0; j < cols; j++){
				if (grid[i][j])
					gridString = gridString + "X";
				else
					gridString = gridString + ".";
			}
			gridString = gridString + "\n"; // end of row
		}  
		return gridString;
	}

	public int blobCount(){
		// returns the number of blobs in this grid
		int count = 0;
		for(int i=0; i < rows; i++){
			for(int j=0; j < cols; j++){
				if(grid[i][j]== true && visitedGrid[i][j]==false){
			 //here mark the cell in matrix and its neighbouring cells that are 
			 //also blobs. After increase the count variable.
					markCells(i,j);
					count++;
				}
			}
		}
		return count;
	}

	public void markCells(int i, int j){
	//This function recursively goes over the grid and marks the cells visited.
	//Mark the neighbouring cells if they have not been visited and make sure  
	//to not go out of bound.
		if (!(i<0 || j <0 || i >= rows || j >= cols 
				|| visitedGrid[i][j] == true || grid[i][j] == false))
		{
			visitedGrid[i][j] = true;
			markCells(i, j-1);
			markCells(i, j+1);
			markCells(i-1, j);
			markCells(i+1, j);
			markCells(i-1, j-1);
			markCells(i-1, j+1);
			markCells(i+1, j-1);
			markCells(i+1, j+1);
		}
	}
}