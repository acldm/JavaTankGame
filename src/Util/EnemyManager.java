package Util;

import Main.Actor;
import Main.Scene;
import Actor.NormalEnemyTank;
import Actor.SolidObject;
import Scene.WinnerScene;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.Collections;

public class EnemyManager extends Actor {

    private int enemyCount;
    private int sEnemyCount;
    private int dieEnemyCount = 0;
    private int aliveEnemy = 0;
    private int frame = 256;

    private boolean canMove;

    public EnemyManager(Scene scene, int enemyCount) {
        super(scene);
        this.enemyCount = enemyCount;
        this.sEnemyCount = enemyCount;
    }

    @Override
    public void gUpdate() {

        if (this.dieEnemyCount == sEnemyCount) {
            this.parentScene.main.changeScene(new WinnerScene( this.parentScene.main, this.dieEnemyCount));
        }

        if (this.aliveEnemy < 4 && frame >= 128 && this.enemyCount > 0) {
            if(createEnemyToScene()) {
                this.aliveEnemy ++;
                this.enemyCount --;
            }
        }

        if (frame >= 128) {
            frame = 0;
        }

        frame++;
    }

    private boolean createEnemyToScene() {

        this.canMove = true;
        Collections.shuffle(Config.enemyCreatePos);
        for (int pos : Config.enemyCreatePos) {
            this.parentScene.getActorsStream().forEach((a) -> {
                if (a instanceof SolidObject) {

                    if (GUtil.RectCollideIter(pos, 0, 28, 28, a.getPosX(), a.getPosY(), a.getWidth(), a.getHeight())) {
                        this.canMove = false;
                    }
                }
            });

            if (this.canMove) {
                NormalEnemyTank n = new NormalEnemyTank(this.parentScene, pos, 0, this.parentScene.player, this.parentScene.heart,this);
                this.parentScene.addChild(n);
                break;
            }
        }

        return this.canMove;
    }

    @Override
    public void gDraw(Graphics2D g2, ImageObserver i) {

    }

    public void subEnemy() {
        if (this.aliveEnemy > 0) {
            this.aliveEnemy -= 1;
        }
        this.dieEnemyCount += 1;
    }
}
