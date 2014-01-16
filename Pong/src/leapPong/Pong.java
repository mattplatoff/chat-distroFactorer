package leapPong;

import processing.core.PApplet;

public class Pong extends PApplet {
private Paddle p1,p2;
	public void setup(){
	 size (600,600);
	 background(100);
	 p1=new Paddle(20,20,this);
	 p2=new Paddle (50,50,this);
 }
 public void draw(){
	 p1.create();
	 p1.moveUp(UP, keyEvent );
 }
}
