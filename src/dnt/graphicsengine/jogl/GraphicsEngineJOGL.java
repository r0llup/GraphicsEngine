package dnt.graphicsengine.jogl;

import java.util.ArrayList;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;

import com.jogamp.opengl.util.Animator;

import dnt.graphicsengine.common.Views;
import dnt.graphicsengine.interfaces.Camera;
import dnt.graphicsengine.interfaces.GraphicsEngine;
import dnt.graphicsengine.interfaces.Light;
import dnt.graphicsengine.interfaces.Scene;
import dnt.graphicsengine.interfaces.SceneManager;
import dnt.graphicsengine.jogl.listeners.Camera2DListenerJOGL;
import dnt.graphicsengine.jogl.listeners.GraphicsEngineListenerJOGL;
import dnt.graphicsengine.jogl.listeners.LightListenerJOGL;
import dnt.graphicsengine.jogl.listeners.Camera3DListenerJOGL;
import dnt.graphicsengine.jogl.listeners.PickingListenerJOGL;
import dnt.graphicsengine.jogl.listeners.TextureListenerJOGL;
import dnt.graphicsengine.jogl.listeners.WindowZoomListenerJOGL;

/**
 * Manage a GraphicsEngineJOGL
 * @author Sh1fT
 *
 */
public class GraphicsEngineJOGL implements GraphicsEngine {
	private SceneManagerJOGL sceneManagerJOGL;
	private GLProfile glProfile;
	private GLCapabilities glCapabilities;
	private ArrayList<GraphicsEngineListenerJOGL> graphicsEngineListener;
	private ArrayList<Camera2DListenerJOGL> camera2DListener;
	private Camera3DListenerJOGL camera3DListener;
	private ArrayList<PickingListenerJOGL> pickingListener;
	private ArrayList<LightListenerJOGL> lightListener;
	private ArrayList<WindowZoomListenerJOGL> windowZoomListener;
	private ArrayList<TextureListenerJOGL> textureListener;
	private ArrayList<GLCanvas> glCanvas;
	private ArrayList<Animator> animators;
	private Boolean turnedOn;

	/**
	 * Create a new GraphicsEngineJOGL instance
	 */
	public GraphicsEngineJOGL() {
		this.setSceneManagerJOGL(new SceneManagerJOGL());
		this.setGlProfile(GLProfile.getDefault());
		this.setGlCapabilities(new GLCapabilities(this.getGlProfile()));
		// a few rendering improvements
		this.getGlCapabilities().setHardwareAccelerated(true);
		this.getGlCapabilities().setNumSamples(8);
		this.getGlCapabilities().setSampleBuffers(true);
		this.getGlCapabilities().setDoubleBuffered(true);
		this.setGraphicsEngineListener(new ArrayList<GraphicsEngineListenerJOGL>());
		this.setCamera2DListener(new ArrayList<Camera2DListenerJOGL>());
		this.setCamera3DListener(null);
		this.setPickingListener(new ArrayList<PickingListenerJOGL>());
		this.setLightListener(new ArrayList<LightListenerJOGL>());
		this.setWindowZoomListener(new ArrayList<WindowZoomListenerJOGL>());
		this.setTextureListener(new ArrayList<TextureListenerJOGL>());
		this.setGlCanvas(new ArrayList<GLCanvas>());
		this.setAnimators(new ArrayList<Animator>());
		this.setTurnedOn(false);
		this.initialize();
	}

	public SceneManagerJOGL getSceneManagerJOGL() {
		return sceneManagerJOGL;
	}

	public void setSceneManagerJOGL(SceneManagerJOGL sceneManagerJOGL) {
		this.sceneManagerJOGL = sceneManagerJOGL;
	}

	public GLProfile getGlProfile() {
		return glProfile;
	}

	public void setGlProfile(GLProfile glProfile) {
		this.glProfile = glProfile;
	}

	public GLCapabilities getGlCapabilities() {
		return glCapabilities;
	}

	public void setGlCapabilities(GLCapabilities glCapabilities) {
		this.glCapabilities = glCapabilities;
	}
	
	public ArrayList<GraphicsEngineListenerJOGL> getGraphicsEngineListener() {
		return graphicsEngineListener;
	}

	public void setGraphicsEngineListener(ArrayList<GraphicsEngineListenerJOGL> graphicsEngineListener) {
		this.graphicsEngineListener = graphicsEngineListener;
	}

	public ArrayList<Camera2DListenerJOGL> getCamera2DListener() {
		return camera2DListener;
	}

	public void setCamera2DListener(ArrayList<Camera2DListenerJOGL> camera2dListener) {
		camera2DListener = camera2dListener;
	}

	public Camera3DListenerJOGL getCamera3DListener() {
		return camera3DListener;
	}

	public void setCamera3DListener(Camera3DListenerJOGL camera3dListener) {
		camera3DListener = camera3dListener;
	}

	public ArrayList<PickingListenerJOGL> getPickingListener() {
		return pickingListener;
	}

	public void setPickingListener(ArrayList<PickingListenerJOGL> pickingListener) {
		this.pickingListener = pickingListener;
	}

