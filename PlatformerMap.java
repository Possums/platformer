import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;


import javax.imageio.ImageIO;

public class PlatformerMap extends GameMap {

	Image background, platform;
	Dimension a = Toolkit.getDefaultToolkit().getScreenSize();
	int mapX = a.width;
	int mapY = a.height;
	public PlatformerMap() {
		addGameObject(new Doge(Math.random(),Math.random()*Math.PI*2, 100, 3, 0, 0));
	}


	@Override
	public void openBackgroundImage() {
		// TODO Auto-generated method stub
		try {
			URL url = getClass().getResource("images/background.jpg");
			background = ImageIO.read(url);
		} catch (Exception e) {
			System.out.println("problem opening the background");
			e.printStackTrace();
		}
		
		try {
			URL url = getClass().getResource("images/platform.png");
			platform = ImageIO.read(url);
		} catch (Exception e) {
			System.out.println("problem opening the background");
			e.printStackTrace();
		}	
		
	}

	public void draw(Graphics g){
		g.drawImage(background, 0,0, mapX, mapY, null);
		g.drawImage(platform, 0 , 3*mapY/4, mapX/2, mapY/8, null);
		g.drawImage(platform, mapX/2 , 3*mapY/4, mapX/2, mapY/8, null);
		super.draw(g);
	}

}