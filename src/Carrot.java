import greenfoot.Actor;
import greenfoot.GreenfootImage;
import greenfoot.Color;
public class Carrot extends Actor
{
    private int weight = 5;


    public Carrot(int weight, int width, int height){
        setWeight(weight);
        GreenfootImage carrot = new GreenfootImage("karotte.png");
        carrot.scale(width,height);
        setImage(carrot);
    }


    public int getWeight() {
        return weight;
    }

    public void setWeight(int newWeight){
        drawWeight(weight, newWeight);
        weight = newWeight;
        getImage().drawString(String.valueOf(weight), 0, 10);
    }
    private void drawWeight(int oldWeight, int newWeight){
        int x = 0;
        int y = 10;
        getImage().setColor(new Color(250,215,155)); //alten Text im Bild "unsichtbar machen"
        getImage().drawString(String.valueOf(oldWeight), x, y);
        getImage().setColor(Color.BLACK);
        getImage().drawString(String.valueOf(newWeight), x, y);
    }
}
