import greenfoot.*;

import java.util.List;
import java.util.Random;
import greenfoot.World;

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

        Player player = new Player(99, 50);
        addObject(player, 3, 3);
        placeStones(Greenfoot.getRandomNumber(25) + 4);
        placeTrees(Greenfoot.getRandomNumber(10) + 4);
        placeCarrots(Greenfoot.getRandomNumber(3));
        List<Actor> actors = this.getObjectsAt(2, 2, Actor.class);
        if(actors.size() > 0){
            this.removeObject(actors.get(0));
        }
        Axe axe = new Axe();
        addObject(axe, 2, 2);
        HauptmenüIcon hauptmenüIcon = new HauptmenüIcon();
        addObject(hauptmenüIcon, 0, getHeight());
    }

    public void act() {
        updateSpawnTimer();
        checkPlayerLocation();
    }

    public void moveWorld(int direction, Player unicorn) {
        WorldsMap map = WorldsMap.getInstance(this);
        map.moveWorld(direction, unicorn, this);
    }

    private void checkPlayerLocation() {
        Player player = (Player) getObjects(Player.class).get(0);
        int playerX = player.getX();
        int playerY = player.getY();

        // Überprüfe, ob der Spieler die Welt verlassen hat
        if (playerX < 0 || playerX >= getWidth() || playerY < 0 || playerY >= getHeight()) {
            showText("Du hast die Welt verlassen!", getWidth() / 2, getHeight() / 2);
            Greenfoot.delay(50); // Warte 50 Schritte, um die Meldung anzuzeigen
            Greenfoot.setWorld(new Level2()); // Wechsle zur neuen Welt (ersetze NewWorld durch den Namen deiner neuen Weltklasse)
        }
    }

    private void spawnRandomMonster() {
        int monsterType = random.nextInt(4);

        int x = random.nextInt(getWidth());
        int y = random.nextInt(getHeight() - 1);

        if (monsterType == 0) {
            addObject(new FeuerMonster(10, 20), x, y);
        } else {
            if (monsterType == 1 || monsterType == 2) {
                addObject(new Snake(5, 1), x, y);
            } else {
                addObject(new Shadow(20, 5), x, y);
            }
        }
    }

    private void placeStones(int numberOfStones) {
        for (int i = 0; i < numberOfStones; i++) {
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight() - 1);
            addObject(new Rock(), x, y);
        }
    }

    private void placeTrees(int numberOfTrees) {
        for (int i = 0; i < numberOfTrees; i++) {
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight() - 1);
            addObject(new Tree(), x, y);
        }
    }

    private void placeCarrots(int numberOfCarrots) {
        for (int i = 0; i < numberOfCarrots; i++) {
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight() - 1);
            addObject(new Carrot(5, 20, 20), x, y);
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