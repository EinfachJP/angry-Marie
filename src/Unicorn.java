import greenfoot.*;
import java.util.List;
public class Unicorn extends Player {
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


    public Unicorn() {
        super(45,45);
        setLife(100);
        setStamina(20);
    }

    public void act() {
        super.act();
        if (getLife() > 0) {
            performMovement();
            //getImage().drawString(String.valueOf(life), 0, 20);
            //draw((int) stamina);
            regenStamina();
        }
        if (Greenfoot.isKeyDown("v")) {
            transform();
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
    public void transform() {
        int x = getX();
        int y = getY();
        Human human = new Human();
        getWorld().addObject(human, x, y);
        getWorld().removeObject(this);
    }
}
