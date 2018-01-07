package Actor.MapBlock;

import java.awt.*;
import java.awt.image.ImageObserver;
import Main.*;
public class Snow extends Actor {

    public Snow(Scene scene, int x, int y) {
        super("img/block/block_06.png", scene);
        this.setPosition(x, y);
    }

    @Override
    public void gUpdate() {

    }

    @Override
    public void gDraw(Graphics2D g2, ImageObserver i) {
        g2.drawImage(this.image, this.getPosX(), this.getPosY(), i);
    }

}
