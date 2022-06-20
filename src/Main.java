/**
 * A class that is the entry point of the entire game
 */
public class Main extends GamePlayUI {
    public static void main(String[] args) {
        // Initializing the board
        Board board = new Board();

        while (!board.isFull()) {
            // Printing the board
            System.out.println(printBoard(board));

            // Asking the user to fill a cell on the board
            fillIn(board);

            // Clearing the screen
            clearScreen();
        }

        // Saying that the board is full and the game is over
        System.out.println("The board is full and the game is over!");
        System.out.println("Congratulations and thank you for playing!");
    }

    /*
     * Method to ask the user for a value at a position
     * @param board the board to fill in
     */
    public static void fillIn(Board board) {
        // Getting the position from the user
        Position position = getPosition();

        // While the position already has a value, ask the user for a new position
        int row = position.getRow() - 1;
        int column = position.getColumn() - 1;

        while (!board.getBoard()[row][column].isEmpty()) {
            // Add a line break
            addLineBreak();

            System.out.println("This position already has a value. Please enter a new position.");
            position = getPosition();

            // Updating the row and column
            row = position.getRow() - 1;
            column = position.getColumn() - 1;
        }

        // Add a line break
        addLineBreak();

        // Getting the value from the user
        int value = getValue();

        // While the value conflicts with the board, ask the user for a new value
        while (board.conflicts(position, value)) {
            // Add a line break
            addLineBreak();

            System.out.println("This value conflicts with the board. Please enter a new value.");
            value = getValue();
        }

        // Filling in the board
        board.fillIn(position, value);
    }
}
