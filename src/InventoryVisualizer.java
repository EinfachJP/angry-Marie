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