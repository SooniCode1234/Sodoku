/**
 * A class that represents a board of Sudoku
 */
public class Board {
    private Cell[][] board;

    private static final int BOARD_SIZE = 9;

    /**
     * Constructor for a Board
     */
    public Board() {
        board = new Cell[BOARD_SIZE][BOARD_SIZE];

        // Initializing 60% of the board with random values
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (Math.random() < 0.6) {
                    board[i][j] = new Cell((int) (Math.random() * 9) + 1);
                } else {
                    board[i][j] = new Cell(0);
                }
            }
        }
    }

    /**
     * Getter for the board
     * @return the board
     */
    public Cell[][] getBoard() {
        return board;
    }
}
