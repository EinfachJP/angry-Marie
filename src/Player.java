import greenfoot.*;

public class Player extends IntelligentCharacter {
    //Attribute
    private int oldY = 0;
    private int oldX = 0;
    private float srgT = 0.1f;
    private World level2 = new Level2();
    private int Worldx = 0;
    private int Worldy = 19;

    //Konstruktoren
    public Player(int life, int stamina) {
        super(50, 50);
        setLife(life);
        setStamina(stamina);
    }

    public Player(int life) {
        super();
        setLife(life);
    }

    //Methoden
    public void act() {
        super.act();
        if (getLife() > 0) {
            performMovement();
            regenStamina();
        }
        if (Greenfoot.isKeyDown("V")) {
            transform();
        }
    }





    /*public void moveWorld(World newWorld, int myNewX, int myNewY) {


        World myWorld = getWorld();

        myWorld.removeObject(this);
        newWorld.addObject(this, myNewX, myNewY);
        Greenfoot.setWorld(newWorld);
    }

    public void getToNewWorld(int direction) {
        int myNewX = getX();
        int myNewY = getY();

        Level1 myWorld = (Level1) getWorld();
        myWorld.moveWorld(direction ,this);
    }*/

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
        for (Items items : inventory) {
            if (items instanceof Crystal) {

                int x = getX();
                int y = getY();
                Unicorn unicorn = new Unicorn(getLife());
                unicorn.setInventory(this.inventory);
                getWorld().addObject(unicorn, x, y);
                getWorld().removeObject(this);
            }
        }
    }




}
