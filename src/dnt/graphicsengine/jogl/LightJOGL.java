package dnt.graphicsengine.jogl;

import dnt.graphicsengine.common.Lightings;
import dnt.graphicsengine.interfaces.Light;

/**
 * Manage a LightJOGL
 * @author Sh1fT
 *
 */
public class LightJOGL implements Light {
	private float[] position;
	private float[] ambient;
	private float[] diffuse;
	private float[] specular;
	private Boolean turnedOn;

	/**
	 * Create a new LightJOGL instance
	 */
	public LightJOGL() {
		this(Lightings.LIGHT_POSITION);
	}

	/**
	 * Create a new LightJOGL instance
	 * @param position
	 */
	public LightJOGL(float[] position) {
		this(position, Lightings.LIGHT_AMBIENT, Lightings.LIGHT_DIFFUSE, Lightings.LIGHT_SPECULAR);
	}

	/**
	 * Create a new LightJOGL instance
	 * @param position
	 * @param ambient
	 * @param diffuse
	 * @param specular
	 */
	public LightJOGL(float[] position, float[] ambient, float[] diffuse, float[] specular) {
		this(position, ambient, diffuse, specular, false);
	}

	/**
	 * Create a new LightJOGL instance
	 * @param position
	 * @param ambient
	 * @param diffuse
	 * @param specular
	 * @param turnedOn
	 */
	public LightJOGL(float[] position, float[] ambient, float[] diffuse, float[] specular, Boolean turnedOn) {
		this.setPosition(position);
		this.setAmbient(ambient);
		this.setDiffuse(diffuse);
		this.setSpecular(specular);
		this.setTurnedOn(turnedOn);
	}

	public float[] getPosition() {
		return position;
	}

	public void setPosition(float[] position) {
		this.position = position;
	}

	public float[] getAmbient() {
		return ambient;
	}

	public void setAmbient(float[] ambient) {
		this.ambient = ambient;
	}

	public float[] getDiffuse() {
		return diffuse;
	}

	public void setDiffuse(float[] diffuse) {
		this.diffuse = diffuse;
	}

	public float[] getSpecular() {
		return specular;
	}

	public void setSpecular(float[] specular) {
		this.specular = specular;
	}

	public Boolean getTurnedOn() {
		return turnedOn;
	}

	public void setTurnedOn(Boolean turnedOn) {
		this.turnedOn = turnedOn;
	}

	@Override
	public void turnOn() {
		this.setTurnedOn(true);
	}

	@Override
	public void turnOff() {
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
}