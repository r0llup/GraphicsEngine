package dnt.main;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JInternalFrame;

import dnt.graphicsengine.common.Position3D;
import dnt.graphicsengine.common.Views;
import dnt.graphicsengine.jogl.GraphicsEngineJOGL;
import dnt.graphicsengine.jogl.objects.complexobjects.AxisJOGL;
import dnt.graphicsengine.jogl.objects.complexobjects.PlaneJOGL;
import dnt.graphicsengine.jogl.objects.complexobjects.TexturedPlaneJOGL;
import dnt.graphicsengine.jogl.objects.simpleobjects.PointJOGL;
import dnt.graphicsengine.jogl.objects.simpleobjects.SquareJOGL;
import dnt.graphicsengine.jogl.objects.simpleobjects.SurfaceJOGL;

import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Manage a Main
 * @author Sh1fT
 *
 */
public class Main implements KeyListener, WindowListener, ComponentListener {
	private GraphicsEngineJOGL graphicsEngine;
	private JFrame jFrame;
	private JInternalFrame perspectiveInternalFrame;
	private JInternalFrame frontInternalFrame;
	private JInternalFrame topInternalFrame;
	private JInternalFrame sideInternalframe;
	private LinkedList<Position3D> ctlArray;
	private ArrayList<String> textureLocation;

	/**
	 * Create a new Main instance
	 */
	public Main() {
		this.setGraphicsEngine(new GraphicsEngineJOGL());
		this.setCtlArray(new LinkedList<Position3D>());
		this.setTextureLocation(new ArrayList<String>());
		this.getTextureLocation().add("ressources/front.png");
		this.getTextureLocation().add("ressources/top.png");
		this.getTextureLocation().add("ressources/side.png");
		// Update the front's light's position
		this.getGraphicsEngine().getSceneManagerJOGL().getLights().get(0).setPosition(new float[] {25f, 2f, 3f, 0f});
		// Update the top's light's position
		this.getGraphicsEngine().getSceneManagerJOGL().getLights().get(1).setPosition(new float[] {12.5f, 9f, 3f, 0f});
		// Update the side's light's position
		this.getGraphicsEngine().getSceneManagerJOGL().getLights().get(2).setPosition(new float[] {12.5f, 2f, 11f, 0f});
		this.getGraphicsEngine().getSceneManagerJOGL().getScene().addObject(new TexturedPlaneJOGL("TEXTUREDPLANE",
				new Position3D(-10d, 0d, -3d), 20d, 4d, 6d, this.getTextureLocation(), false));
		this.getGraphicsEngine().getSceneManagerJOGL().getScene().addObject(new PlaneJOGL("PLANE", new Position3D(-10d, 0d, -3d), 20d, 4d, 6d));
		this.getGraphicsEngine().getSceneManagerJOGL().getScene().addObject(new AxisJOGL("AXIS", new Position3D(0d, 0d, 0d), 10d, 4d, 3d));
		
		//drawTestCube();
		
				this.getGraphicsEngine().getSceneManagerJOGL().getScene().addObject(new SurfaceJOGL("HULL", this.getCtlArray(), new Color(225, 0, 0)));
		
		this.feedCtlarray();
		Integer cpt = 0;
		for (Position3D pos : this.getCtlArray()) {
			this.getGraphicsEngine().getSceneManagerJOGL().getScene().addObject(new PointJOGL(String.valueOf(cpt), pos, Color.BLUE, null, 5f));
			cpt++;
		}
		this.initialize();
	}
	
