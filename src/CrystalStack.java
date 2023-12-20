import greenfoot.Actor;
import greenfoot.GreenfootImage;


public class CrystalStack extends Actor {


    public CrystalStack(int width, int height) {
        GreenfootImage cristal = new GreenfootImage("Kristall.png");
        cristal.scale(width, height);
        setImage(cristal);
    }
}
