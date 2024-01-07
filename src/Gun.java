import greenfoot.GreenfootImage;

public class Gun extends Items {
    public Gun(int width, int height) {
        GreenfootImage gun = new GreenfootImage("Gun.png");
        gun.scale(width, height);
        setImage(gun);
    }
}
