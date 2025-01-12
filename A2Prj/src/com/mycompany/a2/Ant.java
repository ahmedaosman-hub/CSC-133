package com.mycompany.a2;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

public class Ant extends Moveable implements IFoodie {

	// Ant's attributes
	private int maximumSpeed = 10;
	private int foodLevel = 100;
	private int foodConsumptionRate = 1;
	private int healthLevel = 10;
	private int lastFlagReached = 1;
	private int lives = 3;
	private static int red = 255;
	private boolean isDead = false; 



	// Constructor to initialize the ant
	public Ant(int size, Point location, int heading) {
		super(size, location);
		super.setSpeed(5);
		super.setColor(ColorUtil.rgb(red, 0, 0));
	}

	// Getter for maximumSpeed
	public int getMaximumSpeed() {
		return maximumSpeed;
	}

	// Method to check and limit Ant's speed based on health

	public void checkSpeed() {
		maximumSpeed = (int) (30 - (30 * (healthLevel / 100)));
		if (getSpeed() > maximumSpeed) {
			setSpeed(maximumSpeed);
		}
	}

	public int getFoodLevel() {
		return foodLevel;
	}

	public void setFoodLevel(int food) {
		if (food == 300) {
			foodLevel -= foodConsumptionRate;
		} else {
			foodLevel += food;
			if (foodLevel > 100) {
				foodLevel = 100;
			}
		}
	}

	// Getter for foodConsumptionRate

	public int getFoodConsumptionRate() {
		return foodConsumptionRate;
	}

	// Setter for foodConsumptionRate attribute
	@Override
	public void setFoodConsumptionRate(int foodConsumptionRate) {
		this.foodConsumptionRate = foodConsumptionRate;
	}

	// Getter for healthLevel
	public int getHealthLevel() {
		return healthLevel;
	}

	public void setHealthLevel(int health) {
		this.healthLevel = health;
	}
	// Getter for lastFlagReached attribute

	public int getLastFlagReached() {
		return lastFlagReached;
	}

	// Getter for lives
	public int getLives() {
		return lives;
	}

	public void fadeColor() {
		int currentColor = getColor(); 
		
		int red = ColorUtil.red(currentColor);
		
		red = Math.max(0, red - 10);
		
		setColor(ColorUtil.rgb(red, ColorUtil.green(currentColor), ColorUtil.blue(currentColor)));
	}
	@Override
	public void setSpeed(int speed) {
		if (speed >= 0 && speed <= (maximumSpeed)) {
			super.setSpeed(speed);
		}
	}

	public void changeHeading(char h) {
		if (h == 'l') {
			setHeading(5);
		}
		if (h == 'r') {
			setHeading(-5);
		}
	}


	// Method to handle flag collisions

	public void flagCollision(int flagNumber) {
		if (flagNumber == (lastFlagReached + 1)) {
			lastFlagReached = flagNumber;
		}
	}

	// Method to reset the Ant's attributes

	public void resetAnt() {
		setX(500);
		setY(500);
		healthLevel = 100;
		lives -= 1;
		checkSpeed();
	}

	// String representation of the Ant object

	public String toString() {
		String parentDesc = super.toString();
		String myDesc = " maxSpeed=" + maximumSpeed + "food consumption= " + foodConsumptionRate;
		return "Ant:" + parentDesc + myDesc;
	}
	
	public void loseLife() {
		lives --;
	}
	
	public int getRed() {
		return red;
	}
	public void setRed(int add) {
		red -= add;
	}

}
