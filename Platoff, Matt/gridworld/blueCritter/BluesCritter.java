package blueCritter;

import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

public class BluesCritter extends Critter {
	private Location loc;

	/**list with  random blue rock in 10 spaces followed by neighbors
	 * gets all actors with in a 10 block radius filters all but blue rocks and
	 * returns an arraylist with rocks and all other actors  . if no
	 * rocks returns null.
	 */
	public ArrayList<Actor> getActors() {
		ArrayList<Actor> a=new ArrayList<Actor>();
		for (Location l: this.getGrid().getOccupiedLocations()){
		if (Math.pow((l.getLineNumber()*l.getLineNumber())+(l.getRowNumber()*l.getRowNumber()),.5<11)
				a.add(gr.get(l));
		}
		ArrayList<Rock> r=new ArrayList<Rock>();
		for (Actor a: a){
			if (a instanceof Rock){
				if (a.getColor().equals(Color.blue)
						r.add(a);
			}
		}
			
		return r ;

		
	}

	/**
	 * find rock. removes enighbors. store loc as feild
	 * randomly selects a rock and takes it out of the grid and all neighbors
	 * around the rock. saves the location of the rock into loc. if null is
	 * passed in null is stored as loc and the method does nothing else.
	 */
	public void processActors(ArrayList<Actor> actors)
	{
		ArrayList<Actor> remove = new ArrayList<>();
		for(Actor a : actors)
			if(!(a instanceof Rock))
				remove.add(a);
		
		actors.removeAll(remove);
		
		int i = actors.size();
		if (i == 0)
		{
			loc = getLocation();
			return;
		}
		
		int rand = (int) (Math.random()  * n);
		loc = actors.get(rand).getLocation();
		
		for(Actor a : getGrid().getNeighbors(moveTo))
			a.removeSelfFromGrid();
	}
	/**
	 * uses the location stored in loc. if null method does nothing
	 */
	
	/**
	 * selects loc. if null does nothing
	 */
	public Location selectMoveLocation(ArrayList<Location> locs) {
		return loc;

	}

	/**
	 * moves to loc, if null does nothing.
	 */
	

}
