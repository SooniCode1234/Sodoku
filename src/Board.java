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
                    board[i][j] = new Cell();
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

    /**
     * Method to fill in a cell on the board
     * @param position the position of the cell to fill in
     * @param value the value to fill in the cell
     */
    public void fillIn(Position position, int value) {
        // Getting the row and column out of the position
        int row = position.getRow() - 1;
        int column = position.getColumn() - 1;

        // Filling in the cell
        board[row][column].setValue(value);
    }
}
