package maze_solver;

public class LA2Main {

	public static void main(String[] args) {

		MazeSolver solver = new MazeSolver();

		// gets row and col data from user, creates maze, sets fields in MazeSolver
		MazeInput.initializeMazeSolver(solver);

		System.out.println("******Maze #1******");
		System.out.println("Start drawing the maze...");
		System.out.println("The maze is as below:");
		solver.printMaze();
		
		if (solver.isSolvable()) {
			solver.solveMazeRecursively(solver.getNumRows(), solver.getNumColumns());
			solver.printResult();
		} else {
			System.out.println("Sorry, no solution can be found for this maze!");
		}

	}

}

