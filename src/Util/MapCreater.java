package Util;

import Actor.MapBlock.*;
import Main.Actor;
import Main.Scene;

//地圖生成器
public class MapCreater {
    public  MapCreater(Integer[] maps, Scene scene) {
        if (maps == null) {
            return;
        }

        Actor wallObj;

        //循环生成地图
        for (int i=0; i<13; i++) {
            for (int j=0; j<13; j++) {
                int x = j*32;
                int y = i*32;
                switch (maps[i*13 + j]) {
                    case 1:
                        Wall.CreateWall(scene, x, y);
                        break;
                    case 2:
                        wallObj = new Iron(scene, x, y);
                        scene.addChild(wallObj);
                        break;
                    case 3:
                        wallObj = new Grass(scene, x, y);
                        scene.addChild(wallObj);
                        break;
                    case 4:
                        wallObj = new Water(scene, x, y);
                        scene.addChild(wallObj);
                        break;
                    case 5:
                        wallObj = new Snow(scene, x, y);
                        scene.addChild(wallObj);
                        break;
                    case 11:
                        Wall.CreateLeftWall(scene, x, y);
                        break;
                    case 12:
                        Wall.CreateUpWall(scene, x, y);
                        break;
                    case 13:
                        Wall.CreateRightWall(scene, x, y);
                        break;
                    case 14:
                        Wall.CreateDownWall(scene, x, y);
                        break;
                    case 21:
                        Wall.CreateDownLeftWall(scene, x, y);
                        break;
                    case 22:
                        Wall.CreateDownRightWall(scene, x, y);
                        break;
                    default:
                        break;
                }

            }
        }
    }
}
