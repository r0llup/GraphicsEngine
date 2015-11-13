package dnt.graphicsengine.jogl.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.nio.FloatBuffer;

import javax.media.opengl.GL2;

import com.jogamp.common.nio.Buffers;
import com.jogamp.opengl.util.Animator;

import dnt.graphicsengine.jogl.GraphicsEngineJOGL;
import dnt.graphicsengine.jogl.objects.simpleobjects.SquareJOGL;

/**
 * Manage a WindowZoomListener
 * @author Sh1fT
 *
 */
public class WindowZoomListenerJOGL  implements MouseListener, MouseMotionListener, KeyListener {
	private GraphicsEngineJOGL parent;
	private Integer view;
	private GraphicsEngineListenerJOGL graphicsEngineListener;
	private Camera2DListenerJOGL camera2DListener;
	protected Animator animator;
	protected Integer numMouse;
	protected SquareJOGL selectionArea;
	protected Boolean shiftPressed;

	/**
	 * Create new WindowZoomListener instance
	 * @param parent
	 * @param view
	 */
	public WindowZoomListenerJOGL(GraphicsEngineJOGL parent, Integer view) {
		this.setParent(parent);
		this.setView(view);
		this.setGraphicsEngineListener(this.getParent().getGraphicsEngineListener().get(this.getView()));
		this.setCamera2DListener(this.getParent().getCamera2DListener().get(this.getView()-1));
		this.setAnimator(this.getParent().getAnimators().get(this.getView()));
		this.setNumMouse(MouseEvent.NOBUTTON);
		this.setSelectionArea(new SquareJOGL());
		this.getSelectionArea().setSize(2f);
		this.setShiftPressed(false);
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

	public GraphicsEngineListenerJOGL getGraphicsEngineListener() {
		return graphicsEngineListener;
	}

	public void setGraphicsEngineListener(
			GraphicsEngineListenerJOGL graphicsEngineListener) {
		this.graphicsEngineListener = graphicsEngineListener;
	}

	public Camera2DListenerJOGL getCamera2DListener() {
		return camera2DListener;
	}

	public void setCamera2DListener(Camera2DListenerJOGL camera2dListener) {
		camera2DListener = camera2dListener;
	}

	public Animator getAnimator() {
		return animator;
	}

	public void setAnimator(Animator animator) {
		this.animator = animator;
	}

	public Integer getNumMouse() {
		return numMouse;
	}

	public void setNumMouse(Integer numMouse) {
		this.numMouse = numMouse;
	}

	public SquareJOGL getSelectionArea() {
		return selectionArea;
	}

	public void setSelectionArea(SquareJOGL selectionArea) {
		this.selectionArea = selectionArea;
	}

	public Boolean getShiftPressed() {
		return shiftPressed;
	}

	public void setShiftPressed(Boolean shiftPressed) {
		this.shiftPressed = shiftPressed;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Double realy = 0d;
	    double wcoord[] = new double[4];
		if (this.getShiftPressed()) {
			switch (this.getNumMouse()) {
				case MouseEvent.BUTTON1:
					realy = this.getGraphicsEngineListener().getViewport()[3] - (double) e.getY();
					FloatBuffer realz = Buffers.newDirectFloatBuffer(1);
					this.getGraphicsEngineListener().getGl2().glReadPixels(e.getX(), realy.intValue(),
							1, 1, GL2.GL_DEPTH_COMPONENT, GL2.GL_FLOAT, realz);
					System.out.println("Coordinates at cursor are (" + e.getX() + ", " + realy + ")");
					this.getGraphicsEngineListener().getGlu().gluUnProject(e.getX(), realy, realz.get(),
							this.getGraphicsEngineListener().getMvmatrix(), 0, this.getGraphicsEngineListener().getProjmatrix(),
							0, this.getGraphicsEngineListener().getViewport(), 0, wcoord, 0);
					System.out.println("World coords are (" + wcoord[0] + ", " + wcoord[1] + ", " + wcoord[2] + ")");
					Double x = wcoord[0]; //(e.getX()-(this.getGraphicsEngineListener().getWidth()/2d)) / this.getCamera2DListener().getZoom();
					Double y = wcoord[1]; //(e.getY()-(this.getGraphicsEngineListener().getHeight()/2d)) / this.getCamera2DListener().getZoom();
					Double z = wcoord[2];
					switch (this.getView()) {
						case 1:
							this.getSelectionArea().getPosition3().setY(y); //-y
							this.getSelectionArea().getPosition4().setY(y); //-y
							this.getSelectionArea().getPosition2().setZ(z); //x
							this.getSelectionArea().getPosition3().setZ(z); //x
							break;
						case 2:
							this.getSelectionArea().getPosition2().setX(x);
							this.getSelectionArea().getPosition3().setX(x);
							this.getSelectionArea().getPosition3().setZ(z); //y
							this.getSelectionArea().getPosition4().setZ(z); //y
							break;
						case 3:
							this.getSelectionArea().getPosition2().setX(x);
							this.getSelectionArea().getPosition3().setX(x);
							this.getSelectionArea().getPosition3().setY(y); //-y
							this.getSelectionArea().getPosition4().setY(y); //-y
							break;
						default:
							break;
					}
				default:
					break;
			}
		}
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Double realy = 0d;
	    double wcoord[] = new double[4];
		if (this.getShiftPressed()) {
			switch (e.getButton()) {
				case MouseEvent.BUTTON1:
					if (this.getNumMouse().equals(MouseEvent.NOBUTTON)) {
						this.runAnimator();
						this.setNumMouse(e.getButton());
						this.getParent().getSceneManagerJOGL().getScene().addObject(this.getSelectionArea());
						realy = this.getGraphicsEngineListener().getViewport()[3] - (double) e.getY();
						FloatBuffer realz = Buffers.newDirectFloatBuffer(1);
						this.getGraphicsEngineListener().getGl2().glReadPixels(e.getX(), realy.intValue(),
								1, 1, GL2.GL_DEPTH_COMPONENT, GL2.GL_FLOAT, realz);
						System.out.println("Coordinates at cursor are (" + e.getX() + ", " + realy + ")");
						this.getGraphicsEngineListener().getGlu().gluUnProject(e.getX(), realy, realz.get(),
								this.getGraphicsEngineListener().getMvmatrix(), 0, this.getGraphicsEngineListener().getProjmatrix(),
								0, this.getGraphicsEngineListener().getViewport(), 0, wcoord, 0);
						System.out.println("World coords are (" + wcoord[0] + ", " + wcoord[1] + ", " + wcoord[2] + ")");
						Double x = wcoord[0]; //(e.getX()-(this.getGraphicsEngineListener().getWidth()/2d)) / this.getCamera2DListener().getZoom();
						Double y = wcoord[1]; //(e.getY()-(this.getGraphicsEngineListener().getHeight()/2d)) / this.getCamera2DListener().getZoom();
						Double z = wcoord[2];
						switch (this.getView()) {
							case 1:
								this.getSelectionArea().getPosition1().setY(y);
								this.getSelectionArea().getPosition2().setY(y);
								this.getSelectionArea().getPosition1().setZ(z);
								this.getSelectionArea().getPosition4().setZ(z);
								break;
							case 2:
								this.getSelectionArea().getPosition1().setX(x);
								this.getSelectionArea().getPosition4().setX(x);
								this.getSelectionArea().getPosition1().setZ(z); //y
								this.getSelectionArea().getPosition2().setZ(z); //y
								break;
							case 3:
								this.getSelectionArea().getPosition1().setX(x);
								this.getSelectionArea().getPosition4().setX(x);
								this.getSelectionArea().getPosition1().setY(y); //-y
								this.getSelectionArea().getPosition2().setY(y); //-y
								break;
							default:
								break;
						}
					}
					break;
				default:
					break;
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (this.getNumMouse().equals(e.getButton())) {
			this.getCamera2DListener().setZoom(this.getCamera2DListener().getZoom()+15f);
			this.setNumMouse(MouseEvent.NOBUTTON);
			this.getParent().getSceneManagerJOGL().getScene().removeObject(this.getSelectionArea());
			this.getAnimator().pause();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_SHIFT:
				this.setShiftPressed(true);
				break;
			default:
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_SHIFT:
				this.setShiftPressed(false);
				break;
			default:
				break;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	/**
	 * Run the animator
	 */
	public void runAnimator() {
		if (!this.getAnimator().isStarted())
			this.getAnimator().start();
		else if (this.getAnimator().isPaused())
			this.getAnimator().resume();
	}
}