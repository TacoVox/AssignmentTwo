/**
 *  Class TTT implements the necessary machinery to play one
 *  game of tic-tac-toe between two players, for the
 *  second assignment in DIT948, 2014 edition. //addedcomment
 */
public class TTT {
    /**
     *  A two-element array for the players.
     */
    private Player[] players = new Player[2];
    /**
     *  An instance of the TTTBoard class.
     */
    private TTTBoard board = new TTTBoard();

    /**
     *  Constructs a new game with the two players.
     */
    public TTT(Player player1, Player player2) {
    }

    /**
     *  Prints the index (0 or 1) of the player who has
     *  the first move (result of a random decision).
     *  Then prints the board.
     *  Then enters a loop in which the two players take
     *  turns; after each move the board is printed.
     *  The loop is exited when the game is over.
     */
    public void play() {
    }

    /**
     *  This is the main function which will be used
     *  to test your program; do not change it.
     */
    public static void main(String[] args) {
        Player player1 = new RandomPlayer();
        Player player2 = new HumanPlayer();
        TTT ttt = new TTT(player1, player2);
        ttt.play();
    }
}

        
