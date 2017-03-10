import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.imageio.ImageIO;

public class Dew extends GameObject{

	Image dew, dew2;
	String name;
	private String returnS="";
	private String[] pics=new String[5];
	public Dew(double speed, double direction, int size, double health, int x, int y, Color c, String name){
		super(speed, direction, size, health, x, y, c);
		openBackgroundImage();
		this.setDirection(direction);
		this.setSpeed(200);
		this.name = name;
	}


	@Override
	public void checkOffScreen() {
		// TODO Auto-generated method stub

	}



	@Override
	public void draw(Graphics g) {
		//		this.setBoundingRect((int)this.getX(), (int)this.getY(), 20, 20);
		if (name.equals("pepe")){
			g.drawImage(dew2, this.getX(), this.getY(), 14*getSize(), 6*getSize(), null);	
		}
		else {
					if(returnS==pics[0]){
			g.drawImage(dew, this.getX(), this.getY(), 14*getSize(), 6*getSize(), null);
		}
		else if(returnS==pics[1]){
			g.drawImage(dew, this.getX(), this.getY(), 15*getSize(), 7*getSize(), null);
		}
		else if(returnS==pics[2]){
			g.drawImage(dew, this.getX(), this.getY(), 15*getSize(), 10*getSize(), null);
		}
		else if(returnS==pics[3]){
			g.drawImage(dew, this.getX(), this.getY(), 13*getSize(), 10*getSize(), null);
		}
		}
	}

	@Override
	public void openBackgroundImage() {
		// TODO Auto-generated method stub
		try {
			URL url = getClass().getResource("images/"+ random());
			dew = ImageIO.read(url);
		} catch (Exception e) {
			System.out.println("problem opening the background");
			e.printStackTrace();
		}
		try {
			URL url = getClass().getResource("images/dew2.png");
			dew2 = ImageIO.read(url);
		} catch (Exception e) {
			System.out.println("problem opening the background");
			e.printStackTrace();
		}
	}
	public String random(){
		pics[0]="dew.png";
		pics[1]="crush.png";
		pics[2]="pepsi.png";
		pics[3]="harambe.png";
		pics[4]="";
		
		
		returnS=pics[(int) (Math.random()*(pics.length-1))];
		return returnS; 
	}


}
