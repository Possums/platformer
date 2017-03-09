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
	GameObject platform1, platform2, platform3, platform4, platform5, platform6, platform7;
	Portal portal;
	boolean jump;
	int jumpCounter;
	int shootCounter;

	public PlatformerMap() {
		doge = (new Doge(mapX/200,0, mapX/36, 3, 0, 0));
		platform1 = new Platform(0, mapY/2, mapX/2, mapY/2);
		platform2 = new Platform(mapX/8, mapY/2, mapX/2, mapY/2);
		platform3 = new Platform(mapX/4, mapY/2, mapX/2, mapY/2);
		platform4 = new Platform((int)(mapX/2.5), (int)(mapY/1.4), mapX/2,  mapY/2);
		platform5 = new Platform((int)(mapX/2), (int)(mapY/2.5), mapX/2,  mapY/2);
		platform6 = new Platform((int)(mapX/1.6), (int)(mapY/2.5), mapX/2, mapY/2);
		platform7 = new MiniPlatform((int)(mapX/1.2), (int)(mapY/1.5), mapX/8, mapY/2);
		portal = new Portal(0,0,0,0, (int)(mapX/1.1), (int)(mapY/1.5), mapX/6, mapY/3);
		addGameObject(platform1);
		addGameObject(platform2);
		addGameObject(platform3);
		addGameObject(platform4);
		addGameObject(platform5);
		addGameObject(platform6);
		addGameObject(platform7);
		addGameObject(portal);
		addGameObject(doge);
//159,293
	}

	public void tick(){
		super.tick();
		if (jump && jumpCounter < 10){
			doge.setY(doge.getY()-(mapY/35));
			jumpCounter++;
		}
		else if (!intersect()){
			doge.setY(doge.getY()+(mapY/35));
			
		}
		doge.setBoundingRect(doge.getX(), doge.getY(), mapX/18, mapX/12);
		if (intersect()){
			doge.setSpeed(0);
			//JOptionPane.showMessageDialog(null, "intersection");
		}
		shootCounter++;
		//System.out.println("doge" + doge.getBoundingRect());
		//System.out.println("platform" + platform1.getBoundingRect());

	}
	
	public boolean intersect(){
		for (int i=0; i<movers.size(); i++){
			if (movers.get(i) instanceof Platform || movers.get(i) instanceof MiniPlatform){
				if (doge.getBoundingRect().intersects(movers.get(i).getBoundingRect())){
					return true;
				}
			}
		}
		return false;
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
		g.drawString("Wow", mapX/8, (int)(mapY * 0.75));
		//---------------------
		super.draw(g);
	}

	public void shoot(){
	if(shootCounter >5){
			addGameObject(doge.shoot());
			shootCounter = 0;
		}
	}

	public void stopDoge(){
		doge.setSpeed(0);
	}

	public void moveDown(){
		//t.setY((int)(t.getY()-10));
		//		if (!intersect()){
		//			doge.setDirection((Math.PI/2));
		//			doge.setSpeed(mapY/160);
		//		}
	}

	public void moveUp(){
		//t.setY((int)(doge.getY()+10));
		if (intersect()){
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