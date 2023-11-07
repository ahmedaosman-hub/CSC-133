package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.table.TableLayout;

public class CommandAbout extends Command {
	private GameWorld gw;
	
	public CommandAbout(GameWorld gw) {
		super("About");
		this.gw = gw;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		Dialog aboutBox = new Dialog("About", new TableLayout(4,1));
		Command okCommand = new Command("Ok");
		
		aboutBox.add(new Label ("TheJourney Game"));
		aboutBox.add(new Label("Created by: Ahmed Osman"));
		aboutBox.add(new Label ("CSC 133 A2Prj"));
		
		Command c = Dialog.show("", aboutBox, okCommand);
		if (c == okCommand) {
			return; 
		}
	}
}