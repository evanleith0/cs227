package hw3;

import static api.Direction.*;
import static api.Orientation.HORIZONTAL;
import static api.Orientation.VERTICAL;

import api.Direction;
import api.Orientation;

/**
 * @author Evan Leith
 */

/**
 * Represents a boulder in the game.
 */
public class Boulder {
	
	/**
	 * Stores the original row value of the boulder.
	 */
	private int firstRow;
	
	/**
	 * Stores the original column value of the boulder.
	 */
	private int firstCol;
	
	/**
	 * Stores the current row of the boulder.
	 */
	private int currRow;
	
	/**
	 * Stores the current column of the boulder.
	 */
	private int currCol;
	
	/**
	 * Stores the length of the boulder.
	 */
	private int length;
	
	/**
	 * Stores the orientation of the boulder.
	 */
	private Orientation orientation;
	
	/**
	 * Constructs a new Boulder with a specific location relative to the board. The
	 * upper/left most corner of the boulder is given as firstRow and firstCol. All
	 * boulders are only one cell wide. The length of the boulder is specified in cells.
	 * The boulder can either be horizontal or vertical on the board as specified by
	 * orientation.
	 * 
	 * @param firstRow    the first row that contains the boulder
	 * @param firstCol    the first column that contains the boulder
	 * @param length      boulder length in cells
	 * @param orientation either HORIZONTAL or VERTICAL
	 */
	public Boulder(int firstRow, int firstCol, int length, Orientation orientation) {
		this.firstRow = firstRow;
		this.firstCol = firstCol;
		currRow = firstRow;
		currCol = firstCol;
		this.length = length;
		this.orientation = orientation;
	}

	/**
	 * Resets the position of the boulder to the original firstRow and firstCol values
	 * that were passed to the constructor during initialization of the the boulder.
	 */
	public void reset() {
		currRow = firstRow;
		currCol = firstCol;
	}

	/**
	 * Move the boulders position by one cell in the direction specified. The boulders
	 * first column and row should be updated. The method will only move VERTICAL
	 * boulders UP or DOWN and HORIZONTAL boulders RIGHT or LEFT. Invalid movements are
	 * ignored.
	 * 
	 * @param dir direction to move (UP, DOWN, RIGHT, or LEFT)
	 */
	public void move(Direction dir) {
		if (orientation.equals(HORIZONTAL) && (dir.equals(RIGHT) || dir.equals(LEFT))) {
			if (dir.equals(RIGHT)) {
				currCol += 1;
			}
			if (dir.equals(LEFT)) {
				currCol -= 1;
			}
		}
		if (orientation.equals(VERTICAL) && (dir.equals(UP) || dir.equals(DOWN))) {
			if (dir.equals(UP)) {
				currRow -= 1;
			} 
			if (dir.equals(DOWN)) {
				currRow += 1;
			}
		}
	}

	/**
	 * Gets the first row of the boulder on the board.
	 * 
	 * @return first row
	 */
	public int getFirstRow() {
		return firstRow;
	}

	/**
	 * Sets the first row of the boulder on the board.
	 * 
	 * @param firstRow first row
	 */
	public void setFirstRow(int firstRow) {
		this.firstRow = firstRow;
	}

	/**
	 * Gets the first column of the boulder on the board.
	 * 
	 * @return first column
	 */
	public int getFirstCol() {
		return firstCol;
	}

	/**
	 * Sets the first column of the boulder on the board.
	 * 
	 * @param firstCol first column
	 */
	public void setFirstCol(int firstCol) {
		this.firstCol = firstCol;
	}

	/**
	 * Gets the length of the boulder.
	 * 
	 * @return length measured in cells
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Gets the orientation of the boulder.
	 * 
	 * @return either VERTICAL or HORIZONTAL
	 */
	public Orientation getOrientation() {
		return orientation;
	} 
	
	@Override
	public String toString() {
		return "(row=" + getFirstRow() + ", col=" + getFirstCol() + ", len=" + getLength()
				+ ", ori=" + getOrientation() + ")";
	}
}
