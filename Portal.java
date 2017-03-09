import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;


public class Portal extends GameObject {
	Image portal;
	int mapX, mapY;
	public Portal(int x, int y, int mapX, int mapY){
		super(0,0,0,0, x, y, null);
		setBoundingRect(getX(), getY(), size*2, size*3);
		openImage();
		this.mapX = mapX;
		this.mapY = mapY;
		
	}
	@Override
	public void checkOffScreen() {
		// TODO Auto-generated method stub
		
	}
	
	public void openImage(){
		try {                
			URL url = getClass().getResource("images/portal.png");
			portal = ImageIO.read(url);
	       } catch (IOException ex) {
	            // handle exception...
	       }
	}
		
	@Override
	public void draw(Graphics g) {
		
		g.drawImage(portal, this.getX() , this.getY(), mapX/2, mapY/2, null);
		//g.drawRect(this.getX(), this.getY(), this.getBoundingRect().width, this.getBoundingRect().height);
	}
	
}