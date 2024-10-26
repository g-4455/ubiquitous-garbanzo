//Gameplay for inputs, looping, and prompting

public class Gameplay {
    public static int rightlim = App.getCells()[0].length-1;
    public static int bottomlim = App.getCells().length-1; 

    public static void score(){
        Cell[][] gameboard = App.getCells(); 
        int[] returnme = {0, 0}; //first one is blacks score
        for (int a = App.squares(); a >= 0; a--){
            for (int b = App.squares(); b >= 0; b--){
                if (Cell.getType(gameboard[a][b]) == "Red") returnme[0]++;
                if (Cell.getType(gameboard[a][b]) == "Blue") returnme[1]++;
            }
        }
        System.out.println("Black's Score: " + returnme[0]);
        System.out.println("White's Score: " + returnme[1]);
    }

    //function to loop the game until defeat is admitted
    public static void loop(){
        Boolean flipper = true; 
        int turncount = App.squares()^2; 

            //Break the loop with a break; statement
            while (true){ //loop
                //declare outside of loops
                String pieceColor = flipper ? "White":"Black"; //Has to be here, make its own function?
                int column = 0;
                int row = 0; 
                //Prompt then get user input

                while (true){
                System.out.println(pieceColor + "'s Turn! Input row (-1 to surrender)");
                //Declare outside of loop
                int play = 0;
                while (true){
                play = App.getinput(); //needs to check for defeat admisson

                //Check if they admitted defeat
                if (play < 0){ //How would this read a string?
                    System.out.println(pieceColor + " Surrenders");
                    break;
                }

                //Check if the play is legal
                if (play >= 0 && play <= rightlim){break;}
                else{System.out.println("Illegal move, enter again:");}
            }

                
                row = play;
                

                //Otherwise
                System.out.println("Input column");
                while (true){
                column = App.getinput();
                //Check if legal play
                if (play >= 0 && play <= bottomlim){break;}
                else{System.out.println("Illegal move, enter again:");}
                }
            
                //Check if the cell is open
                if (Cell.getPlayable(App.myarray[row][column])){break;}
                else{System.out.println("Illegal move, try again");}
            }

                /*//If they didn't admit defeat, split the input into a row (first) and column (second)
                int row = Integer.parseInt(Integer.toString(play).substring(0, 1));
                int column = Integer.parseInt(Integer.toString(play).substring(1, 2)); //00 DOES NOT WORK
                //Java is taking 00 as 0, 01 also as 1 */
                

                //FINALLY update button of row and coloumn color as piece color
                App.myarray[row][column].updateType(pieceColor);
                App.myarray[row][column].updatePlay(false); //make it so its no longer playable

            Capture.checkall();
            flipper = !flipper; //Flip from white to black at the end of the loop
            turncount--;

            if (turncount == 0) break;
            
        }
    }
}
