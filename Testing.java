//Debug file

public class Testing {

    //DONT FORGET about getsquares, instance var, squares, and unit being added into app
    //MAIN FUNCTIONS MUST RUN FIRST!!

    //Testing function
    public static void main(String[] args){

        //Gameboard.createBoard();
        //as of Sep 13 Gameboard will not work called outside of App due to App's critical functions

        Cell test = new Cell(true, "White", 1, 1);
        test.print(); //expected output true, true, 1, 1
        test.updateType("Black"); 
        test.print(); //expected output true, false, 1, 1
        //Must be the LAST thing to run
        //Gameplay.loop();

        //Testing how to split an int
        int testint = 23;
        int firstdigit = Integer.parseInt(Integer.toString(testint).substring(0, 1));
        int secondigit = Integer.parseInt(Integer.toString(testint).substring(1, 2));

        System.out.println(firstdigit);
        System.out.println(secondigit);
    }
}
