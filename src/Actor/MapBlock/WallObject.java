package Actor.MapBlock;

import java.awt.*;
import java.awt.image.ImageObserver;
import Main.*;
import Actor.SolidObject;
public class WallObject extends SolidObject {

    public WallObject(String path, Scene scene, int x, int y) {
        super(path, scene, x, y);
    }

    public WallObject(String[] paths, Scene scene, int x, int y) {
        super(paths, scene, x, y);
        //this.setPosition(x, y);
    }

    @Override
    public void gUpdate() {

    }

    @Override
    public void gDraw(Graphics2D g2, ImageObserver i) {
        g2.drawImage(this.image, this.getPosX(), this.getPosY(), i);
    }

    @Override
    public void Destory() {
        super.Destory();
    }
}
