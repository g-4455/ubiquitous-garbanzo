//function for capturing pieces and creating terratories

public class Capture {

    //Returns an array N, E, S, W of a cell's liberties 
    public static Cell[] liberities(int row, int col){ //turn this into a cell array
        Cell[][] gameboard = App.getCells();

        Cell returnme[] = new Cell[4];
        if (row-1 < 0) returnme[0] = null; else returnme[0]=gameboard[row-1][col];  //N pos 0 
        if (col+1 > Gameplay.bottomlim) returnme[1] = null; else returnme[1]=gameboard[row][col+1];  //E pos 1
        if (row+1 > Gameplay.rightlim) returnme[2] = null; else returnme[2]=gameboard[row+1][col];  //S pos 2
        if (col-1 < 0) returnme[3] = null; else returnme[3]=gameboard[row][col-1]; //W pos 3

        //Debug
        //for (int i = 0; i < 4; i++){System.out.println(Cell.getPlayable(returnme[i]));}

        
        return returnme;
    }

    //RECURSIVE SOLUTION
    public static Boolean wipeterratory = false;
    //return true if it needs to keep looping
    //return false if an empty space is found
    //return null if black is found 
    public static void terratorycheck(int row, int col){ //Just tell me if i need to wipe the terratory or not
        wipeterratory = true; 
        //Debug
        Cell[][] gameboard = App.getCells();
        Cell[] libC = liberities(row, col);
        String color = Cell.getType(gameboard[row][col]);
        //Check N, E, S, & W liberties around cell C
        for (Cell l : libC) {
            if (l != null && Cell.getType(l) == "null") {
            wipeterratory = false;
            break;
            }
            //Check if the color is the same and run the code again if so
            if (Cell.getType(l) == color){
                terratorycheck(Cell.getY(l), Cell.getX(l));
            }
        } 

        //Kill all cells if terratory killed marks true
        if (wipeterratory){
            gameboard[row][col].updatePlay(false);
                        if (Cell.getType(gameboard[row][col]) == "Black") gameboard[row][col].updateType("Red"); //Needs to become the oppsosite of the typing type
            else gameboard[row][col].updateType("Blue");
        }
    }

    public static void deathcheck(int row, int col){
        //Initilization
        Cell[][] gameboard = App.getCells();
        String mycolor = Cell.getType(gameboard[row][col]);
        Cell[] mylib = liberities(row, col);
        Boolean kill = true;

        //LOWER the kill flag if there is an empty space or same color piece around
        for (Cell l : mylib) if (Cell.getType(l) == null || mycolor == Cell.getType(l) || Cell.getType(l) == "null") kill = false;
        //Check if it's ONLY a same color piece and run recursive terratory check if so
        for (Cell m : mylib) {
            if (m != null && Cell.getType(m) == mycolor){
            //run function once
            //System.out.println("I work!"); Debug
            //terratorycheck(row, col);
            break;
        }
    }

        //if kill is true, kill the original cell
        if (kill){
            gameboard[row][col].updatePlay(false); 
            if (Cell.getType(gameboard[row][col]) == "Black") gameboard[row][col].updateType("Red"); //Needs to become the oppsosite of the typing type
            else gameboard[row][col].updateType("Blue");
        }
        //Reset terratory kill flag
        wipeterratory = false;

    }

    

    //Mechanic for checking if a piece is captured
    public static void checkall(){
        //Initialization
        for (int a = App.squares(); a >= 0; a--){
            for (int b = App.squares(); b >= 0; b--){
                deathcheck(a, b); 
            }
        }
        
        
    }
}
