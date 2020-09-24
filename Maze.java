
package amazinglife;
import stackexcercise.*;

public class Maze {
    
    //data fields:
    int[][] finalGrid;
    String[][] maze;
    int r;
    int c;
    String explorer = "*";
    int loc_R = 1;
    int loc_C = 1;
    boolean cantMove = false;
    
    //creating the stack:
    GreeneStack<Location> thePath = new GreeneStack<>();
    
    //constructor:
    public Maze(int rows, int columns, int[][] lastGen) {
        r = rows;
        c = columns;
        finalGrid = lastGen;  
    }
    
    //methods:
    ///////////////////////////////////////////////////////////////////////////
    //creating the maze from the last generation:
    public String[][] createMaze() {
        
        maze = new String[r + 2][c + 2];
        
        //top/bottom bounds:
        for(int j = 0; j < c + 2; j++) {
            maze[0][j] = "|";
            maze[r + 1][j] = "|";
        }
        //left/right bounds:
        for(int i = 0; i < r + 2; i++) {
            maze[i][0] = "|";
            maze[i][c + 1] = "|";
        }
        
        //filling the insides:
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                
                if(finalGrid[i+1][j+1] == 0) {
                    maze[i+1][j+1] = " ";
                }
                else if(finalGrid[i+1][j+1] == 1) {
                    maze[i+1][j+1] = "#"; 
                }
            }
        }
        
        //setting the value in the first location to "*":
        maze[1][1] = explorer; 
        
        return maze;
    }
    ///////////////////////////////////////////////////////////////////////////
    //method for updating the maze:
    public void updateMaze(Location location) throws GreeneEmptyStackException {
        
        int i = location.rowN;
        int j = location.columnN;
         
        //right
        if(!maze[i][j + 1].equals("#") && (j+1) <= c &&
                !maze[i][j + 1].equals(".")) {
            
            //setting previous place to "."
            maze[i][j] = ".";
            
            //setting the new location's position:
            maze[i][j + 1] = explorer;
            loc_R = i;
            loc_C = j + 1;
           
            //moving previous location to the stack
            thePath.push(location);  
        }
        //down
        else if(!maze[i + 1][j].equals("#") && (i+1) <= r &&
                !maze[i + 1][j].equals(".")) {
            
            //setting previous place to "."
            maze[i][j] = ".";
            
            //setting the new location's position:
            maze[i + 1][j] = explorer;
            loc_R = i + 1;
            loc_C = j;
          
            //moving previous location to the stack
            thePath.push(location);
        }
        //left
        else if(!maze[i][j - 1].equals("#") && (j >= 2) &&
                !maze[i][j - 1].equals(".")) {
            
            //setting previous place to "."
            maze[i][j] = ".";
            
            //setting the new location's position:
            maze[i][j - 1] = explorer;
            loc_R = i;
            loc_C = j - 1;
            
            //moving previous location to the stack
            thePath.push(location);
        }
        //up
        else if(!maze[i - 1][j].equals("#") && (i >= 2) &&
                !maze[i - 1][j].equals(".")) {
            
            //setting previous place to "."
            maze[i][j] = ".";
            
            //setting the new location's position:
            maze[i - 1][j] = explorer;
            loc_R = i - 1;
            loc_C = j;
            
            //moving previous location to the stack
            thePath.push(location);
            
        }   
        //couldn't move
        else {
            
            //checking if the stack is empty (no more possible places to move):
            if(thePath.isEmpty()) {
                cantMove = true;
            }
            else {
                
                //setting previous place to "."
                maze[i][j] = ".";
            
                //going back to the previous location:
                Location prevLoc =  thePath.pop();
                maze[prevLoc.rowN][prevLoc.columnN] = explorer;
            
                //setting the new location's position:
                loc_R = prevLoc.rowN;
                loc_C = prevLoc.columnN;
            }   
        }
    }    
    //////////////////////////////////////////////////////////////////////////// 
    
    //Overriding the toString method for output:
    public String toString() {
        
        String output = "";
        
        //printing the entire maze (including the bounds):
        for(int m = 0; m < r + 2; m++) {   
            for(int n = 0; n < c + 2; n++) { 
                
                if(n == c + 1) {
                    output = output + maze[m][n] + "\n";
                }
                else {
                    output = output + maze[m][n];
                }
            }
        }
       
        return output;
    }
    ///////////////////////////////////////////////////////////////////////////
    
}
