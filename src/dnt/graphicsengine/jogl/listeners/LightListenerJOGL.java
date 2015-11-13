package dnt.graphicsengine.jogl.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import dnt.graphicsengine.common.Views;
import dnt.graphicsengine.jogl.LightJOGL;

/**
 * Manage a LightListener
 * @author Sh1fT
 *
 */
public class LightListenerJOGL implements KeyListener {
	private LinkedList<LightJOGL> light;
	private Integer view;

	/**
	 * Create a new LightListener instance
	 */
	public LightListenerJOGL() {
		this(new LinkedList<LightJOGL>(), 0);
	}

	/**
	 * Create a new LightListener instance
	 * @param light
	 * @param view
	 */
	public LightListenerJOGL(LinkedList<LightJOGL> light, Integer view) {
		this.setLight(light);
		this.setView(view);
	}

	public LinkedList<LightJOGL> getLight() {
		return light;
	}

	public void setLight(LinkedList<LightJOGL> light) {
		this.light = light;
	}

	public Integer getView() {
		return view;
	}

	public void setView(Integer view) {
		this.view = view;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_F1:
				if (this.getView().equals(Views.PERSPECTIVE)) {
					for (LightJOGL light : this.getLight()) {
						if (light.isTurnedOn())
							light.turnOff();
						else
							light.turnOn();
					}
				} else {
					if (this.getLight().get(this.getView()-1).isTurnedOn())
						this.getLight().get(this.getView()-1).turnOff();
					else
						this.getLight().get(this.getView()-1).turnOn();
				}
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