import java.util.Scanner;

/**
 * A class that handles the game play UI
 */
public class GamePlayUI {
    public static final String positionRegex = "[1-9]";
    public static final String valueRegex = "[0-9]";

    /*
     * Method to display the game play UI
     * Got the game play UI from the following link: https://codegolf.stackexchange.com/questions/126930/draw-a-sudoku-board-using-line-drawing-characters
     * @param board the board to display
     */
    public static String printBord(Board board) {
        String P="0121213121213121214",                         // Both lines and rows are repeated according to this pattern.
                R[]={"╔═╤╦╗","║ │║║x","╟─┼╫╢","╠═╪╬╣","╚═╧╩╝"},  // Characters found on each line.
                //   (note the 'x')
                r="";                                            // The string under construction

        for (int X: P.getBytes()) {                             // For each line,
            for (int x:                                           //  For each character in the pattern,
                    P.replace("1",R[X-=48].length()>5?"151":"111")   //    *but* with a cell width of 3,
                            //    and with an optional character ('x')
                            .getBytes())
                r+=R[X].charAt(x-48);                               //   append the real mapped character
            r+="\n";                                              //  then append a new line
        }
        for(Cell[] row : board.getBoard()) {                          // For each number in the input
            for(Cell cell : row) {                                    //  For each cell in the row
                r = r.replaceFirst("x", cell.getValue() == 0 ? " " : cell.getValue() + ""); // Replace the 'x' with the cell value
            }
        }

        //    (or space if zero)
        return r;                                               // Return the constructed string.
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

        // Checking if the row is valid
        while(!row.matches(positionRegex)) {
            System.out.print("Invalid row. Please enter a number between 1 and 9: ");
            row = scanner.nextLine();
        }

        // Add a line break
        addLineBreak();

        // Asking the user for the column
        System.out.print("Enter the column of the cell you want to fill in: ");
        String column = scanner.nextLine();

        // Checking if the column is valid
        while(!column.matches(positionRegex)) {
            System.out.print("Invalid column. Please enter a number between 1 and 9: ");
            column = scanner.nextLine();
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

        // Checking if the value is valid
        while (!value.matches(valueRegex)) {
            System.out.print("Invalid value. Please enter a number between 0 and 9: ");
            value = scanner.nextLine();
        }

        // Converting the value to an integer
        return Integer.parseInt(value);
    }

    /*
     * Method to add a line break
     */
    public static void addLineBreak() {
        System.out.println();
    }
}
