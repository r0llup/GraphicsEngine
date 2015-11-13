package dnt.graphicsengine.jogl.objects.simpleobjects;

import java.awt.Color;

import javax.media.opengl.GL2;

import dnt.graphicsengine.common.Position3D;

/**
 * Manage a SquareJOGL
 * @author Sh1fT
 *
 */
public class SquareJOGL extends UntexturedSimpleObjectJOGL {
	private Position3D position1;
	private Position3D position2;
	private Position3D position3;
	private Position3D position4;
	private Position3D normal;
	private Boolean fill;

	/**
	 * Create a new SquareJOGL instance
	 */
	public SquareJOGL() {
		this("0", new Position3D(0d, 0d, 0d), new Position3D(0d, 0d, 0d),
			new Position3D(0d, 0d, 0d), new Position3D(0d, 0d, 0d));
	}

	/**
	 * Create a new SquareJOGL instance
	 * @param id
	 * @param position1
	 * @param position2
	 * @param position3
	 * @param position4
	 */
	public SquareJOGL(String id, Position3D position1, Position3D position2, Position3D position3, Position3D position4) {
		this(id, position1, position2, position3, position4, Color.WHITE);
	}

	/**
	 * Create a new SquareJOGL instance
	 * @param id
	 * @param position1
	 * @param position2
	 * @param position3
	 * @param position4
	 * @param color
	 */
	public SquareJOGL(String id, Position3D position1, Position3D position2, Position3D position3, Position3D position4, Color color) {
		this(id, position1, position2, position3, position4, color, null);
	}

	/**
	 * Create a new SquareJOGL instance
	 * @param id
	 * @param position1
	 * @param position2
	 * @param position3
	 * @param position4
	 * @param color
	 * @param selectionColor
	 */
	public SquareJOGL(String id, Position3D position1, Position3D position2, Position3D position3, Position3D position4, Color color, Color selectionColor) {
		this(id, position1, position2, position3, position4, color, selectionColor, 1f);
	}

	/**
	 * Create a new SquareJOGL instance
	 * @param id
	 * @param position1
	 * @param position2
	 * @param position3
	 * @param position4
	 * @param color
	 * @param selectionColor
	 * @param size
	 */
	public SquareJOGL(String id, Position3D position1, Position3D position2, Position3D position3, Position3D position4, Color color, Color selectionColor, Float size) {
		this(id, position1, position2, position3, position4, color, selectionColor, size, false);
	}

	/**
	 * Create a new SquareJOGL instance
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
	public SquareJOGL(String id, Position3D position1, Position3D position2, Position3D position3, Position3D position4, Color color, Color selectionColor, Float size, Boolean fill) {
		this.setId(id);
		this.setPosition1(position1);
		this.setPosition2(position2);
		this.setPosition3(position3);
		this.setPosition4(position4);
		this.computeNormal();
		this.setColor(color);
		this.setSelectionColor(selectionColor);
		this.setSize(size);
		this.setFill(fill);
	}

	public Position3D getPosition1() {
		return position1;
	}

	public void setPosition1(Position3D position1) {
		this.position1 = position1;
	}

	public Position3D getPosition2() {
		return position2;
	}

	public void setPosition2(Position3D position2) {
		this.position2 = position2;
	}

	public Position3D getPosition3() {
		return position3;
	}

	public void setPosition3(Position3D position3) {
		this.position3 = position3;
	}

	public Position3D getPosition4() {
		return position4;
	}

	public void setPosition4(Position3D position4) {
		this.position4 = position4;
	}
	
	/**
	 * @return the normal
	 */
	public Position3D getNormal() {
		return normal;
	}

	/**
	 * @param normal the normal to set
	 */
	public void setNormal(Position3D normal) {
		this.normal = normal;
	}

	public Boolean getFill() {
		return fill;
	}

	public void setFill(Boolean fill) {
		this.fill = fill;
	}

