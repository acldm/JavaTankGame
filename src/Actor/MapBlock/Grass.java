package Actor.MapBlock;
import Main.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class Grass extends Actor {


    public Grass(Scene scene, int x, int y) {
        super("img/block/block_03.png", scene);
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
