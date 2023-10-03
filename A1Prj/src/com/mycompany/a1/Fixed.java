package com.mycompany.a1;

import com.codename1.charts.models.Point;

public class Fixed extends GameObject {

	public Fixed(int color) {
		super(color);
	}

	public Fixed(int color, int size) {
		super(color, size);
	}

	public Fixed(int size, Point location, int color) {
super(color);
super.setSize(size);
super.setLocation(location.getX(), location.getY());
}

	@Override
	public void setX(float x) {

	}

	@Override
	public void setY(float y) {

	}
}
