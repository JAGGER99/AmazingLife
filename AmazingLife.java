/*
File Name : AmazingLife + A'maze'n Life
Program Author(s) : Joshua Greene
Program Tester : Micah Hays
Course Number & Title : Data Structures (COSC2203)
Assignment Number & Name : Assignment #1: Amazing Life and #2: A'maze'n Life
Due Date : 9/16/2020
Description : This program is a simulation of John Conway's Game of Life.
              The user provides the number of generations they want outputted
              along with the first generation.The program returns the proceeding 
              generations. 

(added features): The program now takes the final grid and converts it
                  to a maze. The program implements a stack to keep track of
                  the path the explorer took to get from the top left to the
                  bottem right of the maze. The program outputs each step taken
                  by the explorer if verbose("v/V") is specified and only the 
                  complete path if the user enters anything else.
*/

package amazinglife;
import stackexcercise.*;
import java.util.*;

//AmazingLife class (the driver class):
public class AmazingLife  {
    
    //main method incharge of input & output:
    public static void main(String[] args) throws GreeneEmptyStackException {
      
        //***primitive data types***:
        String vORs = "";
        int numOfGen = 0;
        int rows = 0;
        int columns = 0;
        String line = "";
        String output = "";
        
        //getting input from user:
        Scanner input = new Scanner(System.in);
        
        System.out.println("Do you want verbose(V) or silent(S)?:");
        vORs = input.nextLine();
        System.out.println("How many generations are there?:");
        numOfGen = input.nextInt();
        System.out.println("How many rows in the grid?:");
        rows = input.nextInt();
        System.out.println("How many columns in the grid?:");
        columns = input.nextInt();
        
        //checking if number of generations is too high:
        if(numOfGen > 100) {
            
            System.out.println("Sorry, I can't handle that many Generations!");
            System.exit(0);
        }
        
        //creating my first grid:
        int[][] initGrid = new int[rows + 2][columns + 2];
        
        //need this to reset the scanner!
        input.nextLine();

        //creating the initial grid with user's data:
        System.out.println("Please create the initial grid with 0's and 1's:");
        for(int i = 0; i < rows; i++) {
            line = input.nextLine();
            
            //if a row is too long (unnecessary but helpful to user):
            while(line.length() > columns) {
                System.out.println("Sorry, this grid is not the correct size.");
                System.out.println("Please try again:");
                line = input.nextLine();
            }
            
            for(int j = 0; j < columns; j++) {
                initGrid[i+1][j+1] = Character.getNumericValue(line.charAt(j));
            }   
        }
        
        //making output easier to understand:
        System.out.println("\n****Beginning of New Generation(s)****\n");
        
        
        // printing to console:        
        for(int x = 0;x < numOfGen - 1; x++) {
              
            //making an instance of the grid class:
            Grid grid = new Grid(rows, columns, initGrid);
            
            //creating a new 2d array to hold my new generation:
            int[][] newGrid = grid.getNextGen();
            
            //output if vORs = "V":
            if(vORs.equalsIgnoreCase("V")) {
                
                System.out.println("Gen: " + (x+2));
                output = grid.toString(newGrid);
                System.out.println(output);
            }
            
            //output if vORs = "S"(or anything other than V/v):
            else {
                if(x == numOfGen - 2) {
                    
                    System.out.println("Gen: " + (x+2));
                    output = grid.toString(newGrid);
                    System.out.println(output);
                          
                }
            }
            
            //making the new grid the first grid for the next time through:
            initGrid = newGrid;
        }
        
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
        
        //creating the maze
        //keep in mind: initGrid is the last "newGrid" at this point!
        Maze maze = new Maze(rows, columns, initGrid);
                
        String[][] theMaze = maze.createMaze();
        System.out.println(maze.toString());
                
        //updating the maze and printing:        
        while(!theMaze[rows][columns].equals("*")) {
                    
            Location location = new Location(maze.loc_R, maze.loc_C);
            maze.updateMaze(location);
            if(maze.cantMove == true) {
                System.out.println("There was no solution to the maze!");
                break;
            }
            
            //verbose:
            if(vORs.equalsIgnoreCase("V")) {
                System.out.println(maze.toString());
            }
            // silent (only the final path):
            else {
                if(theMaze[rows][columns].equals("*")) {
                    System.out.println(maze.toString());
                }
            }
                    
        }       
        
    }   
}
