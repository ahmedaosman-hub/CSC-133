package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;

public class CommandExit extends Command{
	
	private GameWorld gw;
	
	public CommandExit(GameWorld gw) {
		super("Exit");
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		Command yes = new Command("yes");
		Command no = new Command("no");
		
		Label label = new Label("");
		
		Command c = Dialog.show("Are you sure you would like to exit", label, yes, no);
		
		if (c == yes) {
			gw.exit();
		}
		else if (c == no) {
			return; 
		}
	}

}