package maze_solver;

public class LA2Main {

	public static void main(String[] args) {

		MazeSolver solver = new MazeSolver();

		// Gets row and col data from user, creates maze, sets fields in MazeSolver
		MazeInput.initializeMazeSolver(solver);

		for (int i = 1; i <= 3; i++) {

			System.out.println("******Maze #" + i + "******");
			System.out.println("Start drawing the maze...");
			solver.drawMaze();
			
			System.out.println("The maze is as below:");
			solver.printMaze();

			if (solver.isSolvable()) {
				solver.printResult();
			} else {
				System.out.println("Sorry, no solution can be found for this maze!");
			}

			System.out.println();

		}

	}

}
