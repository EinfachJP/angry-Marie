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
    public void openMenu(){
        if (Greenfoot.mouseClicked(this)) {
            moveMainMenu();
        }
    }
    public void moveMainMenu() {
        World mainMenu = new MainMenu();
            Greenfoot.setWorld(mainMenu);

    }






}
