import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class Tree extends BlockingObjekt {
    public Tree(){
        GreenfootImage tree = new GreenfootImage("Tree.png");
        tree.scale(50,70);
        setImage(tree);
    }
}
