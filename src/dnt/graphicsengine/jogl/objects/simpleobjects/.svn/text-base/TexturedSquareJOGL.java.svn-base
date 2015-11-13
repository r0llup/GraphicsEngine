package dnt.graphicsengine.jogl.objects.simpleobjects;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.media.opengl.GL2;

import com.jogamp.opengl.util.texture.Texture;

import dnt.graphicsengine.common.Position3D;
import dnt.graphicsengine.common.Views;
import dnt.graphicsengine.interfaces.TexturedSimpleObject;
import dnt.graphicsengine.jogl.helper.TextureHelper;

/**
 * Manage a TexturedSquareJOGL
 * @author Sh1fT
 *
 */
public class TexturedSquareJOGL extends SquareJOGL implements TexturedSimpleObject {
	private String textureLocation;
	private ArrayList<Texture> texture;
	private Integer originalSize;

	/**
	 * Create a new TexturedSquareJOGL instance
	 * @param id
	 * @param position1
	 * @param position2
	 * @param position3
	 * @param position4
	 * @param color
	 * @param selectionColor
	 * @param size
	 * @param fill
	 */
	public TexturedSquareJOGL(String id, Position3D position1, Position3D position2, Position3D position3, Position3D position4,
			Color color, Color selectionColor, Float size, Boolean fill) {
		this(id, position1, position2, position3, position4, color, selectionColor, size, fill, null);
	}

	/**
	 * Create a new TexturedSquareJOGL instance
	 * @param id
	 * @param position1
	 * @param position2
	 * @param position3
	 * @param position4
	 * @param color
	 * @param selectionColor
	 * @param size
	 * @param fill
	 * @param textureLocation
	 */
	public TexturedSquareJOGL(String id, Position3D position1, Position3D position2, Position3D position3, Position3D position4,
			Color color, Color selectionColor, Float size, Boolean fill, String textureLocation) {
		this(id, position1, position2, position3, position4, color, selectionColor, size, fill, textureLocation, null);
	}

	/**
	 * Create a new TexturedSquareJOGL instance
	 * @param id
	 * @param position1
	 * @param position2
	 * @param position3
	 * @param position4
	 * @param color
	 * @param selectionColor
	 * @param size
	 * @param fill
	 * @param textureLocation
	 * @param originalSize
	 */
	public TexturedSquareJOGL(String id, Position3D position1, Position3D position2, Position3D position3, Position3D position4,
			Color color, Color selectionColor, Float size, Boolean fill, String textureLocation, Integer originalSize) {
		this.setId(id);
		this.setPosition1(position1);
		this.setPosition2(position2);
		this.setPosition3(position3);
		this.setPosition4(position4);
		this.setColor(color);
		this.setSelectionColor(selectionColor);
		this.setSize(size);
		this.setFill(fill);
		this.setTextureLocation(textureLocation);
		this.setTexture(new ArrayList<Object>());
		this.setOriginalSize(originalSize);
		this.initTexture();
	}

	public String getTextureLocation() {
		return textureLocation;
	}

	public void setTextureLocation(String textureLocation) {
		this.textureLocation = textureLocation;
	}

	public ArrayList<Texture> getTexture() {
		return texture;
	}

	@Override
	public void setTexture(List<Object> texture) {
		this.texture = new ArrayList<Texture>();
		for (Object o : texture) {
			if (o instanceof Texture)
				this.getTexture().add((Texture) o);
			else
				this.getTexture().add(null);
		}
	}

	/**
	 * Initialize the texture
	 */
	public void initTexture() {
		for (Integer i=0; i <= 3; i++)
			this.getTexture().add(null);
	}

	public Integer getOriginalSize() {
		return originalSize;
	}

	public void setOriginalSize(Integer originalSize) {
		this.originalSize = originalSize;
	}

