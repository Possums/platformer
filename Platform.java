import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Platform extends GameObject {
	
	Image platform;
	int mapX, mapY;
	public Platform(int x, int y, int mapX, int mapY){
		super(0, 0, 0, 0, x, y, null);
		this.mapX = mapX;
		this.mapY = mapY;
		try {                
			URL url = getClass().getResource("images/platform.png");
			platform = ImageIO.read(url);
		} 
		catch (IOException ex) {
			// handle exception...
		
		
		}
		this.setBoundingRect(this.getX(), this.getY(), mapX/4, mapY/16);
	}
	@Override
	public void checkOffScreen() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(platform, this.getX() , this.getY(), mapX/4, mapY/16, null);
		this.setBoundingRect(this.getX(), this.getY(), mapX/4, mapY/16);
		//g.drawRect(this.getX(), this.getY(), this.getBoundingRect().width, this.getBoundingRect().height);
	}

}