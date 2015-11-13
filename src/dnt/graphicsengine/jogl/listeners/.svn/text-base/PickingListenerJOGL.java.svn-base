package dnt.graphicsengine.jogl.listeners;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.jogamp.opengl.util.Animator;

import dnt.graphicsengine.common.Views;
import dnt.graphicsengine.interfaces.Object;
import dnt.graphicsengine.jogl.GraphicsEngineJOGL;
import dnt.graphicsengine.jogl.objects.complexobjects.TexturedPlaneJOGL;
import dnt.graphicsengine.jogl.objects.simpleobjects.PointJOGL;
import dnt.graphicsengine.jogl.objects.simpleobjects.TexturedSquareJOGL;

/**
 * Manage a PickingListener
 * @author Sh1fT
 *
 */
public class PickingListenerJOGL implements MouseListener, MouseMotionListener, KeyListener {
	private GraphicsEngineListenerJOGL graphicsEngineListener;
	private Integer view;
	private Camera2DListenerJOGL camera2DListener;
	protected Animator animator;
	protected Integer numMouse;
	private Point pickPoint;
	private PointJOGL selectedPoint;
	private Integer bufferSize;

	/**
	 * Create new PickingListener instance
	 * @param parent
	 * @param view
	 */
	public PickingListenerJOGL(GraphicsEngineJOGL parent, Integer view) {
		this.setGraphicsEngineListener(parent.getGraphicsEngineListener().get(view));
		this.setView(view);
		if (!this.getView().equals(Views.PERSPECTIVE))
			this.setCamera2DListener(parent.getCamera2DListener().get(view-1));
		else
			this.setCamera2DListener(null);
		this.setAnimator(parent.getAnimators().get(this.getView()));
		this.setNumMouse(MouseEvent.NOBUTTON);
		this.setPickPoint(null);
		this.setSelectedPoint(null);
		this.setBufferSize(512);
	}

	public GraphicsEngineListenerJOGL getGraphicsEngineListener() {
		return graphicsEngineListener;
	}

	public void setGraphicsEngineListener(
			GraphicsEngineListenerJOGL graphicsEngineListener) {
		this.graphicsEngineListener = graphicsEngineListener;
	}

	public Integer getView() {
		return view;
	}

	public void setView(Integer view) {
		this.view = view;
	}

	public Camera2DListenerJOGL getCamera2DListener() {
		return camera2DListener;
	}

	public void setCamera2DListener(Camera2DListenerJOGL camera2dListener) {
		camera2DListener = camera2dListener;
	}

	public Integer getNumMouse() {
		return numMouse;
	}

	public Animator getAnimator() {
		return animator;
	}

	public void setAnimator(Animator animator) {
		this.animator = animator;
	}

	public void setNumMouse(Integer numMouse) {
		this.numMouse = numMouse;
	}

	public Point getPickPoint() {
		return pickPoint;
	}

	public void setPickPoint(Point pickPoint) {
		this.pickPoint = pickPoint;
	}

	public PointJOGL getSelectedPoint() {
		return selectedPoint;
	}

	public void setSelectedPoint(PointJOGL selectedPoint) {
		this.selectedPoint = selectedPoint;
	}

	public Integer getBufferSize() {
		return bufferSize;
	}

