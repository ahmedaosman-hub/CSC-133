package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CommandFlag extends Command {
	private GameWorld gw;
	
	public CommandFlag(GameWorld gw) {
		super("Collide with Flag");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent ev, int flagNumber) {
		gw.flagCollision(flagNumber);
	}

}