public class Character extends MovingActor{
    private int life = 4;
    private int damage = 2;

    public Character(int sizeX, int sizeY) {
        super(sizeX, sizeY);
    }


    public Character() {
        super();
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



    public void act() {
        draw(life);
    }

    public void hit(int damage) {
        if (life>0) {
            setLife(getLife() - damage);
            int life = getLife();
        }
    }
}