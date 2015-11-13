package dnt.graphicsengine.jogl.objects.simpleobjects;

import java.awt.Color;
import javax.media.opengl.GL2;

import dnt.graphicsengine.common.Position3D;

/**
 * Manage a LineJOGL
 * @author Sh1fT
 *
 */
public class LineJOGL extends UntexturedSimpleObjectJOGL {
	private Position3D position1;
	private Position3D position2;

	/**
	 * Create a new LineJOGL instance
	 */
	public LineJOGL() {
		this("0", new Position3D(), new Position3D());
	}

	/**
	 * Create a new LineJOGL instance
	 * @param id
	 * @param Position1
	 * @param Position2
	 */
	public LineJOGL(String id, Position3D position1, Position3D position2) {
		this(id, position1, position2, Color.WHITE);
	}

	/**
	 * Create a new LineJOGL instance
	 * @param id
	 * @param position1
	 * @param position2
	 * @param color
	 */
	public LineJOGL(String id, Position3D position1, Position3D position2, Color color) {
		this(id, position1, position2, color, null);
	}

	/**
	 * Create a new LineJOGL instance
	 * @param id
	 * @param position1
	 * @param position2
	 * @param color
	 * @param selectionColor
	 */
	public LineJOGL(String id, Position3D position1, Position3D position2, Color color, Color selectionColor) {
		this(id, position1, position2, color, selectionColor, 1f);
	}

	/**
	 * Create a new LineJOGL instance
	 * @param id
	 * @param position1
	 * @param position2
	 * @param color
	 * @param selectionColor
	 * @param size
	 */
	public LineJOGL(String id, Position3D position1, Position3D position2, Color color, Color selectionColor, Float size) {
		this.setId(id);
		this.setPosition1(position1);
		this.setPosition2(position2);
		this.setColor(color);
		this.setSelectionColor(selectionColor);
		this.setSize(size);
	}

	public Position3D getPosition1() {
		return position1;
	}

	public void setPosition1(Position3D position1) {
		this.position1 = position1;
	}

	public Position3D getPosition2() {
		return position2;
	}

	public void setPosition2(Position3D position2) {
		this.position2 = position2;
	}

	@Override
	public void draw(Object drawable, Integer view) {
		if (drawable instanceof GL2) {
			GL2 gl2 = (GL2) drawable;
			if (this.getSelectionColor() == null)
				gl2.glColor3d(this.getColor().getRed()/255d, this.getColor().getGreen()/255d, this.getColor().getBlue()/255d);
			else
				gl2.glColor3d(this.getSelectionColor().getRed()/255d, this.getSelectionColor().getGreen()/255d, this.getSelectionColor().getBlue()/255d);
			gl2.glLineWidth(this.getSize());
			gl2.glBegin(GL2.GL_LINES);
			gl2.glVertex3d(this.getPosition1().getX(), this.getPosition1().getY(), this.getPosition1().getZ());
			gl2.glVertex3d(this.getPosition2().getX(), this.getPosition2().getY(), this.getPosition2().getZ());
			gl2.glEnd();
		}
	}

	@Override
	public void move(Double xDisp, Double yDisp, Double zDisp) {
		this.getPosition1().setX(this.getPosition1().getX()+xDisp);
		this.getPosition1().setY(this.getPosition1().getY()+yDisp);
		this.getPosition1().setZ(this.getPosition1().getZ()+zDisp);
		this.getPosition2().setX(this.getPosition2().getX()+xDisp);
		this.getPosition2().setY(this.getPosition2().getY()+yDisp);
		this.getPosition2().setZ(this.getPosition2().getZ()+zDisp);
	}
}