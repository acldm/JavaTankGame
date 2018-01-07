package Main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Scene {
	public Actor player;
	public Actor heart;
	public CopyOnWriteArrayList<Actor> actorList;

	public GMain main;
	public Scene(GMain gmain) {
		this.main = gmain;
		actorList = new CopyOnWriteArrayList<>();
	}
	
	public void gUpdate() {
		List<Actor> tl;

		tl = actorList.stream().filter((a) -> {
			if (a.alive) {
				return true;
			}
			else {
				return false;
			}
		}).collect(Collectors.toList());
		actorList.clear();
		actorList.addAll(tl);

		//循环
		this.getActorsStream().forEach((a) -> {
			a.gUpdate();
		});
	}
	
	public synchronized void gDraw(Graphics g) {
		this.getActorsStream().forEach((a) -> {
			a.gDraw((Graphics2D)g, (ImageObserver)main);
		});
	}

	public synchronized Stream<Actor> getActorsStream() {
		return this.actorList.stream();
	}
	public synchronized CopyOnWriteArrayList<Actor> getActorsListIterator() {
		return this.actorList;
	}
	public synchronized void addChild(Actor actor) {
		this.actorList.add(actor);
	}

	public ImageObserver getImageObserver() {
		return (ImageObserver)this.main;
	}
	
}
