package Actor.UI;

import Util.ClickEvent;

import java.awt.*;
import java.awt.image.ImageObserver;
import Main.*;

//此类用于在画面上绘制文字
public class TextActor extends Actor {
    private String title;
    private boolean isSelected = false;
    private ClickEvent clickEvent;
    public TextActor(Scene scene, int x, int y, String title, ClickEvent clickEvent) {
        super(scene);
        this.setPosX(x);
        this.setPosY(y);
        this.title = title;
        this.clickEvent = clickEvent;
    }

    @Override
    public void gUpdate() {

    }

    @Override
    public void gDraw(Graphics2D g2, ImageObserver i) {
        Color c = g2.getColor();
        if (this.isSelected) {
            g2.setColor(Color.red);
        }
        else {
            g2.setColor(Color.WHITE);
        }
        int strWidth =  g2.getFontMetrics().stringWidth(this.title);
        g2.drawString(title, this.getPosX() - (strWidth / 2), this.getPosY());
        g2.setColor(c);
    }

    public void ClickEvent() {
        clickEvent.onClick();
    }

    public void setSelected(boolean b) {
        this.isSelected = b;
    }
}
