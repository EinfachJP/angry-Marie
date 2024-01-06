import greenfoot.GreenfootImage;

public class Gun extends Items {
    public Gun(int width, int height) {
        GreenfootImage cristal = new GreenfootImage("Gun.png");
        cristal.scale(width, height);
        setImage(cristal);
    }
}
