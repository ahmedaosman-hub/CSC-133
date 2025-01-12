package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CommandBrake extends Command {
	
	private GameWorld gw;
	
	public CommandBrake(GameWorld gw) {
		super("Brake");
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		gw.setAntSpeed(-2);
	}
}