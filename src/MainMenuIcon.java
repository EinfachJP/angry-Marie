import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.World;

public class MainMenuIcon extends BlockingObject{




    public MainMenuIcon(){
        GreenfootImage mainMenuIcon = new GreenfootImage("StoppButton.png");
        mainMenuIcon.scale(40,40);
        setImage(mainMenuIcon);
    }
    public void act(){
        openMenu();
    }
    int mm = 0;
    public void openMenu(){
        if (Greenfoot.mouseClicked(this)) {
            moveMainMenu();
            mm=mm+1;
        }
    }
    public void moveMainMenu() {
        World mainMenu = new MainMenu();
        World myWorld = getWorld();
            myWorld.removeObject(this);
            mainMenu.addObject(this, 3, 4);

            Greenfoot.setWorld(mainMenu);
            System.out.println(mm);

    }






}
