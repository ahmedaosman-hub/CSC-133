package com.mycompany.a3;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

public class Flag extends Fixed implements IDrawable{
	private int sequenceNumber;
	private GameWorld gw;
	private Point location;

	public Flag(GameWorld gw, int size, Point location, int sequenceNumber) {
		super(gw,size, location);
		this.location = location;
		this.sequenceNumber = sequenceNumber;
		super.setColor(ColorUtil.rgb(0, 0, 255));	}

	public int getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber() {
		this.sequenceNumber = sequenceNumber;
	}
	@Override
	public String toString() {
		String parentDesc = super.toString();
		String myDesc = " sequence Number=" + sequenceNumber;
		return "Flag:" + parentDesc + myDesc;
	}
	
	
	
	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {
	    float xLocFloat = getLocation().getX() + pCmpRelPrnt.getX();
	    float yLocFloat = getLocation().getY() + pCmpRelPrnt.getY();
	    int xLoc = Math.round(xLocFloat);
	    int yLoc = Math.round(yLocFloat);
	    int flagSize = getSize(); // Use the size defined for the flag

	    // Calculate the coordinates of the triangle vertices
	    int x1 = xLoc - (flagSize / 2);
	    int y1 = yLoc + (flagSize / 2); // Bottom-left vertex
	    int x2 = xLoc + (flagSize / 2);
	    int y2 = yLoc + (flagSize / 2); // Bottom-right vertex
	    int x3 = xLoc; // Top vertex
	    int y3 = yLoc - (flagSize / 2);

	    // Define the vertices of the filled isosceles triangle
	    int[] xPoints = { x1, x2, x3 };
	    int[] yPoints = { y1, y2, y3 };

	    // Create a filled Polygon with the vertices
	    int nPoints = 3; // Three points to create a triangle
	    int color = getColor(); // Use the color defined for the flag
	    g.setColor(color);
	    g.fillPolygon(xPoints, yPoints, nPoints);
	    
	    // Draw the sequence number
	    g.setColor(0x000000);
	    String sequenceNum = Integer.toString(sequenceNumber);
	    g.drawString(sequenceNum, xLoc - 7, yLoc + 5);
	}

		public boolean contains(Point pPtrRelPrnt, Point pCmpRelPrnt) {
			float x = pPtrRelPrnt.getX(); 
			float y = pPtrRelPrnt.getY(); 
			int xLoc = (int) (pCmpRelPrnt.getX()+ this.getX());
			int yLoc = (int) (pCmpRelPrnt.getY()+ this.getY());
			if ( (x >= xLoc) && (x <= xLoc+this.getSize())&& (y >= yLoc) && (y <= yLoc+this.getSize()) )
			        return true; 
			else
			        	return false;
			
		}


}