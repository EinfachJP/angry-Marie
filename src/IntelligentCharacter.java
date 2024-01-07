import greenfoot.World;
import java.util.List;
public class IntelligentCharacter extends Character {

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

    public void placeItem(int x, int y) {
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

    public void placeItemHere() {
        int x = getX();
        int y = getY();
        placeItem(x, y);
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
    public void hitMonster() {
        World myWorld = getWorld();
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


}