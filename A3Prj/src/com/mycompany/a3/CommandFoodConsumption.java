package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CommandFoodConsumption extends Command {

	private GameWorld gw;
	
	public CommandFoodConsumption(GameWorld gw) {
		super("Increasing food consumption");
		this.gw = gw;
	}
	
	@Override 
	public void actionPerformed(ActionEvent ev) {
		gw.setFoodConsumptionRate(1);
	}
}