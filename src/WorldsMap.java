import greenfoot.Greenfoot;
import greenfoot.World;

public class WorldsMap {
    private static WorldsMap map = null;
    private static World[][] worlds = new World[20][20];
    private int xWorld = 0;
    private int yWorld = 19;

    private WorldsMap(Level1 level) {

        for(int i=19;i>=0;i--){
            for(int j=0;j<20;j++){
                worlds[i][j] = new Level2();
            }
        }
        worlds[0][19] = level;

    }

    public static WorldsMap getInstance(Level1 level){
        if (map == null){
            map = new WorldsMap(level);
        }
        return map;
    }
    public void moveWorld (int direction, Player player, World world){
        int newPlayerX = player.getX();
        int newPlayerY = player.getY();
        if ((direction == 0) & (yWorld != 0)) {
            yWorld = yWorld - 1;
            newPlayerX = 9;
        }
        if ((direction == 1) & (xWorld != 19)) {
            xWorld = xWorld + 1;
            newPlayerX = 0;
        }
        if ((direction == 2) & (yWorld != 19)) {
            yWorld = yWorld - 1;
            newPlayerY = 0;
        }
        if ((direction == 3) & (xWorld != 0)) {
            xWorld = xWorld + 1;
            newPlayerY = 9;
        }


        World newWorld = (worlds[xWorld][yWorld]);

        world.removeObject(player);
        newWorld.addObject(player,newPlayerX,newPlayerY);
        Greenfoot.setWorld(newWorld);

    }
}
