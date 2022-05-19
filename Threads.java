package pack;

class Threads implements Runnable
{
	private int row;
	private int col;
	private char grid[][];
	private char nextGrid[][];
	
	public Threads(int row, int col, char[][] grid, char[][] nextGrid)
	{
		this.row = row;
		this.col = col;
		this.grid = grid;
		this.nextGrid = nextGrid;
	}
	
	public boolean isAlive()
	{
		int liveNeighbor = 0;
		
		for (int i = row - 1; i <= row + 1; i++)
		{
			for (int j = col - 1; j <= col + 1; j++)
			{
				if ((i != row || j != col) && i >= 0 && j >= 0 && i < 20 && j < 20 && grid[i][j] == 'X')
				{
					liveNeighbor++;
				}
			}
		}
		if (grid[row][col] == 'O' && liveNeighbor == 3)
		{
			return true;
		}      
		if (grid[row][col] == 'X' && (liveNeighbor == 2 || liveNeighbor == 3))
		{
			return true;
		}
			return false;
	}
	
	@Override
	public void run()
	{
		boolean living = isAlive();
		if (living)
		{
			nextGrid[row][col] = 'X';
		}
		else
		{
			nextGrid[row][col] = 'O';
		}
	}
}
