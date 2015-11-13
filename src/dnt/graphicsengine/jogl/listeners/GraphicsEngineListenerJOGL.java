package dnt.graphicsengine.jogl.listeners;

import java.awt.Color;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

import com.jogamp.common.nio.Buffers;
import dnt.graphicsengine.common.Position3D;
import dnt.graphicsengine.common.Views;
import dnt.graphicsengine.interfaces.ComplexObject;
import dnt.graphicsengine.interfaces.Object;
import dnt.graphicsengine.interfaces.SimpleObject;
import dnt.graphicsengine.interfaces.UntexturedSimpleObject;
import dnt.graphicsengine.jogl.GraphicsEngineJOGL;
import dnt.graphicsengine.jogl.SceneJOGL;
import dnt.graphicsengine.jogl.objects.simpleobjects.PointJOGL;

/**
 * Manage a GraphicsEngineListener
 * @author Sh1fT
 *
 */
public class GraphicsEngineListenerJOGL implements GLEventListener {
	private GraphicsEngineJOGL parent;
	private Integer view;
	private SceneJOGL scene;
	private Camera2DListenerJOGL camera2DListener;
	private Camera3DListenerJOGL camera3DListener;
	private PickingListenerJOGL pickingListener;
	private LightListenerJOGL lightListener;
	private TextureListenerJOGL textureListener;
	private Float aspect;
	private Integer width;
	private Integer height;
	private GLU glu;
	private int viewport[];
	private double mvmatrix[];
	private double projmatrix[];
	private GL2 gl2;
	private Float bgColor[];

	/**
	 * Create a new GraphicsEngineListener instance
	 * @param parent
	 * @param view
	 */
	public GraphicsEngineListenerJOGL(GraphicsEngineJOGL parent, Integer view) {
		this.setParent(parent);	
		this.setView(view);
		this.setScene(this.getParent().getSceneManagerJOGL().getScene());
		this.setCamera2DListener(null);
		this.setCamera3DListener(null);
		this.setPickingListener(null);
		this.setLightListener(parent.getLightListener().get(this.getView()));
		this.setTextureListener(parent.getTextureListener().get(this.getView()));
		this.setAspect(0f);
		this.setWidth(0);
		this.setHeight(0);
	    this.setGlu(new GLU());
	    this.setViewport(new int[4]);
	    this.setMvmatrix(new double[16]);
	    this.setProjmatrix(new double[16]);
	    this.setGl2(null);
	    this.setBgColor(new Float[] {0f, 0f, .15f, .5f});
	}

	public GraphicsEngineJOGL getParent() {
		return parent;
	}

	public void setParent(GraphicsEngineJOGL parent) {
		this.parent = parent;
	}

	public Integer getView() {
		return view;
	}

	public void setView(Integer view) {
		this.view = view;
	}

	public SceneJOGL getScene() {
		return scene;
	}

	public void setScene(SceneJOGL scene) {
		this.scene = scene;
	}

	public Camera2DListenerJOGL getCamera2DListener() {
		return camera2DListener;
	}

	public void setCamera2DListener(Camera2DListenerJOGL camera2dListener) {
		camera2DListener = camera2dListener;
	}

	public Camera3DListenerJOGL getCamera3DListener() {
		return camera3DListener;
	}

	public void setCamera3DListener(Camera3DListenerJOGL camera3dListener) {
		camera3DListener = camera3dListener;
	}

	public PickingListenerJOGL getPickingListener() {
		return pickingListener;
	}

	public void setPickingListener(PickingListenerJOGL pickingListener) {
		this.pickingListener = pickingListener;
	}

	public LightListenerJOGL getLightListener() {
		return lightListener;
	}

	public void setLightListener(LightListenerJOGL lightListener) {
		this.lightListener = lightListener;
	}

	public TextureListenerJOGL getTextureListener() {
		return textureListener;
	}

	public void setTextureListener(TextureListenerJOGL textureListener) {
		this.textureListener = textureListener;
	}

	public Float getAspect() {
		return aspect;
	}

