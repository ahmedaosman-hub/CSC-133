package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import java.util.Random;
import com.codename1.charts.models.Point;

public class GameObject {
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
}
