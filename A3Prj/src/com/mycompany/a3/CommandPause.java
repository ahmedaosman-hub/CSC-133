package com.mycompany.a3;

import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.table.TableLayout;


public class CommandPause extends Command {

	private GameWorld gw;

	
	
	public CommandPause(GameWorld gw) {
		super("Pause");
		this.gw = gw;
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		if(gw.isPause())
			gw.setIsPause(false);
		else
			gw.setIsPause(true);
		}
	
	
}