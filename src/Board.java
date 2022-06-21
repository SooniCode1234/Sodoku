/**
 * A class that represents a board of Sudoku
 */
public class Board {
    private final Cell[][] board;

    private static final int BOARD_SIZE = 9;

    private int cellSet = 0;

    /**
     * Constructor for a Board
     */
    public Board() {
        board = new Cell[BOARD_SIZE][BOARD_SIZE];

        // Getting the number of cells in each row and column
        int boardCells = BOARD_SIZE * BOARD_SIZE;

        // Initializing about 60% of the board with random values, including 0
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                // Creating an empty cell
                board[i][j] = new Cell();

                // Setting the value of the cell to a random number between 0 and 9, for about 60% of the board
                if (Math.random() < 0.6 && cellSet < (0.6 * boardCells)) {
                    // Setting the value of the cell to a random number between 0 and 9
                    int value = (int) (Math.random() * 10);

                    // Ensure value does not conflict with the board
                    while (conflicts(new Position(i + 1, j + 1), value)) {
                        value = (int) (Math.random() * 10);
                    }

                    board[i][j].setValue(value);

                    // Incrementing the number of cells set so far
                    cellSet++;
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
        cellSet++;
    }

    /**
     * Method to check if a value conflicts with the board
     * @param position the position to check around
     * @param value the value to check
     * @return true if the value conflicts with the board, false otherwise
     */
    public boolean conflicts(Position position, int value) {
        // Getting the row and column out of the position
        int row = position.getRow() - 1;
        int column = position.getColumn() - 1;

        // Checking if the value conflicts with the row
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[row][i] != null && board[row][i].getValue() == value) {
                return true;
            }
        }

        // Checking if the value conflicts with the column
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i][column] != null && board[i][column].getValue() == value) {
                return true;
            }
        }

        // Checking if the 3x3 grid contains this value

        // Divide our sudoku board into 3x3 grids, each grid labeled with its own x and y coordinate
        // Example: Top row middle column 3x3 grid is block (0, 1)
        // The y coordinate of this cell's 3x3 grid
        int blockY = column / 3;

        // The x coordinate of this cell's 3x3 grid
        int blockX = row / 3;

        // Checking the 3x3 grid containing this cell
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // Based on the blockX and blockY, we offset the cells we are checking
                int blockXOffset = (blockX * 3) + i;
                int blockYOffset = (blockY * 3) + j;

                // Checking if the cell is not null and if the value matches the value we are checking
                if (board[blockXOffset][blockYOffset] != null && board[blockXOffset][blockYOffset].getValue() == value) {
                    return true;
                }
            }
        }


        return false;
    }

    /**
     * Method to check if the board is full
     * @return true if the board is full, false otherwise
     */
    public boolean isFull() {
        return cellSet == BOARD_SIZE * BOARD_SIZE;
    }
}
