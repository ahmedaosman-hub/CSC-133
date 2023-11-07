package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

import java.util.Random;
import com.codename1.charts.models.Point;

public class GameObject implements IDrawable{
    private int myColor;
    private Point location;
    private int size;

    public GameObject(int color) {
        this(color, 0);
    }

    public GameObject(int color, int size) {
        this.myColor = color;
        this.size = size;
        Random rand = new Random();
        float x = (float) rand.nextDouble() * 1000;
        float y = (float) rand.nextDouble() * 1000;
        this.setLocation(new Point(x, y));
    }

    public float getX() {
        return getLocation().getX();
    }

    public float getY() {
        return getLocation().getY();
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

    public int getSize() {
        return size;
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
        int x = (int) (location.getX() - size / 2 + pCmpRelPrnt.getX());
        int y = (int) (location.getY() - size / 2 + pCmpRelPrnt.getY());    	
    	
    	if (this instanceof Ant) {
    		g.setColor(myColor);
    		g.fillArc(x, y, size, size, 0, 360);
    	}
    	else if (this instanceof FoodStation) {
    		g.setColor(myColor);
    		g.fillRect(x, y, size, size);
    		
    	}
    	else if (this instanceof Flag) {
    		g.setColor(myColor);
            int[] xPoints = { x, x + size, x + size / 2 };
            int[] yPoints = { y + size, y + size, y };
            g.fillPolygon(xPoints, yPoints, 3);
            }
    	else if (this instanceof Spider) {
            g.setColor(myColor);
            int[] xPoints = {
                x, 
                x + size / 2, 
                x + size,
                x + size / 2
            };
            int[] yPoints = {
                y + size / 2, 
                y, 
                y + size / 2,
                y + size
            };
            g.fillPolygon(xPoints, yPoints, 4); 
    	}
    g.setColor(ColorUtil.BLACK);
    g.drawString("Label", x, y);
}
}