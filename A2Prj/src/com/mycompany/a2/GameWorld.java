package com.mycompany.a2;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import java.util.ArrayList;
import java.util.Random;

// Represents the game's model
public class GameWorld extends Observable {
	private int currentClockTime;
	private int livesRemaining;
	private GameWorldCollection gameObjects;
	private PlayerAnt player;
	Random rand = new Random();
	private boolean soundOn; 
	

	// Starting game and reset game objects
	public void init() {
		this.currentClockTime = 0; 
		this.soundOn = true;
		gameObjects = new GameWorldCollection;
		addGameObjects();
		this.setChanged();
		this.notifyObservers(this); 
	}

	public void addGameObjects() {
		float x = 0, y = 0;
		int flagObjects = 9;
		int foodSpiderObject = 3;
		gameObjects.add(PlayerAnt.getPlayerAnt());
		player = PlayerAnt.getPlayerAnt();
		for (int i = 1; i < flagObjects; i++) {
			gameObjects.add(new Flag(i));
		}
		for (int i = 0; i < foodSpiderObject; i++) {
			gameObjects.add(new FoodStation());
		}
		for (int i = 0; i < foodSpiderObject; i++) {
			gameObjects.add(new Spider());
		}
		for (int i = 0; i < 3; i++) {
			NonPlayerAnt npa = new NonPlayerAnt();
			int choice = rand.nextInt(2);
			if ( choice == 0) {
				npa.setStrategy(new AttackStrategy(gameObjects.npa));
			}
			else {
				npa.setStrategy(new FlagStrategy(gameObjects.npa));
				gameObjects.add(npa);
			}
		}
		
		IIterator itr = gameObjects.getIterator();
		while(itr.hasNext()) {
			GameObjects tempObject = itr.getNext();
			if (tempObject instanceof Flags) {
				if (((Flags)tempObject).getSequenceNumber() == 1) {
					x = ((Flags))tempObject).getX();
					y = ((Flags))tempObject).getY();
				}
			}
		}
		
		IIterator itr2 = gameObjects.getIterator();
		while(itr2.hasNext()) {
			GameObjects tempObject2 = itr2.getNext();
			if (tempObject2 instanceof PlayerAnt) {
				((PlayerAnt)tempObject2).setX(x);
				((PlayerAnt)tempObject2).setY(y);
			}
			else if (tempObject2 instanceof NonPlayerAnt) {
				((NonPlayerAnt) tempObject2).setX(x + rand.nextInt(100));
				((NonPlayerAnt) tempObject2).setY(y + rand.nextInt(100));
				
			}
		}
	}
	

	// Press 'a' to increase speed or 'b' to decrease speed of ant
	public void setAntSpeed(int x) {
		if (x == 2) {
			ant.setSpeed(ant.getSpeed() + x);
			System.out.println("Speeding Up!");
		} else {
			ant.setSpeed(ant.getSpeed() + x);
			System.out.println("Slowing down!");
		}

	}

	// Press 'l' to turn left or 'r' to turn right of ant
	public void changeHeading(char h) {
		if (h == 'l') {
			ant.changeHeading(h);
			System.out.println("Turning Left!");
		} else {
			ant.changeHeading(h);
			System.out.println("Turning Right!");
		}

	}

	// Press 'c' for food consumption rate of ant
	public void setFoodConsumptionRate(int foodConsumptionRate) {
		ant.setFoodConsumptionRate(foodConsumptionRate);
		System.out.println("Food Consumption Rate set to: " + foodConsumptionRate);
	}

	// Press 1-9 for collision between ant and a flag
	public void flagCollision(int lastFlagReached) {
		int highestFlagNumber = 0;
		for (GameObject gameObject : gameObjectList) {
			if (gameObject instanceof Flag) {
				Flag flag = (Flag) gameObject;
				int flagNumber = flag.getSequenceNumber();
				if (flagNumber == lastFlagReached + 1) {
					ant.flagCollision(flag.getSequenceNumber());
					System.out.println("Got the " + lastFlagReached + " flag");
					return;
				} else if (flagNumber > highestFlagNumber) {
					highestFlagNumber = flagNumber;
				}
			}
		}
		if (highestFlagNumber == lastFlagReached) {
			System.out.println("No more flags!");
		}
	}

	// Press 'f' for collision between ant and a foodstation
	public void foodStationCollision() {
		for (GameObject gameObject : gameObjectList) {
			if (gameObject instanceof FoodStation) {
				FoodStation foodStation = (FoodStation) gameObject;
				int capacity = foodStation.getCapacity();

				if (capacity != 0) {
					ant.setFoodLevel(capacity);
					foodStation.setCapacity(0);
					gameObject.setColor(ColorUtil.rgb(0, 255, 0));
				}
			}

		}
		System.out.println("Colliding with foodstation! Yummy");

		gameObjectList.add(new FoodStation(randObjSize(), new Point(randX(), randY())));
	}

	// Press 'g' for collision between ant and a spider
	public void spiderCollision() {
		System.out.println("Oh no a spider!");

		for (GameObject gameObject : gameObjectList) {
			if (gameObject instanceof Spider) {
				if (gameObject.getX() == ant.getX() && gameObject.getY() == ant.getY()) {
					ant.collision('g');
				}
			}
		}
	}

	// Press 't' for game tick
	public void tick() {
		timer++;

		// update spider's heading
		for (GameObject gameObject : gameObjectList) {
			if (gameObject instanceof Spider) {
				Spider spider = (Spider) gameObject;
				spider.getHeading();
			}
		}

		// update positions of all moveable objects
		for (GameObject gameObject : gameObjectList) {
			if (gameObject instanceof Moveable) {
				Moveable moveable = (Moveable) gameObject;
				moveable.move();
			}

		}

		// reduce ant's food level based on foodConsumptionRate
		int foodConsumptionRate = ant.getFoodConsumptionRate();
		ant.setFoodLevel(foodConsumptionRate);
		System.out.println("Tick Tock: " + timer);
		// increment clock
		timer++;

	}

	// Press 'd' to print the current game/ant state values
	public void printCurrent() {
		for (GameObject gameObject : gameObjectList) {
			if (gameObject instanceof Ant) {
				Ant ant = (Ant) gameObject;
				int lives = ant.getLives();
				int timer = getTime();
				int lastFlagReached = ant.getLastFlagReached();
				int foodLevel = ant.getFoodLevel();
				int healthLevel = ant.getHealthLevel();

				System.out.println("Ant Information: ");
				System.out.println("Lives left " + lives);
				System.out.println("Timer elasped: " + timer);
				System.out.println("Last flag reached: " + lastFlagReached);
				System.out.println("Current food level: " + foodLevel);
				System.out.println("Current health level: " + healthLevel);
			}
		}
	}
	// Press 'm' to print the current map

	public void map() {
		for (GameObject temp : gameObjectList) {
			System.out.println(temp);
		}
	}

	// Press 'x' to exit the game

	public void exit() {
		if (isExit) {
			System.exit(0);
		}
	}

	// Press 'y' to confirm(){
	public void quitGame() {
		System.out.println("Would you like to end the game? (y/n)");
		isExit = true;
	}

	// Press 'n' to cancel(){
	public void dontQuit() {
		System.out.println("Great, lets keep playing. \nEnter a command ");
		isExit = false;
	}

	// Increment the game's elapsed time
	public int getTime() {
		return this.timer;
	}

	// Creating randInts for the game
	private int randX() {
		return rand.nextInt(1000);
	}

	private int randY() {
		return rand.nextInt(1000);
	}

	private int randObjSize() {
		return 15 + rand.nextInt(15);
	}
}
