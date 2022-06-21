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

            // Checking if the user wants to exit the game
            if (getExit()) {
                break;
            }
        }

        // Checking if the user manually exited the game
        if (getExit()) {
            // Clearing the screen
            clearScreen();

            System.out.println("Exiting the game...");
            System.out.println("Thank you for playing!");
        } else {
            // Saying that the board is full and the game is over
            System.out.println("The board is full and the game is over!");
            System.out.println("Congratulations and thank you for playing!");
        }

    }

    /**
     * Method to ask the user for a value at a position
     * @param board the board to fill in
     */
    public static void fillIn(Board board) {
        // Asking the user if they want to quit
        System.out.println("Do you want to quit? Type 'exit' at any point to quit.");

        // Asking the user if they want to reset their current inputs
        System.out.println("Do you want to reset your current inputs? Type 'reset' at any point to reset.");

        // Adding a new line
        addLineBreak();

        // Getting the position from the user
        Position position = getPosition();

        // If the position is null, then the user wants to quit or reset
        if (position == null) {
            // Break out of the function
            return;
        }

        // While the position already has a value, ask the user for a new position
        int row = position.getRow() - 1;
        int column = position.getColumn() - 1;

        while (!board.getBoard()[row][column].isEmpty()) {
            // Add a line break
            addLineBreak();

            System.out.println("This position already has a value. Please enter a new position.");
            position = getPosition();

            // If the position is null, then the user wants to quit or reset
            if (position == null) {
                // Break out of the function
                return;
            }

            // Updating the row and column
            row = position.getRow() - 1;
            column = position.getColumn() - 1;
        }

        // Add a line break
        addLineBreak();

        // Getting the value from the user
        int value = getValue();

        // If the value is a -1, then the user wants to quit or reset
        if (value == -1) {
            // Break out of the function
            return;
        }

        // While the value conflicts with the board, ask the user for a new value
        while (board.conflicts(position, value)) {
            // Add a line break
            addLineBreak();

            System.out.println("This value conflicts with the board. Please enter a new value.");
            value = getValue();

            // If the value is a -1, then the user wants to quit or reset
            if (value == -1) {
                // Break out of the function
                return;
            }
        }

        // Filling in the board
        board.fillIn(position, value);
    }
}
