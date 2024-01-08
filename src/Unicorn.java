import greenfoot.*;

public class Unicorn extends IntelligentCharacter {
    //Attribute

    private int oldY = 0;
    private int oldX = 0;
    private float srgT = 0.1f;
    private World level2 = new Level2();

    private int Worldx = 0;
    private int Worldy = 19;
    private long transformStartTime;

    //Konstruktoren
    public Unicorn(int life, int stamina) {
        super(50, 50);
        setLife(life);
        setStamina(stamina);
    }

    public Unicorn(int life) {
        super();
        setLife(life);
    }




    /**
     * Wird einmal pro Zeiteinheit aufgerufen
     */
    public void act() {
        super.act();
        if (getLife() > 0) {
            performMovement();
            regenStamina();
        }
        transformAfterDelay();
    }
    private void transformAfterDelay() {
        if (transformStartTime == 0) {
            transformStartTime = System.currentTimeMillis();
        }

        long currentTime = System.currentTimeMillis();
        if (currentTime - transformStartTime >= 30000) { // Überprüfe, ob 30 Sekunden vergangen sind
            transform();// Führe die Transformation aus
            transformStartTime = 0; // Setze den Timer zurück
        }
    }



    
    /**
     * moves one step forwardA
     */


    public void moveWorld(World newWorld, int myNewX, int myNewY) {


        World myWorld = getWorld();

        myWorld.removeObject(this);
        newWorld.addObject(this, myNewX, myNewY);
        Greenfoot.setWorld(newWorld);
    }

    public void getToNewWorld(int direction) {
        int myNewX = getX();
        int myNewY = getY();

        Level1 myWorld = (Level1) getWorld();
        myWorld.moveWorld(direction, this);
    }

    public void regenStamina() {
        if (getWorld() != null) {
            int x = getX();
            int y = getY();
            if (oldX == x && oldY == y) {
                if (stamina < 50) {
                    stamina = stamina + srgT;
                    srgT = srgT + 0.05f;
                }
            } else {
                srgT = 0.1f;
            }
            oldX = x;
            oldY = y;
        }
    }

    public void transform() {
        int x = getX();
        int y = getY();

        Player newPlayer = new Player(getLife());
        newPlayer.setInventory(this.inventory);
        getWorld().addObject(newPlayer, x, y);
        getWorld().removeObject(this);

    }
}

