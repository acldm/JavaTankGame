package Actor.MapBlock;

import Main.Scene;

public class Wall {
    private Wall() {

    }
    public static void CreateWall(Scene scene, int x, int y) {
        for (int i=0; i<2; i++) {
            for (int j=0; j<2; j++) {
                WallPart part = new WallPart(scene, x + i * 16, y + j * 16);
                scene.addChild(part);
            }
        }
    }

    public static void CreateLeftWall(Scene scene, int x, int y) {
        for (int i=0; i<2; i++) {
                WallPart part = new WallPart(scene, x , y + i * 16);
                scene.addChild(part);
        }
    }

    public static void CreateRightWall(Scene scene, int x, int y) {
        for (int i=0; i<2; i++) {
            WallPart part = new WallPart(scene, x + 16 , y + i * 16);
            scene.addChild(part);
        }
    }

    public static void CreateUpWall(Scene scene, int x, int y) {
        for (int i=0; i<2; i++) {
            WallPart part = new WallPart(scene, x + i * 16 , y);
            scene.addChild(part);
        }
    }

    public static void CreateDownWall(Scene scene, int x, int y) {
        for (int i=0; i<2; i++) {
            WallPart part = new WallPart(scene, x + i * 16 , y + 16);
            scene.addChild(part);
        }
    }

    public static void CreateDownLeftWall(Scene scene, int x, int y) {
        WallPart part = new WallPart(scene, x, y + 16);
        scene.addChild(part);
    }

    public static void CreateDownRightWall(Scene scene, int x, int y) {
        WallPart part = new WallPart(scene, x + 16, y + 16);
        scene.addChild(part);
    }

}
