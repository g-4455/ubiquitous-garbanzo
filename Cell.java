import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;

public class Cell {
    public static void run(){}
    //3 values
    public int y; //BUG: y and x only exist here, not in Cell
    public int x; //place in the 2d array
    public String type; //Empty, White, Black
    private Boolean isPlayable; //For CHECKING only use type for everything else
    public Boolean isChecked;
    public Boolean isCheckedCounter;
    public Boolean isTerratory;
    private JButton b;
    
    public static Cell nullPiece = new Cell(-1, -1, "Null", false); //Cell that doesn't exist
    
        //Constructor 
    public Cell(int y1, int x1, String s, Boolean p){
            this.x = x1; //Add variables
            this.y = y1;
            this.type = s;
            this.isPlayable = p;
            this.isChecked = false;
            this.isTerratory = false;
            this.b = new JButton();
    
        //When constructed, create a button with color defined by type
        b.setBounds((this.y*90)+25, (this.x*90)+25, 30, 30); //Create bounds, are y and x right?

        b.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e){ //God bless you Nahuel Ourthe
            Boolean islegal = legal(y, x); //Check playing a stone with no liberities
            if (isPlayable && islegal){ //Check so buttons cant be repeatly clicked
                b.setBackground(Game.isWhite ? Color.WHITE : Color.BLACK); //Check the conditional CONDITION IN THE STATEMENT 
                b.setOpaque(true); //Combination of these two that work but they cant be placed anywhere else or code break
                b.setBorderPainted(false); //You too
                
                //Progress the game
                Game.change(); //Change the turn (Game.isWhite)

                //update stone attributes
                board[y][x].type = Game.isWhite ?"White":"Black"; //Change Type based on white or black 
                board[y][x].isPlayable = false; //Once a cell is played on, it cannot be played on for the rest of the game
                Game.Lcheck(board[y][x]);
            } 
            else if (!islegal) System.out.println("You can't play a piece with no liberities!"); //Output text incase a button is played on
            else System.out.println("You can't play a stone on a stone!");

            //DEBUG
            //board[y][x].print(); //Add 1 for dramatic effect, x & y dont work... concerning //Debug
        }});
        
        Gui.game.add(b); //add the button to the board
    } //End of cell creation

    public static void changecolor(Cell c){c.b.setBackground(Color.GRAY);}

    public static Boolean legal(int y, int x){ //Make sure cells cant be played inbetween 4 opposite cells
        Cell og = board[y][x];
        String ogtype = Game.isWhite ? "White" : "Black";
        Cell[] array = {Game.north(og), Game.south(og), Game.left(og), Game.right(og)};
        int liberities = 4; //When this reaches 0 dont allow the player to make that play

        for (Cell i : array){ if (i.type == ogtype || i.type == "Null") --liberities;}

        if (liberities == 0) return false;
        else return true;
    }

    //Utility Functions
    public static String opposite(Cell c){
        if (c.type.equals("White")) return "Black";
        if (c.type.equals("Black")) return "White";
        else return "Null";
    }

    public static Cell[][] board = makeboard(); //Gameboard after being initilized
    private static Cell[][] makeboard(){ //Function to create an array full of cells
        Cell[][] returnme = new Cell[9][9]; //from 0 to 8

        for (int a = 0; a < 9; a++){  //Double for loop for initilizing the array full of empty cells
            for (int b = 0; b < 9; b++){
                returnme[a][b] = new Cell(a, b, "Empty", true);
            }
        }
        return returnme; //Return
    }

    //Test Client for printing
    public void print(){
        System.out.println("y-value: " + this.y); //variable
        System.out.println("x-value: " + this.x); //variable
        System.out.println("type: " + this.type); //White or Black
        System.out.println("Playable flag: " + this.isPlayable); //Should always be false when output unless empty
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    //Test Client
    public static void test(){
        Cell testme = new Cell(1, 2, "Test", true);
        testme.print();
    }

    public static void winbutton(){
        JButton points = new JButton();
        points.setBounds(800, 350, 100, 100);
        points.setText("Points");
        points.setVisible(true);
        points.setOpaque(true); 
        points.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e){Game.updateScore();}});
        Gui.game.add(points);



    }
}