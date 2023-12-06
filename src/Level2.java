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
        super(8, 8, 60);
        setBackground("cell.jpg");
        setPaintOrder(Star.class, Player.class, Carrot.class, Rock.class);

        Monster monster =  new Monster(50,2);
        addObject(monster, 0, 0);



    }

}