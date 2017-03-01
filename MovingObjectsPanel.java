import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;
import javax.swing.Timer;// this timer is best with Swing Components
import javax.swing.JPanel;


public class MovingObjectsPanel extends JPanel {
	////here is my code that creates the animation:  This code goes in the 
	////Panel class
	private Timer t;// belongs to the class
	private final int tickRate = 15;

	public MovingObjectsPanel(Dimension dim) {
		defaultDim = dim;
		this.setPreferredSize(defaultDim);
		setUpKeyMappings();
		makeGameMap();
		t.start();// start the timer which starts the "ticking"
	}
	private void makeGameMap() {
		gm = new PlatformerMap();// let the map know what dim is
		ActionListener aL = new ActionListener() {// fires off every 10 ms
			@Override
			public void actionPerformed(ActionEvent arg0) {
				gm.tick();// I tell the GameMap to tick... do what
				// you do every time the clock goes off.
				repaint();// naturally, we want to see the new view
			}
		};
		t = new Timer(tickRate, aL);// this semicolon is here because it is the end of the new Timer construction...
	}
	final Dimension defaultDim;// = new Dimension(800,600);
	GameMap gm;

	public MovingObjectsPanel() {
		this( new Dimension(900,1600));
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);  
		gm.draw(g); 
	}
	private void setUpKeyMappings() {
		// maps keys with actions...
		//  The code below maps a KeyStroke to an action to be performed
		// In this case I mapped the space bar key to the action named "shoot"
		// Whenever someone hits the Space Bar the action shoot is sent out

		this.getInputMap().put(KeyStroke.getKeyStroke("SPACE"),"shoot");
		this.getInputMap().put(KeyStroke.getKeyStroke("W"),"up");
		this.getInputMap().put(KeyStroke.getKeyStroke("A"),"left");
		this.getInputMap().put(KeyStroke.getKeyStroke("S"),"down");
		this.getInputMap().put(KeyStroke.getKeyStroke("D"),"right");
		this.getInputMap().put(KeyStroke.getKeyStroke("released SPACE"),"released shoot");
		this.getInputMap().put(KeyStroke.getKeyStroke("released W"),"released up");
		this.getInputMap().put(KeyStroke.getKeyStroke("released A"),"released left");
		this.getInputMap().put(KeyStroke.getKeyStroke("released S"),"released down");
		this.getInputMap().put(KeyStroke.getKeyStroke("released D"),"released right");
		//  This associates the command shoot with some action.  In this 
		// case, the action triggers a shoot command invoked on my GameMap.  In general, whatever 
		// goes in the actionPerformed method will be executed when a shoot command
		// is sent...
			
		this.getActionMap().put("shoot",new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("space");
				gm.spaceKeyHit();
			}
		});this.getActionMap().put("left",new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("left");
				gm.leftKeyHit();
			}
		});this.getActionMap().put("up",new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("up");
				gm.upKeyHit();
			}
		});this.getActionMap().put("right",new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("right");
				gm.rightKeyHit();
			}
		});this.getActionMap().put("down",new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("down");
				gm.downKeyHit();
			}
		});this.getActionMap().put("released shoot",new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				gm.spaceKeyReleased();
			}
		});this.getActionMap().put("released left",new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("released left");
				gm.leftKeyReleased();
			}
		});this.getActionMap().put("released up",new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("released up");
				gm.upKeyReleased();
			}
		});this.getActionMap().put("released right",new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("released right");
				gm.rightKeyReleased();
			}
		});this.getActionMap().put("released down",new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("released down");
				gm.downKeyReleased();
			}
		});
		this.requestFocusInWindow();		
	}


}