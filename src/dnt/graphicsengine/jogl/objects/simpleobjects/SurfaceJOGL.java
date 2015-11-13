package dnt.graphicsengine.jogl.objects.simpleobjects;

import java.awt.Color;
import java.util.LinkedList;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLUnurbs;
import javax.media.opengl.glu.gl2.GLUgl2;

import dnt.graphicsengine.common.Position3D;

/**
 * Manage a SurfaceJOGL
 * @author Sh1fT
 *
 */
public class SurfaceJOGL extends UntexturedSimpleObjectJOGL {
	private LinkedList<Position3D> ctlArray;
	private GLUgl2 glug12;
	private GLUnurbs nurbsRenderer;

	/**
	 * Create a new SurfaceJOGL instance
	 */
	public SurfaceJOGL() {
		this("0", new LinkedList<Position3D>());
	}

	/**
	 * Create a new SurfaceJOGL instance
	 * @param id
	 * @param ctlArray
	 */
	public SurfaceJOGL(String id, LinkedList<Position3D> ctlArray) {
		this(id, ctlArray, Color.WHITE);
	}

	/**
	 * Create a new SurfaceJOGL instance
	 * @param id
	 * @param ctlArray
	 * @param color
	 */
	public SurfaceJOGL(String id, LinkedList<Position3D> ctlArray, Color color) {
		this(id, ctlArray, color, null);
	}

	/**
	 * Create a new SurfaceJOGL instance
	 * @param id
	 * @param ctlArray
	 * @param color
	 * @param selectionColor
	 */
	public SurfaceJOGL(String id, LinkedList<Position3D> ctlArray, Color color, Color selectionColor) {
		this(id, ctlArray, color, selectionColor, 1f);
	}

	/**
	 * Create a new SurfaceJOGL instance
	 * @param id
	 * @param ctlArray
	 * @param color
	 * @param selectionColor
	 * @param size
	 */
	public SurfaceJOGL(String id, LinkedList<Position3D> ctlArray, Color color, Color selectionColor, Float size) {
		this.setId(id);
		this.setCtlArray(ctlArray);
		this.setColor(color);
		this.setSelectionColor(selectionColor);
		this.setSize(size);
		this.setGlug12(new GLUgl2());
		this.setNurbsRenderer(this.getGlug12().gluNewNurbsRenderer());
	}

	public LinkedList<Position3D> getCtlArray() {
		return ctlArray;
	}

	public void setCtlArray(LinkedList<Position3D> ctlArray) {
		this.ctlArray = ctlArray;
	}

	public GLUgl2 getGlug12() {
		return glug12;
	}

	public void setGlug12(GLUgl2 glug12) {
		this.glug12 = glug12;
	}

	public GLUnurbs getNurbsRenderer() {
		return nurbsRenderer;
	}

	public void setNurbsRenderer(GLUnurbs nurbsRenderer) {
		this.nurbsRenderer = nurbsRenderer;
	}

	/**
	 * Translate a list to an array
	 * @param list
	 * @return
	 */
	private float[] toArray(LinkedList<Position3D> list) {
		float[] array = new float[this.getCtlArray().size()*3];
		Integer cpt = 0;
		for (Position3D pos : this.getCtlArray()) {
			array[cpt*3+0] = pos.getX().floatValue();
			array[cpt*3+1] = pos.getY().floatValue();
			array[cpt*3+2] = pos.getZ().floatValue();
			cpt++;
		}
		return array;
	}

	@Override
	public void draw(Object drawable, Integer view) {
		if (drawable instanceof GL2) {
			GL2 gl2 = (GL2) drawable;
			if (this.getSelectionColor() == null)
				gl2.glColor3d(this.getColor().getRed()/255d, this.getColor().getGreen()/255d, this.getColor().getBlue()/255d);
			else
				gl2.glColor3d(this.getSelectionColor().getRed()/255d, this.getSelectionColor().getGreen()/255d, this.getSelectionColor().getBlue()/255d);
			gl2.glLineWidth(this.getSize());
			this.getGlug12().gluBeginSurface(this.getNurbsRenderer());
	        Integer uknot_cnt = 8;
	        float[] uknot = new float[] {0f, 0f, 0f, 0f, 1f, 1f, 1f, 1f};
	        Integer vknot_cnt = 8;
	        float[] vknot = uknot;
	        Integer ustride = 4 * 3;
	        Integer vstride = 3;
	        Integer uorder = 4;
	        Integer vorder = 4;
	        Integer evl_type = GL2.GL_MAP2_NORMAL;
	        
	        this.getGlug12().gluNurbsSurface(this.getNurbsRenderer(), uknot_cnt, uknot, vknot_cnt, vknot, ustride,
	       		 vstride, this.toArray(this.getCtlArray()), uorder, vorder, evl_type);
	        evl_type = GL2.GL_MAP2_VERTEX_3;
	        this.getGlug12().gluNurbsSurface(this.getNurbsRenderer(), uknot_cnt, uknot, vknot_cnt, vknot, ustride,
	       		 vstride, this.toArray(this.getCtlArray()), uorder, vorder, evl_type);
	        this.getGlug12().gluEndSurface(this.getNurbsRenderer());
		}
	}

	@Override
	public void move(Double xDisp, Double yDisp, Double zDisp) {
		for (Position3D p : this.getCtlArray()) {
			p.setX(p.getX()+xDisp);
			p.setY(p.getY()+yDisp);
			p.setZ(p.getZ()+zDisp);
		}
	}
}