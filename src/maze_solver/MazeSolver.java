package maze_solver;

public class MazeSolver {

	private String[][] maze;
	private boolean[][] visited;
	private double[][] fieldCosts;
	private int numRows;
	private int numColumns;
	private int numCoins = 0;

	public void drawMaze() {

		int totalCells = getNumRows() * getNumColumns();
		int totalObstacles = 0;
		this.maze = new String[getNumRows()][getNumColumns()];
		this.visited = new boolean[getNumRows()][getNumColumns()];
		this.fieldCosts = new double[getNumRows()][getNumColumns()];

		for (int i = 0; i < getNumRows(); i++) {
			for (int j = 0; j < getNumColumns(); j++) {

				this.visited[i][j] = false;
				this.fieldCosts[i][j] = 99999.9;

				if (totalObstacles >= totalCells / 3) {
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
		
		calculateRowCost(row + 1, col);
		calculateRowCost(row, col + 1);
		calculateRowCost(row - 1, col);
		calculateRowCost(row, col - 1);
		
		double lowestCost = this.fieldCosts[0][0];

		for (int i = 0; i < getNumRows(); i++) {
			for (int j = 0; j < getNumColumns(); j++) {
				if (this.fieldCosts[i][j] < lowestCost && !this.maze[i][j].equals("#") && !this.visited[i][j]) {
					lowestCost = this.fieldCosts[i][j];
				}
			}
		}
		
		if (lowestCost == this.fieldCosts[0][0]) {
			return false;
		}
		
		for (int i = 0; i < getNumRows(); i++) {
			for (int j = 0; j < getNumColumns(); j++) {
				if (lowestCost == this.fieldCosts[i][j] && !this.maze[i][j].equals("#") && !this.visited[i][j]) {
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
		
		if (this.visited[getNumRows() - 2][getNumColumns() - 1] 
				|| this.visited[getNumRows() - 1][getNumColumns() - 2]) {
			return true;
		} else {
			return false;
		}
		
	}
	
	// Helper method for solveMazeRecursively
	private void calculateRowCost(int row, int col) {
		if (row < getNumRows() 
				&& col < getNumColumns()
				&& row >= 0
				&& col >= 0
				&& !this.maze[row][col].equals("#") 
				&& !this.visited[row][col]) {
			
			double distanceFromStart = Math.sqrt(Math.pow(row, 2) + Math.pow(col, 2));
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
