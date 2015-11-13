package dnt.graphicsengine.jogl.objects.complexobjects;

import java.awt.Color;
import java.util.LinkedList;
import dnt.graphicsengine.common.Position3D;
import dnt.graphicsengine.interfaces.Object;
import dnt.graphicsengine.jogl.objects.simpleobjects.SquareJOGL;

/**
 * Manage a PlaneJOGL
 * @author Sh1fT
 *
 */
public class PlaneJOGL extends ComplexObjectJOGL {
	private Double width;
	private Double height;
	private Double depth;

	/**
	 * Create a new PlaneJOGL instance
	 */
	public PlaneJOGL() {
		this("0", new Position3D(), 0d, 0d, 0d);
	}

	/**
	 * Create a new PlaneJOGL instance
	 * @param id
	 * @param startPosition
	 * @param width
	 * @param height
	 * @param depth
	 */
	public PlaneJOGL(String id, Position3D startPosition, Double width, Double height, Double depth) {
		this.setId(id);
		this.setObjects(new LinkedList<Object>());
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
		for (Double z=this.getStartPosition().getZ(); z < this.getStartPosition().getZ()+this.getDepth(); z++) {
			// top
			for (Double x=this.getStartPosition().getX(); x < this.getStartPosition().getX()+this.getWidth(); x++) {
				this.getObjects().add(new SquareJOGL("TOP", new Position3D(x, this.getStartPosition().getY(), z+1d),
						new Position3D(x+1d, this.getStartPosition().getY(), z+1d),
						new Position3D(x+1d, this.getStartPosition().getY(), z),
						new Position3D(x, this.getStartPosition().getY(), z), new Color(60, 60, 60), null, 1f));
			}
			// side
			for (Double y=this.getStartPosition().getY(); y < this.getStartPosition().getY()+this.getHeight(); y++) {
				this.getObjects().add(new SquareJOGL("SIDE", new Position3D(this.getStartPosition().getX(), y, z+1d),
					new Position3D(this.getStartPosition().getX(), y+1d, z+1d),
					new Position3D(this.getStartPosition().getX(), y+1d, z),
					new Position3D(this.getStartPosition().getX(), y, z), new Color(60, 60, 60), null, 1f));
			}
		}
		// front
		for (Double x=this.getStartPosition().getX(); x < this.getStartPosition().getX()+this.getWidth(); x++) {
			for (Double y=this.getStartPosition().getY(); y < this.getStartPosition().getY()+this.getHeight(); y++) {
				this.getObjects().add(new SquareJOGL("FRONT", new Position3D(x, y+1d, this.getStartPosition().getZ()),
						new Position3D(x+1d, y+1d, this.getStartPosition().getZ()),
						new Position3D(x+1d, y, this.getStartPosition().getZ()),
						new Position3D(x, y, this.getStartPosition().getZ()), new Color(60, 60, 60), null, 1f));
			}
		}
	}

	@Override
	public void move(Double xDisp, Double yDisp, Double zDisp) {
		for (Object o : this.getObjects()) {
			((SquareJOGL) o).getPosition1().setX(((SquareJOGL) o).getPosition1().getX()+xDisp);
			((SquareJOGL) o).getPosition1().setY(((SquareJOGL) o).getPosition1().getY()+yDisp);
			((SquareJOGL) o).getPosition1().setZ(((SquareJOGL) o).getPosition1().getZ()+zDisp);
			((SquareJOGL) o).getPosition2().setX(((SquareJOGL) o).getPosition2().getX()+xDisp);
			((SquareJOGL) o).getPosition2().setY(((SquareJOGL) o).getPosition2().getY()+yDisp);
			((SquareJOGL) o).getPosition2().setZ(((SquareJOGL) o).getPosition2().getZ()+zDisp);
			((SquareJOGL) o).getPosition3().setX(((SquareJOGL) o).getPosition3().getX()+xDisp);
			((SquareJOGL) o).getPosition3().setY(((SquareJOGL) o).getPosition3().getY()+yDisp);
			((SquareJOGL) o).getPosition3().setZ(((SquareJOGL) o).getPosition3().getZ()+zDisp);
			((SquareJOGL) o).getPosition4().setX(((SquareJOGL) o).getPosition4().getX()+xDisp);
			((SquareJOGL) o).getPosition4().setY(((SquareJOGL) o).getPosition4().getY()+yDisp);
			((SquareJOGL) o).getPosition4().setZ(((SquareJOGL) o).getPosition4().getZ()+zDisp);
		}
	}
}