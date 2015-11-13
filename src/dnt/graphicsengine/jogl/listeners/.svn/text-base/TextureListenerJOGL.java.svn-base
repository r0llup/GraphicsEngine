package dnt.graphicsengine.jogl.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Manage a TextureListenerJOGL
 * @author Sh1fT
 *
 */
public class TextureListenerJOGL implements KeyListener {
	private Boolean turnedOn;

	/**
	 * Create a new TextureListenerJOGL instance
	 */
	public TextureListenerJOGL() {
		this(false);
	}

	/**
	 * Create a new TextureListenerJOGL instance
	 * @param turnedOn
	 */
	public TextureListenerJOGL(Boolean turnedOn) {
		this.setTurnedOn(turnedOn);
	}

	public Boolean getTurnedOn() {
		return turnedOn;
	}

	public void setTurnedOn(Boolean turnedOn) {
		this.turnedOn = turnedOn;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_F2:
				if (this.getTurnedOn())
					this.setTurnedOn(false);
				else
					this.setTurnedOn(true);
				break;
			default:
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}