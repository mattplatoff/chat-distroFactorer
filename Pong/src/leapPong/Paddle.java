package leapPong;

import java.awt.event.KeyEvent;

public class Paddle {
private int xpos,ypos;
private Pong myParrent;
private final int PWIDTH=20,PLENGTH=100; 
public Paddle(int xpos,int ypos, Pong myParrent){
	this.xpos=xpos;
	this.ypos=ypos;
}
/**
 * 
 */
public void create(){
	myParrent.rect(xpos, ypos, PWIDTH, PLENGTH);
	myParrent.fill(100,50,3);
}
/**
 *  
 * @param keyId id of trigger key
 * @param e a key event
 */
public void moveUp(int keyId, KeyEvent e){
	
	if (keyId==e.getKeyCode()){
		while(e.getID()!=KeyEvent.KEY_RELEASED)
		xpos+=10;
	}
}
/**
 * move paddle down
 * @param keyId id of the key
 * @param e a key event
 */
public void moveDown(int keyId, KeyEvent e){
	if (keyId==e.getKeyCode()){
		while(e.getID()!=KeyEvent.KEY_RELEASED)
		xpos-=10;
	}
}

}
