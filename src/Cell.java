/**
 * A class that represents a single cell in a Sudoku board
 */
public class Cell {
    private int value;
    private boolean hasValue;

    /**
     * Constructor for a Cell
     * @param value the value of the cell
    */
    public Cell(int value) {
        this.value = value;
        this.hasValue = true;
    }

    /**
     * No argument constructor for a Cell
     */
    public Cell() {
        this.hasValue = false;
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
        this.hasValue = true;
    }

    /**
     * Getter for the hasValue of the cell
     * @return whether the cell has a value or not
     */
    public boolean hasValue() {
        return hasValue;
    }
}
