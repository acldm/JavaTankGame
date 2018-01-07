package Scene;

import Actor.UI.TextActor;
import Main.GMain;
import Main.Scene;
import Util.*;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GameOverScene extends Scene {
    private TextActor eventText;
    public GameOverScene(GMain gmain) {
        super(gmain);

        eventText = new TextActor(this, Config.MapWidth/2, 200,"失败! 按 r 返回主菜单",() -> {
            TitleScene scene = new TitleScene(main);
            main.changeScene(scene);
        });

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
