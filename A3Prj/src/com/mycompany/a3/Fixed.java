package com.mycompany.a3;

import com.codename1.charts.models.Point;

public abstract class Fixed extends GameObject {

	private boolean isSelected;

	public Fixed(GameWorld gw, int size, Point location) {
		super(gw, size,location );
	}
	
	public void setSelected(boolean yes) {
		isSelected = yes;
	}
	
	public boolean isSelected() {
		return isSelected;
	}
	
	
	public boolean contains(Point pPtrRelPrnt, Point pCmpRelPrnt) {
		float x = pPtrRelPrnt.getX();
		float y = pPtrRelPrnt.getY();
		
		int locationX = (int) (pCmpRelPrnt.getX()+ this.getX());// shape location relative 
		int locationY = (int) (pCmpRelPrnt.getY()+ this.getY());// to parents origin
		if ( (x >= locationX) && (x <= locationX +this.getSize())&& (y >= locationY) && (y <= locationY +this.getSize()) )
		        return true; 
		else
		        	return false;
		
	}
}