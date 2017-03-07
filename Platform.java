import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Platform extends GameObject {
	
	Image platform;
	int mapX, mapY;
	public Platform(double speed, double direction, int size, double health, int x, int y, int mapX, int mapY){
		super(speed, direction, size, health, x, y, null);
		this.mapX = mapX;
		this.mapY = mapY;
		try {                
			URL url = getClass().getResource("images/platform.png");
			platform = ImageIO.read(url);
		} 
		catch (IOException ex) {
			// handle exception...
		}
		this.setBoundingRect(this.getX(), this.getY() + mapY / 24, mapX/2, mapY/16);
	}
	@Override
	public void checkOffScreen() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(platform, this.getX() , this.getY(), mapX/2, mapY/8, null);
	}

}