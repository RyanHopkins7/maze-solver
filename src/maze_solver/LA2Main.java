package maze_solver;

public class LA2Main {

	public static void main(String[] args) {

		MazeSolver solver = new MazeSolver();

		// gets row and col data from user, creates maze, sets fields in MazeSolver
		MazeInput.initializeMazeSolver(solver);

		solver.printMaze();
		
		if (solver.isSolvable()) {
			solver.solveMazeRecursively(solver.getNumRows(), solver.getNumColumns());
			solver.printResult();
		} else {
			System.out.println("Sorry, no solution can be found for this maze!");
		}

	}

}
