package Actor.MapBlock;

import java.awt.*;
import java.awt.image.ImageObserver;
import Main.*;

public class LittleBlock extends WallObject {
    public LittleBlock(Scene scene, int x, int y) {
        super("img/block/little_block.png", scene, x, y);
        this.setWidth(8);
        this.setHeight(8);
    }

    @Override
    public void gDraw(Graphics2D g2, ImageObserver i) {
        super.gDraw(g2, i);
    }
}
