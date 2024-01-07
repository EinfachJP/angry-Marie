import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

public class Rock extends BlockingObject {


	/**
	 * Will be called on a hit.
	 */
	public void hit() {
		int i = Greenfoot.getRandomNumber(5);
		if(i == 0){
			getWorld().addObject(new Crystal(20,20), getX(), getY());
			getWorld().addObject(new Star(), getX(), getY()); //Bei einem Treffer wird kurz ein Stern eingeblendet
		}
		if(i == 1){
			getWorld().addObject(new Gold(), getX(), getY());
			getWorld().addObject(new Star(), getX(), getY()); //Bei einem Treffer wird kurz ein Stern eingeblendet
		}
		if(i == 2){
			getWorld().addObject(new Gold(), getX(), getY());
			getWorld().addObject(new Star(), getX(), getY()); //Bei einem Treffer wird kurz ein Stern eingeblendet
		}
		getWorld().addObject(new Stone(), getX(), getY());

	}
	public Rock(){
		GreenfootImage rock = new GreenfootImage("rock.gif");
		rock.scale(20,20);
		setImage(rock);
	}


}