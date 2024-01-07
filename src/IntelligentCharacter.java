import greenfoot.Greenfoot;
import greenfoot.World;
import java.util.List;
public class IntelligentCharacter extends Character {

    public int life;
    public InventoryVisualizer visualizer;
    public Items[] inventory = new Items[10];
    public World level1 = null;
    public int damageP = 5;
    public float stamina = 40;


    public IntelligentCharacter(int sizeX, int sizeY) {
        super(sizeX, sizeY);
    }
    public IntelligentCharacter() {
        super();
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setStamina(float newStamina) {
        stamina = newStamina;
        //getImage().drawString(String.valueOf(stamina), 0, 20);
    }

    public void setInventory(Items[] playerInventory) {
        this.inventory = new Items[playerInventory.length];
        System.arraycopy(playerInventory, 0, this.inventory, 0, playerInventory.length);
    }

    public void takeItemsOnYou() {
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

    public void act() {
        draw(life);
        itemNumber();
        dead();
    }

    public void itemNumber() {
        int i;
        if (Greenfoot.isKeyDown("1")) {
            i = 0;
            placeItem(getX(), getY(), i);
        }
        if (Greenfoot.isKeyDown("2")) {
            i = 1;
            placeItem(getX(), getY(), i);
        }
        if (Greenfoot.isKeyDown("3")) {
            i = 2;
            placeItem(getX(), getY(), i);
        }
        if (Greenfoot.isKeyDown("4")) {
            i = 3;
            placeItem(getX(), getY(), i);
        }
        if (Greenfoot.isKeyDown("5")) {
            i = 4;
            placeItem(getX(), getY(), i);
        }
        if (Greenfoot.isKeyDown("6")) {
            i = 5;
            placeItem(getX(), getY(), i);
        }
        if (Greenfoot.isKeyDown("7")) {
            i = 6;
            placeItem(getX(), getY(), i);
        }
        if (Greenfoot.isKeyDown("8")) {
            i = 7;
            placeItem(getX(), getY(), i);
        }
        if (Greenfoot.isKeyDown("9")) {
            i = 8;
            placeItem(getX(), getY(), i);
        }
        if (Greenfoot.isKeyDown("0")) {
            i = 9;
            placeItem(getX(), getY(), i);
        }
        if(Greenfoot.isKeyDown("c")){
            craftGun();
        }
    }
    public void craftGun(){
        World myWorld = getWorld();
        List<Stone> stones = myWorld.getObjectsAt(getX(), getY(), Stone.class);
        List<Gold> golds = myWorld.getObjectsAt(getX(), getY(), Gold.class);
        List<Lumber> lumbers = myWorld.getObjectsAt(getX(), getY(), Lumber.class);
        if (lumbers.size() > 2 && stones.size() > 4 && golds.size() > 2){
            getWorld().addObject(new Gun(20, 20), getX(), getY());
            myWorld.removeObject(lumbers.get(0));
            myWorld.removeObject(stones.get(0));
            myWorld.removeObject(stones.get(1));
            myWorld.removeObject(stones.get(2));
            myWorld.removeObject(stones.get(3));
            myWorld.removeObject(golds.get(0));
            myWorld.removeObject(golds.get(1));
        }
    }
    public void placeItem(int x, int y, int i) {
        if (inventory[i] != null) {
            World world = getWorld();
            Items items = inventory[i];
            world.addObject(items, x, y);
            inventory[i] = null;
        }

    }

        public boolean pickaxeInInv() {
            for (Items items : inventory) {
                if (items instanceof Pickaxe) {
                    return true;
                }
            }
            return false;
        }
    public boolean axeInInv() {
        for (Items items : inventory) {
            if (items instanceof Axe) {
                return true;
            }
        }
        return false;
    }
    public void destroyTree(){
        if (!canMove()) {
            World myWorld = getWorld();
            List<Tree> trees = myWorld.getObjectsAt(getNextX(1), getNextY(1), Tree.class);
            if (trees.size() > 0 && axeInInv()) {
                Tree tree = trees.get(0);
                tree.hit();
                myWorld.removeObject(tree);
            }
        }
    }

    public void destroyRock(){
        if (!canMove()) {
            World myWorld = getWorld();
            List<Rock> rocks = myWorld.getObjectsAt(getNextX(1), getNextY(1), Rock.class);
            if (rocks.size() > 0 && pickaxeInInv()) {
                Rock rock = rocks.get(0);
                rock.hit();
                myWorld.removeObject(rock);

            }
        }
    }


    public void eatCarrotOnYou() {
        World myWorld = getWorld();
        List<Carrot> carrots = myWorld.getObjectsAt(getX(), getY(), Carrot.class);
        if (carrots.size() > 0) {
            Carrot carrot = carrots.get(0);
            myWorld.removeObject(carrot);
            if(getLife() < 89){
                setLife(getLife() + carrot.getWeight());
            }
        }
    }
    public void hitMonster() {
        List<Monster> monsters = getNeighbours(1, true, Monster.class);
        monsters.addAll(getIntersectingObjects(Monster.class));
        if (monsters.size() > 0) {
            monsters.get(0).hit(damageP);
        }
    }

    protected void addedToWorld(World world) {
        super.addedToWorld(world);
        if (level1 == null) {
            level1 = getWorld();
        }
        visualizer = new InventoryVisualizer(inventory);
        world.addObject(visualizer, 5, world.getHeight() - 1);
    }

    public void consumeStamina() {
        stamina = stamina ;
    }

    public void move() {
        if (canMove()) {
            if (stamina > 1) {
                move(1);
                consumeStamina();
            }
        }
    }

    public void hit(int damage) {
        if (life>0) {
            setLife(getLife() - damage);
        }
    }
    public void dead(){
        if(getLife()<=0){
            getWorld().addObject(new GameOver(),10, 10);
            setLife(0);
        }
    }
}