	public ArrayList<LightListenerJOGL> getLightListener() {
		return lightListener;
	}

	public void setLightListener(ArrayList<LightListenerJOGL> lightListener) {
		this.lightListener = lightListener;
	}

	public ArrayList<WindowZoomListenerJOGL> getWindowZoomListener() {
		return windowZoomListener;
	}

	public void setWindowZoomListener(ArrayList<WindowZoomListenerJOGL> windowZoomListener) {
		this.windowZoomListener = windowZoomListener;
	}

	public ArrayList<TextureListenerJOGL> getTextureListener() {
		return textureListener;
	}

	public void setTextureListener(ArrayList<TextureListenerJOGL> textureListener) {
		this.textureListener = textureListener;
	}

	public ArrayList<GLCanvas> getGlCanvas() {
		return glCanvas;
	}

	public void setGlCanvas(ArrayList<GLCanvas> glCanvas) {
		this.glCanvas = glCanvas;
	}

	public ArrayList<Animator> getAnimators() {
		return animators;
	}

	public void setAnimators(ArrayList<Animator> animators) {
		this.animators = animators;
	}

	public Boolean getTurnedOn() {
		return turnedOn;
	}

	public void setTurnedOn(Boolean turnedOn) {
		this.turnedOn = turnedOn;
	}

	@Override
	public SceneManager getSceneManager() {
		return sceneManagerJOGL;
	}

	@Override
	public Camera getCamera() {
		return new CameraJOGL();
	}

	@Override
	public Light getLight() {
		return new LightJOGL();
	}

	@Override
	public Scene getScene() {
		return new SceneJOGL();
	}

	@Override
	public void turnOn() {
		for (Animator a : this.getAnimators())
			a.start();
		this.setTurnedOn(true);
	}

	@Override
	public void turnOff() {
		for (Animator a : this.getAnimators())
			a.stop();
		this.setTurnedOn(false);
	}

	@Override
	public Boolean isTurnedOn() {
		return this.getTurnedOn();
	}

	@Override
	public Boolean isTurnedOff() {
		return !this.getTurnedOn();
	}

	@Override
	public void initialize() {
		for (Integer view=0; view < 4; view++) {
			this.getGlCanvas().add(new GLCanvas(this.getGlCapabilities()));
			this.getLightListener().add(new LightListenerJOGL(this.getSceneManagerJOGL().getLights(), view));
			this.getGlCanvas().get(view).addKeyListener(this.getLightListener().get(view));
			this.getTextureListener().add(new TextureListenerJOGL());
			this.getGlCanvas().get(view).addKeyListener(this.getTextureListener().get(view));
			this.getGraphicsEngineListener().add(new GraphicsEngineListenerJOGL(this, view));
			this.getGlCanvas().get(view).addGLEventListener(this.getGraphicsEngineListener().get(view));
			this.getAnimators().add(new Animator(this.getGlCanvas().get(view)));
			if (view.equals(Views.PERSPECTIVE)) {
				this.setCamera3DListener(new Camera3DListenerJOGL(this));
				this.getGlCanvas().get(view).addMouseListener(this.getCamera3DListener());
				this.getGlCanvas().get(view).addMouseMotionListener(this.getCamera3DListener());
				this.getGlCanvas().get(view).addMouseWheelListener(this.getCamera3DListener());
				this.getGlCanvas().get(view).addFocusListener(this.getCamera3DListener()); //FIXME
				this.getGraphicsEngineListener().get(view).setCamera3DListener(this.getCamera3DListener());
			} else {
				this.getCamera2DListener().add(new Camera2DListenerJOGL(this, view));
				this.getGlCanvas().get(view).addMouseListener(this.getCamera2DListener().get(view-1));
				this.getGlCanvas().get(view).addMouseMotionListener(this.getCamera2DListener().get(view-1));
				this.getGlCanvas().get(view).addMouseWheelListener(this.getCamera2DListener().get(view-1));
				this.getGlCanvas().get(view).addFocusListener(this.getCamera2DListener().get(view-1)); //FIXME
				this.getGraphicsEngineListener().get(view).setCamera2DListener(this.getCamera2DListener().get(view-1));
				this.getWindowZoomListener().add(new WindowZoomListenerJOGL(this, view));
				this.getGlCanvas().get(view).addMouseListener(this.getWindowZoomListener().get(view-1));
				this.getGlCanvas().get(view).addMouseMotionListener(this.getWindowZoomListener().get(view-1));
				this.getGlCanvas().get(view).addKeyListener(this.getWindowZoomListener().get(view-1));
				this.getCamera2DListener().get(view-1).setWindowZoomListener(this.getWindowZoomListener().get(view-1));
			}
			this.getPickingListener().add(new PickingListenerJOGL(this, view));
			this.getGraphicsEngineListener().get(view).setPickingListener(this.getPickingListener().get(view));
			this.getGlCanvas().get(view).addMouseListener(this.getPickingListener().get(view));
			this.getGlCanvas().get(view).addMouseMotionListener(this.getPickingListener().get(view));
			this.getGlCanvas().get(view).addKeyListener(this.getPickingListener().get(view));
		}
	}
}