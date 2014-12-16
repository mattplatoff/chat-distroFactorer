package homeworkQuiz;

import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

public class SheepCritter extends Critter {
private int wolfCount=0;
public ArrayList<Actor> getActors(){
	ArrayList<Actor> actors=new ArrayList<Actor>();
	if (this.getGrid().get(this.getLocation().getAdjacentLocation(this.getDirection())) instanceof WolfCritter){
		actors.add(this.getGrid().get(this.getLocation().getAdjacentLocation(this.getDirection())));
	}
	return actors;
	
}



public void processActors(ArrayList<Actor> a){
	if (a.get(0)!=null){
		wolfCount++;
		if (wolfCount==3)
			this.removeSelfFromGrid();
		
		
		}
	else {
		this.wolfCount=0;
		return;}
	}
	public ArrayList<Location> getMoveLocations(){
		ArrayList<Location> locs=new ArrayList<Location>();
		if (this.getGrid().get(this.getLocation().getAdjacentLocation(this.getDirection()-Location.HALF_CIRCLE)).equals(null))
		 locs.add(this.getLocation().getAdjacentLocation(this.getDirection()-Location.HALF_CIRCLE));
		else 
			locs=super.getMoveLocations();
		return locs;
		
		
	}
public Location selectMoveLocations(ArrayList<Location> l){
	if (this.getLocation().getAdjacentLocation(this.getDirection()-Location.HALF_CIRCLE) != null){
		return this.getLocation().getAdjacentLocation(this.getDirection()-Location.HALF_CIRCLE);
		
	}
	else 
		return super.selectMoveLocation(l);
		
	
	
}
}
	
	

