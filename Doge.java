import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;


public class Doge extends GameObject {
	public Doge(double speed, double direction, double size, double health, int x, int y){
		super(speed, direction, size, health, x, y, null);
		try {                
			URL url = getClass().getResource("images/doge.png");
			setImg(ImageIO.read(url));
	       } catch (IOException ex) {
	            // handle exception...
	       }
	}
	@Override
	public void checkOffScreen() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics g) {
		getImg().getHeight(null);
		g.drawImage(getImg(), getX(), getY(), null);
	}
	
}