import greenfoot.*;
import java.util.List;
public class Human extends Player {
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
    public Human(int life, int stamina) {
        super(50, 50);
        setLife(life);
        setStamina(stamina);
    }

    public Human() {
        super();
    }





    /**
     * getter, setter
     */
    public float getStamina() {
        return stamina;
    }

    public void setStamina(float newStamina) {
        stamina = newStamina;
        getImage().drawString(String.valueOf(stamina), 0, 20);
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
}