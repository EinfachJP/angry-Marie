import greenfoot.GreenfootImage;

public class Stone extends Items{
    public Stone(){
        GreenfootImage stone = new GreenfootImage("rock.gif");
        stone.scale(10,10);
        setImage(stone);
    }
}
