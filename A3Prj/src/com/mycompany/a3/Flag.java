package com.mycompany.a3;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

public class Flag extends Fixed {

	private int sequenceNumber;
	private int myColor;

	public Flag(int size, Point location, int sequenceNumber) {
		super(size, location, ColorUtil.rgb(0, 0, 255));
		this.sequenceNumber = sequenceNumber;
		this.myColor = ColorUtil.rgb(0, 0, 255);
	}

	public int getSequenceNumber() {
		return sequenceNumber;
	}

	@Override
	public String toString() {
		String parentDesc = super.toString();
		String myDesc = " sequence Number=" + sequenceNumber;
		return "Flag:" + parentDesc + myDesc;
	}
	
	@Override
	public void setColor(int color) {
		myColor = color; 
	}

}