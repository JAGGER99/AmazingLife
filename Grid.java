
package amazinglife;

//Grid class is incharge of creating the next 2d array and checking neighbors:
public class Grid {
    
    //***data fields***:
    int[][] this_gen;
    int[][] next_gen;
    int r;
    int c;
       
    //parameter constructor:
    public Grid(int row, int col, int[][] init_gen) {
        this_gen = init_gen;
        r = row;
        c = col;
    }
    
    //***methods***:
    
    //getNextGen method returns the next 2d array:
    public int[][] getNextGen() {
        
        //creating my next grid:
        next_gen = new int[r + 2][c + 2];
        
        //moving through the 2d array:
        for(int i = 0 ; i < r; i++) {
            for(int j = 0; j < c; j++) {
                    
                //if current cell contains 0:
                if(this_gen[i + 1][j + 1] == 0) {
                        
                    if(numOfNeighbors(i + 1,j + 1) == 3) {
                        next_gen[i + 1][j + 1] = 1;
                    }
                    else {
                        next_gen[i + 1][j + 1] = 0;
                    }
                }
                //if current cell contains 1:
                else if(this_gen[i + 1][j + 1] == 1) {
                           
                    if(numOfNeighbors(i + 1,j + 1) <= 1) {
                        next_gen[i + 1][j + 1] = 0;
                    }
                    else if(numOfNeighbors(i + 1,j + 1) >= 4) {
                        next_gen[i + 1][j + 1] = 0;
                    }
                    else if(numOfNeighbors(i + 1,j + 1) == 2 || 
                    numOfNeighbors(i + 1,j + 1) == 3) {
                        next_gen[i + 1][j + 1] = 1;
                    }       
                }                    
            }
        }
        
        return next_gen;
    }
    
    //method for determining how many neighbors a cell has:
    public int numOfNeighbors(int i, int j) {
        
        int Ncount= 0;
        
        //boxes above and below:
        for(int k = -1; k <= 1; k++) {
            
            //top 3 boxes:
            if(this_gen[i - 1][j + k] == 1) {
                Ncount++;
            }
            
            //bottom 3 boxes:
            if(this_gen[i + 1][j + k] == 1) {                                   
                Ncount++;
            }      
        }
        
        //left box:
        if(this_gen[i][j - 1] == 1) {
            Ncount++;
        }
        
        //right box:
        if(this_gen[i][j + 1] == 1) {
            Ncount++;
        }
       
        return Ncount;
    }
   
    //Overriding the toString method for output:
    public String toString(int[][] arr) {
        
        String output = "";
        
        //for each row looking at every column:
        for(int m = 0; m < r; m++) {   
            for(int n = 0; n < c; n++) { 
                
                if(n == c - 1) {
                    output = output + arr[m+1][n+1] + "\n";
                }
                else {
                    output = output + arr[m+1][n+1];
                }
            }
        }
       
        return output;
    }
}
