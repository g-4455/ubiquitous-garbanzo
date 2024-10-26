import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Gameboard extends JPanel{ //copied from other code

    public void paint(Graphics g){ 
        g.drawRect(80, 80, 600, 600); //Starting
        
        //g.drawline doesn't take floats so the code will break using high numbers of squares that dont evenly divide into 600
        for (int i = 1; i <= App.squares()-1; i++){ //Draw App.squares()-1 lines
            g.drawLine(80+App.unit()*i, 80, 80+App.unit()*i, 680); //Draw horizontal lines
        }

        for (int j = 1; j <= App.squares()-1; j++){ 
            g.drawLine(80, App.unit()*j+80, 680, 80+App.unit()*j); //Draw vertical lines
        }      
    }

    //Set public
    public static JFrame frame = new JFrame("Go Game");

    //Return statement to get pass frame to other files
    public static JFrame getFrame(){return frame;}


    public static void createBoard(){ 
        frame.getContentPane().add(new Gameboard()); 
        frame.setSize(800, 800); //Size should never change
        frame.setVisible(true); //There is never a good reason to change this
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //THis too
        frame.setResizable(false);  //Maybe? 

        //HIGHLY IMPORTANT FOR JBUTTONS
        frame.setLayout(null); //Otherwise they will takeover the entire screen
    }


}