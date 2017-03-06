import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;


import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class PlatformerMap extends GameMap {

	Image background, platform;
	Dimension a = Toolkit.getDefaultToolkit().getScreenSize();
	int mapX = a.width;
	int mapY = a.height;
	Doge doge;
	GameObject platform1, platform2, platform3;
	boolean jump;
	int jumpCounter;


	public PlatformerMap() {
		doge = (new Doge(mapX/100,0, mapX/20, 3, 0, 0));
		platform1 = new Platform(0,0,0,0,   0, (int)(0.82*mapY), mapX, mapY);
		platform2 = new Platform(0,0,0,0,   mapX/2, (int)(0.82*mapY), mapX, mapY);
		platform3 = new Platform(0,0,0,0,   mapX/2, (int)(0.4*mapY), mapX, mapY);
		addGameObject(platform1);
		addGameObject(platform2);
		addGameObject(platform3);
		addGameObject(doge);

	}

	public void tick(){
		super.tick();
		if (jump && jumpCounter < 15){
			doge.setY(doge.getY()-(mapY/35));
			jumpCounter++;
		}
		else if (!(doge.getBoundingRect().intersects(platform1.getBoundingRect())
				|| doge.getBoundingRect().intersects(platform2.getBoundingRect())
				|| doge.getBoundingRect().intersects(platform3.getBoundingRect()))){
			doge.setY(doge.getY()+(mapY/35));
			
		}
		doge.setBoundingRect(doge.getX(), doge.getY(), ((mapX/20) * 2)-70, (mapX/20) * 3 - 20);
		if (doge.getBoundingRect().intersects(platform1.getBoundingRect())
				|| doge.getBoundingRect().intersects(platform2.getBoundingRect())
				|| doge.getBoundingRect().intersects(platform3.getBoundingRect())){
			doge.setSpeed(0);
			//JOptionPane.showMessageDialog(null, "intersection");
		}
		//System.out.println("doge" + doge.getBoundingRect());
		//System.out.println("platform" + platform1.getBoundingRect());

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
		for (int i=0; i<movers.size(); i++){
			//System.out.println(movers.get(i));
			movers.get(i).draw(g);
		}

		g.drawImage(background, 0,0, mapX, mapY, null);
		//g.drawImage(platform, 0 , (int)(0.82*mapY), mapX/2, mapY/8, null);
		//g.drawImage(platform, mapX/2 , (int)(0.82*mapY), mapX/2, mapY/8, null);
		g.setColor(Color.YELLOW);
		//g.drawLine(0, (int)(0.82*mapY), mapX, (int)(0.82*mapY));
		//---------------------
		g.setFont(new Font("Comic Sans MS", Font.PLAIN, 300)); 
		g.setColor(Color.YELLOW);
		FontMetrics metrics = g.getFontMetrics();
		int x = (3840 - metrics.stringWidth("Wow")) / 2;
		int y = ((2160 - metrics.getHeight()) / 2) + metrics.getAscent();
		g.drawString("Wow", x, y);
		//---------------------
		super.draw(g);
	}

	public void shoot(){
		this.addGameObject(doge.shoot());
	}

	public void stopDoge(){
		doge.setSpeed(0);
	}

	public void moveDown(){
		//t.setY((int)(t.getY()-10));
		if (!(doge.getBoundingRect().intersects(platform1.getBoundingRect())
				|| doge.getBoundingRect().intersects(platform2.getBoundingRect())
				|| doge.getBoundingRect().intersects(platform3.getBoundingRect()))){
			doge.setDirection((Math.PI/2));
			doge.setSpeed(mapY/160);
		}
	}

	public void moveUp(){
		//t.setY((int)(doge.getY()+10));
		if (doge.getBoundingRect().intersects(platform1.getBoundingRect())
				|| doge.getBoundingRect().intersects(platform2.getBoundingRect())
				|| doge.getBoundingRect().intersects(platform3.getBoundingRect())){
			jump = true;
			jumpCounter = 0;
		}
	}

	public void moveRight(){
		//doge.setX((int)(doge.getX()+10));
		doge.setDirection(0);
		doge.setSpeed(mapY/100);
	}

	public void moveLeft(){
		//doge.setX((int)(doge.getX()-10));
		doge.setDirection(Math.PI);
		doge.setSpeed(mapY/100);
	}

}