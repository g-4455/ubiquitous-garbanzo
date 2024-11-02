import javax.swing.JFrame;
import javax.swing.WindowConstants;

//I never want to see this stuff so it's going in a seperate file

public class Gui {
    public static JFrame game = new JFrame("Go"); //Create here so it can be accessed from other files
    
    public static void open(){ //Put all settings in here
        
        game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Settings
        game.setSize(900, 810); //Widith, Height
        game.setLayout(null); //Giant button appears behind jframe if this isnt null
    }
}
