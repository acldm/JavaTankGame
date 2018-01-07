package Util;

import Main.Actor;

import java.util.Random;

public class GUtil {

    private static Random r = new Random();

    public static void colliderMapEdge(Actor actor) {
        if(actor.getPosX() > Config.MapWidth - 32)
            actor.setPosX(Config.MapWidth - 32);
        if(actor.getPosX() < 0)
            actor.setPosX(0);

        if(actor.getPosY() > Config.MapHeight - 32)
            actor.setPosY(Config.MapHeight - 32);
        if(actor.getPosY() < 0)
            actor.setPosY(0);
    }

    public static Boolean isColliderMapEdge(Actor actor) {

        if (actor.getPosX() > Config.MapWidth || actor.getPosX() < 0) {
            return true;
        }

        if (actor.getPosY() > Config.MapHeight || actor.getPosY() < 0) {
            return true;
        }
        return false;
    }

    public static Boolean isColliderMapEdgePos(int x, int y) {
        if (x > Config.MapWidth - 32 || x < 0) {
            return true;
        }

        if (y > Config.MapHeight - 32 || y < 0) {
            return true;
        }
        return false;
    }

    public static Boolean aInb(int a, int b1, int b2) {
        return a > b1 && a < b1 + b2;
    }

    public static Boolean RectCollideIter(int x1, int y1, int w1, int h1, int x2, int y2, int w2, int h2) {
        if (y1>y2+h2 || y2>y1+h1
                || x1>x2+w2 || x2>x1+w1) {
            return false;
        }
        else
        {
            return true;
        }
    }

    public static Boolean RectCollider(Actor a, Actor b) {
        return GUtil.RectCollideIter(a.getPosX(), a.getPosY(), a.getWidth(), a.getHeight(),
        b.getPosX(), b.getPosY(), b.getWidth(), b.getHeight());
    }

    public static double distanceAToB(int ax, int ay, int bx, int by) {
        return Math.sqrt(Math.pow(ax - bx, 2) + Math.pow(ay - by, 2));
    }

    public static boolean getRandomTrueOrFalse() {
        return r.nextInt(2) == 0? true : false;
    }

    public static int getRandom1To10() {
        return r.nextInt(10) + 1;
    }

    public static int getIntRandom(int bound) {
        return r.nextInt(bound);
    }
    /*
    public static  void Main(String[] args) {
        for (int i=0; i<100; i++) {
            System.out.println(getRandomTrueOrFalse());
        }
    }
    */
}
