//Thanks for importing automatically vsc
import java.awt.Color;
import javax.swing.JButton;

//Maybe didnt need its own class but i didnt know how much was gonna go into this
public class Visual {

    public static void testbutton(){
        JButton test = new JButton();  
        test.setBounds(30, 30 ,30,30); //posX, posY, size
        test.setVisible(false); //The buttons need to be there, but not visible
        test.setBackground(Color.BLACK);

    }
    //Create a function for creating buttons since I need to make a lot of them
    public static JButton createButton(String type, int x, int y) {   
        JButton Button = new JButton();  
        Button.setBounds(x+6,y+6,30,30); //posX, posY, size
        Button.setVisible(false); //The buttons need to be there, but not visible

        //Button Color
        if (type == "null"){Button.setVisible(false);} //If type null, then button will NOT be visible
        else{Button.setVisible(true);} //I know this looks weird since true is default but since I change buttons not create new ones I need this
        if (type == "Black"){Button.setBackground(Color.BLACK);} //If false, set black
        if (type == "Red"){Button.setBackground(Color.RED);} //For terratories
        if (type == "Blue"){Button.setBackground(Color.RED);} //Also for terratories, same color for visual effect
        if (type == "White") {Button.setBackground(Color.WHITE);} //Other is here for capturing 
        
        Button.setOpaque(true); //Required code
        Button.setBorderPainted(false); //Required code

    return Button;

}
}