	private void drawTestCube(){
		
		double a = 1;
		// front
		this.getGraphicsEngine().getSceneManagerJOGL().getScene().addObject(
				new SquareJOGL("front", 
				new Position3D(-a, -a, a), 
				new Position3D(a, -a, a),
				new Position3D(a, a, a),
				new Position3D(-a, a, a),
				new Color(1.0f, 0.0f, 0.0f),
				new Color(0.0f, 1.0f, 0.0f),
				0.0f,
				true));
		
		// back
		this.getGraphicsEngine().getSceneManagerJOGL().getScene().addObject(
				new SquareJOGL("front", 
				new Position3D(-a, -a, -a), 
				new Position3D(-a, a, -a),
				new Position3D(a, a, -a),
				new Position3D(a, -a, -a),
				new Color(1.0f, 0.0f, 0.0f),
				new Color(0.0f, 1.0f, 0.0f),
				0.0f,
				true));
		
		// top
		this.getGraphicsEngine().getSceneManagerJOGL().getScene().addObject(
				new SquareJOGL("front", 
				new Position3D(-a, a, -a), 
				new Position3D(-a, a, a),
				new Position3D(a, a, a),
				new Position3D(a, a, -a),
				new Color(1.0f, 0.0f, 0.0f),
				new Color(0.0f, 1.0f, 0.0f),
				0.0f,
				true));
		
		// bottom
		this.getGraphicsEngine().getSceneManagerJOGL().getScene().addObject(
				new SquareJOGL("front", 
				new Position3D(-a, -a, -a), 
				new Position3D(a, -a, -a),
				new Position3D(a, -a, a),
				new Position3D(-a, -a, a),
				new Color(1.0f, 0.0f, 0.0f),
				new Color(0.0f, 1.0f, 0.0f),
				0.0f,
				true));
		
		// right
		this.getGraphicsEngine().getSceneManagerJOGL().getScene().addObject(
				new SquareJOGL("front", 
				new Position3D(a, -a, -a), 
				new Position3D(a, a, -a),
				new Position3D(a, a, a),
				new Position3D(a, -a, a),
				new Color(1.0f, 0.0f, 0.0f),
				new Color(0.0f, 1.0f, 0.0f),
				0.0f,
				true));			

		// left
		this.getGraphicsEngine().getSceneManagerJOGL().getScene().addObject(
				new SquareJOGL("front", 
				new Position3D(-a, -a, -a), 
				new Position3D(-a, -a, a),
				new Position3D(-a, a, a),
				new Position3D(-a, a, -a),
				new Color(1.0f, 0.0f, 0.0f),
				new Color(0.0f, 1.0f, 0.0f),
				0.0f,
				true));			
		
	}

	/**
	 * Feed the ctlArray
	 */
	private void feedCtlarray() {
		this.getCtlArray().add(new Position3D(-10d, 4d, -3d));
		this.getCtlArray().add(new Position3D(-10d, -1d, -3d));
		this.getCtlArray().add(new Position3D(-10d, -1d, 3d));
		this.getCtlArray().add(new Position3D(-10d, 4d, 3d));

		this.getCtlArray().add(new Position3D(-5d, 4d, -3d));
		this.getCtlArray().add(new Position3D(-5d, -1d, -3d));
		this.getCtlArray().add(new Position3D(-5d, -1d, 3d));
		this.getCtlArray().add(new Position3D(-5d, 4d, 3d));

		this.getCtlArray().add(new Position3D(0d, 4d, -3d));
		this.getCtlArray().add(new Position3D(0d, -1d, -3d));
		this.getCtlArray().add(new Position3D(0d, -1d, 3d));
		this.getCtlArray().add(new Position3D(0d, 4d, 3d));

		this.getCtlArray().add(new Position3D(5d, 4d, -3d));
		this.getCtlArray().add(new Position3D(5d, -1d, -3d));
		this.getCtlArray().add(new Position3D(5d, -1d, 3d));
		this.getCtlArray().add(new Position3D(5d, 4d, 3d));
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setjFrame(new JFrame());
		this.getjFrame().addKeyListener(this);
		this.getjFrame().addWindowListener(this);
		this.getjFrame().addComponentListener(this);
		this.getjFrame().setBounds(100, 100, 1024, 768);
		this.getjFrame().getContentPane().setLayout(null);
		this.setPerspectiveInternalFrame(new JInternalFrame("Perspective View"));
		this.getPerspectiveInternalFrame().setToolTipText("Perspective View");
		this.getPerspectiveInternalFrame().setResizable(true);
		this.getPerspectiveInternalFrame().setDoubleBuffered(true);
		this.getPerspectiveInternalFrame().setBounds(0, 0, (int) this.getjFrame().getSize().getWidth()/2, (int) this.getjFrame().getSize().getHeight()/2);
		this.getPerspectiveInternalFrame().getContentPane().add(this.getGraphicsEngine().getGlCanvas().get(Views.PERSPECTIVE));
		this.getjFrame().getContentPane().add(this.getPerspectiveInternalFrame());
		this.setFrontInternalFrame(new JInternalFrame("Front View"));
		this.getFrontInternalFrame().setToolTipText("Front View");
		this.getFrontInternalFrame().setResizable(true);
		this.getFrontInternalFrame().setDoubleBuffered(true);
		this.getFrontInternalFrame().setBounds((int) this.getjFrame().getSize().getWidth()/2, 0,
				(int) this.getjFrame().getSize().getWidth()/2, (int) this.getjFrame().getSize().getHeight()/2);
		this.getFrontInternalFrame().getContentPane().add(this.getGraphicsEngine().getGlCanvas().get(Views.FRONT));
		this.getjFrame().getContentPane().add(this.getFrontInternalFrame());
		this.setTopInternalFrame(new JInternalFrame("Top View"));
		this.getTopInternalFrame().setToolTipText("Top View");
		this.getTopInternalFrame().setResizable(true);
		this.getTopInternalFrame().setDoubleBuffered(true);
		this.getTopInternalFrame().setBounds(0, this.getjFrame().getHeight()/2, this.getjFrame().getWidth()/2, this.getjFrame().getHeight()/2);
		this.getTopInternalFrame().getContentPane().add(this.getGraphicsEngine().getGlCanvas().get(Views.TOP));
		this.setSideInternalframe(new JInternalFrame("Side View"));
		this.getSideInternalframe().setToolTipText("Side View");
		this.getSideInternalframe().setResizable(true);
		this.getSideInternalframe().setDoubleBuffered(true);
		this.getSideInternalframe().setBounds((int) this.getjFrame().getSize().getWidth()/2, (int) this.getjFrame().getSize().getHeight()/2,
				(int) this.getjFrame().getSize().getWidth()/2, (int) this.getjFrame().getSize().getHeight()/2);
		this.getSideInternalframe().getContentPane().add(this.getGraphicsEngine().getGlCanvas().get(Views.SIDE));
		this.getjFrame().getContentPane().add(this.getSideInternalframe());
		this.getPerspectiveInternalFrame().setVisible(true);
		this.getFrontInternalFrame().setVisible(true);
		this.getTopInternalFrame().setVisible(true);
		this.getSideInternalframe().setVisible(true);
	}

