import greenfoot.GreenfootImage;
import greenfoot.World;

public class Hauptmen� extends World {


    public Hauptmen�() {
        super(20, 21, 40);
        GreenfootImage cell2 = new GreenfootImage("cell.lightgreenGrass.jpg");
        cell2.scale(20, 20);
        setBackground(cell2);
        setPaintOrder(Star.class, Player.class, Carrot.class, Rock.class);


















    }
}
