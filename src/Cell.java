/**
 * A class that represents a single cell in a Sudoku board
 */
public class Cell {
    private int value;

    private static final int NULL_VALUE = -1;

    /**
     * Constructor for a Cell
     * @param value the value of the cell
    */
    public Cell(int value) {
        this.value = value;
    }

    /**
     * No argument constructor for a Cell
     */
    public Cell() {
        this.value = NULL_VALUE;
    }

    /**
     * Getter for the value of the cell
     * @return the value of the cell
     */
    public int getValue() {
        return value;
    }

    /**
     * Setter for the value of the cell
     * @param value the new value of the cell
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Method to check if the cell is empty
     * @return true if the cell is empty, false otherwise
     */
    public boolean isEmpty() {
        return value == NULL_VALUE;
    }
}
