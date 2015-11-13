package dnt.graphicsengine.jogl.objects;

import java.util.Random;

/**
 * Manage a ObjectJOGL
 * @author Sh1fT
 *
 */
public abstract class ObjectJOGL implements dnt.graphicsengine.interfaces.Object {
	private String id;
	private Boolean isHidden;

	/**
	 * Create a new ObjectJOGL instance
	 */
	public ObjectJOGL() {
		this.setId(String.valueOf(new Random().nextInt()));
		this.setIsHidden(false);
	}

	@Override
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Boolean getIsHidden() {
		return isHidden;
	}

	public void setIsHidden(Boolean isHidden) {
		this.isHidden = isHidden;
	}

	@Override
	public void hide() {
		this.setIsHidden(true);
	}

	@Override
	public void show() {
		this.setIsHidden(false);
	}

	@Override
	public void setVisibility(Boolean visible) {
		this.setIsHidden(visible);
	}
	
	@Override
	public Boolean isHidden() {
		return this.getIsHidden();
	}

	@Override
	public void scale() {
		// TODO Auto-generated method stub
	}

	@Override
	public void copy() {
		// TODO Auto-generated method stub
	}
}