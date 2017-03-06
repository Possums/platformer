import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;


public class Doge extends GameObject {
	public Doge(double speed, double direction, int size, double health, int x, int y){
		super(speed, direction, size, health, x, y, null);
		try {                
			URL url = getClass().getResource("images/doge.png");
			setImg(ImageIO.read(url).getScaledInstance(size*2, size*3, 0));
	       } catch (IOException ex) {
	            // handle exception...
	       }
		this.setBoundingRect(this.getX(), this.getY(), size*2, (size*3)-20);
	}
	@Override
	public void checkOffScreen() {
		// TODO Auto-generated method stub
		
	}
	
	public GameObject shoot(){
		Dew b = new Dew(10, 0, 50, 1000, this.getX(), this.getY(), Color.red);
		System.out.println("shoot mountain dews");
		return b;
	
	}
	
	@Override
	public void draw(Graphics g) {
		getImg().getHeight(null);
		g.drawImage(getImg(), getX(), getY(), null);
		g.drawRect(this.getX(), this.getY(), this.getBoundingRect().width, this.getBoundingRect().height);
	}
	
}