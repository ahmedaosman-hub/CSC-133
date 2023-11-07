package com.mycompany.a3;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

import java.util.Random;

public  class Spider extends Moveable {

	private Random rand = new Random();
	private int size;

	public Spider(GameWorld gw, int size, Point location) {
		super(gw, size, location);
		super.setColor(ColorUtil.rgb(255, 255, 255));
		this.size = size;
		setSpeed(randSpeed());
		setHeading(randHeading());
	}

	public String toString() {
		String parentDesc = super.toString();
		return "Spider:" + parentDesc;
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

	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {
		int locationX = (int) getX() + (int) pCmpRelPrnt.getX();
		int locationY = (int) getY() + (int) pCmpRelPrnt.getY();
		Point top = new Point(locationX, locationY + size);
		Point left = new Point(locationX - size, locationY - size);
		Point right = new Point(locationX + size, locationY - size);

		g.setColor(getColor());
		g.drawLine((int) top.getX(), (int) top.getY(), (int) left.getX(), (int) left.getY());
		g.drawLine((int) left.getX(), (int) left.getY(), (int) right.getX(), (int) right.getY());
		g.drawLine((int) right.getX(), (int) right.getY(), (int) top.getX(), (int) top.getY());
	}

	@Override
	public boolean collidesWith(GameObject otherObjects) {
		// TODO Auto-generated method stub
		return false;
	}
}
