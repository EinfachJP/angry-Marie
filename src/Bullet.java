import greenfoot.*;

import java.util.List;

public class Bullet extends Actor {
    public Bullet(int width, int height) {
        GreenfootImage bullet = new GreenfootImage("bullet.png");
        bullet.scale(width, height);
        setImage(bullet);
    }
    public void act() {
        move(2);
        hitMonster();
        checkEdge();
    }

    private void hitMonster() {
        List<Monster> monsters = getIntersectingObjects(Monster.class);
        if (!monsters.isEmpty()) {
            monsters.get(0).hit(2);
            getWorld().removeObject(this);
        }
    }
    private void checkEdge() {
        if (getWorld() != null && (getX() < 0 || getX() >= getWorld().getWidth() - 1 || getY() < 0 || getY() >= getWorld().getHeight() - 1)) {
            getWorld().removeObject(this);
        }
    }
}
