import greenfoot.*;
import java.util.List;
public class Player extends Charakter {
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
    private World[][] worlds = new World[10][10];
    private int xWorld = 0;
    private int yWorld = 9;
    //Konstruktoren
    public Player() {
        super(30,30);
        setLife(100);
        setStamina(20);
    }

    public Player(int life) {
        super(30,30);
        setLife(life);
    }



    public Player(int life, float stamina) {
        super(30,30);
        setLife(life);
        setStamina(stamina);
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
        world.addObject(visualizer,0, world.getHeight()-1);
    }


    private void performMovement() {
        if (Greenfoot.isKeyDown("W")) {
            turn(Direction.NORTH);
            if(getY()>0) {
                move();
            }
            else {
                getToNewWorld(0);
            }
        }
        if (Greenfoot.isKeyDown("D")) {
            turn(Direction.EAST);
            if(getX()<19) {
                move();
            }
            else {
                getToNewWorld(1);
            }
        }
        if (Greenfoot.isKeyDown("S")) {
            turn(Direction.SOUTH);
            if(getY()>19) {
                move();
            }
            else {
                getToNewWorld(2);
            }
        }
        if (Greenfoot.isKeyDown("A")) {
            turn(Direction.WEST);
            if(getX()>0) {
                move();
            }

            else {
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
        }
    }

    public void moveWorld(World newWorld,int myNewX,int myNewY) {


        World myWorld = getWorld();

        myWorld.removeObject(this);
        newWorld.addObject(this, myNewX, myNewY);
        Greenfoot.setWorld(newWorld);
    }
    public void getToNewWorld(int direction){
        int myNewX = getX();
        int myNewY = getY();

        if((direction==0)&(yWorld!=0)){
            yWorld = yWorld-1;
            myNewY = 9;
        }
        if((direction==1)&(xWorld!=9)){
            xWorld = xWorld+1;
            myNewX = 0;
        }
        if((direction==2)&(yWorld!=9)){
            yWorld = yWorld-1;
            myNewY = 0;
        }
        if((direction==3)&(xWorld!=0)){
            xWorld = xWorld+1;
            myNewY = 9;
        }
        World newWorld = worlds[xWorld][yWorld];
        moveWorld(newWorld,myNewX,myNewY);
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