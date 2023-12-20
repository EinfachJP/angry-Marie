import greenfoot.Actor;
import greenfoot.GreenfootImage;
import greenfoot.Color;
import greenfoot.World;

import java.util.List;


public class Items extends Actor {
    public void carrotStack(){
        if(getX()==0 & getY()==21){
            World myWorld = getWorld();
            List<Carrot> carrots = myWorld.getObjectsAt(getX(), getY(), Carrot.class);
            getImage().drawString(String.valueOf(carrots.size()), 0, 20);
        }


    }
}
