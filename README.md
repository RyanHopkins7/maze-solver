# maze-solver
A project for my Computer Science 2 class. Generates three mazes with dimensions based on user input. A robot must find a path from the top left of the maze to the bottom right. Obstacles are randomly generated. I chose to use A* path-finding.

I used the Eclipse IDE for this project. To run code, download or clone this repository and open it in Eclipse. 

See Maze Solver SLC Report.docx for documentataion and prompt.pdf for prompt. 

Summarized version of the prompt:

Create an application Maze Solver that can:
  1)	Generate a maze (a 2d array of strings) 
    a.	Number of rows and columns are given by the user and must be in the range [5,10]. Number of rows cannot equal number of columns.
    b.	Must validate input. If input is invalid, repeatedly ask for valid input.
  2)	Randomly fill the maze with numbers in the range [1,100] and #’s. 
    a.	The number is the amount of coins the robot can pick up by passing through that cell.
    b.	A ‘#’ represents a blocked position the robot cannot pass through.
    c.	‘S’ is the starting point for the robot and is at the top left corner of the maze.
    d.	‘D’ is the robot’s final destination (the end of the maze) and is at the bottom right corner of the maze.
    e.	The total number of #’s cannot be greater than a third of the total number of positions in the maze.
  3)	Print out the maze to the screen once it is generated.
  4)	Attempt to find an available path from S to D.
    a.	The robot can move up, right, left, or down.
    c.	This program must use recursion.
  5)	If the robot is not able to find a path, print a corresponding message to the screen.
  6)	If the robot finds a path, then:
    a.	Print out the maze with the path marked by +’s.
    b.	Sum up all the numbers on this path and print out the result as the number of coins found.
  7)	This program is required to run steps 2 – 6 above 3 times.