	public void setAspect(Float aspect) {
		this.aspect = aspect;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public GLU getGlu() {
		return glu;
	}

	public void setGlu(GLU glu) {
		this.glu = glu;
	}

	public int[] getViewport() {
		return viewport;
	}

	public void setViewport(int[] viewport) {
		this.viewport = viewport;
	}

	public double[] getMvmatrix() {
		return mvmatrix;
	}

	public void setMvmatrix(double[] mvmatrix) {
		this.mvmatrix = mvmatrix;
	}

	public double[] getProjmatrix() {
		return projmatrix;
	}

	public void setProjmatrix(double[] projmatrix) {
		this.projmatrix = projmatrix;
	}

	public GL2 getGl2() {
		return gl2;
	}

	public void setGl2(GL2 gl2) {
		this.gl2 = gl2;
	}

	public Float[] getBgColor() {
		return bgColor;
	}

	public void setBgColor(Float[] bgColor) {
		this.bgColor = bgColor;
	}

	/**
	 * Called by the drawable immediately after the OpenGL context is
     * initialized for the first time. Can be used to perform one-time OpenGL
     * initialization such as setup of lights and display lists.
	 * @param drawable The GLAutoDrawable object.
	 */
	@Override
	public void init(GLAutoDrawable drawable) {
		this.setGl2(drawable.getGL().getGL2());
    	this.getGl2().glClearColor(this.getBgColor()[0], this.getBgColor()[1],
    			this.getBgColor()[2], this.getBgColor()[3]);
    	this.getGl2().glEnable(GL2.GL_NORMALIZE);
    	//this.getGl2().glEnable(GL2.GL_MAP2_NORMAL); 
    	
	    if (this.getView().equals(Views.PERSPECTIVE)) {
	    	this.getGl2().glEnable(GL2.GL_DEPTH_TEST);
	    	this.getGl2().glShadeModel(GL2.GL_SMOOTH);
	    	this.getGl2().glDepthFunc(GL2.GL_LEQUAL);
	    	this.getGl2().glClearDepth(1f);
	    	this.getGl2().glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST);
//	    	this.getGl2().glEnable(GL2.GL_ALPHA_TEST);
//	    	this.getGl2().glAlphaFunc(GL2.GL_GREATER, 0); // only render if alpha > 0
	        
	    	// setup the light
	    	for (Integer i=0; i < 1; i++) {
	    		this.getGl2().glLightfv(GL2.GL_LIGHT0+i, GL2.GL_POSITION,
    		    		this.getLightListener().getLight().get(i).getPosition(), 0);
	    		this.getGl2().glLightfv(GL2.GL_LIGHT0+i, GL2.GL_AMBIENT,
	    				this.getLightListener().getLight().get(i).getAmbient(), 0);
	    		this.getGl2().glLightfv(GL2.GL_LIGHT0+i, GL2.GL_DIFFUSE,
	    				this.getLightListener().getLight().get(i).getDiffuse(), 0);
	    		this.getGl2().glLightfv(GL2.GL_LIGHT0+i, GL2.GL_SPECULAR,
    		    		this.getLightListener().getLight().get(i).getSpecular(), 0);
	    	}
	    } else {
	    	this.getGl2().glDisable(GL2.GL_DEPTH_TEST);
	    	// setup the light
	    	this.getGl2().glLightfv(GL2.GL_LIGHT0+this.getView()-1, GL2.GL_POSITION,
		    		this.getLightListener().getLight().get(this.getView()-1).getPosition(), 0);
	    	this.getGl2().glLightfv(GL2.GL_LIGHT0+this.getView()-1, GL2.GL_AMBIENT,
	    			this.getLightListener().getLight().get(this.getView()-1).getAmbient(), 0);
	    	this.getGl2().glLightfv(GL2.GL_LIGHT0+this.getView()-1, GL2.GL_DIFFUSE,
    				this.getLightListener().getLight().get(this.getView()-1).getDiffuse(), 0);
	    	this.getGl2().glLightfv(GL2.GL_LIGHT0+this.getView()-1, GL2.GL_SPECULAR,
		    		this.getLightListener().getLight().get(this.getView()-1).getSpecular(), 0);
	    	
	    }

//	    // temp
//	    float SHINE_ALL_DIRECTIONS = 1;
//        float[] lightPos = {-30, 0, 0, SHINE_ALL_DIRECTIONS};
//        float[] lightColorAmbient = {0.2f, 0.2f, 0.2f, 1f};
//        float[] lightColorSpecular = {0.8f, 0.8f, 0.8f, 1f};
//
//        // Set light parameters.
//        this.getGl2().glLightfv(GL2.GL_LIGHT0, GL2.GL_POSITION, lightPos, 0);
//        this.getGl2().glLightfv(GL2.GL_LIGHT0, GL2.GL_AMBIENT, lightColorAmbient, 0);
//        this.getGl2().glLightfv(GL2.GL_LIGHT0, GL2.GL_SPECULAR, lightColorSpecular, 0);
//
//        // Enable lighting in GL.
//        this.getGl2().glEnable(GL2.GL_LIGHT0);
//        this.getGl2().glEnable(GL2.GL_LIGHTING);
//        
//        // Set material properties.
//        float[] rgba = {0.3f, 0.5f, 1f};
//        this.getGl2().glMaterialfv(GL2.GL_FRONT, GL2.GL_AMBIENT, rgba, 0);
//        this.getGl2().glMaterialfv(GL2.GL_FRONT, GL2.GL_SPECULAR, rgba, 0);
//        this.getGl2().glMaterialf(GL2.GL_FRONT, GL2.GL_SHININESS, 0.5f);
//        // temp/
	}

