import greenfoot.*;
import java.util.Random;

/**
 * The Level1 class represents the first level of the game.
 * @author SAE
 * @version 1.0
 */
public class Level1 extends World {
    private Random random = new Random();
    private int spawnTimer = Greenfoot.getRandomNumber(31) + 30; // Starte mit einem zufälligen Timer-Wert zwischen 30 und 60 Sekunden

    /**
     * Create a world with default settings.
     */
    public Level1() {
        super(20, 21, 40);
        GreenfootImage cell2 = new GreenfootImage("cell.lightgreenGrass.jpg");
        cell2.scale(20, 20);
        setBackground(cell2);
        setPaintOrder(Star.class,Player.class, Carrot.class, Rock.class);

        Player player= new Player(100, 50);
        addObject(player, 3, 3);

        Carrot carrot = new Carrot(5, 20, 20);
        addObject(carrot, 1, 5);
        Carrot ligthcarrot = new Carrot(3, 20, 20);
        addObject(ligthcarrot, 1, 6);

        Rock rock = new Rock();
        addObject(rock, 5, 5);

        Crystal crystal = new Crystal(30, 30);
        addObject(crystal, 10, 10);

        for (int i = getHeight() - 2; i >= 0; i--) {
            Rock rockRow = new Rock();
            addObject(rockRow, 7, i);
        }

        Tree tree = new Tree();
        addObject(tree, 3, 1);
    }

    public void act() {
        updateSpawnTimer();
    }

    public void moveWorld(int direction, Player player) {
        WorldsMap map = WorldsMap.getInstance(this);
        map.moveWorld(direction, player, this);
    }

    private void spawnRandomMonster() {
        int monsterType = random.nextInt(2);

        int x = random.nextInt(getWidth());
        int y = random.nextInt(getHeight());

        if (monsterType == 0) {
            addObject(new FeuerMonster(10, 1), x, y);
        } else {
            addObject(new Snake(5, 1), x, y);
        }
    }

    private void updateSpawnTimer() {
        spawnTimer--;

        if (spawnTimer <= 0) {
            spawnRandomMonster();
            resetSpawnTimer();
        }
    }

    private void resetSpawnTimer() {
        spawnTimer = Greenfoot.getRandomNumber(31) + 30; // Setze den Timer auf einen neuen zufälligen Wert zwischen 30 und 60 Sekunden
    }
}