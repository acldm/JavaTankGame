package Scene;

import Main.GMain;
import Util.EnemyManager;
import Main.Scene;
import Util.MapCreater;

public class Game2Scene extends Scene {
    public Game2Scene(GMain gmain) {
        super(gmain);
        player = new Actor.PlayerTank(this, 140, 384);
        heart = new Actor.Heart(this);

        this.addChild(player);

        this.addChild(new EnemyManager(this, 6));
        this.addChild(heart);
        new MapCreater(new Integer[] {
                0,0,0,0,0,0,0,1,1,1,0,0,0,
                0,1,1,1,14,0,14,0,0,1,0,0,0,
                0,0,0,0,1,0,12,0,0,0,0,1,1,
                0,4,4,4,4,4,0,1,11,0,0,1,2,
                0,0,6,6,6,4,4,4,0,0,4,1,0,
                0,0,2,2,2,4,0,1,0,0,4,1,0,
                1,0,1,1,1,4,0,1,3,0,3,1,0,
                0,0,0,0,2,4,0,1,3,3,3,1,0,
                4,4,4,0,4,4,0,1,3,0,4,0,0,
                0,0,0,0,0,0,0,2,3,0,4,4,0,
                1,1,1,0,0,0,0,12,0,0,0,0,13,
                0,0,1,0,0,22,14,21,0,1,0,1,0,
                0,0,0,0,0,13,0,11,0,0,0,0,0
        }, this);

    }
}
