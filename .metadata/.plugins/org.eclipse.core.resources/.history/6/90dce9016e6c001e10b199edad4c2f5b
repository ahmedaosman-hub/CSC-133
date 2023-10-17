package com.mycompany.a2;

import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import java.lang.String;

// Class serves as controller and view 
public class Game extends Form {
	private GameWorld gw;

	public Game() {
		gw = new GameWorld();
		gw.init();
		play();
	}

	private void play() {
		Label myLabel = new Label("Enter a command:");
		this.addComponent(myLabel);
		final TextField myTextField = new TextField();
		this.addComponent(myTextField);
		this.show();

		myTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String sCommand = myTextField.getText().toString();

				myTextField.clear();
				if (sCommand.length() != 0)
					switch (sCommand.charAt(0)) {

					case 'a':
						gw.setAntSpeed(2);
						break;

					case 'b':
						gw.setAntSpeed(-2);
						break;

					case 'l':
						gw.changeHeading('l');
						break;

					case 'r':
						gw.changeHeading('r');
						break;

					case 'c':
						gw.setFoodConsumptionRate('c');
						break;

					case '1':
						gw.flagCollision(1);
						break;

					case '2':
						gw.flagCollision(2);
						break;

					case '3':
						gw.flagCollision(3);
						break;

					case '4':
						gw.flagCollision(4);
						break;

					case '5':
						gw.flagCollision(5);
						break;

					case '6':
						gw.flagCollision(6);
						break;

					case '7':
						gw.flagCollision(7);
						break;

					case '8':
						gw.flagCollision(8);
						break;

					case '9':
						gw.flagCollision(9);
						break;

					case 'f':
						gw.foodStationCollision();
						break;

					case 'g':
						gw.spiderCollision();
						break;

					case 't':
						gw.tick();
						break;

					case 'd':
						gw.printCurrent();
						break;

					case 'm':
						gw.map();
						break;

					case 'n':
						myLabel.setText("Great lets keep playing!\n Enter a command");
						gw.dontQuit();

						break;

					case 'x':
						// System.out.println("Please confirm to exit");
						myLabel.setText("Please enter y or n");
						gw.quitGame();
						break;

					case 'y':
						gw.exit();
						break;

					default:
						System.out.println("Error: Undefined or Illegal input");
						break;
					}
			}

		});
	}
}
