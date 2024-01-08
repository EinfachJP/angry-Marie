import greenfoot.*;
public class StartButton extends Character {
    public StartButton() {
        getImage().drawString("StartButton.png", 20, 30);
    }

    public void act() {
        super.act();
        if (Greenfoot.mouseClicked(this)) {
            removeMainMenu();
            // F�hre Aktion f�r den Start-Button aus
            Greenfoot.setWorld(new Level1());  // Wechsel zur Spielwelt
        }
    }


    public void removeMainMenu() {
        World myWorld = getWorld();
        myWorld.removeObject(this);
    }







}
