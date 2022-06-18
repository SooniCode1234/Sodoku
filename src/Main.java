public class Main extends GamePlayUI {
    public static void main(String[] args) {
        // Initializing the board
        Board board = new Board();

        // Printing the board
        System.out.println(printBord(board));

        // Asking the user to fill a cell on the board
        fillIn(board);

        // Printing the board
        System.out.println(printBord(board));
    }

    /*
     * Method to ask the user for a value at a position
     * @param board the board to fill in
     */
    public static void fillIn(Board board) {
        // Getting the position from the user
        Position position = getPosition();

        // Add a line break
        addLineBreak();

        // Getting the value from the user
        int value = getValue();

        // Filling in the board
        board.fillIn(position, value);
    }
}
