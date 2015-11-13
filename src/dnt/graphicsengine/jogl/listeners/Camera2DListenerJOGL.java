package dnt.graphicsengine.jogl.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import dnt.graphicsengine.jogl.GraphicsEngineJOGL;

/**
 * Manage a Camera2DListener
 * @author Sh1fT
 *
 */
public class Camera2DListenerJOGL extends CameraListenerJOGL {
	private WindowZoomListenerJOGL windowZoomListener;

	/**
	 * Create new Camera2DListener instance
	 * @param parent
	 * @param view
	 */
	public Camera2DListenerJOGL(GraphicsEngineJOGL parent, Integer view) {
		super(parent, view);
		this.setWindowZoomListener(null);
	}

	public WindowZoomListenerJOGL getWindowZoomListener() {
		return windowZoomListener;
	}

	public void setWindowZoomListener(WindowZoomListenerJOGL windowZoomListener) {
		this.windowZoomListener = windowZoomListener;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (!this.getWindowZoomListener().getShiftPressed()) {
			switch (e.getButton()) {
				case MouseEvent.BUTTON1:
					if (this.getNumMouse().equals(MouseEvent.NOBUTTON)) {
						this.runAnimator();
						this.setNumMouse(e.getButton());
						this.getTranslate1().setX(e.getPoint().getX());
						this.getTranslate1().setY(e.getPoint().getY());
					}
					break;
				default:
					break;
			}
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (!this.getWindowZoomListener().getShiftPressed()) {
			switch (this.getNumMouse()) {
				case MouseEvent.BUTTON1:
					this.getTranslate2().setX(e.getPoint().getX());
					this.getTranslate2().setY(e.getPoint().getY());
					this.getTranslateDiff().setX(this.getTranslate2().getX()-this.getTranslate1().getX());
					this.getTranslateDiff().setY(this.getTranslate2().getY()-this.getTranslate1().getY());
					this.getTranslate3().setX(this.getTranslate3().getX()+this.getTranslateDiff().getX());
					this.getTranslate3().setY(this.getTranslate3().getY()+this.getTranslateDiff().getY());
					this.getTranslate1().setX(this.getTranslate2().getX());
					this.getTranslate1().setY(this.getTranslate2().getY());
					break;
				default:
					break;
			}
		}
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		this.runAnimator();
		if (e.getWheelRotation() < 0)
			this.setZoom(this.getZoom()+1f);
		else if (this.getZoom() > 1f)
			this.setZoom(this.getZoom()-1f);
	}
}