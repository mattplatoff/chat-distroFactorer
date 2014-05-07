package funWithGrid;

import java.util.ArrayList;

import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;


public class NumberTile {
	
	
	private Location myLoc;
	private GameBoard gb;
	private int value;
	private Grid<NumberTile> grid;

	/**
	 * creates a new number tile
	 * @param loc  location of the tile
	 * @param gb game board that the tile is contained in
	 * @param value the value of teh tile
	 */

	public NumberTile(Location loc, GameBoard gb, int value) {
		this.myLoc = loc;
		this.gb = gb;
		this.value = value;
		this.grid = gb.getGrid();

	}

	/**
	 * moves tile in direction of key pressed
	 * @pram dirKey the description of the key that was pressed
	 */
	public void move(String dirKey) {
		
		if (dirKey.equals("UP")) {
			
			if (grid.isValid(this.getFarLineEmptyLocation(Location.NORTH))) {
				gb.remove(myLoc);
				//myLoc=myLoc.getAdjacentLocation(Location.NORTH);
				myLoc = this.getFarLineEmptyLocation(Location.NORTH);
				merge(Location.NORTH);
				putSelfInGrid(myLoc);
			}
		}
		if (dirKey.equals("LEFT")) {
			if (grid.isValid(this.getFarLineEmptyLocation(Location.WEST))) {
				gb.remove(myLoc);
				
				myLoc = this.getFarLineEmptyLocation(Location.WEST);
				merge(Location.WEST);
				putSelfInGrid(myLoc);
			}
		}
		if (dirKey.equals("DOWN")) {
			if (grid.isValid(this.getFarLineEmptyLocation(Location.SOUTH))) {
				gb.remove(myLoc);
				
				myLoc = this.getFarLineEmptyLocation(Location.SOUTH);
				merge(Location.SOUTH);
				putSelfInGrid(myLoc);
			}
		}
		if (dirKey.equals("RIGHT")) {
			if (grid.isValid(this.getFarLineEmptyLocation(Location.EAST))) {
					
				gb.remove(myLoc);
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
			//this.remove();
			this.remove();
			temp.remove();
			myLoc=myLoc.getAdjacentLocation(dir);
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
		gb.remove(myLoc);
		

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

	/**
	 * returns the suffix for the .gif file for the tile of coresponding value
	 * @return the suffix of value .gif file
	 */
	public String getImageSuffix() {
		if (value == 2)
			return "_2";
		if (value == 4)
			return "_4";
		if (value == 8)
			return "_8";
		if (value == 16)
			return "_16";
		if (value == 32)
			return "_32";
		if (value == 64)
			return "_64";
		if (value == 128)
			return "_128";
		if (value == 256)
			return "_256";
		if (value == 512)
			return "_512";
		if (value == 1024)
			return "_1024";
		if (value == 2048)
			return "_2048";
		return "";

	}
/**
 * makes tile a frowney face
 */
	public void gameOver(){
	value=(int) (Math.random()*2342345);
}
}
