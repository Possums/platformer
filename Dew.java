import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.imageio.ImageIO;

public class Dew extends GameObject{
	
	Image dew;

	public Dew(double speed, double direction, int size, double health, int x, int y, Color c){
		super(speed, direction, size, health, x, y, c);
		openBackgroundImage();
		this.setDirection(direction);

	}


		@Override
		public void checkOffScreen() {
			// TODO Auto-generated method stub
			
		}



	@Override
	public void draw(Graphics g) {
		//		this.setBoundingRect((int)this.getX(), (int)this.getY(), 20, 20);
		g.drawImage(dew, this.getX(), this.getY(), 14*getSize(), 6*getSize(), null);

	}

	@Override
	public void openBackgroundImage() {
		// TODO Auto-generated method stub
		try {
			URL url = getClass().getResource("images/dew.png");
			dew = ImageIO.read(url);
		} catch (Exception e) {
			System.out.println("problem opening the background");
			e.printStackTrace();
		}
	}


}
