import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

public class Tree extends BlockingObject {
    public Tree() {
        GreenfootImage tree = new GreenfootImage("Tree.png");
        tree.scale(40, 60);
        setImage(tree);
    }

    public void hit() {
        int i = Greenfoot.getRandomNumber(2);
        if (i == 0) {
            getWorld().addObject(new Pickaxe(), getX(), getY());
            getWorld().addObject(new Star(), getX(), getY()); //Bei einem Treffer wird kurz ein Stern eingeblendet
        } /*else  if (i == 1) {
            getWorld().addObject(new Pickaxe(), getX(), getY());
            getWorld().addObject(new Star(), getX(), getY()); //Bei einem Treffer wird kurz ein Stern eingeblendet
        }*/
        getWorld().addObject(new Lumber(), getX(), getY());
    }
}
