package dnt.graphicsengine.jogl;

import java.util.LinkedList;

import dnt.graphicsengine.interfaces.Light;
import dnt.graphicsengine.interfaces.Scene;
import dnt.graphicsengine.interfaces.SceneManager;

/**
 * Manage a SceneManagerJOGL
 * @author Sh1fT
 *
 */
public class SceneManagerJOGL implements SceneManager {
	private LinkedList<LightJOGL> lights;
	private SceneJOGL scene;

	/**
	 * Create a new SceneManagerJOGL instance
	 */
	public SceneManagerJOGL() {
		this.setLights(new LinkedList<LightJOGL>());
		this.setScene(new SceneJOGL());
		this.initializeLights();
	}

	public LinkedList<LightJOGL> getLights() {
		return lights;
	}

	public void setLights(LinkedList<LightJOGL> lights) {
		this.lights = lights;
	}

	public SceneJOGL getScene() {
		return scene;
	}

	@Override
	public void initializeLights() {
		for (Integer i=0; i < 3; i++)
			this.getLights().add(new LightJOGL());
	}

	@Override
	public void addLight(Light light) {
		if (light instanceof LightJOGL)
			this.getLights().add((LightJOGL) light);
	}

	@Override
	public void removeLight(Light light) {
		if (light instanceof LightJOGL)
			this.getLights().remove((LightJOGL) light);
	}

	@Override
	public void setScene(Scene scene) {
		if (scene instanceof SceneJOGL)
			this.scene = (SceneJOGL) scene;
	}

	@Override
	public void removeScene() {
		this.setScene(null);
	}
}