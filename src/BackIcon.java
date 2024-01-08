import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.World;

public class BackIcon extends BlockingObject{
    private World level1 = null;
int mm = 0;
    public BackIcon(){
        GreenfootImage mainMenuIcon = new GreenfootImage("StoppButton.png");
        mainMenuIcon.scale(40,40);
        setImage(mainMenuIcon);
    }
    public void act(){
        closeMenu();
        if (level1 == null) {
            level1 = getWorld();
        }
        System.out.println(mm);
    }
    public void closeMenu(){
        if (Greenfoot.mouseClicked(this)) {
            moveMenuBack();
        }
    }
    public void moveMenuBack() {
        Greenfoot.setWorld(level1);
        mm=mm+1;
    }

}