	public GraphicsEngineJOGL getGraphicsEngine() {
		return graphicsEngine;
	}

	public void setGraphicsEngine(GraphicsEngineJOGL graphicsEngine) {
		this.graphicsEngine = graphicsEngine;
	}

	public JFrame getjFrame() {
		return jFrame;
	}

	public void setjFrame(JFrame jFrame) {
		this.jFrame = jFrame;
		jFrame.setTitle("Kepler Engine Demo (Beta)");
	}

	public JInternalFrame getPerspectiveInternalFrame() {
		return perspectiveInternalFrame;
	}

	public void setPerspectiveInternalFrame(
			JInternalFrame perspectiveInternalFrame) {
		this.perspectiveInternalFrame = perspectiveInternalFrame;
		perspectiveInternalFrame.setMaximizable(true);
		perspectiveInternalFrame.setIconifiable(true);
		perspectiveInternalFrame.setClosable(true);
	}

	public JInternalFrame getFrontInternalFrame() {
		return frontInternalFrame;
	}

	public void setFrontInternalFrame(JInternalFrame frontInternalFrame) {
		this.frontInternalFrame = frontInternalFrame;
		frontInternalFrame.setMaximizable(true);
		frontInternalFrame.setIconifiable(true);
		frontInternalFrame.setClosable(true);
	}

	public JInternalFrame getTopInternalFrame() {
		return topInternalFrame;
	}

	public void setTopInternalFrame(JInternalFrame topInternalFrame) {
		this.topInternalFrame = topInternalFrame;
		topInternalFrame.setBounds(0, 381, 512, 349);
		jFrame.getContentPane().add(topInternalFrame);
		topInternalFrame.setMaximizable(true);
		topInternalFrame.setIconifiable(true);
		topInternalFrame.setClosable(true);
	}

	public JInternalFrame getSideInternalframe() {
		return sideInternalframe;
	}

	public void setSideInternalframe(JInternalFrame sideInternalframe) {
		this.sideInternalframe = sideInternalframe;
		sideInternalframe.setMaximizable(true);
		sideInternalframe.setIconifiable(true);
		sideInternalframe.setClosable(true);
	}

	public LinkedList<Position3D> getCtlArray() {
		return ctlArray;
	}

	public void setCtlArray(LinkedList<Position3D> ctlArray) {
		this.ctlArray = ctlArray;
	}

	public ArrayList<String> getTextureLocation() {
		return textureLocation;
	}

	public void setTextureLocation(ArrayList<String> textureLocation) {
		this.textureLocation = textureLocation;
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosing(WindowEvent e) {
		this.getGraphicsEngine().turnOff();
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					SwingUtilities.updateComponentTreeUI(window.getjFrame());
					window.getjFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void componentResized(ComponentEvent e) {
		this.getPerspectiveInternalFrame().setBounds(0, 0, (int) this.getjFrame().getSize().getWidth()/2, (int) this.getjFrame().getSize().getHeight()/2);
		this.getFrontInternalFrame().setBounds((int) this.getjFrame().getSize().getWidth()/2, 0,
				(int) this.getjFrame().getSize().getWidth()/2, (int) this.getjFrame().getSize().getHeight()/2);
		this.getSideInternalframe().setBounds((int) this.getjFrame().getSize().getWidth()/2, (int) this.getjFrame().getSize().getHeight()/2,
				(int) this.getjFrame().getSize().getWidth()/2, (int) this.getjFrame().getSize().getHeight()/2);
		this.getTopInternalFrame().setBounds(0, this.getjFrame().getHeight()/2, this.getjFrame().getWidth()/2, this.getjFrame().getHeight()/2);
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_ESCAPE:
				this.getGraphicsEngine().turnOff();
				System.exit(0);
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