public class Character extends MovingActor{
    private int monsterLife = 4;
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

    public int getMonsterLife() {
        return monsterLife;
    }

    public void setMonsterLife(int life) {
        this.monsterLife = life;
    }



    public void act() {
        draw(monsterLife);
    }

    public void hit(int damage) {
        if (monsterLife>0) {
            setMonsterLife(getMonsterLife() - damage);
        }
    }
}
