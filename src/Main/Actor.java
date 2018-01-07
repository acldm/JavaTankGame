package Main;

import Util.DirectionState;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

//所有游戏角色的抽象基类
public abstract class Actor {
	public Image image;
	public ArrayList<Image> images;
	public int posX;
	public int posY;
	public int width;
	public int height;
	public int speedX;
	public int speedY;
	public DirectionState dirState;

	public Scene parentScene;
	public boolean alive = true;
	
	public Actor(String path, Scene scene) {
		this.image = Toolkit.getDefaultToolkit().getImage(path);
		this.parentScene = scene;
		this.width = this.image.getWidth(scene.getImageObserver());
		this.height = this.image.getHeight(scene.getImageObserver());
	}
	
	public Actor(String[] paths, Scene scene) {
		this.images = new ArrayList<>();
		for (int i=0; i<paths.length; i++) {
			Image image = Toolkit.getDefaultToolkit().getImage(paths[i]);
			this.images.add(image);

		}
		this.parentScene = scene;
		this.width = this.images.get(0).getWidth(scene.getImageObserver());
		this.height = this.images.get(0).getHeight(scene.getImageObserver());
	}

	public Actor(Scene scene) {
		this.parentScene = scene;
	}
	
	public abstract void gUpdate();
	public abstract void gDraw(Graphics2D g2,ImageObserver i);

	public void Destory() {
		this.alive = false;
	}
    public void Destory(DirectionState dirState) {
        this.alive = false;
    }


    public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	public void setPosition(int x, int y) {
		this.setPosX(x);
		this.setPosY(y);
	}
	
	public void Move(int x, int y) {
		this.setPosX(this.getPosX() + x);
		this.setPosY(this.getPosY() + y);
	}
	
	public void setSpeed (int x, int y) {
		this.speedX = x;
		this.speedY = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}