	@Override
	public void draw(Object drawable, Integer view) {
		if (drawable instanceof GL2) {
			GL2 gl2 = (GL2) drawable;
			if (gl2.glIsEnabled(GL2.GL_TEXTURE_2D)) {
				gl2.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
				if ((this.getTexture() != null) && (this.getTexture().get(view) != null)) {
					this.getTexture().get(view).enable(gl2);
					this.getTexture().get(view).bind(gl2);
				} else if (this.getTextureLocation() != null) {
					this.getTexture().add(view, TextureHelper.loadTexture(gl2, this.getTextureLocation()));
					this.getTexture().get(view).enable(gl2);
					this.getTexture().get(view).bind(gl2);
				}
			} else {
				if ((this.getTexture() != null) && (this.getTexture().get(view) != null))
					this.getTexture().get(view).disable(gl2);
				if (this.getSelectionColor() == null)
					gl2.glColor3d(this.getColor().getRed()/255d, this.getColor().getGreen()/255d, this.getColor().getBlue()/255d);
				else
					gl2.glColor3d(this.getSelectionColor().getRed()/255d, this.getSelectionColor().getGreen()/255d, this.getSelectionColor().getBlue()/255d);
				gl2.glLineWidth(this.getSize());
				if (this.getFill())
					gl2.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
				else
					gl2.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);
			}
			gl2.glBegin(GL2.GL_QUADS);
			if (this.getOriginalSize() != null) {
				if ((this.getTexture() != null) && (this.getTexture().get(view) != null)) {
					if (this.getOriginalSize().equals(Views.TOP)) {
						gl2.glTexCoord2d(0d, 1d);
						gl2.glVertex3d(this.getPosition1().getX(), this.getPosition1().getY(), this.getPosition1().getZ());
						gl2.glTexCoord2d(1d, 1d);
						gl2.glVertex3d(this.getPosition1().getX()+this.getTexture().get(view).getWidth(),
								this.getPosition1().getY(), this.getPosition1().getZ());
						gl2.glTexCoord2d(1d, 0d);
						gl2.glVertex3d(this.getPosition1().getX()+this.getTexture().get(view).getWidth(),
								this.getPosition1().getY(), this.getPosition2().getZ()+this.getTexture().get(view).getHeight());
						gl2.glTexCoord2d(0d, 0d);
						gl2.glVertex3d(this.getPosition1().getX(), this.getPosition1().getY(),
								this.getPosition1().getZ()+this.getTexture().get(view).getHeight());
					} else if (this.getOriginalSize().equals(Views.SIDE)) {
						gl2.glTexCoord2d(0d, 1d);
						gl2.glVertex3d(this.getPosition1().getX(), this.getPosition1().getY(), this.getPosition1().getZ());
						gl2.glTexCoord2d(1d, 1d);
						gl2.glVertex3d(this.getPosition1().getX()+this.getTexture().get(view).getWidth(),
								this.getPosition1().getY(), this.getPosition1().getZ());
						gl2.glTexCoord2d(1d, 0d);
						gl2.glVertex3d(this.getPosition1().getX()+this.getTexture().get(view).getWidth(),
								this.getPosition1().getY()+this.getTexture().get(view).getHeight(), this.getPosition1().getZ());
						gl2.glTexCoord2d(0d, 0d);
						gl2.glVertex3d(this.getPosition1().getX(), this.getPosition2().getY()+this.getTexture().get(view).getHeight(),
								this.getPosition1().getZ());
					} else if (this.getOriginalSize().equals(Views.FRONT)) {
						gl2.glTexCoord2d(0d, 1d);
						gl2.glVertex3d(this.getPosition1().getX(), this.getPosition1().getY(), this.getPosition1().getZ());
						gl2.glTexCoord2d(1d, 1d);
						gl2.glVertex3d(this.getPosition1().getX(), this.getPosition1().getY(),
								this.getPosition1().getZ()+this.getTexture().get(view).getHeight());
						gl2.glTexCoord2d(1d, 0d);
						gl2.glVertex3d(this.getPosition1().getX(), this.getPosition1().getY()+this.getTexture().get(view).getWidth(),
								this.getPosition1().getZ()+this.getTexture().get(view).getHeight());
						gl2.glTexCoord2d(0d, 0d);
						gl2.glVertex3d(this.getPosition1().getX(), this.getPosition1().getY()+this.getTexture().get(view).getWidth(),
								this.getPosition1().getZ());
					}
				}
			} else {
				gl2.glTexCoord2d(0d, 1d);
				gl2.glVertex3d(this.getPosition1().getX(), this.getPosition1().getY(), this.getPosition1().getZ());
				gl2.glTexCoord2d(1d, 1d);
				gl2.glVertex3d(this.getPosition2().getX(), this.getPosition2().getY(), this.getPosition2().getZ());
				gl2.glTexCoord2d(1d, 0d);
				gl2.glVertex3d(this.getPosition3().getX(), this.getPosition3().getY(), this.getPosition3().getZ());
				gl2.glTexCoord2d(0d, 0d);
				gl2.glVertex3d(this.getPosition4().getX(), this.getPosition4().getY(), this.getPosition4().getZ());
			}
			gl2.glEnd();
		}
	}
}