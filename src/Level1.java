// imports Actor, World, Greenfoot, GreenfootImage
import greenfoot.*;

/**
 * @author SAE
 * @version 1.0
 */
public class Level1 extends World
{
    private static World[][] worlds = new World[20][20];
    /**
     * Erzeuge eine Welt.
     */
    public Level1()
    {
        super(20, 20, 40);
        GreenfootImage cell2=new GreenfootImage("cell.jpg");
        cell2.scale(20,20);
        setBackground(cell2);
        setPaintOrder(Star.class, Player.class, Carrot.class, Rock.class);

        Player player =  new Player(100,50);
        addObject(player, 3, 3);

        if(worlds!=null){
            generateWorlds();
        }

        Carrot carrot = new Carrot(5, 20, 20);
        addObject(carrot, 1, 5);
        Carrot ligthcarrot = new Carrot(3, 20, 20);
        addObject(ligthcarrot, 1, 6);

        Rock rock = new Rock();
        addObject(rock, 5, 5);
        Monster monster =  new Monster(50,2);
        addObject(monster, 0, 0);

        /*Unicorn unicorn = new Unicorn();
        addObject(unicorn, 6, 5);*/

        Crystal crystal = new Crystal(30, 30);
        addObject(crystal, 10, 10);





        for(int i = getHeight()-2; i>=0 ;i--){
            Rock rockRow = new Rock();
            addObject(rockRow, 7, i);
        }

        Tree tree = new Tree();
        addObject(tree,3,1);
    }
    public void generateWorlds(){
        for(int i=19;i>=0;i--){
            for(int j=0;j<20;j++){
                worlds[i][j] = new Level2();
            }
        }
    }
}