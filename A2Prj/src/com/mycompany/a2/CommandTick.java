package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CommandTick extends Command{
	private GameWorld gw;
	
	public CommandTick(GameWorld gw) {
		super("Tick");
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		gw.tick();
	}
}
