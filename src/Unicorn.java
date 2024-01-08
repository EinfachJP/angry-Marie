import greenfoot.*;

public class Unicorn extends IntelligentCharacter {
    //Attribute

    private int oldY = 0;
    private int oldX = 0;
    private float srgT = 0.1f;
    private World level2 = new Level2();

    private int Worldx = 0;
    private int Worldy = 19;

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
            //getImage().drawString(String.valueOf(life), 0, 20);
            //draw((int) stamina);
            regenStamina();

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

    public void shoot() {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] instanceof Gun) {
                MouseInfo mouse = Greenfoot.getMouseInfo();

                if (mouse != null) {
                    int mouseX = mouse.getX();
                    int mouseY = mouse.getY();

                    Bullet bullet = new Bullet(30, 30);
                    getWorld().addObject(bullet, getX(), getY());

                    double angle = Math.toDegrees(Math.atan2(mouseY - getY(), mouseX - getX()));
                    bullet.setRotation((int) angle);
                    bullet.move(10);
                }
            }
        }
    }

    public void transform() {
        int x = getX();
        int y = getY();

        if (inventory != null && inventory.length > 0) {
            for (int i = 0; i < inventory.length; i++) {
                if (inventory[i] instanceof Crystal) {
                    inventory[i] = null;
                    break;
                }
            }
        }
        Player newPlayer = new Player(getLife());
        newPlayer.setInventory(this.inventory);
        getWorld().addObject(newPlayer, x, y);
        getWorld().removeObject(this);
    }
}
