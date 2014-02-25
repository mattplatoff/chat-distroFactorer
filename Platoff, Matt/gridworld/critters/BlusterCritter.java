package critters;

import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

public class BlusterCritter extends Critter {
	private int c;

	public BlusterCritter(int c) {
		this.c = c;
	}

	public ArrayList<Actor> getActors() {
		ArrayList<Location> spaces = this.getGrid().getValidAdjacentLocations(
				this.getLocation());
		ArrayList<Actor> neighbors = new ArrayList<Actor>();
		for (Location l : spaces) {
			neighbors.addAll(this.getGrid().getNeighbors(l));
		}
if (neighbors.size()>c)
	this.setColor(this.getColor().darker());
else if (neighbors.size()<c){
	this.setColor(this.getColor().brighter());
}
		return neighbors;

	}
}
