package dnt.graphicsengine.jogl.objects.complexobjects;

import java.awt.Color;
import java.util.ArrayList;
import dnt.graphicsengine.common.Position3D;
import dnt.graphicsengine.interfaces.Object;
import dnt.graphicsengine.jogl.objects.simpleobjects.LineJOGL;
import dnt.graphicsengine.jogl.objects.simpleobjects.SquareJOGL;

/**
 * Draw a Prism
 * @author eugen
 *
 */
public class Cube extends ComplexObjectJOGL {
	private Double width;
	private Color color;

	/**
	 * Create a new AxisJOGL instance
	 */
	public Cube() {
		this("Test Cube", Color.GREEN, 1d);
	}

	/**
	 * Create a new AxisJOGL instance
	 * @param id
	 * @param startPosition
	 * @param width
	 * @param height
	 * @param depth
	 */
	public Cube(String id, Color color, Double width) {
		this.setId(id);
		this.setObjects(new ArrayList<Object>());
		this.setColor(color);
		this.setWidth(width);
		this.draw();
	}

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * Add the objects to the list
	 */
	public void draw() {
		
		// front
		getObjects().add(new SquareJOGL("front", 
						new Position3D(-width, -width, width), 
						new Position3D(width, -width, width),
						new Position3D(width, width, width),
						new Position3D(-width, width, width),
						color,
						Color.RED,
						0.0f,
						true));
				
		// back
		getObjects().add(new SquareJOGL("back", 
						new Position3D(-width, -width, -width), 
						new Position3D(-width, width, -width),
						new Position3D(width, width, -width),
						new Position3D(width, -width, -width),
						color,
						Color.RED,
						0.0f,
						true));
				
		// top
		getObjects().add(new SquareJOGL("top", 
						new Position3D(-width, width, -width), 
						new Position3D(-width, width, width),
						new Position3D(width, width, width),
						new Position3D(width, width, -width),
						color,
						Color.RED,
						0.0f,
						true));
				
		// bottom
		getObjects().add(new SquareJOGL("bottom", 
						new Position3D(-width, -width, -width), 
						new Position3D(width, -width, -width),
						new Position3D(width, -width, width),
						new Position3D(-width, -width, width),
						color,
						Color.RED,
						0.0f,
						true));
				
		// right
		getObjects().add(new SquareJOGL("right", 
						new Position3D(width, -width, -width), 
						new Position3D(width, width, -width),
						new Position3D(width, width, width),
						new Position3D(width, -width, width),
						color,
						Color.RED,
						0.0f,
						true));			

		// left
		getObjects().add(new SquareJOGL("left", 
						new Position3D(-width, -width, -width), 
						new Position3D(-width, -width, width),
						new Position3D(-width, width, width),
						new Position3D(-width, width, -width),
						color,
						Color.RED,
						0.0f,
						true));	
		
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
		}
	}
}