	/**
	 * Called by the drawable during the first repaint after the component has
	 * been resized. The client can update the viewport and view volume of the
	 * window appropriately, for example by a call to
	 * GL.glViewport(int, int, int, int); note that for convenience the component
	 * has already called GL.glViewport(int, int, int, int)(x, y, width, height)
	 * when this method is called, so the client may not have to do anything in
	 * this method.
	 * @param drawable The GLAutoDrawable object.
	 * @param x The X Coordinate of the viewport rectangle.
	 * @param y The Y coordinate of the viewport rectanble.
	 * @param width The new width of the window.
	 * @param height The new height of the window.
	 */
	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		this.setGl2(drawable.getGL().getGL2());
		this.setWidth(width);
		this.setHeight((height <= 0) ? 1 : height);
		this.setAspect((float) this.getWidth() / this.getHeight());
		this.getGl2().glViewport(0, 0, this.getWidth(), this.getHeight());
		this.getGl2().glMatrixMode(GL2.GL_PROJECTION);
		this.getGl2().glLoadIdentity();
		if (this.getView().equals(Views.PERSPECTIVE)) {
			this.getGlu().gluPerspective(45f, this.getAspect(), .01f, 100000f); //FIXME
			this.getGlu().gluLookAt(0d, 0d, 512d, 0d, 0d, 0d, 0d, 1d, 0d); //FIXME
			this.getCamera3DListener().getTranslate3().setX(this.getWidth()/2d);
	    	this.getCamera3DListener().getTranslate3().setY(this.getHeight()/2d);
		} else {
			this.getGl2().glOrtho(0d, this.getWidth(), 0d, this.getHeight(), -100000d, 100000d); //FIXME
			if (this.getView().equals(Views.FRONT))
				this.getGl2().glRotated(90d, 0d, 1d, 0d);
			else if (this.getView().equals(Views.TOP))
				this.getGl2().glRotated(90d, 1d, 0d, 0d);
			this.getCamera2DListener().getTranslate3().setX(this.getWidth()/2d);
	    	this.getCamera2DListener().getTranslate3().setY(-this.getHeight()/2d);
		}
		this.getGl2().glMatrixMode(GL2.GL_MODELVIEW);
		this.getGl2().glLoadIdentity();
	}

	/**
	 * Called by the drawable to initiate OpenGL rendering by the client.
     * After all GLEventListeners have been notified of a display event, the
     * drawable will swap its buffers if necessary.
	 * @param drawable The GLAutoDrawable object.
	 */
	@Override
	public void display(GLAutoDrawable drawable) {
		this.setGl2(drawable.getGL().getGL2());
		Position3D rotatePos = new Position3D();
	    Double realy = 0d;
	    double wcoord[] = new double[4];
		this.getGl2().glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
		this.getGl2().glMatrixMode(GL2.GL_MODELVIEW);
		this.getGl2().glPushMatrix();
		this.getGl2().glLoadIdentity();
		this.getGl2().glGetIntegerv(GL2.GL_VIEWPORT, this.getViewport(), 0);
		this.getGl2().glGetDoublev(GL2.GL_MODELVIEW_MATRIX, this.getMvmatrix(), 0);
		this.getGl2().glGetDoublev(GL2.GL_PROJECTION_MATRIX, this.getProjmatrix(), 0);
		if (this.getView().equals(Views.PERSPECTIVE)) {
			realy = this.getViewport()[3] - this.getCamera3DListener().getTranslate3().getY();
			FloatBuffer realzbuff = Buffers.newDirectFloatBuffer(1);
			this.getGl2().glReadPixels(this.getCamera3DListener().getTranslate3().getX().intValue(),
					realy.intValue(), 1, 1, GL2.GL_DEPTH_COMPONENT, GL2.GL_FLOAT, realzbuff);
			Float realz = realzbuff.get();
			System.out.println("Coordinates at cursor are (" + this.getCamera3DListener().getTranslate3().getX() + ", " +
					+ realy + ", " + realz + ")");
			this.getGlu().gluUnProject(this.getCamera3DListener().getTranslate3().getX(), realy, realz,
					this.getMvmatrix(), 0, this.getProjmatrix(), 0, this.getViewport(), 0, wcoord, 0);
			System.out.println("World coords are " + wcoord[0] + ", " + wcoord[1] + ", " + wcoord[2] + ")");
			this.getGl2().glTranslated(wcoord[0], wcoord[1], wcoord[2]);
			this.getGl2().glScalef(this.getCamera3DListener().getZoom(), this.getCamera3DListener().getZoom(),
					this.getCamera3DListener().getZoom());
			for (Object o : this.getScene().getObjects()) {
				if (o instanceof PointJOGL) {
					if (((PointJOGL) o).getSelectionColor() != null) {
						rotatePos = ((PointJOGL) o).getPosition();
						break;
					}
	        	}
			}
			this.getGl2().glRotated(this.getCamera3DListener().getAngleY(), 1d, 0d, 0d);
			this.getGl2().glRotated(this.getCamera3DListener().getAngleX(), 0d, 1d, 0d);
			this.getGl2().glTranslated(-rotatePos.getX(), -rotatePos.getY(), -rotatePos.getZ());
	 		Integer cpt = 0;
	 		for (Integer i=0; i < 3; i++) {
	 			if (this.getLightListener().getLight().get(i).isTurnedOn()) {
	 				this.getGl2().glEnable(GL2.GL_LIGHT0+i);
	 				cpt++;
	 			} else {
	 				this.getGl2().glDisable(GL2.GL_LIGHT0+i);
	 				cpt--;
	 			}
	 		}
	 		if (cpt >= 0)
	 			this.getGl2().glEnable(GL2.GL_LIGHTING);
	 		else
	 			this.getGl2().glDisable(GL2.GL_LIGHTING);
		}
		else {
			Double x = this.getCamera2DListener().getTranslate3().getX();
			Double y = this.getCamera2DListener().getTranslate3().getY();
			if (this.getView().equals(Views.FRONT))
				this.getGl2().glTranslated(0d, -y, x);
			else if (this.getView().equals(Views.TOP))
				this.getGl2().glTranslated(x, 0d, y);
			else
				this.getGl2().glTranslated(x, -y, 0d);
			this.getGl2().glScalef(this.getCamera2DListener().getZoom(), this.getCamera2DListener().getZoom(),
					this.getCamera2DListener().getZoom());
			if (this.getLightListener().getLight().get(this.getView()-1).isTurnedOn()) {
				this.getGl2().glEnable(GL2.GL_LIGHT0+this.getView()-1);
				this.getGl2().glEnable(GL2.GL_LIGHTING);
			} else {
				this.getGl2().glDisable(GL2.GL_LIGHT0+this.getView()-1);
				this.getGl2().glDisable(GL2.GL_LIGHTING);
			}
		}
		if (this.getTextureListener().getTurnedOn())
			this.getGl2().glEnable(GL2.GL_TEXTURE_2D);
		else
			this.getGl2().glDisable(GL2.GL_TEXTURE_2D);
		this.drawObj(GL2.GL_RENDER);
		if (this.getPickingListener().getPickPoint() != null) {
			this.pickObj();
			this.getPickingListener().setPickPoint(null);
		}
		this.getGl2().glFlush();
		this.getGl2().glPopMatrix();
	}

	@Override
	public void dispose(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
	}

	/**
	 * Draw objects
	 * @param mode
	 */
	private void drawObj(Integer mode) {
		switch (mode) {
			case GL2.GL_SELECT:
				for (Object o : this.getScene().getObjects()) {
					if (o instanceof PointJOGL) {
						this.getGl2().glPushName(Integer.valueOf(((PointJOGL) o).getId()));
						this.fetchObj(o);
						this.getGl2().glPopName();
					}
				}
				break;
			case GL2.GL_RENDER:
				for (Object o : this.getScene().getObjects())
					this.fetchObj(o);
				break;
			default:
				break;
		}
	}

	/**
	 * Fetch objects
	 * @param obj
	 */
	private void fetchObj(Object obj) {
		if (obj instanceof SimpleObject) {
			if (obj instanceof UntexturedSimpleObject) {
				UntexturedSimpleObject uso = (UntexturedSimpleObject) obj;
		        float[] rgba = {uso.getColor().getRed()/255f, uso.getColor().getGreen()/255f, uso.getColor().getBlue()/255f};
		        if (this.getView().equals(Views.PERSPECTIVE)) {
		        	Integer cpt = 0;
			 		for (Integer i=0; i < 3; i++) {
			 			if (this.getLightListener().getLight().get(i).isTurnedOn())
			 				cpt++;
			 			else
			 				cpt--;
			 		}
			 		if (cpt >= 0) {
			 			this.getGl2().glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT, rgba, 0);
			 			this.getGl2().glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, rgba, 0);
			 			this.getGl2().glMaterialf(GL2.GL_FRONT_AND_BACK, GL2.GL_SHININESS, .5f);
			 		}
		        } else {
			        if (this.getLightListener().getLight().get(this.getView()-1).isTurnedOn()) {
			        	this.getGl2().glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT, rgba, 0);
			        	this.getGl2().glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, rgba, 0);
			        	this.getGl2().glMaterialf(GL2.GL_FRONT_AND_BACK, GL2.GL_SHININESS, .5f);
			        }
		        }
			}
			if (!obj.isHidden())
				((SimpleObject) obj).draw(this.getGl2(), this.getView());
		} else if (obj instanceof ComplexObject) {
			for (Object o : ((ComplexObject) obj).getChildren())
				this.fetchObj(o);
		}
	}

	/**
	 * Pickup objects
	 */
	private void pickObj() {
	    int selectBuf[] = new int[this.getPickingListener().getBufferSize()];
	    IntBuffer selectBuffer = Buffers.newDirectIntBuffer(this.getPickingListener().getBufferSize());
	    Integer hits;
	    this.getGl2().glSelectBuffer(this.getPickingListener().getBufferSize(), selectBuffer);
	    this.getGl2().glRenderMode(GL2.GL_SELECT);
	    this.getGl2().glMatrixMode(GL2.GL_PROJECTION);
	    this.getGl2().glPushMatrix();
	    this.getGl2().glLoadIdentity();
	    this.getGl2().glGetIntegerv(GL2.GL_VIEWPORT, this.getViewport(), 0);
	    this.getGlu().gluPickMatrix(this.getPickingListener().getPickPoint().getX(),
    		this.getViewport()[3]-this.getPickingListener().getPickPoint().getY(), 25d, 25d, this.getViewport(), 0);
	    if (this.getView().equals(Views.PERSPECTIVE)) {
	    	this.getGlu().gluPerspective(45f, this.getAspect(), .01f, 100000f); //FIXME
			this.getGlu().gluLookAt(0d, 0d, 512d, 0d, 0d, 0d, 0d, 1d, 0d); //FIXME
		} else {
			this.getGl2().glOrtho(0d, this.getWidth(), 0d, this.getHeight(), -100000d, 100000d); //FIXME
			if (this.getView().equals(Views.FRONT))
				this.getGl2().glRotated(-90d, 0d, 1d, 0d);
			else if (this.getView().equals(Views.TOP))
				this.getGl2().glRotated(90d, 1d, 0d, 0d);
		}
	    this.getGl2().glMatrixMode(GL2.GL_MODELVIEW);
	    this.getGl2().glInitNames();
	    this.drawObj(GL2.GL_SELECT);
	    this.getGl2().glMatrixMode(GL2.GL_PROJECTION);
	    this.getGl2().glPopMatrix();
	    this.getGl2().glMatrixMode(GL2.GL_MODELVIEW);
	    this.getGl2().glFlush();
	    hits = this.getGl2().glRenderMode(GL2.GL_RENDER);
	    if (hits != 0) {
	    	selectBuffer.get(selectBuf);
	    	this.processHits(hits, selectBuf);
	    }
	}

	/**
	 * Process hits
	 * @param hits
	 * @param buffer
	 */
	private void processHits(Integer hits, int buffer[]) {
	    Integer names;
	    Integer ptr = 0;
	    System.out.println("hits = " + hits);
	    for (Integer i=0; i < hits; i++) {
	      names = buffer[ptr];
	      System.out.println("number of names for this hit = " + names);
	      ptr++;
	      System.out.println("z1 is " + buffer[ptr]);
	      ptr++;
	      System.out.println("z2 is " + buffer[ptr]);
	      ptr++;
	      System.out.println("names are ");
	      for (Integer j=0; j < names; j++) {
	        System.out.println("" + buffer[ptr]);
	        for (Object o : this.getScene().getObjects()) {
	        	if (o instanceof PointJOGL) {
					if (Integer.valueOf(((PointJOGL) o).getId()).equals(buffer[ptr])) {
						this.getPickingListener().setSelectedPoint((PointJOGL) o);
						((PointJOGL) o).setSelectionColor(Color.YELLOW);
					} else
						((PointJOGL) o).setSelectionColor(null);
	        	}
	        }
	        ptr++;
	      }
	    }
	}
}