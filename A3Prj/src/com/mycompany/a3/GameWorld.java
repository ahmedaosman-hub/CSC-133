package com.mycompany.a3;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

public class GameWorld extends Observable {

	private boolean endCol = false;
	private boolean crashCol = false;
	private boolean foodCol = false;
	private boolean isPause = false;
	private boolean positionable;
	private double clock;
	private boolean sound = false;

	private int contWidth;
	private int contHeight;
	private int mapHeight;
	private int mapWidth;

	private int lives;

	private Random rand = new Random();
	private int timer = 0;
	private Ant ant;
	private int flagSize = 15;
	private int antSize = 25;
	private boolean isExit = true;
	private GameObject lastCollision;
	private ArrayList<GameObject> colliderList = new ArrayList<GameObject>();
	GameObjectCollection gameObjectList;

	public GameWorld() {
		gameObjectList = new GameObjectCollection();
		ant = new Player(this, antSize, 0, new Point(randX(), randY()));
		lastCollision = ant;
	}

	public void setMapHeight(int height) {
		this.mapHeight = height;
	}

	public void setMapWidth(int width) {
		this.mapWidth = width;
	}

	public int getMapWidth() {
		return mapWidth;
	}

	public int getMapHeight() {
		return mapHeight;
	}

	public int getContWidth() {
		return contWidth;
	}

	public int getContHeight() {
		return contHeight;
	}

	public void init() {
		gameObjectList.add(ant);

		int flagCount = 4 + rand.nextInt(6);
		for (int i = 1; i <= flagCount; i++) {
			Point location = new Point(randX(), randY());
			gameObjectList.add(new Flag(this, flagSize, i, location));
		}

		int spiderCount = 2 + rand.nextInt(2);
		for (int i = 1; i <= spiderCount; i++) {
			Point location = new Point(randX(), randY());
			gameObjectList.add(new Spider(this, randObjSize(), location));
		}

		int foodStationCount = 2 + rand.nextInt(3);
		for (int i = 1; i <= foodStationCount; i++) {
			Point location = new Point(randX(), randY());
			gameObjectList.add(new FoodStation(this, randObjSize(), location));
		}
	}

	public void display() {
		System.out.println("Lives left: " + ant.getLives() + ", Current clock: " + timer + ", Last flag reached: "
				+ ant.getLastFlag() + ", Food Level: " + ant.getFoodLevel() + ", Health: " + ant.getHealthLevel());
	}

	public void map() {
		IIterator elements = gameObjectList.getIterator();
		while (elements.hasNext()) {
			GameObject temp = ((GameObject) elements.getNext());
			System.out.println(temp.toString());
		}
	}

	private void lifeReset() {
		ant.resetAnt();
		setEndCollision(true);
	}

	public void toggleSound() {
		sound = !sound;
		this.setChanged();
		this.notifyObservers();
	}

	public void tick(int i) {
		if (ant.getLastFlag() == 9) {
			System.out.println("You win!");
			System.exit(0);
		}

		if ((ant.getHealthLevel() != 100 && ant.getHealthLevel() <= 100) && ant.getFoodLevel() != 0
				&& ant.getLives() != 0) {
			ant.setHeading(ant.getHeading());
			ant.setFoodLevel(300);
			counterTime();

			IIterator elements = gameObjectList.getIterator();
			while (elements.hasNext()) {
				GameObject temp = ((GameObject) elements.getNext());
				if (temp instanceof Moveable) {
					if (temp instanceof Spider) {
						((Moveable) temp).setHeading(((Moveable) temp).getHeading());
						((Moveable) temp).move(this, i);
					}
				} else {
					((Moveable) temp).move(this, i);
				}
			}
			IIterator collide = gameObjectList.getIterator();

			while (collide.hasNext()) {
				GameObject current = (GameObject) collide.getNext();
				if (ant.collidesWith(current)) {
					if (!colliderList.contains((GameObject) current)) {
						colliderList.add((GameObject) current);
						ant.handleCollision(current);
					}
				} else {
					colliderList.remove((GameObject) current);
				}
			}
		} else {
			if (ant.getLives() != 0) {
				endCol = true;
				ant.setHealth(0);
				lifeReset();
			} else {
				System.out.println("Game over!");
			}
		}
		notifyobs();
	}

	public void flagCollision(int flagNumber) {
		ant.flagCollision(flagNumber);
		notifyobs();
	}

	public void setAntSpeed(int x) {
		ant.setSpeed(ant.getSpeed() + x);
		notifyobs();
	}

	public void changeHeading(char change) {
		ant.changeHeading(change);
		notifyobs();
	}

	public int getAntBaseReached() {
		return ant.getLastFlag();
	}

	public void foodStationCollision(GameObject temp) {
		foodCol = true;
		if (((FoodStation) temp).getCapacity() != 0) {
			ant.setFoodLevel(((FoodStation) temp).getCapacity());
			((FoodStation) temp).setCapacity();
			temp.setColor(ColorUtil.rgb(0, 230, 191));
		}
		gameObjectList.add(new FoodStation(this, randObjSize(), new Point(randX(), randY())));
		notifyobs();
	}

	public void counterTime() {
		clock += (1 / 50.00);
		timer = (int) clock;
	}

	public int getAntFlagReached() {
		return ant.getLastFlag();
	}

	public int getAntHealthLevel() {
		return ant.getHealthLevel();
	}

	public boolean isSound() {
		return sound;
	}

	private int randX() {
		int positiveMapWidth = Math.max(mapWidth, 1);
		return rand.nextInt(positiveMapWidth);
	}

	private int randY() {
		int positiveMapHeight = Math.max(mapHeight, 1);

		return rand.nextInt(positiveMapHeight);
	}

	private int randObjSize() {
		return 15 + rand.nextInt(25);
	}

	public int getLives() {
		return ant.getLives();
	}

	public int getClock() {
		return timer;
	}

	public void Timer() {
		timer += 1;
	}

	private void notifyobs() {
		this.setChanged();
		this.notifyObservers();
	}

	public Ant getAnt() {
		return ant;
	}

	public boolean isPause() {
		return isPause;
	}

	public void setIsPause(boolean isPause) {
		this.isPause = isPause;
	}

	public boolean isPositionable() {
		return positionable;
	}

	public void setPositionable(boolean positionable) {
		this.positionable = positionable;
	}

	public boolean isFoodCol() {
		return foodCol;
	}

	public void setFoodCol(boolean foodCol) {
		this.foodCol = foodCol;
	}

	public boolean isCrashCol() {
		return crashCol;
	}

	public void setCrashCol(boolean crashCol) {
		this.crashCol = crashCol;
	}

	public boolean isEndCollision() {
		return endCol;
	}

	public void setEndCollision(boolean endCol) {
		this.endCol = endCol;
	}

	public void exit() {
		if (isExit) {
			System.exit(0);
		}
	}

	public void quitGame() {
		System.out.println("Do you want to exit? (y/n)");
		isExit = true;
	}

	public void dontQuit() {
		isExit = false;
	}

	public void setFoodConsumptionRate(int foodConsumptionRate) {
		ant.setFoodConsumptionRate(foodConsumptionRate);
		System.out.println("Food Consumption Rate set to: " + foodConsumptionRate);
	}

	public void setWidthHeight(int width, int height) {
		contWidth = width;
		contHeight = height;
	}

	public void antCollision(char c) {
		ant.collision(c);
		notifyobs();
	}

	public int getFoodLevel() {
		return ant.getFoodLevel();
	}

}
