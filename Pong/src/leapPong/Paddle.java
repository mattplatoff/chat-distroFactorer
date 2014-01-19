package leapPong;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Paddle extends Pong implements KeyListener {
	private int xpos, ypos;
	private Pong myParent;
	private final int PWIDTH = 20, PLENGTH = 100;
	private final int upKey, downKey;

	public Paddle(Pong parent, int xpos, int ypos, int upKey, int downKey) {
		this.xpos = xpos;
		this.ypos = ypos;
		this.upKey = upKey;
		this.downKey = downKey;
		this.myParent=parent;

	}


	public void create() {
	
		myParent.rect(xpos, ypos, PWIDTH, PLENGTH);
		fill(255, 255, 0);
		//addKeyListener(this);
	}

	/**
	 * 
	 * @param keyId
	 *            id of trigger key
	 * @param e
	 *            a key event
	 */
	private void moveUp() {

		xpos += 10;
	}

	/**
	 * move paddle down
	 * 
	 * @param keyId
	 *            id of the key
	 * @param e
	 *            a key event
	 */
	private void moveDown() {

		xpos -= 10;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		while (upKey == e.getKeyCode())
			this.moveUp();
		while (downKey == e.getKeyCode())
			this.moveDown();
	}

}
