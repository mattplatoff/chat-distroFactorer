package blueCritter;

import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

public class BluesCritter extends Critter {
	private Location loc;

	/**
	 * gets all actors with in a 11 block radius filters all but blue rocks and
	 * returns an arraylist with rocks and all other actors  . if no
	 * rocks returns null.
	 */
	public ArrayList<Actor> getActors() {
		return null;

		
	}

	/**
	 * 
	 * randomly selects a rock and takes it out of the grid and all neighbors
	 * around the rock. saves the location of the rock into loc. if null is
	 * passed in null is stored as loc and the method does nothing else.
	 */
	public void processActors(ArrayList<Actor> actors) {

	}

	/**
	 * uses the location stored in loc. if null method does nothing
	 */
	public ArrayList<Location> getMoveLocations() {
		return null;

	}

	/**
	 * selects loc. if null does nothing
	 */
	public Location selectMoveLocation(ArrayList<Location> locs) {
		return null;

	}

	/**
	 * moves to loc, if null does nothing.
	 */
	public void makeMove(Location loc) {

	}

}
