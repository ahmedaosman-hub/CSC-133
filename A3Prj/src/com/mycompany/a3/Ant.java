package com.mycompany.a3;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

public class Ant extends Moveable implements IFoodie {

    // Ant's attributes
    private int maximumSpeed = 30;
    private int foodLevel = 100;
    private double foodConsumptionRate = 1.00;
    private int healthLevel = 0; // Set to 0 initially
    private int lastFlagReached = 1;
    private int lives = 3;
    private static int red = 255;
    private boolean isDead = false;
    double nonDisplayFood = 100.00;
    private GameWorld gw;

    // Constructor to initialize the ant
    public Ant(GameWorld gw, int size, int heading, Point location) {
        super(gw, size,location);
        super.setSpeed(10); // Set initial speed
        super.setColor(ColorUtil.rgb(red, 0, 0));
        this.gw = gw;
    }

    // Getter for maximumSpeed
    public int getMaximumSpeed() {
        return maximumSpeed;
    }

    // Method to check and limit Ant's speed based on health
    public void checkSpeed() {
        maximumSpeed = (int) (30 - (30 * (healthLevel / 100.0)));
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
        return (int) (foodConsumptionRate * 100); // Multiply by 100 to match Robot's representation
    }

    // Setter for foodConsumptionRate attribute
    public void setFoodConsumptionRate(int foodConsumptionRate) {
        this.foodConsumptionRate = foodConsumptionRate / 100.0; // Divide by 100 to match Robot's representation
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

    // Method to change Ant's heading
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
    @Override
    public String toString() {
        String parentDesc = super.toString();
        String myDesc = " maxSpeed=" + maximumSpeed + " food consumption=" + (int) (foodConsumptionRate * 100);
        return "Ant:" + parentDesc + myDesc + " healthLevel=" + healthLevel + " lives: " + lives;
    }

    public void loseLife() {
        lives--;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int add) {
        red -= add;
    }

	public void setLastFlagReached(int sequenceNumber) {
		// TODO Auto-generated method stub
		
	}
}
