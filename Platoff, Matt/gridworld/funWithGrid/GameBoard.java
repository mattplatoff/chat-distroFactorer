package funWithGrid;

import java.util.ArrayList;


import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

public class GameBoard extends World {
 private static BoundedGrid<NumberTile> bg=new BoundedGrid<NumberTile>(4,4);
	/**
	 * creates a new game board
	 */
	public GameBoard() {
		super(bg);
		spawnTile();
		spawnTile();
	}

/**
 * moves te tiles on the board in the direction of arrow key pressed
 */
	public boolean keyPressed(String description, Location loc) {

		for (Location t : (ArrayList<Location>) getGrid().getOccupiedLocations()) {
			((NumberTile)bg.get(t)).move(description);
			
			
		}
		System.out.println(description);
        if (!spawnTile())
        	for (Location t : (ArrayList<Location>) getGrid().getOccupiedLocations()) {
    			((NumberTile)bg.get(t)).gameOver();}
        
		return true;

	}

	/**
	 * attempts to place the numbertile in an unoccupied location in the grid
	 * 
	 * @return true if tile was placed , false of there are no more unoccupied
	 *         locations
	 */
	public boolean spawnTile() {
		ArrayList<Location> emptyLocs = new ArrayList<Location>();
		for (int r = 0; r < 4; r++) {
			for (int c = 0; c < 4; c++) {
				if (this.getGrid().get(new Location(r, c)) == null)
					emptyLocs.add(new Location(r, c));
			}
		}
		if (emptyLocs.size() == 0)
			return false;
		else {
			Location temp = emptyLocs.get((int) (emptyLocs.size() * Math
					.random()));
			new NumberTile(temp, this, ((int) (Math.random() * 2)+1) * 2)
					.putSelfInGrid(temp);
			return true;
		}

	}

	
	}

