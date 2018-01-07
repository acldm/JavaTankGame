package Main;

import Scene.*;
import Util.Config;
import Util.GInput;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

//游戏主入口类，管理一切游戏中资源
public class GMain extends JPanel implements Runnable, KeyListener{

	//双缓冲画板和画笔
	private Image iBuffer;
	private Graphics gBuffer;

	//逻辑线程
	private Thread logicLoop;

	private Scene currentScene;

	public GMain() {
		setSize(Config.MapWidth, Config.MapHeight);
		setFocusable(true);

		//当前场景
		currentScene = new TitleScene(this);

		logicLoop = new Thread(this);
		logicLoop.start();

		addKeyListener(this);
	}


	@Override
	public void update(Graphics g) {
		paint(g);
	}

	@Override
	public void run() {
		for (;;) {
			while (true) {
				try {
					Thread.sleep(33);
				}
				catch(Exception e) {

				}
				gUpdate();
				repaint();
			}
		}
	}

	//统一更新函数
	public void gUpdate() {
		currentScene.gUpdate();
	}

	//统一绘图函数
	public void gDraw(Graphics g) {
		currentScene.gDraw(g);
	}

	//系统提供绘图环境
	@Override
	public void paint(Graphics g) {

		if (iBuffer == null) {
			iBuffer = createImage(this.getSize().width, this.getSize().height);
			gBuffer = iBuffer.getGraphics();
		}

		gBuffer.setColor(Config.FrontGround);
		gBuffer.fillRect(0, 0, this.getSize().width, this.getSize().height);
		gBuffer.setColor(Config.BackGround);
		gDraw(gBuffer);

		g.drawImage(iBuffer, 0, 0, this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		GInput.keyDown(keyCode);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		GInput.keyUp(keyCode);
	}


	public void changeScene(Scene scene) {
		this.currentScene = scene;
		GInput.clearKey();
	}
}
