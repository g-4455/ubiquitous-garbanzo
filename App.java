//Go Game by Grant Smith

public class App {

    //Test Functions
    public static void test(){
        Cell.board[8][8].print(); //Testing array creation of empty cells 
    }

    //Main
    public static void main(String[] args) throws Exception {
        Gui.open(); //Must be first, open the GUI
        Cell.winbutton();
        Cell.run(); //Must be used to get Cell to create an array
        Gui.game.setVisible(true); //KEEP THIS LAST OR BREAKS
        //test(); //When not commented out, will run test functions
    }
}
