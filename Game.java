public class Game {
    //Is this file even worth it?
    public static Boolean isWhite = true; //For telling whose turn it is
    public static void change(){isWhite = !isWhite; /*System.out.println(isWhite); /*DEBUG*/} //Function to change iswhite

    //Scoring
    public static void updateScore(){
            int Wscore = 0; //This is where I score points
            int Bscore = 0; 

            for (int a = 0; a < 9; a++){ //Copy the forloop from the other array
                for (int b = 0; b < 9; b++){
                    if (Cell.board[a][b].type.equals("Black") && Cell.board[a][b].isTerratory) Bscore++;
                    if (Cell.board[a][b].type.equals("White") && Cell.board[a][b].isTerratory) Wscore++;
                }
            }
            System.out.println("White's Score: " + Wscore);
            System.out.println("Black's Score: " + Bscore);
    }
    
    //Capturing Logic

    //Functions for returning directional Cells
    public static Cell north(Cell c) {
        //Run if within bounds
        if ((c.x)-1 >= 0) return Cell.board[c.y][(c.x)-1]; //Check directional conditions
        else return Cell.nullPiece; //Return nullpiece if beyond 0 or above 8
    }
    //The rest are copies but with slightly different conditions for the four cardinal directions
    public static Cell south(Cell c) {
        if ((c.x)+1 < 9) return Cell.board[c.y][(c.x)+1];
        else return Cell.nullPiece;
    }
    public static Cell left(Cell c) {
        if ((c.y)-1 >= 0) return Cell.board[(c.y)-1][c.x];
        else return Cell.nullPiece;
    }
    public static Cell right(Cell c) {
        if ((c.y)+1 < 9) return Cell.board[(c.y)+1][c.x];
        else return Cell.nullPiece;
    } 


    public static void Lcheck(Cell c){ //Function to check liberities
        if (north(c).type.equals(Cell.opposite(c))) capture(north(c)); //Run capture function
        if (south(c).type.equals(Cell.opposite(c))) capture(south(c));
        if (left(c).type.equals(Cell.opposite(c))) capture(left(c));
        if (right(c).type.equals(Cell.opposite(c))) capture(right(c));

        //Debug
        //System.out.println(Cell.board[c.y][(c.x)-1].type);
        //System.out.println(c.type);
        killflag = true;
    } 

    public static Boolean killflag = true; //Set to true until proven otherwise

    public static void capture(Cell c){
        if (!c.isChecked){ //Logic gate to prevent unessecary code during recursion
            //System.out.println("I Ran"); //Debug

            if (north(c).type == "Empty" || north(c).isTerratory) killflag = false; //Set killflag to false if an empty spot is found
            if (north(c).type == c.type && north(c).isChecked == false) capture(north(c)); //Recur if same type

            if (left(c).type == "Empty" || left(c).isTerratory) killflag = false; 
            if (left(c).type == c.type && left(c).isChecked == false) capture(left(c));

            //Specific spot to minimize errors, may still exist theoredically but i havent found them in gameplay
            c.isChecked = true; //Tell the computer not to check the same cells multiple times. Can't be true otherwise pieces will get "trapped" by check pieces are recursion wont go far

            if (right(c).type == "Empty" || right(c).isTerratory) killflag = false;
            if (right(c).type == c.type && right(c).isChecked == false) capture(right(c));
            
            if (south(c).type == "Empty" || south(c).isTerratory) killflag = false;
            if (south(c).type == c.type && south(c).isChecked == false) capture(south(c));

            

        //Trailing statement
            if (killflag){ //Kill all cells that were checked
                c.isTerratory = true;
                Cell.changecolor(c);
                //System.out.println("Terratories Updated!"); //Debug
        } 
        }

        
        c.isChecked = false; //reset flag incase of having to check again
    }
}
