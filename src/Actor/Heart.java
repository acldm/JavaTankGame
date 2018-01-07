package Actor;
import Main.*;
import Scene.GameOverScene;
import java.awt.*;
        import java.awt.image.ImageObserver;

public class Heart extends SolidObject {
    public Heart(Scene scene) {
        super("img/heart.png", scene, 192, 384);
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
        this.alive  = false;
        this.parentScene.main.changeScene(new GameOverScene(this.parentScene.main));
    }
}
