package Scene;

import Actor.UI.TextActor;
import Main.GMain;
import Main.Scene;
import Util.Config;
import Util.GInput;

import java.awt.*;
import java.awt.event.KeyEvent;

public class WinnerScene extends Scene {
    private int score;
    private TextActor eventText;
    public WinnerScene(GMain gmain, int score) {
        super(gmain);
        eventText = new TextActor(this, Config.MapWidth/2, 200,"按 r 返回主菜单",() -> {
           TitleScene scene = new TitleScene(main);
           main.changeScene(scene);
        });
        this.addChild(new TextActor(this, Config.MapWidth/2, 100,"胜利!  得分:" + score*10,() -> {

        }));
        this.addChild(eventText);
    }

    @Override
    public void gUpdate() {
        super.gUpdate();
        if (GInput.isKeyDown(KeyEvent.VK_R)) {
            eventText.ClickEvent();
        }
    }

    @Override
    public void gDraw(Graphics g) {
        super.gDraw(g);
    }
}
