import greenfoot.GreenfootImage;

public class Tree extends BlockingObject {
    public Tree(){
        GreenfootImage tree = new GreenfootImage("Tree.png");
        tree.scale(40,60);
        setImage(tree);
    }
}
