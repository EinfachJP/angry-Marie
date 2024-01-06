import greenfoot.*;
import java.util.List;
public class Player extends Charakter {
    //Attribute
    private Items[] inventory = new Items[8];
    private float stamina = 20;
    private int damageP = 5;
    private int oldY = 0;
    private int oldX = 0;
    private float srgT = 0.1f;
    private World level2 = new Level2();
    private World level1 = null;
    private InventoryVisualizer visualizer;
    private int Worldx = 0;
    private int Worldy = 19;

    //Konstruktoren
    public Player(int life, int stamina) {
        super(50, 50);
        setLife(life);
        setStamina(stamina);
    }

    public Player() {
        super();
    }

    public float getStamina() {
        return stamina;
    }

    public void setStamina(float newStamina) {
        stamina = newStamina;
        getImage().drawString(String.valueOf(stamina), 0, 20);
    }
    public void setInventory(Items[] playerInventory) {
        this.inventory = new Items[playerInventory.length];
        System.arraycopy(playerInventory, 0, this.inventory, 0, playerInventory.length);
    }
    //Methoden

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


    @Override
    protected void addedToWorld(World world) {
        super.addedToWorld(world);
        if (level1 == null) {
            level1 = getWorld();

        }
        visualizer = new InventoryVisualizer(inventory);
        world.addObject(visualizer, 0, world.getHeight() - 1);
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
            eatCarrotonyou();
        }
        if (Greenfoot.isKeyDown("E")) {
            destroyRock();
        }
        if (Greenfoot.isKeyDown("N")) {
            placeCarrotonyou();
        }
        if (Greenfoot.isKeyDown("F")) {
            hitMonster();
        }
        if (Greenfoot.isKeyDown("M")) {
            takeItemsonyou();
        }
        if (Greenfoot.isKeyDown("V")) {
            transform();
        }
        if (Greenfoot.isKeyDown("r")) {
            shoot();
        }
    }

    public void destroyRock() {
        if (!canMove()) {
            World myWorld = getWorld();
            List<Rock> rocks = myWorld.getObjectsAt(getNextX(1), getNextY(1), Rock.class);
            if (rocks.size() > 0) {
                Rock rock = rocks.get(0);
                myWorld.removeObject(rock);
            }
        }
    }

    public void eatCarrotonyou() {
        World myWorld = getWorld();
        List<Carrot> carrots = myWorld.getObjectsAt(getX(), getY(), Carrot.class);
        if (carrots.size() > 0) {
            Carrot carrot = carrots.get(0);
            myWorld.removeObject(carrot);
            setLife(getLife() + carrot.getWeight());
        }

    }

    public void takeItemsonyou() {
        World myWorld = getWorld();
        List<Items> items = myWorld.getObjectsAt(getX(), getY(), Items.class);
        if (items.size() > 0) {
            Items item = items.get(0);
            for (int i = 0; i < inventory.length; i++) {
                if (inventory[i] == null) {
                    inventory[i] = item;
                    myWorld.removeObject(item);
                    break;
                }
            }
        }
    }


    public void placeCarrot(int x, int y) {
        for (int i = 0; i < inventory.length; i++) {

            if (inventory[i] != null) {
                World world = getWorld();
                Items items = inventory[i];
                world.addObject(items, x, y);
                inventory[i] = null;
                break;
            }
        }
    }

    public void placeCarrotonyou() {
        int x = getX();
        int y = getY();
        placeCarrot(x, y);
    }

    public void consumStamina() {
        stamina = stamina - 1;
    }

    public void move() {
        if (canMove()) {
            if (stamina > 1) {
                move(1);
                consumStamina();
            }
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

    public void hitMonster() {
        World myWorld = getWorld();
        List<Monster> monsters = getNeighbours(1, true, Monster.class);
        monsters.addAll(getIntersectingObjects(Monster.class));
        if (monsters.size() > 0) {
            monsters.get(0).hit(damageP);
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
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] instanceof Crystal) {
                int x = getX();
                int y = getY();
                Unicorn unicorn = new Unicorn();
                unicorn.setInventory(this.inventory);
                getWorld().addObject(unicorn, x, y);
                getWorld().removeObject(this);
            }
        }
    }
}