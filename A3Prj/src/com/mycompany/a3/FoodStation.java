package com.mycompany.a3;


import com.codename1.charts.models.Point;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

public class FoodStation extends Fixed {
	private int capacity;
	private int size;

	public FoodStation(GameWorld gw, int size, Point location) {
		super(gw, size, location);
		super.setColor(ColorUtil.rgb(0, 255, 0));
		capacity = size;
		this.size = size;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity() {
		capacity = 0;
	}

	@Override
	public String toString() {
		String parentDesc = super.toString();
		String myDesc = " capacity = " + capacity;
		return "Food Station:" + parentDesc + myDesc;

	}

	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {
		g.setColor(getColor());
		if (isSelected()) {
			g.fillArc((int) (pCmpRelPrnt.getX() + this.getX()), (int) (pCmpRelPrnt.getY() + this.getY()), this.size,
					size, 0, 360);
		}

		int locationX = (int) getX() + (int) pCmpRelPrnt.getX();
		int locationY = (int) getY() + (int) pCmpRelPrnt.getY();
		g.setColor(ColorUtil.BLACK);
		String capacityNumber = Integer.toString(capacity);
		g.drawString(capacityNumber, locationX, locationY);
	}

	@Override
	public boolean collidesWith(GameObject otherObjects) {
		// TODO Auto-generated method stub
		return false;
	}

}