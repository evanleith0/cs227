package hw3;

import static api.Orientation.*;
import static api.CellType.*;

import java.util.ArrayList;

import api.Cell;

/**
 * @author Evan Leith
 */

/**
 * Utilities for parsing string descriptions of a grid.
 */
public class GridUtil {
	
	/**
	 * Constructs a 2D grid of Cell objects given a 2D array of cell descriptions.
	 * String descriptions are a single character and have the following meaning.
	 * <ul>
	 * <li>"*" represents a wall.</li>
	 * <li>"e" represents an exit.</li>
	 * <li>"." represents a floor.</li>
	 * <li>"[", "]", "^", "v", or "#" represent a part of a boulder. A boulder is not a
	 * type of cell, it is something placed on a cell floor. For these descriptions
	 * a cell is created with CellType of FLOOR. This method does not create any
	 * boulders or set boulders on cells.</li>
	 * </ul>
	 * The method only creates cells and not boulders. See the other utility method
	 * findBoulders which is used to create the boulders.
	 * 
	 * @param desc a 2D array of strings describing the grid
	 * @return a 2D array of cells the represent the grid without any boulders present
	 */
	public static Cell[][] createGrid(String[][] desc) {
		Cell[][] emptyGrid = new Cell[desc.length][desc[0].length];
		for (int i = 0; i < desc.length; i++) {
			for (int j = 0; j < desc[i].length; j++) {
				if (desc[i][j].equals("[") || desc[i][j].equals("]") || desc[i][j].equals("^") ||
						desc[i][j].equals("v") || desc[i][j].equals("#")) {
					emptyGrid[i][j] = new Cell(i, j, GROUND);
				} else {
					if (desc[i][j].equals("*")) {
						emptyGrid[i][j] = new Cell(i, j, WALL);
					} else if (desc[i][j].equals("e")) {
						emptyGrid[i][j] = new Cell(i, j, EXIT);
					} else if (desc[i][j].equals(".")) {
						emptyGrid[i][j] = new Cell(i, j, GROUND);
					}
				}
			}
		}
		return emptyGrid;
	}

	/**
	 * Returns a list of boulders that are constructed from a given 2D array of cell
	 * descriptions. String descriptions are a single character and have the
	 * following meanings.
	 * <ul>
	 * <li>"[" the start (left most column) of a horizontal boulder</li>
	 * <li>"]" the end (right most column) of a horizontal boulder</li>
	 * <li>"^" the start (top most row) of a vertical boulder</li>
	 * <li>"v" the end (bottom most column) of a vertical boulder</li>
	 * <li>"#" inner segments of a boulder, these are always placed between the start
	 * and end of the boulder</li>
	 * <li>"*", ".", and "e" symbols that describe cell types, meaning there is not
	 * boulder currently over the cell</li>
	 * </ul>
	 * 
	 * @param desc a 2D array of strings describing the grid
	 * @return a list of boulders found in the given grid description
	 */
	public static ArrayList<Boulder> findBoulders(String[][] desc) {
		// TODO
		return null;
	}
}
