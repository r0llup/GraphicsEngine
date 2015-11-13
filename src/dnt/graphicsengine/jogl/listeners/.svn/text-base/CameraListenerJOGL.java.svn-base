package dnt.graphicsengine.jogl.listeners;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;

import com.jogamp.opengl.util.Animator;

import dnt.graphicsengine.common.Position2D;
import dnt.graphicsengine.common.Views;
import dnt.graphicsengine.jogl.GraphicsEngineJOGL;

/**
 * Manage a CameraListener
 * @author Sh1fT
 *
 */
public abstract class CameraListenerJOGL implements MouseListener, MouseMotionListener, MouseWheelListener, FocusListener {
	private GraphicsEngineListenerJOGL graphicsEngineListener;
	protected Animator animator;
	protected Integer numMouse;
	private Position2D translate1;
	private Position2D translate2;
	private Position2D translate3;
	private Position2D translateDiff;
	private Float zoom;

	/**
	 * Create a new CameraListener instance
	 * @param parent
	 * @param view
	 */
	public CameraListenerJOGL(GraphicsEngineJOGL parent, Integer view) {
		this.setGraphicsEngineListener(parent.getGraphicsEngineListener().get(view));
		this.setAnimator(parent.getAnimators().get(view));
		this.setNumMouse(MouseEvent.NOBUTTON);
		this.setTranslate1(new Position2D());
		this.setTranslate2(new Position2D());
		this.setTranslate3(new Position2D());
		this.setTranslateDiff(new Position2D());
		// apply a default zoom
		if (view.equals(Views.PERSPECTIVE))
			this.setZoom(2000f);
		else
			this.setZoom(10f);
	}

	public GraphicsEngineListenerJOGL getGraphicsEngineListener() {
		return graphicsEngineListener;
	}

	public void setGraphicsEngineListener(
			GraphicsEngineListenerJOGL graphicsEngineListener) {
		this.graphicsEngineListener = graphicsEngineListener;
	}

	public Animator getAnimator() {
		return animator;
	}

	public void setAnimator(Animator animator) {
		this.animator = animator;
	}

	public Integer getNumMouse() {
		return numMouse;
	}

	public void setNumMouse(Integer numMouse) {
		this.numMouse = numMouse;
	}

	public Position2D getTranslate1() {
		return translate1;
	}

	public void setTranslate1(Position2D translate1) {
		this.translate1 = translate1;
	}

	public Position2D getTranslate2() {
		return translate2;
	}

	public void setTranslate2(Position2D translate2) {
		this.translate2 = translate2;
	}

	public Position2D getTranslate3() {
		return translate3;
	}

	public void setTranslate3(Position2D translate3) {
		this.translate3 = translate3;
	}

	public Position2D getTranslateDiff() {
		return translateDiff;
	}

	public void setTranslateDiff(Position2D translateDiff) {
		this.translateDiff = translateDiff;
	}

	public Float getZoom() {
		return zoom;
	}

	public void setZoom(Float zoom) {
		this.zoom = zoom;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (this.getNumMouse().equals(e.getButton())) {
			this.setNumMouse(MouseEvent.NOBUTTON);
			this.getAnimator().pause();
		}
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
    }

	@Override
    public void focusLost(FocusEvent e) {
		this.getAnimator().pause();
    }

	/**
	 * Run the animator
	 */
	public void runAnimator() {
		if (!this.getAnimator().isStarted())
			this.getAnimator().start();
		else if (this.getAnimator().isPaused())
			this.getAnimator().resume();
	}
}