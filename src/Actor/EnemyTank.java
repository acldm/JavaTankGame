package Actor;
import Main.*;
import Util.DirectionState;
import Util.EnemyManager;
import Util.GUtil;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class EnemyTank extends Tank {
    private int distance = 64;
    private Actor searchTank;
    private Actor Heart;
    private EnemyManager enemyManager;
    private int distanceLength = 0;
    private boolean canMove = false;

    public EnemyTank(String[] paths, Scene scene, int x, int y, Actor searchTank, Actor Heart, EnemyManager enemyManager) {
        super(paths, scene, x, y);
        this.setPosition(x, y);
        this.searchTank = searchTank;
        this.Heart = Heart;
        this.speedX = 2;
        this.speedY = 2;
        this.enemyManager = enemyManager;

        this.setWidth(28);
        this.setHeight(28);
        this.dirState = DirectionState.Up;
    }

    @Override
    public void gUpdate() {
        if (distanceLength % 24 == 0) {
            Shooting();
        }
        distanceLength+=this.speedX;

        searchRoad2();

        int moveX = dirState.getX() * this.speedX;
        int moveY = dirState.getY() *this.speedY;

        boolean s = this.IsCanMove(moveX, moveY);
        if (s == true) {
            this.Move(moveX, moveY);
        }
    }

    public void searchRoad2() {
        ArrayList<int[]> dirs = new ArrayList<>();
        dirs.add(getBoxDown());
        dirs.add(getBoxUp());
        dirs.add(getBoxLeft());
        dirs.add(getBoxRight());

        java.util.List<int[]> s = dirs.stream().filter((a) -> {
            return IsCollide(a[0], a[1]);
        }).collect(Collectors.toList());

        DirectionState now = null;
        DirectionState back = null;
        DirectionState down = null;
        for (int[] m : s) {
            DirectionState ds = DirectionState.findValueToDirectionState(m[2]);
            if (ds == dirState) {
                now = ds;
            }

            if (DirectionState.findValueToOppositeDirectionState(m[2]) == dirState) {
                back = ds;
            }

            if (ds == DirectionState.Down) {
                down = ds;
            }
        }

        if (now == null) {
            Collections.shuffle(s);

            if (s.size() > 0)
                dirState = DirectionState.findValueToDirectionState(s.get(0)[2]);
            else {
                Collections.shuffle(dirs);
                dirState = DirectionState.findValueToDirectionState(dirs.get(0)[2]);
            }
        }
        else if (down != null) {
            if(back != down) {
                int r =  GUtil.getRandom1To10();
                if (r >= 7) {
                    dirState = down;
                }
            }
        }
    }

    @Override
    public void gDraw(Graphics2D g2, ImageObserver i) {
        g2.drawImage(this.images.get(dirState.value()), this.getPosX(), this.getPosY(),i);
    }

    private int[] getBox(int offsetX, int offsetY, int direction) {
        return new int[] {
          offsetX, offsetY, direction
        };
    }

    private int[] getBoxUp() {
        return this.getBox(0, -this.speedY, DirectionState.Up.value());
    }

    private int[] getBoxDown() {
        return this.getBox(0, this.speedY, DirectionState.Down.value());
    }

    private int[] getBoxLeft() {
        return this.getBox(-this.speedX, 0, DirectionState.Left.value());
    }

    private int[] getBoxRight() {
        return this.getBox(this.speedX, 0, DirectionState.Right.value());
    }

    public synchronized boolean IsCollide(int x, int y) {
        this.canMove = true;

        if (GUtil.isColliderMapEdgePos(this.getPosX() + x, this.getPosY() + y)) {
            this.canMove = false;
        }
        else {
            this.parentScene.getActorsStream().forEach((a) -> {
                if (a instanceof SolidObject && a != this) {
                    if (GUtil.RectCollideIter(this.getPosX() + x, this.getPosY() + y, this.getWidth(), this.getHeight(),
                            a.getPosX(), a.getPosY(), a.getWidth(), a.getHeight())) {
                        this.canMove = false;
                    }
                }
            });
        }

        return this.canMove;
    }

    @Override
    void Shooting() {
        if (this.isBullet) {
            this.parentScene.addChild(new EnemyBullet(this.dirState, this.getPosX() +12, this.getPosY() +12, this.parentScene, this));
            this.isBullet = false;
        }
    }

    @Override
    public void Destory() {
        super.Destory();
        this.enemyManager.subEnemy();
        this.parentScene.addChild(new BombAnimate(this.parentScene, this.getPosX(), this.getPosY()));
    }
}
