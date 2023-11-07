package com.mycompany.a3;

import java.util.Random;

import com.codename1.charts.models.Point;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

public class FoodStation extends Fixed {
	private int capacity;
	private int size;
	private Random rand = new Random();

	


	 public FoodStation(GameWorld gw, int size, Point location) {
			super(gw, size, location);
	        super.setColor(ColorUtil.rgb(0, 255, 0));
	        capacity = size;
	        this.size = size;
	    }


	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int i) {
		capacity = i;
	}

	@Override
	public String toString() {
		String parentDesc = super.toString();
		String myDesc = " capacity=" + capacity;
		return "Food Station:" + parentDesc + myDesc;

	}

	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {
	    g.setColor(getColor());
	    int scaledSize = (int) (size * 1.5); // Increase the size by a scaling factor (1.5 in this example)
	    
	    if (!isSelected()) {
	        g.fillRect((int)(pCmpRelPrnt.getX() + this.getX()), (int) (pCmpRelPrnt.getY() + this.getY()), scaledSize, scaledSize); // Filled square representing the food station
	    } else {
	        g.drawRect((int)(pCmpRelPrnt.getX() + this.getX()), (int) (pCmpRelPrnt.getY() + this.getY()), scaledSize, scaledSize); // Border of the square if it's selected
	    }

	    // Draw the capacity text at the center of the square
	    int textX = (int) getX() + scaledSize / 2 - g.getFont().stringWidth(Integer.toString(capacity)) / 2;
	    int textY = (int) getY() + scaledSize / 2 + g.getFont().getHeight() / 2;

	    g.setColor(0x000000);
	    String capacityNum = Integer.toString(capacity);
	    g.drawString(capacityNum, textX, textY);
	}



}