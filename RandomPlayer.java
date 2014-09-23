/**
 *  A player that takes random moves on a tic-tac-toe 
 *  board, for the
 *  second assignment in DIT948, 2014 edition.
 *  Implements the <tt>Player</tt> interface.
 *  RandomPlayer uses the <tt>setRandomCell</tt> method
 *  of the <tt>TTTBoard</tt> class to occupy at random
 *  one of the empty cells.
 *  Do not change this class; your program must work with
 *  it as it is.
 */
public class RandomPlayer implements Player {
    public void move(TTTBoard board) {
        board.setRandomCell();
    }
}
