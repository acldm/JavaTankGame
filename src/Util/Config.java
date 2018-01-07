package Util;

import java.awt.*;
import java.util.ArrayList;

//游戏全局配置
public class Config {
    public static int WindowWidth = 486;
    public static int WindowHeight = 532;
    public static int MapWidth = 416;
    public static int MapHeight = 416;
    public static Color BackGround = new Color(85, 85, 85);
    public static Color FrontGround = Color.BLACK;
    public static int frame = 30;
    public static ArrayList<Integer> enemyCreatePos = new ArrayList<>();
    public static String Title = "坦克大战    计科1601班29号李伟";

    static {
        enemyCreatePos.add(0);
        enemyCreatePos.add(224);
        enemyCreatePos.add(384);
    }

}