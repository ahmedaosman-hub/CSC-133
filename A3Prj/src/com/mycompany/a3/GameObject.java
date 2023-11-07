package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

import java.util.Random;
import com.codename1.charts.models.Point;

public abstract class GameObject implements IDrawable, ICollider{
    private int myColor;
    private Point location;
    private boolean isCollided = false;
    private int size;
    private double left, right, top, bottom;
    GameWorld gameWorld;

   

    public GameObject(GameWorld gameWorld, int size, Point location) {
    	this.size = size;
    	this.location = location;
    	left = (int) (getX() - (size/2));
    	right = (int) (getX() + (size / 2));
    	top = (int) (getY() - (size / 2));
    	bottom = (int) (getY() + (size / 2));
    	this.gameWorld = gameWorld;
    }
    public float getX() {
        return getLocation().getX();
    }

    public float getY() {
        return getLocation().getY();
    }

    public int getSize() {
    	return size;
    }
    public void setX(float x) {
        getLocation().setX(x);
    }

    public void setY(float y) {
        getLocation().setY(y);
    }

    public void setColor(int color) {
        myColor = color;
    }

    public int getColor() {
        return myColor;
    }


    public String toString() {
        return "loc=" + Math.round(getLocation().getX() * 10.0) + "," + Math.round(getLocation().getY() * 10) / 10.0 +
                "color=[" + ColorUtil.red(myColor) + "," + ColorUtil.green(myColor) + "," + ColorUtil.blue(myColor) + "]";
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }
    
    @Override
    public void draw(Graphics g, Point pCmpRelPrnt) {
        
}
    
    public double getRight() {
    	return (getX() + (size / 2));
    }
    
    public double getLeft() {
    	return (getX() - (size / 2));
    }
    public double getTop() {
    	return (this.getY() - (size / 2));
    }
    public double getBottom() {
    	return (getY() + (size/2));
    }
    public boolean getHasCollided() {
    	return isCollided; 
    }
    
    public void setHasCollided(boolean a) {
    	isCollided = a;
    }
    
    
    public boolean collidesWith(GameObject objects) {
    	if (getRight() < objects.getLeft() || getLeft() > objects.getRight()) {
    		return false;
    	}
    	if (objects.getTop() > getBottom() || getTop() > objects.getBottom()) {
    		return false;
    	}
    	
    	return true;
    }
    
    public void handleCollision(GameObject objects) {
    	if(this instanceof Ant) {
			if(objects instanceof FoodStation) {
				if(! objects.getHasCollided()) {
					objects.setHasCollided(true);
					gameWorld.foodStationCollision(objects);
				}
			}
			if(objects instanceof Flag) { 
				if(!objects.getHasCollided()) {
					gameWorld.flagCollision(((Flag) objects).getSequenceNumber());
					objects.setColor(191);
				}
			}
			
			if(objects instanceof Spider) {
				if(!objects.getHasCollided()) {
				gameWorld.spiderCollision();
				}
			}
    }
    }
}