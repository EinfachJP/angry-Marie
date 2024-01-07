import greenfoot.*;  // Importe f�r Greenfoot-Klassen

public class Men� extends World {
    private static final int BUTTON_WIDTH = 150;
    private static final int BUTTON_HEIGHT = 50;

    public Men�() {
        super(1, 1, 40);  // Gr��e der Welt
        GreenfootImage cell2 = new GreenfootImage("cell.Teleporter.jpg");
        cell2.scale(180, 180);
        setBackground(cell2);
        setPaintOrder(Star.class, Player.class, Carrot.class, Rock.class);
        prepareMenu();
    }

    private void prepareMenu() {
        // F�ge Buttons zum Men� hinzu
        addObject(new StartButton(), getWidth() / 2, getHeight() / 2 - 50);
        addObject(new QuitButton(), getWidth() / 2, getHeight() / 2 + 50);
    }
}