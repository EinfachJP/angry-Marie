import greenfoot.*;
public class QuitButton extends Character{
    public QuitButton() {
        getImage().drawString("StoppButton.png", 20, 30);
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            // F�hre Aktion f�r den Quit-Button aus
            Greenfoot.stop();  // Beende das Spiel
        }
    }
}
