import greenfoot.Greenfoot;
import greenfoot.World;

import java.util.List;

public class Monster extends Charakter {
    //Attribute



    private static final int CRYSTAL_DROP_CHANCE = 1;
    private static final int GUN_DROP_CHANCE = 5;


    public Monster(int life, int monsterDamage) {
        super(30,30);
        setLife(life);
        setDamage(monsterDamage);
    }


//Methoden

    public void act() {
        performMovement();
        super.act();
        hitPlayer();
        if (getLife() <= 0) {
            dropItem();
            die();
        }
    }
    public void dropItem() {
        Items items = new Items();
        int randomNumber = Greenfoot.getRandomNumber(100);

        if (randomNumber < CRYSTAL_DROP_CHANCE) {
            getWorld().addObject(new Crystal(30,30), getX(), getY());
        } else if (randomNumber < GUN_DROP_CHANCE) {
            getWorld().addObject(new Gun(30,30), getX(), getY());
        } else {
            getWorld().addObject(new Carrot(5,20,20), getX(), getY());
        }
    }

    public void performMovement() {
        int rngDirection = Greenfoot.getRandomNumber(4);
        int steps = Greenfoot.getRandomNumber(1);
            if (rngDirection == 0) {
                turn(Direction.NORTH);
                move(1);
            }
            if (rngDirection == 1) {
                turn(Direction.WEST);
                move(1);
            }
            if (rngDirection == 2) {
                turn(Direction.SOUTH);
                move(1);
            }
            if (rngDirection == 3) {
                turn(Direction.EAST);
                move(1);
            }
    }

    public void hitPlayer() {
        World myWorld = getWorld();
        List<Player> players = getNeighbours(1,true,Player.class);
        if (players.size() > 0) {
            players.get(0).hit(getDamage());
        }
    }
    private void die() {
        getWorld().removeObject(this);
    }
}