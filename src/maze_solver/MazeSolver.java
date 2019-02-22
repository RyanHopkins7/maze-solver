package maze_solver;

public class MazeSolver {
	
	private String[][] maze;
	private int[][] pathScoring;
	private boolean[][] visited;
	private int numRows;
	private int numColumns;
	
	public void drawMaze() {
		System.out.println(numRows + ", " + numColumns);
	}
	
	public void printMaze() {
		
	}
	
	public boolean isSolvable() {
		return solveMazeRecursively(this.getNumRows(), this.getNumColumns());
	}
	
	public boolean solveMazeRecursively(int row, int col) {
		return true;
	}
	
	public void printResult() {
		
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
