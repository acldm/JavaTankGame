package Actor.MapBlock;

import java.awt.*;
import java.awt.image.ImageObserver;
import Main.*;
import Actor.SolidObject;

public class Water extends SolidObject {
    private int playCount = 0;

    public Water(Scene scene, int x, int y) {
        super(new String[] {
            "img/block/block_04.png", "img/block/block_05.png"
        }, scene, x, y);
    }

    @Override
    public void gUpdate() {

    }

    @Override
    public void gDraw(Graphics2D g2, ImageObserver i) {
        g2.drawImage(this.images.get(playCount / 10), this.getPosX(), this.getPosY(), i);
        if (playCount == 19) playCount = 0;
        playCount++;
    }
}
