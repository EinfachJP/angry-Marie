import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class Rock extends BlockingObjekt {


	/**
	 * Will be called on a hit.
	 */
	public void hit() {
		getWorld().addObject(new Star(), getX(), getY()); //Bei einem Treffer wird kurz ein Stern eingeblendet

	}
	public Rock(){
		GreenfootImage rock = new GreenfootImage("rock.gif");
		rock.scale(20,20);
		setImage(rock);
	}


}