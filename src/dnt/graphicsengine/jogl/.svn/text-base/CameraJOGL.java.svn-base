package dnt.graphicsengine.jogl;

import dnt.graphicsengine.interfaces.Camera;

/**
 * Manage a CameraJOGL
 * @author Sh1fT
 *
 */
public class CameraJOGL implements Camera {
	private Double xPos;
    private Double yPos;
    private Double zPos;
    private Double xTargetPos;
    private Double yTargetPos;
    private Double zTargetPos;
    private Double pitch;
	private Double yaw;

	/**
	 * Create a new CameraJOGL instance
	 */
	public CameraJOGL() {
		this(0d, 0d, 0d, 0d, 0d, 10d);
	}

	/**
	 * Create a new CameraJOGL instance
	 * @param xPos
	 * @param yPos
	 * @param zPos
	 * @param xTargetPos
	 * @param yTargetPos
	 * @param zTargetPos
	 */
	public CameraJOGL(Double xPos, Double yPos, Double zPos, Double xTargetPos, Double yTargetPos, Double zTargetPos) {
		this.setxPos(xPos);
		this.setyPos(yPos);
		this.setzPos(zPos);
		this.setxTargetPos(xTargetPos);
		this.setyTargetPos(yTargetPos);
		this.setzTargetPos(zTargetPos);
		this.setPitch(0d);
		this.setYaw(0d);
		// initialize the camera's view
		this.yawLeft(2.35d);
		this.pitchDown(.3d);
		this.moveForward(-30d);
		this.look(10d);
    }

    public Double getxPos() {
		return xPos;
	}

    public void setxPos(Double xPos) {
		this.xPos = xPos;
	}

    public Double getyPos() {
		return yPos;
	}

    public void setyPos(Double yPos) {
		this.yPos = yPos;
	}

    public Double getzPos() {
		return zPos;
	}

    public void setzPos(Double zPos) {
		this.zPos = zPos;
	}

    public Double getxTargetPos() {
		return xTargetPos;
	}

    public void setxTargetPos(Double xTargetPos) {
		this.xTargetPos = xTargetPos;
	}

    public Double getyTargetPos() {
		return yTargetPos;
	}

    public void setyTargetPos(Double yTargetPos) {
		this.yTargetPos = yTargetPos;
	}

    public Double getzTargetPos() {
		return zTargetPos;
	}

    public void setzTargetPos(Double zTargetPos) {
		this.zTargetPos = zTargetPos;
	}

    public Double getPitch() {
		return pitch;
	}

    public void setPitch(Double pitch)
    {
    	this.pitch = pitch;
    }

    public Double getYaw() {
		return yaw;
	}

    public void setYaw(Double yaw) {
    	this.yaw = yaw;
    }

    @Override
    public void updatePosition(Double xPos, Double yPos, Double zPos) {
        this.setxPos(xPos);
        this.setyPos(yPos);
        this.setzPos(zPos);
    }

    @Override
    public void lookPosition(Double xTargetPos, Double yTargetPos, Double zTargetPos) {
    	this.setxTargetPos(xTargetPos);
    	this.setyTargetPos(yTargetPos);
    	this.setzTargetPos(zTargetPos);
    }

    @Override
    public void moveForward(Double magnitude) {
    	Double xCurrent = this.getxPos();
    	Double yCurrent = this.getyPos();
    	Double zCurrent = this.getzPos();
    	Double xMovement = magnitude * Math.cos(this.getPitch()) * Math.cos(this.getYaw()); 
    	Double yMovement = magnitude * Math.sin(this.getPitch());
    	Double zMovement = magnitude * Math.cos(this.getPitch()) * Math.sin(this.getYaw());
    	Double xNew = xCurrent + xMovement;
    	Double yNew = yCurrent + yMovement;
    	Double zNew = zCurrent + zMovement;
    	System.out.printf("xPos........%5.5f\tyPos........%5.5f\tzPos........%5.5f\n",
    			this.getxPos(), this.getyPos(), this.getzPos());
        System.out.printf("xMovement...%5.5f\tyMovement...%5.5f\tzMovement...%5.5f\n",
        		xMovement, yMovement, zMovement);
        System.out.printf("xNew........%5.5f\tyNew........%5.5f\tzNew........%5.5f\n\n",
        		xNew, yNew, zNew);
        this.updatePosition(xNew, yNew, zNew);
    }

    @Override
    public void strafeLeft(Double magnitude) {
    	Double pitchTemp = this.getPitch();
        this.setPitch(0d);
        this.setYaw(this.getYaw()-.5d*Math.PI);
        this.moveForward(magnitude);
        this.setPitch(pitchTemp);
        this.setYaw(this.getYaw()+.5d*Math.PI);
    }

    @Override
    public void strafeRight(Double magnitude) {
        Double pitchTemp = this.getPitch();
        this.setPitch(0d);
        this.setYaw(this.getYaw()+.5d*Math.PI);
        this.moveForward(magnitude);
        this.setPitch(pitchTemp);
        this.setYaw(this.getYaw()-.5d*Math.PI);
    }

    @Override
    public void frontShiftingUp(Double magnitude) {
        Double yawTemp = this.getYaw();
        this.setYaw(0d);
        this.setPitch(this.getPitch()+.5d*Math.PI);
        this.moveForward(magnitude);
        this.setPitch(this.getPitch()-.5d*Math.PI);
        this.setYaw(yawTemp);
    }

    @Override
    public void frontShiftingDown(Double magnitude) {
    	Double yawTemp = this.getYaw();
    	this.setYaw(0d);
    	this.setPitch(this.getPitch()-.5d*Math.PI);
        this.moveForward(magnitude);
        this.setPitch(this.getPitch()+.5d*Math.PI);
        this.setYaw(yawTemp);
    }

    @Override
    public void look(Double distanceAway) {
    	System.out.printf("pitch.......%5.5f\n", this.getPitch());
        if (this.getPitch() > 1d)
        	this.setPitch(.99d);
        else if (this.getPitch() < -1d)
        	this.setPitch(-.99d);
        this.moveForward(distanceAway);
        Double xLook = this.getxPos();
        Double yLook = this.getyPos();
        Double zLook = this.getzPos();
        this.moveForward(-distanceAway);
        this.lookPosition(xLook, yLook, zLook);
    }

    @Override
    public void pitchUp(Double amount) {
    	this.setPitch(this.getPitch()+amount);
    }

    @Override
    public void pitchDown(Double amount) {
    	this.setPitch(this.getPitch()-amount);
    }

    @Override
    public void yawRight(Double amount) {
    	this.setYaw(this.getYaw()+amount);
    }

    @Override
    public void yawLeft(Double amount) {
    	this.setYaw(this.getYaw()-amount);
    }
}