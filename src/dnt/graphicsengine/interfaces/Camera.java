package dnt.graphicsengine.interfaces;

/**
 * Declaration of a Camera
 * @author Sh1fT
 *
 */
public interface Camera {
	/**
	 * Update the camera's position
	 * @param xPos
	 * @param yPos
	 * @param zPos
	 */
	public void updatePosition(Double xPos, Double yPos, Double zPos);
	/**
	 * Update the target's position
	 * @param xTargetPos
	 * @param yTargetPos
	 * @param zTargetPos
	 */
	 public void lookPosition(Double xTargetPos, Double yTargetPos, Double zTargetPos);
    /**
     * Move the camera
     * @param magnitude
     */
	public void moveForward(Double magnitude);
    /**
     * Lateral left displacement
     * @param magnitude
     */
	public void strafeLeft(Double magnitude);
    /**
     * Lateral right displacement
     * @param magnitude
     */
	public void strafeRight(Double magnitude);
    /**
     * Front up displacement
     * @param magnitude
     */
	public void frontShiftingUp(Double magnitude);
    /**
     * Front down displacement
     * @param magnitude
     */
	public void frontShiftingDown(Double magnitude);
    /**
     * Camera's look
     * @param distanceAway
     */
	public void look(Double distanceAway);
    /**
     * Top inclination
     * @param amount
     */
	public void pitchUp(Double amount);
    /**
     * Bottom inclination
     * @param amount
     */
	public void pitchDown(Double amount);
    /**
     * Right inclination
     * @param amount
     */
	public void yawRight(Double amount);
    /**
     * Left inclination
     * @param amount
     */
	public void yawLeft(Double amount);
}