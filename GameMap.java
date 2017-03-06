import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;


public abstract class GameMap {

	protected List<MovingObject> movers;
	Image backgroundImage;
	
	public GameMap() {
		movers = new ArrayList();
		openBackgroundImage();
	}

	public void addGameObject(GameObject go) {
		movers.add(go);
	}
	public abstract void openBackgroundImage();

	public void draw(Graphics g) {
		for(MovingObject MO:movers){
			MO.draw(g);
		}
	}

	public void spaceKeyHit() {
		// TODO Auto-generated method stub
		
	}

	public void leftKeyHit() {
		// TODO Auto-generated method stub
		
	}

	public void upKeyHit() {
		// TODO Auto-generated method stub
		
	}

	public void rightKeyHit() {
		// TODO Auto-generated method stub
		
	}

	public void downKeyHit() {
		// TODO Auto-generated method stub
		
	}

	public void leftKeyReleased() {
		// TODO Auto-generated method stub
		
	}

	public void spaceKeyReleased() {
		// TODO Auto-generated method stub
		
	}

	public void rightKeyReleased() {
		// TODO Auto-generated method stub
		
	}

	public void upKeyReleased() {
		// TODO Auto-generated method stub
		
	}

	public void downKeyReleased() {
		// TODO Auto-generated method stub
		
	}

	public void tick() {
		// TODO Auto-generated method stub
		for (MovingObject MO: movers){
			MO.move();
		}
		
	} 	
}
