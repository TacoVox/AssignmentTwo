/**
 *  Class representing the tic-tac-toe board for the
 *  second assignment in DIT948, 2014 edition.
 *  This is the main class for the application, keeping
 *  track of the state of the board, which is equivalent to
 *  the state of the game itself.
 */

import static dit948.SimpleIO.*;
import static dit948.Random.*;

public class TTTBoard {
	
    /**
     *  The board is represented by a 3x3 matrix of characters.
     */
    private char[][] board = new char[3][3];
    
    /**
     *  The variable who keeps track of which of the players is supposed
     *  to make the current move.  The players are identified by their
     *  char symbols, 'X' and 'O'.  The first move always belongs to 'X'.
     */
    //Changing "X" to "O" for the correct output --> see toString()
    private char who = 'O';
    
    //String for saving the winner - just visible within class
    private String winner;

    /**
     *  Check if the game is over.
     *  @return true, if the board is full or if one
     *          of the players has three pieces in a row,
     *          column, or diagonal.
     */
    public boolean gameOver() {
	//Creating a boolean gamestate to determine if it is game over.
    	boolean gamestate = false;
	
	//Creating a key for all the winning combinations in the array there is in the game.
    	if ((who == board[0][0] && who == board[0][1] && who == board[0][2]) ||
    		(who == board[1][0] && who == board[1][1] && who == board[1][2]) ||
    		    (who == board[2][0] && who == board[2][1] && who == board[2][2]) 
    		    ||
    		    (who == board[0][0] && who == board[1][0] && who == board[2][0]) ||
    			(who == board[0][1] && who == board[1][1] && who == board[2][1]) ||
    			(who == board[0][2] && who == board[1][2] && who == board[2][2])
    		    ||
    			(who == board[0][0] && who == board[1][1] && who == board[2][2]) ||
    			(who == board[0][2] && who == board[1][1] && who == board[2][0]))
    	{
    		//If one of the combinations above is true the game ends and it tells who the winner is 
    		gamestate = true;
    		winner = "The winner is Player " + who;
    	}

		//If the has an empty cell it continue and if it is full gamestate is true
    	//and there is no of the keys above has worked it is a draw
    	else{
    		gamestate = true;
    		
    		for (int i = 0; i < board.length; i++){
    			for (int j = 0; j < board.length; j++){
    				if (board[i][j] == ' ')
    					gamestate = false;	
    					winner = "It's a draw. No winner.";
    			}
    		}
    	}
    	//Making a return for gamestate
    	return gamestate;
    }

    /**
     *  Selects one of the empty cells on the board,
     *  and sets it to the symbol of the current player.
     *  If the game is already over, does nothing.
     */
    public void setRandomCell() {
    	
    	//This makes the program to set a random cell for X or O for the randomPlayer
    	//Therefore two integers are assigned to random nubers between 0 and 2
    	int a = randomInt(3);
    	int b = randomInt(3);
    	
    	//While there is no empty cell - assign new random ints between 0 and 2
    	while(board[a][b]!= ' '){
    		a = randomInt(3);
    		b = randomInt(3);
    	}
    	
    	//The char will appear at the random cell
    	board[a][b] = who;
    }

    /**
     *  Constructs an initially empty board, i.e. one in which
     *  all the elements of the <tt>board</tt> matrix are set to ' '
     *  (the character for space: tick blank tick).
     */
    public TTTBoard() {
    	
    	//Going throu the 2D array with a capsuled for loop
        for(int i = 0; i < board.length; i++) {      	
        	for(int j = 0; j < board.length; j++) {
 
        		//Set every cell to a space character
        		board[i][j]=' ';		
        	}
        }
    }

    /**
     *  Retrieve the symbol on the board at the given
     *  row and column.
     *  @param row the row position of the cell (0, 1, or 2)
     *  @param col the column position of the cell (0, 1, or 2)
     *  @return ' ', if the cell is empty, 'X' if it has been occupied
     *          by the first player, 'O' if it has been occupied by the
     *          second player.
     */
    public char getCell(int row, int col) {
    	//The array is set to the int row and int col to get the spicific cell
    	return board[row][col];
    }

    /**
     *  Occupies the cell at the given position with the
     *  symbol of the current player.
     *  Does nothing if the game is already over.
     *  This is the place to check whether the game is over
     *  (the given move has either led to a full board, or
     *  to a win of the current player) and, if needed, to switch the
     *  current player.
     */
    public void setCell(int row, int col) {
    	//To store the cell to the char "X" or "O"
    	board[row][col] = who;

    }

    /**
     *  Build a string representation of the board.  The string has
     *  the form
     *
     *           "-------\n" +
     *           "|O| |O|\n" +
     *           "-------\n" +
     *           "|O|X|X|\n" +
     *           "-------\n" +
     *           "|X|O|X|\n" +
     *           "-------\n" +
     *           MESSAGE
     *
     *  where MESSAGE is one of  "Player X to move.", "Player O to move.", 
     *  "Player X has won.", "Player O has won.", "Game drawn.".
     *
     *  Remark: there is no "\n" at the end of the message.
     */
    public String toString()
    {
    	//Create a string to save the output
    	String output;

    	//Creating the visuals of the board that we will see in the console
    	output = "-------\n";
    	
    	//Going through the array with a capsuled for loop
    	for(int i = 0; i < board.length; i++){  		
        	for(int j = 0; j < board.length; j++){
        	
        		//Add the char saved in each cell to the string (after a pipe sign)
        		output = output + "|" + board[i][j];       		
        	}
        		
        	//Add the last part of the frame to the String
        	output = output + "|\n";
        	output = output + "-------\n";
    	}
    	
    	//The message if the game ends
    	if (gameOver() == true){
    		output = output + winner;
    	}
    	
    	//The message of whos turn it is if the game didn't end
    	else {
    		if(who == 'O')
    			who = 'X';
    		else
    			who = 'O';
    		output = output + "Player "+ who + " to move!\n";
    	}
    	
    	//Return the output string
    	return output;
    }
}