package funWithGrid;
import java.util.ArrayList;

import info.gridworld.*;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;
public class GameBoard extends World{

//TODO have keypressed save a direction that is accessable in NumberTile	
public GameBoard(){
	super(new BoundedGrid<NumberTile>(4,4));
}
public boolean keyPressed(String description, Location loc){
	
		for (NumberTile t:(ArrayList<NumberTile>) this.getGrid().getOccupiedLocations()){
	t.move(description);}
	
	
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
		new NumberTile(temp, this, ((int) (Math.random() * 2)) * 2)
				.putSelfInGrid(temp);
		return true;
	}

}
}
