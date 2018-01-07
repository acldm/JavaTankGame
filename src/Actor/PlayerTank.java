package Actor;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import Main.*;
import Util.DirectionState;
import Util.GInput;
import Util.GUtil;
import Scene.GameOverScene;

public class PlayerTank extends Tank {

	public PlayerTank(Scene scene, int x, int y) {
		super(new String[] {
				"img/player/tank_01.png",
				"img/player/tank_02.png",
				"img/player/tank_03.png",
				"img/player/tank_04.png"
		}, scene, x, y);

		init();
	}

	public void init() {
		this.speedX = 4;
		this.speedY = 4;
		this.dirState = DirectionState.Up;
	}

	//private boolean canMove;
	@Override
	public void gUpdate() {

		keyevent();
		GUtil.colliderMapEdge(this);
	}
	
	@Override
	public void gDraw(Graphics2D g2, ImageObserver i) {
		g2.drawImage(this.images.get(dirState.value()), this.getPosX(), this.getPosY(), 32, 32 ,i);
	}

	@Override
	public void Destory() {
		this.alive = false;
		GameOverScene gs= new GameOverScene(this.parentScene.main);
		this.parentScene.main.changeScene(gs);
	}

	public void  keyevent() {

	    DirectionState oldDir = dirState;
		if (GInput.isKeyDown(KeyEvent.VK_LEFT)) {
			if (this.IsCanMove(-this.speedX, 0)) {
				this.Move(-this.speedX, 0);
			}

			dirState = DirectionState.Left;
		}
		else if (GInput.isKeyDown(KeyEvent.VK_RIGHT) ) {
			if (this.IsCanMove(this.speedX, 0)) {
				this.Move(this.speedX, 0);
			}
			dirState = DirectionState.Right;
		}
		else if (GInput.isKeyDown(KeyEvent.VK_UP)) {
			if (this.IsCanMove(0, -this.speedY)) {
				this.Move(0, -this.speedY);
			}
			dirState = DirectionState.Up;
		}
		else if (GInput.isKeyDown(KeyEvent.VK_DOWN) ) {
			if (this.IsCanMove(0, this.speedY)) {
				this.Move(0, this.speedY);
			}
			dirState = DirectionState.Down;
		}

		if (GInput.isKeyDown(KeyEvent.VK_Z)) {
			Shooting();
		}

		resetDir(oldDir, dirState);
	}

	public void resetDir(DirectionState oldDir, DirectionState newDir) {
	    if (oldDir != newDir && oldDir != DirectionState.findValueToOppositeDirectionState(newDir.value())) {
	        int x = this.getPosX();
            int y = this.getPosY();

	        if (this.getPosX() % 32 <= 10) {
	            x = Math.round((float)this.getPosX()  / 32) * 32 - x;
                if (this.IsCanMove(x, 0)) {
                    this.Move(x, 0);
                }
            }

            if (this.getPosY() % 32 <= 10) {
                y = Math.round((float)this.getPosY()  / 32) * 32 - y;
                if (this.IsCanMove(0, y)) {
                    this.Move(0, y);
                }
            }

        }
    }
}