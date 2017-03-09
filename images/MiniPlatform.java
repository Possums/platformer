import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class MiniPlatform extends GameObject {
	
	Image platform2;
	int mapX, mapY;
	public MiniPlatform(int x, int y, int mapX, int mapY){
		super(0,0,0,0,x, y, null);
		this.mapX = mapX;
		this.mapY = mapY;
		try {                
			URL url = getClass().getResource("images/platform2.png");
			platform2 = ImageIO.read(url);
		} 
		catch (IOException ex) {
			// handle exception...
		
		
		}
		this.setBoundingRect(this.getX(), this.getY(), mapX/6, mapY/16);
	}
	@Override
	public void checkOffScreen() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Graphics g) {
		
		g.drawImage(platform2, this.getX() , this.getY(), mapX/6, mapY/16, null);
		//g.drawRect(this.getX(), this.getY(), this.getBoundingRect().width, this.getBoundingRect().height);
	}

}