import greenfoot.GreenfootImage;

public class Crystal extends Items {
    public Crystal(int width, int height){
        GreenfootImage cristal= new GreenfootImage("Kristall.png");
        cristal.scale(width,height);
        setImage(cristal);
    }
}
