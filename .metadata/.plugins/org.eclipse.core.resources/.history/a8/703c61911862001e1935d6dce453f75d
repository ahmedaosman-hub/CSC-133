package com.mycompany.a1;

import com.codename1.charts.models.Point;

public class Moveable extends GameObject {
	private int heading;
	private int speed;
	private int foodLevel;

	public Moveable(int color) {
		super(color);
		
	}
	
	public Moveable(int color, int size) {
		super(color,size);
	}
	



	public Moveable(int size, Point location) {
super(size);
this.setLocation(location);
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

	public void move() {
		if (foodLevel > 0) {
			double newX = getX() + speed * Math.cos(Math.toRadians(heading));
			double newY = getY() + speed * Math.sin(Math.toRadians(heading));

			if (newX >= 0 && newX <= 1000 && newY >= 0 && newY <= 1000) {
				setX((float) newX);
				setY((float) newY);
			} else {
				move();
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

}
