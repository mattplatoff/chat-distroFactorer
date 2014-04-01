package funWithGrid;

import java.util.ArrayList;

import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
//TODO: figure out if there is a way to make the images of this object change with one class or if i need to make subclasses.
public class NumberTile {
	// TODO: make subclasses of number tile so it is easy to change the image of
	// the tile
	private Location myLoc;
	private GameBoard gb;
	private int value;
	private BoundedGrid<NumberTile> grid = (BoundedGrid<NumberTile>) gb
			.getGrid();

	/**
	 * moves tile in direction of arrow key
	 */

	public NumberTile(Location loc, GameBoard gb, int value) {
		this.myLoc = loc;
		this.gb = gb;
		this.value = value;

	}

	/**
	 * moves tile in direction of key pressed
	 */
	public void move(String dirKey) {
		if (dirKey == "w") {
			// TODO fix if statements to they are not repetive code with the
			// check in put self in grid
			// TODO merge before putSelfinGRID may cause unwanted game effects.
			// test this.
			if (grid.isValid(myLoc.getAdjacentLocation(Location.NORTH))) {
				myLoc = this.getFarLineEmptyLocation(Location.NORTH);
				merge(Location.NORTH);
				putSelfInGrid(myLoc);
			}
		}
		if (dirKey == "a") {
			if (grid.isValid(myLoc.getAdjacentLocation(Location.WEST))) {
				myLoc = this.getFarLineEmptyLocation(Location.WEST);
				merge(Location.WEST);
				putSelfInGrid(myLoc);
			}
		}
		if (dirKey == "s") {
			if (grid.isValid(myLoc.getAdjacentLocation(Location.SOUTH))) {
				myLoc = this.getFarLineEmptyLocation(Location.SOUTH);
				merge(Location.SOUTH);
				putSelfInGrid(myLoc);
			}
		}
		if (dirKey == "d") {
			if (grid.isValid(myLoc.getAdjacentLocation(Location.EAST))) {
				myLoc = this.getFarLineEmptyLocation(Location.EAST);
				merge(Location.EAST);
				putSelfInGrid(myLoc);
			}
		}
	}

	/**
	 * merges two tiles and doubles the value of the one left
	 */
	public void merge(int dir) {
		NumberTile temp = grid.isValid(myLoc.getAdjacentLocation(dir)) ? (NumberTile) gb
				.getGrid().get(myLoc.getAdjacentLocation(dir)) : null;
		if (temp != null && temp.getVal() == this.getVal()) {
			temp.remove();
			this.value *= 2;
		}
	}



	/**
	 * checks if location to be placed is valid
	 * 
	 * @param loc
	 *            the location to place the tile
	 * @return true if location was valid, false if not
	 */
	public boolean putSelfInGrid(Location loc) {

		if (grid.isValid(loc) && grid.get(loc) == null) {
			grid.put(loc, this);
			myLoc = loc;
			return true;
		}
		return false;

	}

	/**
	 * gets location of number tile
	 * 
	 * @return location of number tile
	 */
	public Location getLocation() {
		return myLoc;
	}

	/**
	 * returns the value
	 * 
	 * @return value of tile
	 */
	public int getVal() {
		return value;
	}

	/**
	 * removes tile from the grid.
	 */
	public void remove() {
		grid.remove(myLoc);
	}

	/**
	 * gets the farthest empty location in a given direction
	 * 
	 * @param d
	 *            the direction
	 * @return farthest empty location
	 */
	public Location getFarLineEmptyLocation(int d) {
		Location loc;
		loc = myLoc;

		while (grid.isValid(loc.getAdjacentLocation(d))
				&& grid.get(loc.getAdjacentLocation(d)) == null) {
			loc = loc.getAdjacentLocation(d);
		}

		return loc;
	}
//TODO: make override getImageSuffix method
	public String getImageSuffix(){
	if (value==2)
		return "_2";
	if (value==4)
		return "_4";
	if (value==8)
		return "_8";
	if (value==16)
		return "_16";
	if (value==32)
		return "_32";
	if (value==64)
		return "_64";
	if (value==128)
		return "_128";
	if (value==256)
		return "_256";
	if (value==512)
		return "_512";
	if (value==1024)
		return "_1024";
	if (value==2048)
		return "_2048";
	if (value==4096)
		return "_4096";
	
	
	
	
	}
		
		
		return "";
	
}
}