package pack;

import java.io.File;
import java.util.Scanner;

class Driver
{
	private char grid[][] = new char[20][20];
	private char nextGrid[][] = new char[20][20];
	
	public int getGraph()
	{
		int row = 0;
		int generationNum;
		       
		System.out.println("How many generations would you like to compute?");
		Scanner scan = new Scanner(System.in);
		generationNum = scan.nextInt();
		      
		try
		{
			File file = new File("InputGrid.txt");
			Scanner reader = new Scanner(file);
			
			while (reader.hasNext())
			{
				String line = reader.next();
				
				if (line.length() == 20)
				{
					for (int col = 0; col < 20; col++)
					{
						grid[row][col] = line.charAt(col);
					
					}
					row++;
				}
				else
				{
					generationNum = Integer.parseInt(line);
					break;
				}
			}
			reader.close();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return generationNum;
	}
	
	public void useThreads()
	{
		Thread threads[] = new Thread[400];
		int index = 0;
		for (int row = 0; row < 20; row++)
		{
			for (int col = 0; col < 20; col++)
			{
				threads[index] = new Thread(new Threads(row, col, grid, nextGrid));
				threads[index].start();
				index++;
			}
		}
		try
		{
			for (int cells = 0; cells < 400; cells++)
			{
				threads[cells].join();
			}         
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		for (int row = 0; row < 20; row++)
		{
			for (int col = 0; col < 20; col++)
			{
				grid[row][col] = nextGrid[row][col];
			}
		}  
	}
	
	public static void main(String[] args)
	{
		Driver game1 = new Driver();  
		int generations = game1.getGraph();
		
		for (int i = 0; i < generations; i++)
		{
			game1.useThreads();
		}
		
		System.out.println("The final configuration (" + generations + "):");
		
		for (int row = 0; row < 20; row++)
		{
			for (int col = 0; col < 20; col++)
			{
				System.out.print(String.valueOf(game1.grid[row][col]));
			}
			System.out.println("");
		}
	}
}