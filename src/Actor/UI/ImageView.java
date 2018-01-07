package Actor.UI;

import java.awt.*;
import java.awt.image.ImageObserver;
import Main.*;

//此类用于在画面上绘制图片
public class ImageView extends Actor {

    public ImageView(String path, Scene scene, int x, int y, int width, int height) {
        super(path, scene);
        setPosition(x, y);
        setWidth(width);
        setHeight(height);
    }

    @Override
    public void gUpdate() {

    }

    @Override
    public void gDraw(Graphics2D g2, ImageObserver i) {
        g2.drawImage(this.image, this.getPosX() - (this.getWidth()/2), this.getPosY(),this.getWidth(), this.getHeight(), i);
    }
}
