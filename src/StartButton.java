import greenfoot.*;
public class StartButton extends Character {
    public StartButton() {
        getImage().drawString("StartButton.png", 20, 30);
    }

    public void act() {
        super.act();
        if (Greenfoot.mouseClicked(this)) {
            // Führe Aktion für den Start-Button aus
            Greenfoot.setWorld(new Level1());  // Wechsel zur Spielwelt
        }
    }


}
