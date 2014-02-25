package critters;
import java.util.ArrayList;

import info.gridworld.*;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
public class RockHound extends Critter {

	public void processActors(ArrayList<Actor> a){
		for (Actor actor: a){
			if (actor instanceof Rock)
				actor.removeSelfFromGrid();
		}
	
}
	
}
