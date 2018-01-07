package Actor;

import Main.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class BombAnimate extends Actor {
    private int index = 0;
    private int frame = 0;
    public BombAnimate(Scene scene, int x, int y) {
        super(new String[] {
            "img/bomb/bomb_04.png",
                "img/bomb/bomb_05.png",
                "img/bomb/bomb_06.png",
                "img/bomb/bomb_07.png",
                "img/bomb/bomb_08.png",

        }, scene);
        setPosition(x, y);
    }

    @Override
    public void gUpdate() {

        if (frame++ >= 2) {
            index += 1;
            frame = 0;
        }
    }

    @Override
    public void gDraw(Graphics2D g2, ImageObserver i) {
        if (index >= this.images.size()) {
            this.Destory();
            return;
        }
        g2.drawImage(this.images.get(index), this.getPosX(), this.getPosY(), i);
    }
}
