// imports Actor, World, Greenfoot, GreenfootImage
import greenfoot.*;

/**
 * @author SAE
 * @version 1.0
 */
public class Level2 extends World
{

    /**
     * Erzeuge eine Welt.
     */
    public Level2()
    {
        super(20, 20, 40);
        GreenfootImage cell2=new GreenfootImage("cell.jpg");
        cell2.scale(20,20);
        setBackground(cell2);
        setPaintOrder(Star.class, Player.class, Carrot.class, Rock.class);
    }
}