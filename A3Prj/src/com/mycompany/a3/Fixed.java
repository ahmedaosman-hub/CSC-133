package com.mycompany.a3;

import com.codename1.charts.models.Point;

public abstract class Fixed extends GameObject implements ISelectable{

	private boolean isSelected;

	public Fixed(GameWorld gw, int size, Point location) {
		super(gw, size,location );
	}
	
	@Override
	public void setSelected(boolean yes) {
		isSelected = yes;
	}
	
	@Override
	public boolean isSelected() {
		return isSelected;
	}
	
	@Override
	public boolean contains(Point pPtrRelPrnt, Point pCmpRelPrnt) {
		float x = pPtrRelPrnt.getX();
		float y = pPtrRelPrnt.getY();
		
		int locationX = (int) (pCmpRelPrnt.getX()+ this.getX());
		int locationY = (int) (pCmpRelPrnt.getY()+ this.getY());
		if ( (x >= locationX) && (x <= locationX +this.getSize())&& (y >= locationY) && (y <= locationY +this.getSize()) ) {
			
		
		        return true; 
		}
		else {
		        	return false;
		}
	}
}