package Actor.MapBlock;

import Main.Scene;
import Util.DirectionState;

import java.awt.*;
import java.awt.image.ImageObserver;

public class WallPart extends WallObject {

    public WallPart(Scene scene, int x, int y) {
        super("img/block/block_part.png", scene, x, y);
        this.setWidth(16);
        this.setHeight(16);
    }

    @Override
    public void gDraw(Graphics2D g2, ImageObserver i) {
        int x = this.getPosX();
        int y = this.getPosY();
        int width = this.getWidth();
        int height = this.getHeight();
        g2.drawImage(this.image, x, y,
                x + width,y + height,
                0, 0, width, height, i);
    }

    @Override
    public void Destory(DirectionState dirState) {

        //注意:相邻两个判断之间没有 break;
        switch (dirState) {
            case Right:
                this.setPosX(this.getPosX() + 8);
            case Left:
                this.setWidth(this.getWidth() - 8);
                break;

            case Down:
                this.setPosY(this.getPosY() + 8);
            case Up:
                this.setHeight(this.getHeight() - 8);
                break;

            default:
                break;
        }

        if (this.getHeight() <=0 || this.getWidth() <=0) {
            this.alive = false;
        }
    }
}
