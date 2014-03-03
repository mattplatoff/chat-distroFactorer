package buildabug;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

public class BugTester {

	public static void main(String[] args) {
		ActorWorld world = new ActorWorld();
        world.add(new Location(3,4),new MusicBug());
        world.add(new Location(7, 7), new MusicBug());
        world.add(new Location(0,4), new MusicBug());
        world.show();

	}

}
