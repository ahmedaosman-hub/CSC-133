package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CommandFoodStationCollision extends Command {


	private GameWorld gw;

	public CommandFoodStationCollision(GameWorld gw) {
		super("Collided with Food Station");
		this.gw = gw;
	}
	

	
}