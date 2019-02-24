package maze_solver;

public class MazeSolver {

	private String[][] maze;
	private boolean[][] visited;
	private double[][] fieldCosts; // Array of cost values for A* algorithm
	private int numRows;
	private int numColumns;
	private int numCoins = 0;

	public void drawMaze() {

		int totalCells = getNumRows() * getNumColumns();
		
		this.maze = new String[getNumRows()][getNumColumns()];
		this.visited = new boolean[getNumRows()][getNumColumns()];
		this.fieldCosts = new double[getNumRows()][getNumColumns()];
		
		int totalObstacles = 0;

		for (int i = 0; i < getNumRows(); i++) {
			for (int j = 0; j < getNumColumns(); j++) {

				this.visited[i][j] = false;
				this.fieldCosts[i][j] = 99999.9;

				// Number of obstacles cannot be greater than a third of total cells
				if (totalObstacles >= totalCells / 3) {
					// Random integer between 1 and 100 representing coins
					this.maze[i][j] = String.valueOf((int) (Math.random() * 99 + 1)); 
				} else {
					if (Math.random() < .25) {
						this.maze[i][j] = "#";
						totalObstacles++;
					} else {
						this.maze[i][j] = String.valueOf((int) (Math.random() * 99 + 1));
					}
				}

			}
		}

		// Set start and destination points
		this.maze[0][0] = "S";
		this.maze[getNumRows() - 1][getNumColumns() - 1] = "D";
		this.visited[0][0] = true;

	}

	public void printMaze() {
		for (int i = 0; i < getNumRows(); i++) {
			for (int j = 0; j < getNumColumns(); j++) {
				System.out.print(maze[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public boolean isSolvable() {
		return solveMazeRecursively(0, 0);
	}

	public boolean solveMazeRecursively(int row, int col) {
		
		calculateCellCost(row + 1, col);
		calculateCellCost(row, col + 1);
		calculateCellCost(row - 1, col);
		calculateCellCost(row, col - 1);
		
		// Find lowest cost in fieldCosts that has not already been visited and is not an obstacle
		double lowestCost = this.fieldCosts[0][0];

		for (int i = 0; i < getNumRows(); i++) {
			for (int j = 0; j < getNumColumns(); j++) {
				if (this.fieldCosts[i][j] < lowestCost 
						&& !this.maze[i][j].equals("#") 
						&& !this.visited[i][j]) {
					
					lowestCost = this.fieldCosts[i][j];
					
				}
			}
		}
		
		// If there is no new lowestCost that is not a barrier or has already been visited, end
		if (lowestCost == this.fieldCosts[0][0]) {
			return false;
		}
		
		// Move to cell containing lowestCost
		for (int i = 0; i < getNumRows(); i++) {
			for (int j = 0; j < getNumColumns(); j++) {
				if (lowestCost == this.fieldCosts[i][j] 
						&& !this.maze[i][j].equals("#") 
						&& !this.visited[i][j]) {
					
					// If moved to cell containing D in maze, end
					if (i == getNumRows() - 1 && j == getNumColumns() - 1) {
						return true;
					}
					
					this.visited[i][j] = true;
					this.numCoins += Integer.parseInt(maze[i][j]);
					this.maze[i][j] = "+";
					solveMazeRecursively(i, j);
					
				}
			}
		}
		
		// Return true if a path to D in maze has been found, else return false
		if (this.visited[getNumRows() - 2][getNumColumns() - 1] 
				|| this.visited[getNumRows() - 1][getNumColumns() - 2]) {
			return true;
		} else {
			return false;
		}
		
	}
	
	// Helper method for solveMazeRecursively
	// Sets cost in fieldCosts for cell in [row, col] if row & col in range and cell is not an obstacle or visited
	private void calculateCellCost(int row, int col) {
		if (row < getNumRows() 
				&& col < getNumColumns()
				&& row >= 0
				&& col >= 0
				&& !this.maze[row][col].equals("#") 
				&& !this.visited[row][col]) {
			
			// Distance from S in maze
			double distanceFromStart = Math.sqrt(Math.pow(row, 2) + Math.pow(col, 2));
			// Distance from D in maze
			double distanceToDestination = Math.sqrt(Math.pow(getNumRows() - row, 2) + Math.pow(getNumColumns() - col, 2));
			double cost = distanceFromStart + distanceToDestination;
			
			this.fieldCosts[row][col] = cost;
			
		}
	}

	public void printResult() {
		System.out.println("Congratulations! I found a solution for this maze as below:");
		printMaze();
		System.out.println("The amount of coins collected: " + this.numCoins);
	}

	// Getters and setters

	public int getNumRows() {
		return numRows;
	}

	public void setNumRows(int numRows) {
		this.numRows = numRows;
	}

	public int getNumColumns() {
		return numColumns;
	}

	public void setNumColumns(int numColumns) {
		this.numColumns = numColumns;
	}

}
