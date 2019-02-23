package maze_solver;

public class MazeSolver {

	private String[][] maze;
	private int[][] pathScoring;
	private boolean[][] visited;
	private int numRows;
	private int numColumns;

	public void drawMaze() {

		int totalCells = getNumRows() * getNumColumns();
		int totalObstacles = 0;
		this.maze = new String[getNumRows()][getNumColumns()];
		this.pathScoring = new int[getNumRows()][getNumColumns()];
		this.visited = new boolean[getNumRows()][getNumColumns()];

		for (int i = 0; i < getNumRows(); i++) {
			for (int j = 0; j < getNumColumns(); j++) {

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

	}

	public void printMaze() {
		for (int i = 0; i < getNumRows(); i++) {
			for (int j = 0; j < getNumColumns(); j++) {
				System.out.print(maze[i][j] + " ");
			}
			System.out.println();
		}
	}

	public boolean isSolvable() {
		return solveMazeRecursively(this.getNumRows(), this.getNumColumns());
	}

	public boolean solveMazeRecursively(int row, int col) {
		return true;
	}

	public void printResult() {
		System.out.println("Congratulations! I found a solution for this maze as below:");
		printMaze();
		System.out.println("The amount of coins collected:");
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
