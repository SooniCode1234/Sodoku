/**
 * A class that represents a single cell in a Sudoku board
 */
public class Cell {
    private int value;

    /**
     * Constructor for a Cell
     * @param value the value of the cell
    */
    public Cell(int value) {
        this.value = value;
    }

    /**
     * Getter for the value of the cell
     * @return the value of the cell
     */
    public int getValue() {
        return value;
    }
}
