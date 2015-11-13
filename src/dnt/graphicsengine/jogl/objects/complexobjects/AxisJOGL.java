package dnt.graphicsengine.jogl.objects.complexobjects;

import java.awt.Color;
import java.util.ArrayList;
import dnt.graphicsengine.common.Position3D;
import dnt.graphicsengine.interfaces.Object;
import dnt.graphicsengine.jogl.objects.simpleobjects.LineJOGL;

/**
 * Manage an AxisJOGL
 * @author Sh1fT
 *
 */
public class AxisJOGL extends ComplexObjectJOGL {
	private Double width;
	private Double height;
	private Double depth;

	/**
	 * Create a new AxisJOGL instance
	 */
	public AxisJOGL() {
		this("0", new Position3D(), 0d, 0d, 0d);
	}

	/**
	 * Create a new AxisJOGL instance
	 * @param id
	 * @param startPosition
	 * @param width
	 * @param height
	 * @param depth
	 */
	public AxisJOGL(String id, Position3D startPosition, Double width, Double height, Double depth) {
		this.setId(id);
		this.setObjects(new ArrayList<Object>());
		this.setStartPosition(startPosition);
		this.setWidth(width);
		this.setHeight(height);
		this.setDepth(depth);
		this.draw();
	}

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getDepth() {
		return depth;
	}

	public void setDepth(Double depth) {
		this.depth = depth;
	}

	/**
	 * Add the objects to the list
	 */
	public void draw() {
		this.getObjects().add(new LineJOGL("XAXIS", new Position3D(this.getStartPosition().getX(), this.getStartPosition().getY(),
				this.getStartPosition().getZ()), new Position3D(this.getStartPosition().getX()+this.getWidth(),
						this.getStartPosition().getY(), this.getStartPosition().getZ()), Color.RED, null, 2f));
		this.getObjects().add(new LineJOGL("YAXIS", new Position3D(this.getStartPosition().getX(), this.getStartPosition().getY(),
				this.getStartPosition().getZ()), new Position3D(this.getStartPosition().getX(),
						this.getStartPosition().getY()+this.getHeight(), this.getStartPosition().getZ()), Color.GREEN, null, 2f));
		this.getObjects().add(new LineJOGL("ZAXIS", new Position3D(this.getStartPosition().getX(), this.getStartPosition().getY(),
				this.getStartPosition().getZ()), new Position3D(this.getStartPosition().getX(), this.getStartPosition().getY(),
						this.getStartPosition().getZ()+this.getDepth()), Color.YELLOW, null, 2f));
	}

	@Override
	public void move(Double xDisp, Double yDisp, Double zDisp) {
		for (Object o : this.getObjects()) {
			((LineJOGL) o).getPosition1().setX(((LineJOGL) o).getPosition1().getX()+xDisp);
			((LineJOGL) o).getPosition1().setY(((LineJOGL) o).getPosition1().getY()+yDisp);
			((LineJOGL) o).getPosition1().setZ(((LineJOGL) o).getPosition1().getZ()+zDisp);
			((LineJOGL) o).getPosition2().setX(((LineJOGL) o).getPosition2().getX()+xDisp);
			((LineJOGL) o).getPosition2().setY(((LineJOGL) o).getPosition2().getY()+yDisp);
			((LineJOGL) o).getPosition2().setZ(((LineJOGL) o).getPosition2().getZ()+zDisp);
		}
	}
}