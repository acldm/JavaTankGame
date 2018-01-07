package Actor;

import Main.Scene;
import Util.GUtil;

import java.awt.*;
import java.awt.image.ImageObserver;

public class Tank extends SolidObject {
    private boolean canMove;
    public boolean isBullet = true;
    public Tank(String path, Scene scene, int x, int y) {
        super(path, scene, x, y);
    }

    public Tank(String[] paths, Scene scene, int x, int y) {
        super(paths, scene, x, y);
    }


    public synchronized boolean IsCanMove(int x, int y) {
        this.canMove = true;

        if (GUtil.isColliderMapEdgePos(this.getPosX() + x, this.getPosY() + y)) {
            this.canMove = false;
        }

        this.parentScene.getActorsStream().forEach((a) -> {
            if (a instanceof SolidObject && a != this) {
                if (GUtil.RectCollideIter(this.getPosX() + x, this.getPosY() + y, this.getWidth(), this.getHeight(),
                        a.getPosX(), a.getPosY(), a.getWidth() - 4, a.getHeight() -4)) {
                    this.canMove = false;
                }
            }
        });
        return this.canMove;
    }

    @Override
    public void gUpdate() {

    }

    @Override
    public void gDraw(Graphics2D g2, ImageObserver i) {

    }

    void Shooting() {
        if (this.isBullet) {
            this.parentScene.addChild(new Bullet(this.dirState, this.getPosX() +12, this.getPosY() +12, this.parentScene, this));
            this.isBullet = false;
        }
    }

}
