package maze_solver;

public class Maze {
	
	private int numRows;
	private int numColumns;
	private String[][] maze;
	private String[][] mazeSolution;
	
	public Maze(int numRows, int numColumns) {
		
	}
	
	public void generateMaze() {
		
	}
	
	public void solveMaze(String[][] mazeSolution) {
		
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

	public String[][] getMaze() {
		return maze;
	}

	public void setMaze(String[][] maze) {
		this.maze = maze;
	}

	public String[][] getMazeSolution() {
		return mazeSolution;
	}

	public void setMazeSolution(String[][] mazeSolution) {
		this.mazeSolution = mazeSolution;
	}
	
}