	@Override
	public void draw(Object drawable, Integer view) {
		if (drawable instanceof GL2) {
			GL2 gl2 = (GL2) drawable;
			//gl2.glBlendFunc( GL2.GL_SRC_ALPHA , GL2.GL_DST_COLOR); 
			gl2.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE);
			gl2.glDisable(GL2.GL_DEPTH_TEST);
			gl2.glEnable(GL2.GL_BLEND);
			
			if (this.getSelectionColor() == null)
				gl2.glColor4d(this.getColor().getRed()/255d, this.getColor().getGreen()/255d, this.getColor().getBlue()/255d, 0.8d);
			else
				gl2.glColor4d(this.getSelectionColor().getRed()/255d, this.getSelectionColor().getGreen()/255d, this.getSelectionColor().getBlue()/255d, 0.8d);
			gl2.glLineWidth(this.getSize());
			if (this.getFill())
				gl2.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
			else
				gl2.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);
						
			gl2.glBegin(GL2.GL_QUADS);
			gl2.glNormal3d(this.getNormal().getX(), this.getNormal().getY(), this.getNormal().getZ());
			gl2.glVertex3d(this.getPosition1().getX(), this.getPosition1().getY(), this.getPosition1().getZ());
			gl2.glVertex3d(this.getPosition2().getX(), this.getPosition2().getY(), this.getPosition2().getZ());
			gl2.glVertex3d(this.getPosition3().getX(), this.getPosition3().getY(), this.getPosition3().getZ());
			gl2.glVertex3d(this.getPosition4().getX(), this.getPosition4().getY(), this.getPosition4().getZ());
			
			gl2.glEnd();
			gl2.glEnable(GL2.GL_DEPTH_TEST);
			gl2.glDisable(GL2.GL_BLEND);
		}
	}

	@Override
	public void move(Double xDisp, Double yDisp, Double zDisp) {
		this.getPosition1().setX(this.getPosition1().getX()+xDisp);
		this.getPosition1().setY(this.getPosition1().getY()+yDisp);
		this.getPosition1().setZ(this.getPosition1().getZ()+zDisp);
		this.getPosition2().setX(this.getPosition2().getX()+xDisp);
		this.getPosition2().setY(this.getPosition2().getY()+yDisp);
		this.getPosition2().setZ(this.getPosition2().getZ()+zDisp);
		this.getPosition3().setX(this.getPosition3().getX()+xDisp);
		this.getPosition3().setY(this.getPosition3().getY()+yDisp);
		this.getPosition3().setZ(this.getPosition3().getZ()+zDisp);
		this.getPosition4().setX(this.getPosition4().getX()+xDisp);
		this.getPosition4().setY(this.getPosition4().getY()+yDisp);
		this.getPosition4().setZ(this.getPosition4().getZ()+zDisp);
	}
	
	private void computeNormal() {

		double n[] = new double[3];
		n = getSurfaceNormal(
				new double[] {position1.getX(), position1.getY(), position1.getZ()}, 
				new double[] {position2.getX(), position2.getY(), position2.getZ()},
				new double[] {position3.getX(), position3.getY(), position3.getZ()});
		
		this.setNormal(new Position3D(n[0], n[1], n[2]));
		
		System.out.println(n[0] + "," + n[1] + ","+ n[2]);
		//this.setNormal(new Position3D(n[1], n[2], n[0]));
		
	}
	
	 public static double[] getSurfaceNormal(double[] p1, double[] p2, double[] p3) {
	 	  
		  double[] edge1 = {p2[0] - p1[0], p2[1] - p1[1], p2[2] - p1[2]};
		  double[] edge2 = {p3[0] - p1[0], p3[1] - p1[1], p3[2] - p1[2]};
		  
		  double[] normal = computeCrossProduct(edge1, edge2);
		  
		  return normal;
	  }
	 
		public static double[] computeCrossProduct(double[] v0, double[] v1) {
			double crossProduct[] = new double[3];

			crossProduct[0] = v0[1] * v1[2] - v0[2] * v1[1];
			crossProduct[1] = v0[2] * v1[0] - v0[0] * v1[2];
			crossProduct[2] = v0[0] * v1[1] - v0[1] * v1[0];

			return crossProduct;
		}
}