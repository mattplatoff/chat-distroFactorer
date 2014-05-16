package createacritter;

import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

public class HanibalCritter extends Critter {
	private Location loc;

	public HanibalCritter() {
		super();

	}

	/**
	 * gets all critters with in a five space radius of this critter
	 * 
	 * @return the critters with in five spaces
	 */
	public ArrayList<Actor> getActors() {
		ArrayList<Actor> actors = new ArrayList<Actor>();
		for (Location l : this.getGrid().getOccupiedLocations()) {
			if (this.getGrid().get(l) instanceof Critter && getDistance(l) <= 5) {
				actors.add(this.getGrid().get(l));
			}
		}

		return actors;

	}

	/**
	 * eats all critters with in a 1 space radius sets loc to the location of
	 * the closest critter
	 * 
	 */
	public void processActors(ArrayList<Actor> actors) {
		double max = 0;

		for (Location l : this.getGrid().getOccupiedAdjacentLocations(
				this.getLocation())) {
			if (this.getGrid().get(l) instanceof Critter)
				this.getGrid().get(l).removeSelfFromGrid();
		}

		for (Actor a : actors) {
			if (a instanceof Critter&&a.getLocation()!= null) {
				if (getDistance((a.getLocation())) > max) {
					max = getDistance((a.getLocation()));
					this.loc = a.getLocation();
				}
			}
		}
	}

	/**
	 * gets the location adjecent to the closest critter in the direction
	 * towards this critter.
	 */
	public ArrayList<Location> getMoveLocations() {
		ArrayList<Location> locs = new ArrayList<Location>();
		int dirToTarget = this.getLocation().getDirectionToward(loc);
		locs.add(loc.getAdjacentLocation(dirToTarget - Location.HALF_CIRCLE));
		return locs;

	}

	/**
	 * gets the distance between this critter and loc
	 * 
	 * @param loc
	 *            location to find distance between
	 * @return the distance
	 */
	public double getDistance(Location loc) {
		double distance =  Math.sqrt((((this.getLocation().getCol() - loc
				.getCol())*(this.getLocation().getCol() - loc
						.getCol()) )
				+ ((this.getLocation().getRow() - loc.getRow()) )*(this.getLocation().getRow() - loc.getRow()) ));
		System.out.println(distance);

		return distance;

	}

}