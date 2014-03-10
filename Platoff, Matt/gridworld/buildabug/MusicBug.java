package buildabug;

import java.io.IOException;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class MusicBug extends Bug {

	

	public void move() {
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return;
		Location loc = this.getLocation();
		Location next = loc.getAdjacentLocation(getDirection());
		Actor neighbor = gr.get(next);
		boolean stop = false;
		if (neighbor instanceof Rock)
			stop = true;
		if (neighbor instanceof Bug) {

			launchVid();
		}
		if (!stop) {
			if (gr.isValid(next))
				moveTo(next);
		}

		Flower flower = new Flower(getColor());
		Flower f2 = new Flower(getColor());
		Flower f3 = new Flower(getColor());
		flower.putSelfInGrid(gr, loc);
		if (gr.isValid(getLocation().getAdjacentLocation(Location.SOUTHEAST))
				&& gr.get(getLocation().getAdjacentLocation(Location.SOUTHEAST)) == null)
			f2.putSelfInGrid(gr,
					getLocation().getAdjacentLocation(Location.SOUTHEAST));
		if (gr.isValid(getLocation().getAdjacentLocation(Location.SOUTHWEST))
				&& gr.get(getLocation().getAdjacentLocation(Location.SOUTHWEST)) == null)
			f3.putSelfInGrid(gr,
					getLocation().getAdjacentLocation(Location.SOUTHWEST));

	}

	public void launchVid() {
		String url = "http://www.youtube.com/watch?v=dQw4w9WgXcQ&list=AL94UKMTqg-9AA5fs2YLabd8x7fdejYPot";
		try {
			java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean canMove() {
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return false;
		Location loc = getLocation();
		Location next = loc.getAdjacentLocation(getDirection());
		if (!gr.isValid(next))
			return false;

		return !(gr.get(next) instanceof Rock);

	}
}