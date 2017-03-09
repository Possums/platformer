import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.imageio.ImageIO;


public class Enemy extends GameObject {
	Image pepe;
	public Enemy(double speed, double direction, int size, double health,
			int x, int y) {
		super(speed, direction, size, health, x, y, null);
		try {
			URL url = getClass().getResource("images/pepe.png");
			pepe = ImageIO.read(url);
		} catch (Exception e) {
			System.out.println("problem opening the pepe");
			e.printStackTrace();
		}
		// TODO Auto-generated constructor stub
	}
	@Override
	public void draw(Graphics g) {
		//		this.setBoundingRect((int)this.getX(), (int)this.getY(), 20, 20);
		g.drawImage(pepe, this.getX(), this.getY(), getSize(), getSize(), null);
		g.drawRect(this.getX(), this.getY(), this.getBoundingRect().width, this.getBoundingRect().height);
	}
	public void turn(){
		if(getDirection() == 0)
			setDirection(Math.PI);
		if(getDirection() == Math.PI)
			setDirection(0);
	}
	
	
	public GameObject shoot(){
		Dew b = new Dew(getSpeed()*1.5, 0, getSize()/10, 1000, this.getX(), this.getY(), Color.red);
		return b;
	
	}
	
	@Override
	public void checkOffScreen() {
		// TODO Auto-generated method stub

	}

}
