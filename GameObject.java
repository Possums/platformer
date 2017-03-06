import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;


public abstract class GameObject implements MovingObject {

	private double speed;// 0 - 10
	private double direction, // degrees or radians
		 // >= 0
	
	
		 // 10 might be a good size   
		health; // 0 - 100
	private int x, y, size;//
	private Color color;
	private Image img;
	private Rectangle rect = new Rectangle();
	
	public GameObject (double speed, double direction, int size, double health, int x, int y, Color c){
		this.speed = speed;
		this.direction = direction;
		this.size = size;
		this.health = health;
		this.x = x;
		this.y = y;
		this.color = c;
	}
	
	@Override
	public void move() {
		x += (int) (getSpeed()*Math.cos(direction));
		y += (int) (getSpeed()*Math.sin(direction));
		resetDir();
		//System.out.println(direction);
		gravity();
		checkOffScreen();
		// maybe "push" back onto the screen change direction if
		// this object goes off the screen
	}
	public void gravity() {
//		if(direction>(3*Math.PI/2)||direction<(Math.PI/2))
//			direction -= Math.PI/16;
//		if(direction<(3*Math.PI/2)&&direction>(Math.PI/2))
//			direction += Math.PI/16;
		//System.out.println("gravity");
			
	}
	public void resetDir() {
		while(direction > 2*Math.PI)
			direction -= 2*Math.PI;
		while(direction < 0)
			direction += 2*Math.PI;
	}
	public abstract void checkOffScreen();
	
	

	public Image getImg() {
		return img;
	}
	public void setImg(Image img) {
		this.img = img;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public void setDirection(double direction){
		this.direction = direction;
	}
	
	public double getDirection(){
		return this.direction;
	}

	public void openBackgroundImage() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Rectangle getBoundingRect() {
		return this.rect;
	}

	public void setBoundingRect(int x, int y, int width, int height){
		rect.setBounds(x, y, width, height);
	}
	
	
}