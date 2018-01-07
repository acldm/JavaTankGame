package Util;

import Actor.MapBlock.LittleBlock;
import Main.Scene;

//创建不同的砖墙
public class CreateWall {

    public static void addLeftBlock(Scene scene, int x, int y) {
        addHorBlock(scene, x, y);
    }

    public static void addRightBlock(Scene scene, int x, int y) {
        addHorBlock(scene, x + 16, y);
    }

    public static void addHorBlock(Scene scene, int x, int y) {
        for (int i=0; i<4; i++) {
            for (int j=0; j<2; j++) {
                LittleBlock b = new LittleBlock(scene, x + j*8, y + i*8);
                scene.addChild(b);
            }
        }
    }

    public static void addVerBlock(Scene scene, int x, int y) {
        for (int i=0; i<2; i++) {
            for (int j=0; j<4; j++) {
                LittleBlock b = new LittleBlock(scene, x + j*8, y + i*8);
                scene.addChild(b);
            }
        }
    }

    public static void addUpBlock(Scene scene, int x, int y) {
        addVerBlock(scene, x, y);
    }

    public static void addDownBlock(Scene scene, int x, int y) {
        addVerBlock(scene, x, y + 16);
    }

    public static void addEdgeBlock(Scene scene, int x, int y) {
        for (int i=0; i<2; i++) {
            for (int j=0; j<2; j++) {
                LittleBlock b = new LittleBlock(scene, x + j*8, y + i*8);
                scene.addChild(b);
            }
        }
    }

    public static void addLeftEdgeBlock(Scene scene, int x, int y) {
        addEdgeBlock(scene, x + 16, y + 16);
    }

    public static void addRightEdgeBlock(Scene scene, int x, int y) {
        addEdgeBlock(scene, x, y + 16);
    }

}
