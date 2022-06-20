import java.util.Scanner;

/**
 * A class that handles the game play UI
 */
public class GamePlayUI {
    private static final String positionRegex = "[1-9]";
    private static final String valueRegex = "[0-9]";

    private static boolean exit = false;

    /**
     * Getter for the exit flag
     * @return the exit flag
     */
    public static boolean getExit() {
        return exit;
    }

    /*
     * Method to display the game play UI
     * Got the game play UI from the following link: https://codegolf.stackexchange.com/questions/126930/draw-a-sudoku-board-using-line-drawing-characters
     * @param board the board to display
     */
    public static String printBoard(Board board) {
        // Both lines and rows are repeated according to this pattern.
        String P = "0121213121213121214";

        // Characters found on each line.
        String R[] = {"╔═╤╦╗","║ │║║x","╟─┼╫╢","╠═╪╬╣","╚═╧╩╝"};

        // The string under construction
        String r = "";

        // The row line number
        int rowLineNumber = 0;

        // Displaying the column numbers
        for (int i = 0; i < 9; i++) {
            r += "\t";
            r += (i + 1) + " ";
        }

        // Adding a line break
        r += "\n";

        // For each line
        for (int X: P.getBytes()) {
            // If it's an odd line, and not the first line
            if (rowLineNumber != 0 && rowLineNumber % 2 != 0) {
                // Getting the appropriate line number
                int line = rowLineNumber / 2 + 1;

                // Adding the line to the string
                r += line + " ";
            } else {
                // Otherwise, add double spaces
                r += "  ";
            }

            // Increment the line number
            rowLineNumber++;

            // For each character in the pattern
            // With a cell width of 3 and an optional character ('x')
            for (int x: P.replace("1",R[X-=48].length()>5?"151":"111").getBytes())
                // Append the real mapped character
                r+=R[X].charAt(x-48);

            // Add a line break
            r+="\n";
        }

        // For each number in the input
        for(Cell[] row : board.getBoard()) {
            //  For each cell in the row
            for(Cell cell : row) {
                // Replace the 'x' with the cell value
                r = r.replaceFirst("x", cell.isEmpty() ? " " : cell.getValue() + "");
            }
        }

        // (or space if zero)
        // Return the constructed string.
        return r;
    }

    /*
     * Method to ask the user for a position to fill in the board
     * @return the position to fill in the board
     */
    public static Position getPosition() {
        // Initializing the scanner
        Scanner scanner = new Scanner(System.in);

        // Asking the user for the row
        System.out.print("Enter the row of the cell you want to fill in: ");
        String row = scanner.nextLine();

        // Checking if the user wants to exit
        if(checkExit(row)) {
            return null;
        }

        // Checking if the row is valid
        while(!row.matches(positionRegex)) {
            System.out.print("Invalid row. Please enter a number between 1 and 9: ");
            row = scanner.nextLine();

            // Checking if the user wants to exit
            if(checkExit(row)) {
                return null;
            }
        }

        // Add a line break
        addLineBreak();

        // Asking the user for the column
        System.out.print("Enter the column of the cell you want to fill in: ");
        String column = scanner.nextLine();

        // Checking if the user wants to exit
        if(checkExit(column)) {
            return null;
        }

        // Checking if the column is valid
        while(!column.matches(positionRegex)) {
            System.out.print("Invalid column. Please enter a number between 1 and 9: ");
            column = scanner.nextLine();

            // Checking if the user wants to exit
            if(checkExit(column)) {
                return null;
            }
        }

        // Converting the row and column to integers
        int rowInt = Integer.parseInt(row);
        int columnInt = Integer.parseInt(column);

        return new Position(rowInt, columnInt);
    }

    /*
     * Method to ask the user for a value to fill in the board
     * @return the value to fill in the board
     */
    public static int getValue() {
        // Initializing the scanner
        Scanner scanner = new Scanner(System.in);

        // Asking the user for the value
        System.out.print("Enter the value you want to fill in: ");
        String value = scanner.nextLine();

        // Checking if the user wants to exit
        if(checkExit(value)) {
            return -1;
        }

        // Checking if the value is valid
        while (!value.matches(valueRegex)) {
            System.out.print("Invalid value. Please enter a number between 0 and 9: ");
            value = scanner.nextLine();

            // Checking if the user wants to exit
            if(checkExit(value)) {
                return -1;
            }
        }

        // Converting the value to an integer
        return Integer.parseInt(value);
    }

    /*
     * Method to check if the user wants to exit the game
     * @param userInput the user input
     */
    public static boolean checkExit(String userInput) {
        // If the user input is "exit"
        if (userInput.equalsIgnoreCase("exit")) {
            // Set the exit flag to true
            exit = true;

            // Return true
            return true;
        }

        // Return false
        return false;
    }

    /*
     * Method to add a line break
     */
    public static void addLineBreak() {
        System.out.println();
    }

    /*
     * Method to clear the screen
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
