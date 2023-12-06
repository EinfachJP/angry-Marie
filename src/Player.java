import greenfoot.*;
import java.util.List;
public class Player extends Carakter {
    //Attribute
    private Carrot[] inventory =  new Carrot[8];
    private float stamina = 20;
    private int damageP = 5;
    private int oldY = 0;
    private int oldX = 0;
    private float srgT = 0.1f;
    private World level2 = new Level2();
    private World level1 = null;
    private InventoryVisualizer visualizer;
    //Konstruktoren


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
        world.addObject(visualizer,0, world.getHeight()-1);
    }


    private void performMovement() {
        if (Greenfoot.isKeyDown("W")) {
            turn(Direction.NORTH);
            move();
        }
        if (Greenfoot.isKeyDown("D")) {
            turn(Direction.EAST);
            move();
        }
        if (Greenfoot.isKeyDown("S")) {
            turn(Direction.SOUTH);
            move();
        }
        if (Greenfoot.isKeyDown("A")) {
            turn(Direction.WEST);
            move();
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
        if (Greenfoot.isKeyDown("T")) {
            moveLevel();
        }
        if (Greenfoot.isKeyDown("F")) {
            hitMonster();
        }
        if (Greenfoot.isKeyDown("M")) {
            takeCarrotonyou();
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

    public void takeCarrotonyou() {
        World myWorld = getWorld();
        List<Carrot> carrots = myWorld.getObjectsAt(getX(), getY(), Carrot.class);
        if (carrots.size() > 0) {
            Carrot carrot = carrots.get(0);
            for (int i = 0; i < inventory.length; i++) {
                if (inventory[i] == null) {
                    inventory[i] = carrot;
                    myWorld.removeObject(carrot);
                    break;
                }
            }
        }
    }


    public void placeCarrot(int x, int y) {
        for (int i = 0; i < inventory.length; i++) {

            if (inventory[i] != null) {
                World world = getWorld();
                Carrot carrot = inventory[i];
                world.addObject(carrot, x, y);
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


    public Player() {
        setLife(100);
        setStamina(20);
    }

    public Player(int life) {
        setLife(life);
    }



    public Player(int life, float stamina) {
        setLife(life);
        setStamina(stamina);
    }


    public float getStamina() {
        return stamina;
    }

    public void setStamina(float newStamina) {
        stamina = newStamina;
        getImage().drawString(String.valueOf(stamina), 0, 20);
    }

    /**
     * moves one step forwardA
     */
    public void move() {
        if (canMove()) {
            if (stamina > 1) {
                move(1);
                consumStamina();
            }
        } else {
            setLife(getLife() - 10);
        }

    }

    public void moveLevel() {

        int x = getX();
        int y = getY();
        World myWorld = getWorld();
        if (myWorld== level1) {

            if (x < 9 && y == 0) {
                level1.removeObject(this);
                level2.addObject(this, 3, 4);

                Greenfoot.setWorld(level2);

            }
        }
        if (myWorld == level2) {
            if (x < 9 && y == 6) {
                level2.removeObject(this);
                level1.addObject(this, 3, 4);
                Greenfoot.setWorld(level1);

            }
        }
    }

    public void regenStamina() {
        int x = getX();
        int y = getY();
        if (oldX == x && oldY == y) {
            if (stamina < 50) {
                stamina = stamina + srgT;
                srgT = srgT + 0.05f;
            }
        }else{
            srgT = 0.1f;
        }
        oldX=x;
        oldY=y;
    }
    public void hitMonster() {
        World myWorld = getWorld();
        List<Monster> monsters = getNeighbours(1,true,Monster.class);
        monsters.addAll(getIntersectingObjects(Monster.class));
        if (monsters.size() > 0) {
            monsters.get(0).hit(damageP);
        }
    }


}