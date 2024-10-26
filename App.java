//Go Project by Grant Smith

//App to run everything

import java.util.Scanner;

public class App {
    //MAIN FUNCTIONS MUST RUN FIRST!!

    //Input function
    public static int getinput(){

        //NEVER CLOSE REQUEST its what causes the code to work
        Scanner request = new Scanner(System.in);
        int input = request.nextInt(); //do i need final int?
        return input;
    } //IF math starts messing up look here

    public static int getsquares(){ //To print the prompt
            System.out.println("What board size would you like to play on?");
            final int squares = getinput(); //I dont know if I could explain why final is here
            return squares;
     }

    //Initilize to an instance variable
    public static int var = getsquares();

    //Create a function to get and return the instance variable for another classes' use
    public static int squares(){return var;}

    //Returns 1 unit of distance between lines
    public static int unit(){return 600/var;}
    // Bug with this line, large numbers that do not evenly divide into 600 will cause the drawing to be messed up, this is because the drawing commands do not take floats. 

    //Create a 2D array of cells using the squares number
    public static Cell myarray[][] = Cell.fillBoard();

    //Return the cell arrays
    public static Cell[][] getCells(){return myarray;}

    //Main 
    public static void main(String[] args) throws Exception {
        Gameboard.createBoard();
        //myarray[0][0].updateType("Black"); //Code for updating a piece
        Gameplay.loop();
    }
}

