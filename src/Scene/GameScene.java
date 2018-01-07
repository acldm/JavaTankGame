package Scene;

import Actor.PlayerTank;
import Main.GMain;
import Util.EnemyManager;
import Main.Scene;
import Util.MapCreater;

public class GameScene extends Scene {

    public GameScene(GMain gmain) {
        super(gmain);
        player = new PlayerTank(this, 140, 384);
        heart = new Actor.Heart(this);

        this.addChild(player);

        this.addChild(new EnemyManager(this, 12));
        this.addChild(heart);
        new MapCreater(new Integer[] {
                0,0,0,0,0,0,0,0,0,0,0,0,0,
                0,1,0,1,0,1,0,1,0,1,0,1,0,
                0,1,0,1,0,1,2,1,0,1,0,1,0,
                0,1,0,1,0,1,0,1,0,1,0,1,0,
                0,1,0,1,0,0,0,0,0,1,0,1,0,
                0,0,0,0,0,1,0,1,0,0,0,0,0,
                2,0,1,1,0,0,0,0,0,1,1,0,2,
                0,0,0,0,0,1,0,1,0,0,0,0,0,
                0,1,0,1,0,1,1,1,0,1,0,1,0,
                0,1,0,1,0,1,0,1,0,1,0,1,0,
                0,1,0,1,0,0,0,0,0,1,0,1,0,
                0,1,0,1,0,22,14,21,0,1,0,1,0,
                0,0,0,0,0,13,0,11,0,0,0,0,0
        }, this);
    }
}
