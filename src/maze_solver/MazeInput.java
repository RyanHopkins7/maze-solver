package maze_solver;

public class MazeInput {

	// I chose to make these methods static because they act more like functions
	public static void initializeMazeSolver(MazeSolver solver) {

		solver.setNumRows(getNumRows());
		solver.setNumColumns(getNumCols(solver.getNumRows()));
		solver.drawMaze();

	}

	private static int getNumRows() {
		System.out.println("Enter number of rows in range [5, 10]:");
		return 0;
	}

	private static int getNumCols(int numRows) {
		System.out.println("Enter number of columns in range [5, 10].");
		System.out.println("This must be different from number of rows:");
		return 0;
	}

}