/**
 * A class that handles the game play UI
 */
public class GamePlayUI {
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
}
