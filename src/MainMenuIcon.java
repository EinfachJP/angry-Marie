import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.World;

public class MainMenuIcon extends BlockingObject {

    private World level1 = getWorld();
    private World mainMenu = new MainMenu();

    public MainMenuIcon() {
        GreenfootImage mainMenuIcon = new GreenfootImage("StoppButton.png");
        mainMenuIcon.scale(40, 40);
        setImage(mainMenuIcon);
    }

    public void act() {
        super.addedToWorld(level1);
        if (level1 == null) {
            level1 = getWorld();
        }
        menucontrol();
    }

        public void menucontrol () {
            if (Greenfoot.mouseClicked(this)) {
                World myWorld = getWorld();
                if (myWorld == level1) {
                    moveMainMenu();
                }
                if (myWorld == mainMenu) {
                    moveMenuBack();
                }
            }
        }

        public void moveMainMenu () {
            level1.removeObject(this);
            mainMenu.addObject(this, 9, 9);
            Greenfoot.setWorld(mainMenu);
        }

        public void moveMenuBack () {
            mainMenu.removeObject(this);
            level1.addObject(this, 0, level1.getHeight());
            Greenfoot.setWorld(level1);
        }
    }
