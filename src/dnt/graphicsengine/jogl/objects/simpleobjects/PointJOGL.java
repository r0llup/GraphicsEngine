package dnt.graphicsengine.jogl.objects.simpleobjects;

import java.awt.Color;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;

import dnt.graphicsengine.common.Position3D;

/**
 * Manage a PointJOGL
 * @author Sh1fT
 *
 */
public class PointJOGL extends UntexturedSimpleObjectJOGL {
	private Position3D position;

	/**
	 * Create a new PointJOGL instance
	 */
	public PointJOGL() {
		this("0", new Position3D());
	}

	/**
	 * Create a new PointJOGL instance
	 * @param id
	 * @param position
	 */
	public PointJOGL(String id, Position3D position) {
		this(id, position, Color.WHITE);
	}

	/**
	 * Create a new PointJOGL instance
	 * @param id
	 * @param position
	 * @param color
	 */
	public PointJOGL(String id, Position3D position, Color color) {
		this(id, position, color, null);
	}

	/**
	 * Create a new PointJOGL instance
	 * @param id
	 * @param position
	 * @param color
	 * @param selectionColor
	 */
	public PointJOGL(String id, Position3D position, Color color, Color selectionColor) {
		this(id, position, color, selectionColor, 1f);
	}

	/**
	 * Create a new PointJOGL instance
	 * @param id
	 * @param position
	 * @param color
	 * @param selectionColor
	 * @param size
	 */
	public PointJOGL(String id, Position3D position, Color color, Color selectionColor, Float size) {
		this.setId(id);
		this.setPosition(position);
		this.setColor(color);
		this.setSelectionColor(selectionColor);
		this.setSize(size);
	}

	public Position3D getPosition() {
		return position;
	}

	public void setPosition(Position3D position) {
		this.position = position;
	}

	@Override
	public void draw(Object drawable, Integer view) {
		if (drawable instanceof GL2) {
			GL2 gl2 = (GL2) drawable;
			if (this.getSelectionColor() == null)
				gl2.glColor3d(this.getColor().getRed()/255d, this.getColor().getGreen()/255d, this.getColor().getBlue()/255d);
			else
				gl2.glColor3d(this.getSelectionColor().getRed()/255d, this.getSelectionColor().getGreen()/255d, this.getSelectionColor().getBlue()/255d);
			gl2.glPointSize(this.getSize());
			gl2.glBegin(GL.GL_POINTS);
			gl2.glVertex3d(this.getPosition().getX(), this.getPosition().getY(), this.getPosition().getZ());
			gl2.glEnd();
		}
	}

	@Override
	public void move(Double xDisp, Double yDisp, Double zDisp) {
		this.getPosition().setX(this.getPosition().getX()+xDisp);
		this.getPosition().setY(this.getPosition().getY()+yDisp);
		this.getPosition().setZ(this.getPosition().getZ()+zDisp);
	}
}