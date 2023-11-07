package com.mycompany.a3;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

public class Flag extends Fixed {
	private Point location;
	private int size;
	private boolean selected;

	private int sequenceNumber;

	public Flag(GameWorld gw, int size, int sequenceNumber, Point location) {
		super(gw, size, location);
		this.location = location;
		this.size = size;
		this.sequenceNumber = sequenceNumber;
		super.setColor(ColorUtil.rgb(0, 0, 230));
	}

	public int getSequenceNumber() {
		return sequenceNumber;
	}

	@Override
	public void setColor(int color) {
		super.setColor(ColorUtil.rgb(0, 0, 230));
	}

	@Override
	public String toString() {
		String parentDesc = super.toString();
		String myDesc = " sequence Number=" + sequenceNumber;
		return "Flag:" + parentDesc + myDesc;
	}

	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {

		// Draws the flag as a triangle.
		int locationX = (int) (location.getX()) + (int) pCmpRelPrnt.getX();
		int locationY = (int) (location.getY()) + (int) pCmpRelPrnt.getY();
		int xx = (int) (pCmpRelPrnt.getX() + this.getX());
		int yy = (int) (pCmpRelPrnt.getY() + this.getY());

		Point top = new Point((int) (pCmpRelPrnt.getX() + this.getX()), (size) + yy);
		Point left = new Point(xx - (size), yy - (size));
		Point right = new Point(xx + (size), yy - (size));

		g.setColor(getColor());
		if (!selected) {
			g.fillTriangle((int) top.getX(), (int) top.getY(), (int) left.getX(), (int) left.getY(), (int) right.getX(),
					(int) right.getY());
		} else {
			g.setColor(getColor());
			g.drawLine((int) top.getX(), (int) top.getY(), (int) left.getX(), (int) left.getY());
			g.drawLine((int) left.getX(), (int) left.getY(), (int) right.getX(), (int) right.getY());
			g.drawLine((int) top.getX(), (int) top.getY(), (int) right.getX(), (int) right.getY());
		}

		g.setColor(ColorUtil.BLACK);
		String capacityNumber = Integer.toString(sequenceNumber);
		g.drawString(capacityNumber, xx - 7, yy - (size / 2));
	}

	public void setSelected(boolean yes) {
		selected = yes;
	}

	public boolean Selected() {
		return selected;
	}

	public boolean contains(Point pPtrRelPrnt, Point pCmpRelPrnt) {
		int x = (int) pPtrRelPrnt.getX();
		int y = (int) pPtrRelPrnt.getY();
		int locationX = (int) (pCmpRelPrnt.getX() + this.getX());
		int locationY = (int) (pCmpRelPrnt.getY() + this.getY());
		if ((x >= locationX) && (x <= locationX + this.getSize()) && (y >= locationY)
				&& (y <= locationY + this.getSize())) {

			return true;
		} else {
			return false;

		}
	}

	@Override
	public boolean collidesWith(GameObject otherObjects) {
		// TODO Auto-generated method stub
		return false;
	}

}