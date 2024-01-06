import greenfoot.*;
import java.util.Random;

/**
 * The Level1 class represents the first level of the game.
 * @author SAE
 * @version 1.0
 */
public class Level1 extends World {
    private Random random = new Random();
    private int spawnTimer = Greenfoot.getRandomNumber(31) + 30;

    /**
     * Create a world with default settings.
     */
    public Level1() {
        super(20, 21, 40);
        GreenfootImage cell2 = new GreenfootImage("cell.lightgreenGrass.jpg");
        cell2.scale(20, 20);
        setBackground(cell2);
        setPaintOrder(Star.class, Player.class, Carrot.class, Rock.class);

        Player player = new Player(100, 50);
        addObject(player, 3, 3);
        placeStones(Greenfoot.getRandomNumber(20));
        placeTrees(Greenfoot.getRandomNumber(10));
    }

    public void act() {
        updateSpawnTimer();
    }

    public void moveWorld(int direction, Player unicorn) {
        WorldsMap map = WorldsMap.getInstance(this);
        map.moveWorld(direction, unicorn, this);
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
    private void placeStones(int numberOfStones) {
        for (int i = 0; i < numberOfStones; i++) {
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight()-1);
            addObject(new Rock(), x, y);
        }
    }
    private void placeTrees(int numberOfTrees) {
        for (int i = 0; i < numberOfTrees; i++) {
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight()-1);
            addObject(new Tree(), x, y);
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
        spawnTimer = Greenfoot.getRandomNumber(31) + 30;
    }

    public void moveWorld(int direction, Unicorn unicorn) {
    }
}