package com.mycompany.a3;

import com.codename1.charts.models.Point;

public class Player extends Ant{
	public Player(int size, Point location, int heading) {
		super(size, location, heading );
	}
	
	@Override
	public String toString() {
		String parentDesc = super.toString();
		return "Ant: " + parentDesc; 
	}


	
}