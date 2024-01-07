import greenfoot.*;
public class StartButton extends Charakter {
    public StartButton() {
        getImage().drawString("StartButton.png", 20, 30);
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            // F�hre Aktion f�r den Start-Button aus
            Greenfoot.setWorld(new Level1());  // Wechsel zur Spielwelt
        }
    }
}
