package leapPong;

import java.awt.event.KeyEvent;

import processing.core.PApplet;

public class Pong extends PApplet {
private Paddle p1,p2;
	public void setup(){
	 size (600,600);
	 background(0,255,0);
	 p1=new Paddle(this,20,20,KeyEvent.VK_UP, KeyEvent.VK_DOWN);
	
	 
 }
 public void draw(){
	 p1.create();
	 
 }
}
