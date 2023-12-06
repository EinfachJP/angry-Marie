// imports Actor, World, Greenfoot, GreenfootImage
import greenfoot.*;

/**
 * @author SAE
 * @version 1.0
 */
public class Level1 extends World
{
    /**
     * Erzeuge eine Welt.
     */
    public Level1()
    {
        super(10, 10, 60);
        GreenfootImage image=new GreenfootImage("cell.jpg");
        image.scale(30,30);
        setBackground(image);
        setPaintOrder(Star.class, Player.class, Carrot.class, Rock.class);

        Player player =  new Player(100,50);
        addObject(player, 3, 3);

        Carrot carrot = new Carrot();
        addObject(carrot, 1, 5);
        Carrot ligthcarrot = new Carrot(3);
        addObject(ligthcarrot, 1, 6);

        Rock rock = new Rock();
        addObject(rock, 5, 5);
        Monster monster =  new Monster(50,2);
        addObject(monster, 0, 0);

        for(int i = getHeight()-2; i>=0 ;i--){
            Rock rockRow = new Rock();
            addObject(rockRow, 7, i);
        }

        Tree tree = new Tree();
        addObject(tree,3,1);
    }



}