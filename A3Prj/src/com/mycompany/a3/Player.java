package com.mycompany.a3;

import com.codename1.charts.models.Point;
import com.codename1.ui.Graphics;

public   class Player extends Ant {
	private int size;
	private Point location;
	
	
	
	public Player(GameWorld gw, int size, int heading, Point location) {
		super(gw, size, heading, location);
		this.location = location;
		this.size = size;
	}

	@Override
	public String toString() {
			String parentDesc = super.toString();
			return "Ant: " + parentDesc;
			
		}	
	
	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {
		int locationX = (int)getX()+ (int) pCmpRelPrnt.getX();
		int locationY = (int)getY() + (int) pCmpRelPrnt.getY();
		
		g.setColor(getColor());
		g.fillRect(locationX, locationY, size, size);
	}


	@Override
	public void setFoodConsumptionRate(int foodConsumptionRate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean collidesWith(GameObject otherObjects) {
		// TODO Auto-generated method stub
		return false;
	}
}
