import greenfoot.*;
public class QuitButton extends Character{
    public QuitButton() {
        getImage().drawString("StoppButton.png", 20, 30);
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            // Führe Aktion für den Quit-Button aus
            Greenfoot.stop();  // Beende das Spiel
        }
    }
}
