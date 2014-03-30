package funWithGrid;
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
	if(description=="w"){
		for (NumberTile t:this.getGrid().get)
	}
	
	return true;
	
}
}
