import greenfoot.Greenfoot;


import java.util.List;

public class Monster extends Character {
    //Attribute



    private static final int CRYSTAL_DROP_CHANCE = 1;
    private static final int GUN_DROP_CHANCE = 5;
    private static final int CARROT_DROP_CHANCE = 50;


    public Monster(int life, int monsterDamage) {
        super(30,30);
        setMonsterLife(life);
        setDamage(monsterDamage);
    }


//Methoden

    public void act() {
        performMovement();
        super.act();
        hitPlayer();
        if (getMonsterLife() <= 0) {
            dropItem();
            die();
        }
    }
    public void dropItem() {
        int randomNumber = Greenfoot.getRandomNumber(50);
        int fiftyFifty = Greenfoot.getRandomNumber(2);
        if (fiftyFifty == 0) {
            if (randomNumber < CRYSTAL_DROP_CHANCE) {
                getWorld().addObject(new Crystal(30, 30), getX(), getY());
            } else if (randomNumber < GUN_DROP_CHANCE) {
                getWorld().addObject(new Gun(30, 30), getX(), getY());
            } else {
                getWorld().addObject(new Carrot(5, 20, 20), getX(), getY());
            }
        } else {
            int x = getX();
            int y = getY();
            Rock rock = new Rock();
            getWorld().addObject(rock, x, y);
        }
    }


    public void performMovement() {
        int rngDirection = Greenfoot.getRandomNumber(4);

        int currentX = getX();
        int currentY = getY();

        if (rngDirection == 0) {
            turn(Direction.NORTH);
            move(1);
        } else if (rngDirection == 1) {
            turn(Direction.WEST);
            move(1);
        } else if (rngDirection == 2) {
            turn(Direction.SOUTH);
            move(1);
        } else if (rngDirection == 3) {
            turn(Direction.EAST);
            move(1);
        }
        if (getOneIntersectingObject(Items.class) != null) {
            setLocation(currentX, currentY);
        }
    }

    public void hitPlayer() {
        List<Player> players = getNeighbours(1,true,Player.class);
        if (players.size() > 0) {
            players.get(0).hit(getDamage());
        }
    }
    private void die() {
        getWorld().removeObject(this);
    }
}