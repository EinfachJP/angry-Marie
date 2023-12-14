import greenfoot.Greenfoot;
import greenfoot.World;

import java.util.List;

public class Monster extends Charakter {
    //Attribute



//Konstruktoren


    public Monster(int life, int monsterDamage) {
        super(30,30);
        setLife(life);
        setDamage(monsterDamage);
    }


//Methoden

    public void act() {
        //performMovement();
        super.act();
        hitPlayer();
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
}