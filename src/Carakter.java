import greenfoot.Greenfoot;
import greenfoot.World;
import java.util.List;
public class Carakter extends MovingActor {

    private int life = 4;
    private int damage = 2;



    public void act() {
        draw(life);
    }


    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void hit(int damage) {
        if (life>0) {
            setLife(getLife() - damage);
            int life = getLife();
        }
    }








}