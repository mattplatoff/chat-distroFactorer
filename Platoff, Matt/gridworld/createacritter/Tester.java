package createacritter;

import java.awt.Color;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Critter;

public class Tester {

	public static void main(String[] args) {
		ActorWorld a=new ActorWorld();
		HanibalCritter hc=new HanibalCritter();
		hc.setColor(Color.black);
		a.add(hc);
		a.add(new Critter());
		a.add(new Critter());
		a.add(new Critter());
		a.add(new Critter());
		a.add(new Critter());
		a.show();
	}

}
