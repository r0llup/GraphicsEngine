package dnt.graphicsengine.jogl.objects.simpleobjects;

import java.awt.Color;
import java.util.LinkedList;

import javax.media.opengl.GL2;

import dnt.graphicsengine.common.Position3D;

/**
 * Manage a PolygonJOGL
 * @author Sh1fT
 *
 */
public class PolygonJOGL extends UntexturedSimpleObjectJOGL {
	private LinkedList<Position3D> positions;

	/**
	 * Create a new PolygonJOGL
	 */
	public PolygonJOGL() {
		this("0", new LinkedList<Position3D>());
	}

	/**
	 * Create a new PolygonJOGL
	 * @param id
	 * @param positions
	 */
	public PolygonJOGL(String id, LinkedList<Position3D> positions) {
		this(id, positions, Color.WHITE);
	}

	/**
	 * Create a new PolygonJOGL
	 * @param id
	 * @param positions
	 * @param color
	 */
	public PolygonJOGL(String id, LinkedList<Position3D> positions, Color color) {
		this(id, positions, color, null);
	}

	/**
	 * Create a new PolygonJOGL
	 * @param id
	 * @param positions
	 * @param color
	 * @param selectionColor
	 */
	public PolygonJOGL(String id, LinkedList<Position3D> positions, Color color, Color selectionColor) {
		this(id, positions, color, selectionColor, 1f);
	}

	/**
	 * Create a new PolygonJOGL
	 * @param id
	 * @param positions
	 * @param color
	 * @param selectionColor
	 * @param size
	 */
	public PolygonJOGL(String id, LinkedList<Position3D> positions, Color color, Color selectionColor, Float size) {
		this.setId(id);
		this.setPositions(positions);
		this.setColor(color);
		this.setSelectionColor(selectionColor);
		this.setSize(size);
	}

	public LinkedList<Position3D> getPositions() {
		return positions;
	}

	public void setPositions(LinkedList<Position3D> positions) {
		this.positions = positions;
	}

	public void addPosition(Position3D position3D) {
		if (!this.getPositions().contains(position3D))
			this.getPositions().add(position3D);
	}

	public void removePosition(Position3D position3D) {
		this.getPositions().remove(position3D);
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
			gl2.glBegin(GL2.GL_POLYGON);
			for (Position3D pos : this.getPositions())
				gl2.glVertex3d(pos.getX(), pos.getY(), pos.getZ());
			gl2.glEnd();
		}
	}

	@Override
	public void move(Double xDisp, Double yDisp, Double zDisp) {
		for (Position3D p : this.getPositions()) {
			p.setX(p.getX()+xDisp);
			p.setY(p.getY()+yDisp);
			p.setZ(p.getZ()+zDisp);
		}
	}
}