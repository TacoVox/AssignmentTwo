/**
 *  Provides user interaction with the tic-tac-toe
 *  board for the
 *  second assignment in DIT948, 2014 edition.
 *  HumanPlayer implements the Player interface.
 **/

//RESPONSIBILITY: Jonas Kahler

//Import SimpleIO as provided by Cezar
import static dit948.SimpleIO.*;

public class HumanPlayer implements Player
{
    /**
     *  Retrieve a row number and a column
     *  number from the user (which can be 0, 1, or 2)
     *  and use the setCell method of TTTBoard to
     *  occupy it.  For behavior on incorrect input,
     *  see the example session in the assignment text.
     */
    public void move(TTTBoard board)
    {
    	//Variables for row and column
    	int row, column;
    	
    	//Variables to count the number of loops
    	int i = 0;
    	
    	//Do until a cell is empty
    	do
    	{
    		//If i > 0 because of another loop (cell isn't empty)
    		if (i > 0)
    		{
    			//User output because of a non-empty cell
    			println("The cell you try to set is already used.");
    			println("Please try another cell!");
    		}
    		
        	//Call input for the row and column and assign it to the variables
        	row = ask('r');
        	column = ask ('c');
        	
        	//Increase i by one -> everytime a loop is completed
        	i++;
    	}
    	while (board.getCell != ' ');
    	
    	//Write the input to the board
    	board.setCell(row, column);
    }
    
    //This function askss the user for the row. It returns an integer. 
    private int ask(char type)
    {
    	//temporary input variable
    	int usrinput;
    	
    	//Output to the user related if its a row or column
    	if(type == 'r')
    		println("Please enter a row:");
    	else
    		println("Please enter a column:");
    	
		//Assing usrinput with the input of the user
    	usrinput = readInt();
    	
    	//While the input from the user is an illegal move or an IOError
    	while(usrinput <= 0 || usrinput >= 2 || IOError != false)
    	{
    		//Output --> Information that the move isn't correct
    		println("Your input isn't correct!");
    		println("Please enter a number between 1 and 3:");
    		
    		//Assign usrinput again with the input of the user
    		usrinput = readInt();
    	}
    	
    	//Return the entered number
    	return usrinput;
    }
}

