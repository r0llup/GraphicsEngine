package dnt.graphicsengine.jogl.objects.complexobjects;

import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;

import dnt.graphicsengine.common.Position3D;
import dnt.graphicsengine.common.Views;
import dnt.graphicsengine.interfaces.Object;
import dnt.graphicsengine.jogl.objects.simpleobjects.TexturedSquareJOGL;

/**
 * Manage a TexturedPlaneJOGL
 * @author Sh1fT
 *
 */
public class TexturedPlaneJOGL extends PlaneJOGL {
	private ArrayList<String> textureLocation;
	private Boolean originalSize;

	/**
	 * Create a new TexturedPlaneJOGL instance
	 * @param id
	 * @param startPosition
	 * @param width
	 * @param height
	 * @param depth
	 */
	public TexturedPlaneJOGL(String id, Position3D startPosition, Double width, Double height, Double depth) {
		this(id, startPosition, width, height, depth, null);
	}

	/**
	 * Create a new TexturedPlaneJOGL instance
	 * @param id
	 * @param startPosition
	 * @param width
	 * @param height
	 * @param depth
	 * @param textureLocation
	 */
	public TexturedPlaneJOGL(String id, Position3D startPosition, Double width, Double height, Double depth, ArrayList<String> textureLocation) {
		this(id, startPosition, width, height, depth, textureLocation, false);
	}

	/**
	 * Create a new TexturedPlaneJOGL instance
	 * @param id
	 * @param startPosition
	 * @param width
	 * @param height
	 * @param depth
	 * @param textureLocation
	 * @param originalSize
	 */
	public TexturedPlaneJOGL(String id, Position3D startPosition, Double width, Double height, Double depth, ArrayList<String> textureLocation, Boolean originalSize) {
		this.setId(id);
		this.setObjects(new LinkedList<Object>());
		this.setStartPosition(startPosition);
		this.setWidth(width);
		this.setHeight(height);
		this.setDepth(depth);
		this.setTextureLocation(textureLocation);
		this.setOriginalSize(originalSize);
		this.draw();
	}

	public ArrayList<String> getTextureLocation() {
		return textureLocation;
	}

	public void setTextureLocation(ArrayList<String> textureLocation) {
		this.textureLocation = textureLocation;
	}

	public Boolean getOriginalSize() {
		return originalSize;
	}

	public void setOriginalSize(Boolean originalSize) {
		this.originalSize = originalSize;
	}

	/**
	 * Add the objects to the list
	 */
	public void draw() {
		if ((this.getTextureLocation() != null) && (!this.getTextureLocation().isEmpty())) {
			// front
			this.getObjects().add(new TexturedSquareJOGL("FRONT", new Position3D(0d, 0d, this.getStartPosition().getZ()),
					new Position3D(0d, 0d, this.getStartPosition().getZ()+this.getDepth()),
					new Position3D(0d, this.getHeight(), this.getStartPosition().getZ()+this.getDepth()),
					new Position3D(0d, this.getHeight(), this.getStartPosition().getZ()),
					Color.GRAY, null, 1f, false,
					this.getTextureLocation().get(0), this.getOriginalSize() ? Views.FRONT : null));
			// top
			this.getObjects().add(new TexturedSquareJOGL("TOP", new Position3D(this.getStartPosition().getX(),
					this.getStartPosition().getY(), this.getStartPosition().getZ()),
					new Position3D(this.getStartPosition().getX()+this.getWidth(),
							this.getStartPosition().getY(), this.getStartPosition().getZ()),
					new Position3D(this.getStartPosition().getX()+this.getWidth(),
							this.getStartPosition().getY(), this.getStartPosition().getZ()+this.getDepth()),
					new Position3D(this.getStartPosition().getX(), this.getStartPosition().getY(),
							this.getStartPosition().getZ()+this.getDepth()),
					Color.GRAY, null, 1f, false,
					(this.getTextureLocation().size() < 3 ) ? this.getTextureLocation().get(0) : this.getTextureLocation().get(1),
							this.getOriginalSize() ? Views.TOP : null));
			// side
			this.getObjects().add(new TexturedSquareJOGL("SIDE", new Position3D(this.getStartPosition().getX(),
					this.getStartPosition().getY(), 0d),
					new Position3D(this.getStartPosition().getX()+this.getWidth(),
							this.getStartPosition().getY(), 0d),
					new Position3D(this.getStartPosition().getX()+this.getWidth(),
							this.getStartPosition().getY()+this.getHeight(), 0d),
					new Position3D(this.getStartPosition().getX(), this.getStartPosition().getY()+this.getHeight(),
							0d), Color.GRAY, null, 1f, false,
					(this.getTextureLocation().size() < 3 ) ? this.getTextureLocation().get(0) : this.getTextureLocation().get(2),
							this.getOriginalSize() ? Views.SIDE : null));
		}
	}
}