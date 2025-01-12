package com.mycompany.a3;

import com.codename1.charts.models.Point;

public abstract class Moveable extends GameObject {
	private int heading = 0;
	private int speed = 0;
	private int foodLevel; 
	
	
	public Moveable(GameWorld gw, int size, Point location) {
		super(gw, size, location);
}

	
	
	public int getHeading() {
		return heading;
	}

	public void setHeading(int heading) {
		this.heading = heading;
	}
	
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getFoodLevel() {
		return foodLevel;
	}

	public void setFoodLevel(int foodLevel) {
		this.foodLevel = foodLevel;
	}

	public void move(GameWorld temp, int i) {
		if (foodLevel > 0) {
			double newX = getX() + speed * Math.cos(Math.toRadians(heading));
			double newY = getY() + speed * Math.sin(Math.toRadians(heading));

			if (newX >= 0 && newX <= 1000 && newY >= 0 && newY <= 1000) {
				setX((float) newX);
				setY((float) newY);
			} else {
				move(temp, i);
			}

		} else {
			speed = 0;
		}
	}

	public String toString() {
		String parentDesc = super.toString();
		String myDesc = "foodLevel: " + foodLevel + " heading=" + heading + " speed=" + speed;
		return parentDesc + myDesc;
	}



	public void changeHeading(char h) {
		// TODO Auto-generated method stub
		
	}



}