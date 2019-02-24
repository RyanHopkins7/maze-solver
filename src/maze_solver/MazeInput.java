package maze_solver;

import java.util.Scanner;

public class MazeInput {

	// I chose to make these methods static because they act more like functions
	public static void initializeMazeSolver(MazeSolver solver) {

		// Instantiated reader in initializeMazeSolver method because 
		// closing a Scanner object also closes the input source
		Scanner reader = new Scanner(System.in);
		
		solver.setNumRows(getNumRows(reader));
		solver.setNumColumns(getNumCols(reader, solver.getNumRows()));
		
		reader.close();

	}

	private static int getNumRows(Scanner reader) {

		int numRows = -1;

		while (numRows == -1) {

			System.out.println("Enter number of rows in maze in range [5, 10]:");

			try {

				int input = Integer.parseInt(reader.nextLine());
				
				if (input < 5 || input > 10) {
					throw new IllegalArgumentException("Input must be between 5 and 10");
				} else {
					numRows = input;
				}

			} catch (NumberFormatException e) {
				System.out.println("Input must be an integer");
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage()); // Input not in range
			}
			
			System.out.println();

		}

		return numRows;

	}

	private static int getNumCols(Scanner reader, int numRows) {

		int numCols = -1;

		while (numCols == -1) {

			System.out.println("Enter number of columns in maze in range [5, 10]:");
			System.out.println("Number of columns cannot be equal to number of rows entered above");

			try {

				int input = Integer.parseInt(reader.nextLine());
				
				if (input < 5 || input > 10) {
					throw new IllegalArgumentException("Input must be between 5 and 10");
				} else if (input == numRows) {
					throw new IllegalArgumentException("Input cannot be equal to number of rows entered above");
				} else {
					numCols = input;
				}

			} catch (NumberFormatException e) {
				System.out.println("Input must be an integer");
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage()); // Input not in range or input==numRows
			}
			
			System.out.println();

		}

		return numCols;

	}

}