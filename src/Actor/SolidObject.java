package Actor;
import Main.*;
public abstract class SolidObject extends Actor {

    public SolidObject(String path, Scene scene, int x, int y) {
        super(path, scene);
        this.setPosition(x, y);
        this.setWidth(28);
        this.setHeight(28);
    }

    public SolidObject(String[] paths, Scene scene, int x, int y) {
        super(paths, scene);
        this.setPosition(x, y);
        this.setWidth(28);
        this.setHeight(28);
    }

}
