import greenfoot.*;


public class InventoryVisualizer extends BlockingObject {

    private final InventorySlot[] slots;
    private final Actor[] inventory;

    public InventoryVisualizer(Actor[] inventory) {
        getImage().setTransparency(128);
        slots = new InventorySlot[inventory.length];
        this.inventory = inventory;
    }

    public void act(){
        update();
    }

    protected void addedToWorld(World world){
        for(int i=0; i < slots.length; i++){
            slots[i] = createItemSlot(i);
        }
    }

    private InventorySlot createItemSlot(int i) {
        InventorySlot slot = new InventorySlot();
        getWorld().addObject(slot, i+5, getY());
        return slot;
    }


    /**
     * Updates all inventory Slots at the bottom of the screen with the content of the given inventory Array
     */
    private void update() {
        int length = Math.min(inventory.length, this.slots.length);
        for (int i = 0; i < length; i++) {
            if (inventory[i] != this.slots[i].getItem()) {
                slots[i].setItem(inventory[i]);
            }
        }
    }

}
/*import greenfoot.*;

import java.util.Arrays;
import java.util.List;

import static java.lang.String.*;

public class InventoryVisualizer extends BlockingObjekt {

    private final InventorySlot[] slots;
    private final Actor[] inventory;
    private final Items[] visualizedInventory = new Items[8];
    private final int[] inventoryNumber = new int[8];
    public InventoryVisualizer(Actor[] inventory) {
        getImage().setTransparency(0);
        slots = new InventorySlot[visualizedInventory.length];
        this.inventory = inventory;
        System.out.print(inventory);
    }

    public InventoryVisualizer(List<Actor> inventory) {
        this(inventory.toArray(new Actor[0]));
    }

    public void act(){
        itemNumber();
        update();
    }


    protected void addedToWorld(World world){
        for(int i=0; i < slots.length; i++){
            slots[i] = createItemSlot(i);
        }
    }

    private InventorySlot createItemSlot(int i) {
        InventorySlot slot = new InventorySlot();
        getWorld().addObject(slot, i, getY());
        return slot;
    }

    public void itemNumber(){
        for(int j = 0; j< visualizedInventory.length-1; j++){
            for(int i= 0; i<= inventory.length-1; i++)
                if (visualizedInventory[j] == inventory[i] && inventory[i] != null) {
                    System.out.print("visualisiert = von player");
                    inventoryNumber[i]++;
                    System.out.println( inventoryNumber[i]);
                } else if(inventory[i] == null){
                    visualizedInventory[j] = (Items) inventory[i];
                    //System.out.print(inventory[i]);
                    //System.out.print(visualizedInventory[j]);
                }
        }

    }



      Updates all inventory Slots at the bottom of the screen with the content of the given inventory Array

private void update() {
    int length = Math.min(visualizedInventory.length, this.slots.length);
    for (int i = 0; i < length; i++) {
        if (visualizedInventory[i] != this.slots[i].getItem()) {
            slots[i].setItem(inventory[i]);
            getImage().drawString(new String(String.valueOf(inventoryNumber[i])),i , 19);

        }
    }
}

}

import greenfoot.*;

        import java.util.List;

public class InventoryVisualizer extends BlockingObjekt {

    private final InventorySlot[] slots;
    private final Actor[] inventory;
    private final Items[] visualizedInventory = new Items[8];
    private final int[] inventoryNumber = new int[8];

    public InventoryVisualizer(Actor[] inventory) {
        getImage().setTransparency(0);
        slots = new InventorySlot[visualizedInventory.length];
        this.inventory = inventory;
    }

    public InventoryVisualizer(List<Actor> inventory) {
        this(inventory.toArray(new Actor[0]));
    }

    public void act(){
        sortInventory();
        update();
    }

    protected void addedToWorld(World world){
        for(int i=0; i < slots.length; i++){
            slots[i] = createItemSlot(i);
        }
    }

    private InventorySlot createItemSlot(int i) {
        InventorySlot slot = new InventorySlot();
        getWorld().addObject(slot, i, getY());
        return slot;
    }




    public void sortInventory(){
        Actor[] visualizedInventory =inventory;
        for(int j = 0; j < visualizedInventory.length; j++) {
            for (int i = 0; i < inventory.length; i++) {
                if(visualizedInventory[j] ==inventory[i] &&  j < i){
                    this.inventory[i] = null;
                } else if(visualizedInventory[j] ==inventory[i] &&  j > i){
                    visualizedInventory[j] = null;
                }
                System.out.print(j);
                System.out.println(i);
            }
        }
    }


    /**
     * Updates all inventory Slots at the bottom of the screen with the content of the given inventory Array

    private void update() {
        sortInventory();
        int length = Math.min(inventory.length, this.slots.length);
        for (int i = 0; i < length; i++) {
            if (inventory[i] != this.slots[i].getItem()) {
                slots[i].setItem(inventory[i]);
            }
        }
    }

}




import greenfoot.*;

        import java.util.List;

public class InventoryVisualizer extends BlockingObjekt {

    private final InventorySlot[] slots;
    private final Actor[] inventory;
    private final Items[] visualizedInventory = new Items[8];
    private final int[] inventoryNumber = new int[8];

    public InventoryVisualizer(Actor[] inventory) {
        getImage().setTransparency(0);
        slots = new InventorySlot[visualizedInventory.length];
        this.inventory = inventory;
    }

    public InventoryVisualizer(List<Actor> inventory) {
        this(inventory.toArray(new Actor[0]));
    }

    public void act(){
        sortInventory();
        update();
    }

    protected void addedToWorld(World world){
        for(int i=0; i < slots.length; i++){
            slots[i] = createItemSlot(i);
        }
    }

    private InventorySlot createItemSlot(int i) {
        InventorySlot slot = new InventorySlot();
        getWorld().addObject(slot, i, getY());
        return slot;
    }




    public void sortInventory(){
        Actor[] visualizedInventory =inventory;
        for(int j = 0; j < visualizedInventory.length; j++) {
            for (int i = 0; i < inventory.length; i++) {
                if(visualizedInventory[j] ==inventory[i] &&  j < i){
                    this.inventory[i] = null;
                } else if(visualizedInventory[j] ==inventory[i] &&  j > i){
                    visualizedInventory[j] = null;
                }
                System.out.print(j);
                System.out.println(i);
            }
        }
    }


    /**
     * Updates all inventory Slots at the bottom of the screen with the content of the given inventory Array

    private void update() {
        sortInventory();
        int length = Math.min(inventory.length, this.slots.length);
        for (int i = 0; i < length; i++) {
            if (inventory[i] != this.slots[i].getItem()) {
                slots[i].setItem(inventory[i]);
            }
        }
    }

}*/