	public void setBufferSize(Integer bufferSize) {
		this.bufferSize = bufferSize;
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
		switch (e.getButton()) {
			case MouseEvent.BUTTON2:
				if (this.getNumMouse().equals(MouseEvent.NOBUTTON)) {
					if (this.getCamera2DListener() != null)
						this.getCamera2DListener().runAnimator();
					this.setNumMouse(e.getButton());
					this.setPickPoint(e.getPoint());
					if (!this.getView().equals(Views.PERSPECTIVE)) {
						Double xDiff = (this.getPickPoint().getX()-this.getGraphicsEngineListener().getCamera2DListener().getTranslate3().getX()) /
								this.getCamera2DListener().getZoom();
						Double yDiff = (this.getPickPoint().getY()+this.getGraphicsEngineListener().getCamera2DListener().getTranslate3().getY()) /
								this.getCamera2DListener().getZoom();
						System.out.println(xDiff + ", " + yDiff);
						for (Object o : this.getGraphicsEngineListener().getScene().getObjects()) {
							if (o instanceof TexturedPlaneJOGL) {
								for (Object oo : ((TexturedPlaneJOGL) o).getObjects()) {
									if (oo instanceof TexturedSquareJOGL) {
										TexturedSquareJOGL ts = (TexturedSquareJOGL) oo;
										if (ts.getId().equals("FRONT") && this.getView().equals(Views.FRONT)) {
											ts.getPosition1().setY(ts.getPosition1().getY()+yDiff);
											ts.getPosition1().setZ(ts.getPosition1().getZ()+xDiff);
											ts.getPosition2().setY(ts.getPosition2().getY()+yDiff);
											ts.getPosition2().setZ(ts.getPosition2().getZ()+xDiff);
											ts.getPosition3().setY(ts.getPosition3().getY()+yDiff);
											ts.getPosition3().setZ(ts.getPosition3().getZ()+xDiff);
											ts.getPosition4().setY(ts.getPosition4().getY()+yDiff);
											ts.getPosition4().setZ(ts.getPosition4().getZ()+xDiff);
										} else if (ts.getId().equals("TOP") && this.getView().equals(Views.TOP)) {
											ts.getPosition1().setX(ts.getPosition1().getX()-xDiff);
											ts.getPosition1().setZ(ts.getPosition1().getZ()-yDiff);
											ts.getPosition2().setX(ts.getPosition2().getX()-xDiff);
											ts.getPosition2().setZ(ts.getPosition2().getZ()-yDiff);
											ts.getPosition3().setX(ts.getPosition3().getX()-xDiff);
											ts.getPosition3().setZ(ts.getPosition3().getZ()-yDiff);
											ts.getPosition4().setX(ts.getPosition4().getX()-xDiff);
											ts.getPosition4().setZ(ts.getPosition4().getZ()-yDiff);
										} else if (ts.getId().equals("SIDE") && this.getView().equals(Views.SIDE)) {
											ts.getPosition1().setX(ts.getPosition1().getX()-xDiff);
											ts.getPosition1().setY(ts.getPosition1().getY()+yDiff);
											ts.getPosition2().setX(ts.getPosition2().getX()-xDiff);
											ts.getPosition2().setY(ts.getPosition2().getY()+yDiff);
											ts.getPosition3().setX(ts.getPosition3().getX()-xDiff);
											ts.getPosition3().setY(ts.getPosition3().getY()+yDiff);
											ts.getPosition4().setX(ts.getPosition4().getX()-xDiff);
											ts.getPosition4().setY(ts.getPosition4().getY()+yDiff);
										}
									}
								}
							}
						}
					}
				}
				break;
			case MouseEvent.BUTTON3:
				if (this.getNumMouse().equals(MouseEvent.NOBUTTON)) {
					if (this.getCamera2DListener() != null)
						this.getCamera2DListener().runAnimator();
					this.setNumMouse(e.getButton());
					if (e.getClickCount() == 2)
						this.setPickPoint(e.getPoint());
				}
				break;
			default:
				break;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (this.getNumMouse().equals(e.getButton())) {
			this.setNumMouse(MouseEvent.NOBUTTON);
			this.setSelectedPoint(null);
			this.getAnimator().pause();
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (!this.getView().equals(Views.PERSPECTIVE)) {
			if (this.getSelectedPoint() != null) {
				switch (this.getNumMouse()) {
					case MouseEvent.BUTTON3:
						Double x = (e.getPoint().getX()-(this.getGraphicsEngineListener().getWidth()/2d)) / this.getCamera2DListener().getZoom();
						Double y = (e.getPoint().getY()-(this.getGraphicsEngineListener().getHeight()/2d)) / this.getCamera2DListener().getZoom();
						switch (this.getView()) {
							case 1:
								this.getSelectedPoint().getPosition().setY(-y);
								this.getSelectedPoint().getPosition().setZ(-x);
								break;
							case 2:
								this.getSelectedPoint().getPosition().setX(x);
								this.getSelectedPoint().getPosition().setZ(y);
								break;
							case 3:
								this.getSelectedPoint().getPosition().setX(x);
								this.getSelectedPoint().getPosition().setY(-y);
								break;
							default:
								break;
						}
					default:
						break;
				}
			}
		}
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_ESCAPE:
				for (Object o : this.getGraphicsEngineListener().getScene().getObjects()) {
		        	if (o instanceof PointJOGL)
						((PointJOGL) o).setSelectionColor(null);
				}
				break;
			default:
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}
}