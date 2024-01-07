import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class GameOver extends Actor {
    public GameOver(){
        GreenfootImage gameover = new GreenfootImage("GAMEOVER.png");
        gameover.scale(651,83);
        setImage(gameover);
    }
}
