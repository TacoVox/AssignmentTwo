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
    private char who = 'X';
    private String winner;

    /**
     *  Check if the game is over.
     *  @return true, if the board is full or if one
     *          of the players has three pieces in a row,
     *          column, or diagonal.
     */
    public boolean gameOver() {
    	boolean gamestate = false;

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
    		gamestate = true;
    		winner = "The winner is Player " + who;
    	}
    	
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
    	return gamestate;
    }

    /**
     *  Selects one of the empty cells on the board,
     *  and sets it to the symbol of the current player.
     *  If the game is already over, does nothing.
     */
    public void setRandomCell() {
    	
    	int a = randomInt(3);
    	int b = randomInt(3);
    	while(board[a][b]!= ' '){
    		a = randomInt(3);
    		b = randomInt(3);
    	}
    	
    	board[a][b] = who;
    }

    /**
     *  Constructs an initially empty board, i.e. one in which
     *  all the elements of the <tt>board</tt> matrix are set to ' '
     *  (the character for space: tick blank tick).
     */
    public TTTBoard() {
    	
 
        for(int i = 0; i < board.length; i++) {
        	
        	for(int j = 0; j < board.length; j++) {
 
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
    	String output;
    	
    	output = "-------\n";
    	
    	for(int i = 0; i < board.length; i++){
    		
        	for(int j = 0; j < board.length; j++){
        	
        		output = output + "|" + board[i][j];
        		
        	}
        		
        	output = output + "|\n";
        	output = output + "-------\n";
    	}
    	
    	if (gameOver() == true){
    		output = output + winner;
    	}
    	else {
    		if(who == 'O')
    			who = 'X';
    		else
    			who = 'O';
    		output = output + "Player "+ who + " to move!\n";
    	}
    	return output;
    }
}
