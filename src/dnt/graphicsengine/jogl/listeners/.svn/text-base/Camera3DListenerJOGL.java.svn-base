package dnt.graphicsengine.jogl.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import dnt.graphicsengine.common.Position2D;
import dnt.graphicsengine.common.Position3D;
import dnt.graphicsengine.common.Views;
import dnt.graphicsengine.jogl.GraphicsEngineJOGL;

/**
 * Manage a Camera3DListener
 * @author Sh1fT
 *
 */
public class Camera3DListenerJOGL extends CameraListenerJOGL {
	private Position3D rotate1;
	private Position3D rotate2;
	private Position3D rotate3;
	private Position2D rotateDiff;
	private Double angleX;
	private Double angleY;

	/**
	 * Create new Camera3DListener instance
	 * @param parent
	 */
	public Camera3DListenerJOGL(GraphicsEngineJOGL parent) {
		super(parent, Views.PERSPECTIVE);
		this.setRotate1(new Position3D());
		this.setRotate2(new Position3D());
		this.setRotate3(new Position3D());
		this.setRotateDiff(new Position2D());
		this.setAngleX(0d);
		this.setAngleY(0d);
	}

	public Position3D getRotate1() {
		return rotate1;
	}

	public void setRotate1(Position3D rotate1) {
		this.rotate1 = rotate1;
	}

	public Position3D getRotate2() {
		return rotate2;
	}

	public void setRotate2(Position3D rotate2) {
		this.rotate2 = rotate2;
	}

	public Position3D getRotate3() {
		return rotate3;
	}

	public void setRotate3(Position3D rotate3) {
		this.rotate3 = rotate3;
	}

	public Position2D getRotateDiff() {
		return rotateDiff;
	}

	public void setRotateDiff(Position2D rotateDiff) {
		this.rotateDiff = rotateDiff;
	}

	public Double getAngleX() {
		return angleX;
	}

	public void setAngleX(Double angleX) {
		this.angleX = angleX;
	}

	public Double getAngleY() {
		return angleY;
	}

	public void setAngleY(Double angleY) {
		this.angleY = angleY;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		switch (e.getButton()) {
			case MouseEvent.BUTTON1:
				if (this.getNumMouse().equals(MouseEvent.NOBUTTON)) {
					this.runAnimator();
					this.setNumMouse(e.getButton());
					this.getTranslate1().setX(e.getPoint().getX());
					this.getTranslate1().setY(e.getPoint().getY());
				}
				break;
			case MouseEvent.BUTTON3:
				if (this.getNumMouse().equals(MouseEvent.NOBUTTON)) {
					this.runAnimator();
					this.setNumMouse(e.getButton());
					this.getRotate1().setX(e.getPoint().getX());
					this.getRotate1().setY(e.getPoint().getY());
				}
			default:
				break;
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
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
			case MouseEvent.BUTTON3:
				this.getRotate2().setX(e.getPoint().getX());
				this.getRotate2().setY(e.getPoint().getY());
				this.getRotateDiff().setX(this.getRotate2().getX()-this.getRotate1().getX());
				this.getRotateDiff().setY(this.getRotate2().getY()-this.getRotate1().getY());
				this.getRotate3().setX(this.getRotate3().getX()+this.getRotateDiff().getX());
				this.getRotate3().setY(this.getRotate3().getY()+this.getRotateDiff().getY());
				this.getRotate1().setX(this.getRotate2().getX());
				this.getRotate1().setY(this.getRotate2().getY());
				this.setAngleX(this.getRotate3().getX()/this.getGraphicsEngineListener().getWidth()*360d);
				this.setAngleY(this.getRotate3().getY()/this.getGraphicsEngineListener().getHeight()*360d);
			default:
				break;
		}
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		this.runAnimator();
		if (e.getWheelRotation() < 0)
			this.setZoom(this.getZoom()+100f);
		else if (this.getZoom() >= 100f)
			this.setZoom(this.getZoom()-100f);
	}
}