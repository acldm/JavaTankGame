package Scene;

import Actor.UI.ImageView;
import Actor.UI.TextActor;
import Main.GMain;
import Main.Scene;
import Util.ClickEvent;
import Util.Config;
import Util.GInput;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class TitleScene extends Scene {
    private ArrayList<TextActor> TextSelecter;
    private int selected = 0;
    public TitleScene(GMain gmain) {
        super(gmain);

        this.TextSelecter = new ArrayList<>();
        this.addChild(new ImageView("img/title.png", this, Config.MapWidth/2, 24,200,100));
        this.addChild((new TextActor(this, Config.MapWidth / 2, 160, "请选择游戏关卡", null)));

        this.TextSelecter.add(new TextActor(this, Config.MapWidth / 2, 180, "第一关", new ClickEvent() {
            @Override
            public void onClick() {
                GameScene scene = new GameScene(main);
                main.changeScene(scene);
            }
        }));

        this.TextSelecter.add(new TextActor(this, Config.MapWidth / 2, 200, "世界", new ClickEvent() {
            @Override
            public void onClick() {
                Game2Scene scene = new Game2Scene(main);
                main.changeScene(scene);
            }
        }));

        this.TextSelecter.add(new TextActor(this, Config.MapWidth / 2, 240, "退出游戏", new ClickEvent() {
            @Override
            public void onClick() {
                System.exit(0);
            }
        }));

        for (TextActor a : TextSelecter) {
            this.addChild(a);
        }
    }

    @Override
    public void gUpdate() {
        super.gUpdate();
        keyevent();

    }

    @Override
    public void gDraw(Graphics g) {
        for (TextActor a : TextSelecter) {
            a.setSelected(false);
        }

        int index = Math.abs(this.selected) % TextSelecter.size();
        TextSelecter.get(index).setSelected(true);
        super.gDraw(g);
    }

    public void keyevent() {
        int key = GInput.isKeyOnceDown();
        if (key == KeyEvent.VK_UP) {
            this.selected += 2;
        }
        else if (key == KeyEvent.VK_DOWN) {
            this.selected += 1;
        }
        else if (key == KeyEvent.VK_Z) {
            int index = Math.abs(this.selected) % TextSelecter.size();
            TextSelecter.get(index).ClickEvent();
        }
    }
}
