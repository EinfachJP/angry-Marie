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
    }




    public void performMovement() {
        if (Greenfoot.isKeyDown("W")) {
            turn(Direction.NORTH);
            if (getY() > 0) {
                move();
            } else {
                getToNewWorld(0);
            }
        }
        if (Greenfoot.isKeyDown("D")) {
            turn(Direction.EAST);
            if (getX() < 19) {
                move();
            } else {
                getToNewWorld(1);
            }
        }
        if (Greenfoot.isKeyDown("S")) {
            turn(Direction.SOUTH);
            if (getY() < 19) {
                move();
            } else {
                getToNewWorld(2);
            }
        }
        if (Greenfoot.isKeyDown("A")) {
            turn(Direction.WEST);
            if (getX() > 0) {
                move();
            } else {
                getToNewWorld(3);
            }


        }
        if (Greenfoot.isKeyDown("Q")) {
            eatCarrotOnYou();
        }
        if (Greenfoot.isKeyDown("E")) {
            destroyRock();
            destroyTree();
        }
        if (Greenfoot.isKeyDown("F")) {
            hitMonster();
        }
        if (Greenfoot.isKeyDown("M")) {
            takeItemsOnYou();
        }
        if (Greenfoot.isKeyDown("V")) {
            transform();
        }
        if (Greenfoot.isKeyDown("r")) {
            shoot();
        }
    }


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
        myWorld.moveWorld(direction ,this);
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
        for (Items items : inventory) {
            if (items instanceof Gun) {
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