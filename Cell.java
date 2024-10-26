import javax.swing.JButton;

public class Cell {

    //Attribute initilization
    private Boolean playable; //Change to public if any issues
    private String type;
    private int x;
    private int y;
    private JButton b; 
    //Class itself

    public Cell(Boolean isPlayable, String isType, int posX, int posY) {
        //Tag if the cell is playable
        this.playable = isPlayable; 

        //if white = true, if black = false, if empty = null
        this.type = isType;

        //position amongst the x-axis
        this.x = posX;

        //position amongst the y-axis
        this.y = posY;

        //Button linked to a cell instance
        this.b = Visual.createButton(isType, posX, posY); //WHOSE THE OBJECT ORINETENTED NOW JAVAAA
        Gameboard.getFrame().add(this.b); //IT WORKS HAHAHAHHAAH IT WOORKKKKS 

    }

    //Get positions and types
    public static int getY(Cell c){return c.y/60;}
    public static int getX(Cell c){return c.x/60;}
    public static Boolean getPlayable(Cell c){
        if (c == null) return null; 
        else return c.playable;
    }
    public static String getType(Cell c){
        if (c == null) return null; 
        return c.type;
    }

    //Functions to change button stuff
    //They should be here if they arent past me is a loser

    public void updatePlay(Boolean newPlay){
        this.playable = newPlay; //I should add an if statement to check for no change, rule implementation here?
    }
    //Functions to change the type
    public void updateType(String newType){
        this.type = newType;
        //Button updating
        this.b = Visual.createButton(newType, this.x, this.y);
        Gameboard.getFrame().add(this.b);
        Gameboard.getFrame().repaint(); //Magic code? Magic code.
        //Causes lines to get pained over buttons gl with that future me!
    }

    //Update coords
    public void updateCoords(int newX, int newY){
        this.x = newX;
        this.y = newY;
    }


    //Make a function to initilize to a 2d array 
    public static Cell[][] fillBoard(){
        Cell[][] lineup = new Cell[App.squares()+1][App.squares()+1]; //Create a S x S array where S = squares
        //Need to do this a few times
        //lineup[0][0] = new Cell(true, true, 1, 1);

        //Loop for the Column
        for (int a = 0; a < App.squares()+1; a++){ //Plus 1 as pieces are placed on corners

            //Loop for the ROW
            for (int b = 0; b < App.squares()+1; b++){
                //Create a piece with math to iderate amongst the distance
                lineup[a][b] = new Cell(true, "null", 60+(App.unit()*b), 60+(App.unit()*a));
                //lineup[a][b].print(); //testing code
            }
        }
        return lineup;
    }

    //Consider making lineup public using the App.java solution

    //Print info for testing
    public void print(){
        System.out.println(this.playable);
        System.out.println(this.type);
        System.out.println(this.x);
        System.out.println(this.y);
    }
}
