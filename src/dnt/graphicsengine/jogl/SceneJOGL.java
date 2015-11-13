package dnt.graphicsengine.jogl;

import java.util.HashSet;
import dnt.graphicsengine.interfaces.Object;
import dnt.graphicsengine.interfaces.Scene;

/**
 * Manage a SceneJOGL
 * @author Sh1fT
 *
 */
public class SceneJOGL implements Scene {
	private HashSet<Object> objects;

	/**
	 * Create a new SceneJOGL instance
	 */
	public SceneJOGL() {
		this.setObjects(new HashSet<Object>());
	}

	public HashSet<Object> getObjects() {
		return objects;
	}

	public void setObjects(HashSet<Object> objects) {
		this.objects = objects;
	}

	@Override
	public void addObject(Object object) {
		this.getObjects().add(object);
	}

	@Override
	public void removeObject(Object object) {
		this.getObjects().remove(object);
	}

	@Override
	public void removeAllObject() {
		this.getObjects().clear();
	}
}