package com.mycompany.a3;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;

public class CommandExit extends Command {


	private GameWorld gw;

	
	public CommandExit(GameWorld gw) {
		super("Exit");
		this.gw = gw;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		gw.quitGame();
		Command yes = new Command("yes");
		Command  no  = new Command("no");
		
		Label label1 = new Label("");
		
		Command command = Dialog.show("Are you sure you would like to exit", label1, yes, no);
		
		if(command == yes) {
			gw.exit();
		}
		else if (command == no) {
			gw.dontQuit();
		}
	}
}