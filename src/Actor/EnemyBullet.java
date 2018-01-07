package Actor;

import Actor.MapBlock.WallPart;
import Actor.MapBlock.Water;
import Main.Scene;
import Util.DirectionState;
import Util.GUtil;

public class EnemyBullet extends Bullet {
    public EnemyBullet(DirectionState d, int x, int y, Scene scene, Tank actor) {
        super(d, x, y, scene, actor);
    }

    @Override
    public void collide() {
        if (GUtil.isColliderMapEdge(this)) {
            this.alive = false;
            Destory();
        }

        this.parentScene.getActorsStream().forEach((a) -> {
            if (a instanceof SolidObject && !(a instanceof EnemyTank)) {
                if (GUtil.RectCollider(this, a)) {
                    if (a instanceof WallPart) {
                        if (a instanceof  WallPart) {
                            a.Destory(this.dirState);
                        }
                        else {
                            a.Destory();
                        }
                        this.Destory();
                    }
                    else if (!(a instanceof Water)){
                        a.Destory();
                        this.Destory();
                    }
                }
            }
            else if (a instanceof Bullet && a!=this) {
                if (GUtil.RectCollider(this, a)) {
                    this.Destory();
                }
            }
        });
    }
}
