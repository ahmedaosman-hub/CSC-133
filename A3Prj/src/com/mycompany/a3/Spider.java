package com.mycompany.a3;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

import java.util.Random;

public class Spider extends Moveable {
	
	private Random rand = new Random();
	
	
	
	public Spider(GameWorld gw, int size, Point location) {
		super(gw, size, location ); 
		super.setColor(ColorUtil.rgb(0, 0, 0));
		setSpeed(randSpeed());
		setHeading(randHeading());
	}
	
	
	@Override
	public void setColor(int color) {
		
	}
	
	@Override
	public void setHeading(int heading) {
		super.setHeading(randValue());
	}
	
	private int randValue() {
		return ((-5) + rand.nextInt(10));
	}
	
	private int randHeading() {
		return rand.nextInt(359);
	}
	private int randSpeed() {
		return 5 + rand.nextInt(5);
	}
	
	
	public String toString() {
		String parentDesc = super.toString();
		return "Spider: " + parentDesc;
	}	
	
	@Override
    public void draw(Graphics g, Point pCmpRelPrnt) {
        int locationX = (int) getX() + (int) pCmpRelPrnt.getX();
        int locationY = (int) getY() + (int) pCmpRelPrnt.getY();
        Point top = new Point(locationX, locationY + getSize());
        Point bottomL = new Point(locationX - getSize(), locationY - getSize());
        Point bottomR = new Point(locationX + getSize(), locationY - getSize());

        g.setColor(getColor());
        g.drawLine((int) top.getX(), (int) top.getY(), (int) bottomL.getX(), (int) bottomL.getY());
        g.drawLine((int) bottomL.getX(), (int) bottomL.getY(), (int) bottomR.getX(), (int) bottomR.getY());
        g.drawLine((int) bottomR.getX(), (int) bottomR.getY(), (int) top.getX(), (int) top.getY());
    }
}

