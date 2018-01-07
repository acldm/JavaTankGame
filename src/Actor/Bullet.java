package Actor;

import Actor.MapBlock.WallPart;
import Actor.MapBlock.Water;
import Main.*;
import Util.*;
import Util.DirectionState;
import java.awt.Graphics2D;
import java.awt.image.ImageObserver;

public class Bullet extends Actor {
    Tank parentActor;
    Class parentActorClass;
	public Bullet(DirectionState d, int x, int y, Scene scene, Tank actor) {
		super("img/player/bullet.png", scene);
		this.setPosition(x, y);
		this.parentActor = actor;
		this.parentActorClass = this.parentActor.getClass();

		this.dirState = d;

        this.setWidth(12);
		this.setHeight(12);

		if (dirState.value() == DirectionState.Up.value()) {
			this.setSpeed(0, -8);
		}
		else if (dirState.value() == DirectionState.Down.value()) {
			this.setSpeed(0, 8);
		}
		else if (dirState.value() == DirectionState.Left.value()) {
			this.setSpeed(-8, 0);
		}
		else if (dirState.value() == DirectionState.Right.value()) {
			this.setSpeed(8, 0);
		}
	}

	@Override
	public void gUpdate() {
	    this.Move(speedX, speedY);
	    collide();
	}


	//此段代码采用硬编，不便理解，
	public void collide() {
        if (GUtil.isColliderMapEdge(this)) {
            this.alive = false;
            Destory();
        }

        this.parentScene.getActorsStream().forEach((a) -> {
            if (a instanceof SolidObject && a != this.parentActor) {
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

	@Override
	public void gDraw(Graphics2D g2, ImageObserver i) {
		g2.drawImage(this.image, this.getPosX(), this.getPosY(), i);
	}


	public void Destory() {
		this.parentActor.isBullet = true;
		super.Destory();
	}
}
