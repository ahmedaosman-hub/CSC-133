package com.mycompany.a3;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

public abstract  class Ant extends Moveable implements IFoodie {

    private int maximumSpeed = 30;
    private int foodLevel = 100;
    private double foodConsumptionRate = 1.00;
    private int healthLevel = 0;
    private int lastFlagReached = 1;
    private int lives = 3;
    private static int red = 255;
    private boolean isDead = false;
    private GameWorld gw;
    private int heading;

    public Ant(GameWorld gw, int size, int heading, Point location) {
        super(gw, size, location);
        super.setSpeed(10);
        super.setColor(ColorUtil.rgb(red, 0, 0));
        this.gw = gw;
    }
    
    public int getRed() {
        return red;
    }

    public void setRed(int add) {
        red -= add;
    }
    
    public int getLives() {
    	return lives;
    }

    public int getLastFlag() {
    	return lastFlagReached;
    }
    
    public int getHealthLevel() {
    	return healthLevel;
    }
    
    public int getFoodLevel() {
    	return foodLevel;
    }
    
    public int getHeading() {
    	return heading;
    }
   
    @Override
    public void changeHeading(char h) {
        if (h == 'l') {
            if (heading >= (-35)) {
                heading -= 5;
            }
        }
        if (h == 'r') {
            if (heading <= (35)) {
                heading += 5;
            }
        }
    }

    public void checkSpeed() {
        maximumSpeed = (int) (30 - (30 * (healthLevel / 100.0)));
        if (getSpeed() > maximumSpeed) {
            setSpeed(maximumSpeed);
        }
    }

    @Override
    public void setSpeed(int speed) {
        if (speed <= maximumSpeed && speed >= 0) {
            super.setSpeed(speed);
        }
    }
    
    public void setHealth(int health) {
    	healthLevel += health;
    }
    
public void collision(char with) {
	if (foodLevel != 100) {
		if (with=='s') {
			healthLevel -= 5;
			setColor(ColorUtil.rgb((red -= 5), 0, 0));
			checkSpeed();
		}
	}
}

public void flagCollision(int flagNumber) {
	if(flagNumber ==(lastFlagReached + 1)) {
		lastFlagReached = flagNumber;
	}
}

public void setFoodLevel(int food) {
	if(food == 300) {
		food -= (foodConsumptionRate / (1000.00/ 20.00));
		foodLevel = (int) food;
		
	}
	else {
		food = foodLevel += food;
		if(foodLevel > 100) {
			food = foodLevel = 100;
		}
	}
}

public String toString() {
	String parentDesc = super.toString();
	String myDesc = " maxSpeed=" + maximumSpeed + " heading="+heading+ " foodLevel="+ foodLevel+ " health=" + healthLevel + "lives:  "+lives;
	return parentDesc + myDesc;
	
}

public void resetAnt() {
	setX(500);
	setY(500);
	
	healthLevel = 100;
	foodLevel = 100;
	
	lives -= 1;
}
}