package com.mycompany.a2;

import com.codename1.charts.models.Point;

import com.codename1.charts.util.ColorUtil;

public class FoodStation extends Fixed {
	private int capacity;

	public FoodStation(int size, Point location) {
		super(ColorUtil.rgb(0, 255, 0));
		capacity = size;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int i) {
		capacity = 0;
	}

	@Override
	public String toString() {
		String parentDesc = super.toString();
		String myDesc = " capacity=" + capacity;
		return "Food Station:" + parentDesc + myDesc;

	}

}
