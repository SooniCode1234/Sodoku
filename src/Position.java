/**
 * A class that represents a position on the Sudoku board
 */
public class Position {
    private int row;
    private int column;

    /**
     * Constructor for a Position
     * @param row the row of the position
     * @param column the column of the position
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Getter for the row of the position
     * @return the row of the position
     */
    public int getRow() {
        return row;
    }

    /**
     * Getter for the column of the position
     * @return the column of the position
     */
    public int getColumn() {
        return column;
    }
}
