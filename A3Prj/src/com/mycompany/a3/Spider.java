package com.mycompany.a2;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

import java.util.Random;

public class Spider extends Moveable {
	
	private Random rand = new Random();
	
	
	
	public Spider(int size, Point location) {
		super(size, location ); 
		super.setColor(ColorUtil.rgb(0, 0, 0));
		setSpeed(randSpeed());
		setHeading(randHeading());
	}
	
	
	@Override
	public void setColor(int color) {
		
	}
	
	@Override
	public void setHeading(int heading) {
		super.setHeading(randValue());
	}
	
	private int randValue() {
		return ((-5) + rand.nextInt(10));
	}
	
	private int randHeading() {
		return rand.nextInt(359);
	}
	private int randSpeed() {
		return 5 + rand.nextInt(5);
	}
	
	
	public String toString() {
		String parentDesc = super.toString();
		return "Spider: " + parentDesc;
	}	
}