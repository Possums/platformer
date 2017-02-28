import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;


public abstract class GameObject implements MovingObject {

	private double speed;// 0 - 10
	private double direction, // degrees or radians
		x, y, // >= 0
	
	
		size, // 10 might be a good size   
		health; // 0 - 100
	private int level;//
	private Color color;
	private Image img;

	@Override
	public void move() {
		x+= speed*Math.cos(direction);
		y+= speed*Math.sin(direction);
		resetDir();
		gravity();
		checkOffScreen();
		// maybe "push" back onto the screen change direction if
		// this object goes off the screen
	}
	public void gravity() {
		if(direction>(3*Math.PI/2)||direction<(Math.PI/2))
			direction --;
		if(direction<(3*Math.PI/2)&&direction>(Math.PI/2))
			direction ++;
	}
	public void resetDir() {
		if(direction>2*Math.PI)
			direction -= 2*Math.PI;
		if(direction<2*Math.PI)
			direction += 2*Math.PI;
	}
	public abstract void checkOffScreen();
	
	
	@Override
	public Rectangle getBoundingRect() {
		
		return new Rectangle((int)x,(int)y,(int)size,(int)size);
	}

}
