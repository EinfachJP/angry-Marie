import greenfoot.*;  // Importe f�r Greenfoot-Klassen

public class Menu extends World {
    private static final int BUTTON_WIDTH = 150;
    private static final int BUTTON_HEIGHT = 50;

    public Menu() {
        super(1, 1, 40);  // Gr��e der Welt
        GreenfootImage cell2 = new GreenfootImage("cell.Teleporter.jpg");
        cell2.scale(180, 180);
        setBackground(cell2);
        setPaintOrder(Star.class, Player.class, Carrot.class, Rock.class);
        prepareMenu();
    }

    private void prepareMenu() {
        // F�ge Buttons zum Men� hinzu
        addObject(new StartButton(), 1, 21);
        addObject(new QuitButton(), 2, 21);
    }
}