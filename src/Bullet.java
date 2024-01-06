import greenfoot.*;

import java.util.List;

public class Bullet extends Actor {
    public Bullet(int width, int height) {
        GreenfootImage cristal = new GreenfootImage("bullet.png");
        cristal.scale(width, height);
        setImage(cristal);
    }
    public void act() {
        move(5);
        if (getX() < 0 || getX() >= getWorld().getWidth() || getY() < 0 || getY() >= getWorld().getHeight()) {
            getWorld().removeObject(this);
        }
        hitMonster();
    }
    public void hitMonster() {
        World myWorld = getWorld();
        List<Monster> monsters = getNeighbours(1, true, Monster.class);
        monsters.addAll(getIntersectingObjects(Monster.class));
        if (monsters.size() > 0) {
            monsters.get(0).hit(2);
        }
    }
}

