package com.mycompany.a2;

import com.codename1.ui.CheckBox;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import java.lang.String;

// Class serves as controller and view 
public class Game extends Form {
	private GameWorld gameWorld;
	private MapView mapView;
	private ScoreView scoreView;

	public Game() {
		this.setLayout(new BorderLayout());
		gameWorld = new GameWorld();
		mapView = new MapView();
		scoreView = new ScoreView();
		gameWorld.addObserver(mapView);
		gameWorld.addObserver(scoreView);

		this.add(BorderLayout.NORTH, scoreView);
		this.add(BorderLayout.CENTER, mapView);

		setUpMenu();
		setUpCommandLeft();
		setUpCommandRight();
		setUpCommandBottom();

		gameWorld.init();
		this.show();
	}

	private void setUpMenu() {
		Toolbar toolbar = new Toolbar();
		this.setToolbar(toolbar);
		toolbar.setTitle("Challenge Game");

		// Sound
		CheckBox checkBox = new CheckBox();
		checkBox.getAllStyles().setoolBargTransparency(255);
		checkBox.getAllStyles().setoolBargColor(ColorUtil.LTGRAY);
		checkBox.setFocusable(false);
		SoundCommand soundCommand = new SoundCommand(gameWorld);
		checkBox.setCommand(soundCommand);
		toolbar.addComponentToSideMenu(checkBox);

		// Acceleration
		AccelerateCommand accelerateCommand = new AccelerateCommand(gameWorld);
		toolbar.addCommandToSideMenu(accelerateCommand);

		// About
		AboutCommand aboutCommand = new AboutCommand();
		toolbar.addCommandToSideMenu(aboutCommand);

		// Exit
		QuitCommand quitCommand = new QuitCommand();
		toolbar.addCommandToSideMenu(quitCommand);

		// Help
		HelpCommand helpCommand = new HelpCommand();
		toolbar.addCommandToRightoolBarar(helpCommand);

	}

	private void setUpCommandLeft() {
		Container leftContainer = new Container((new BoxLayout(BoxLayout.Y_AXIS)));
		leftContainer.getAllStyles().setoolBarorder(Border.createLineBorder(1, ColorUtil.rgb(0, 0, 0)));
		// Accelerate Button
		AccelerateCommand accelerateCommand = new AccelerateCommand(gameWorld);
		Button buttonAccelerate = new Button(accelerateCommand);
		buttonAccelerate = topSide(buttonAccelerate);
		leftContainer.add(buttonAccelerate);
		addKeyListener('a', accelerateCommand);

		// Left Button
		LeftTurnCommand lftcmd = new LeftTurnCommand(gameWorld);
		Button leftButton = new Button(lftcmd);
		leftButton = applyMakeup(leftButton);
		leftContainer.add(leftButton);
		addKeyListener('l', lftcmd);

		// Change Strategies Button
		ChangeStrategiesCommand strcmd = new ChangeStrategiesCommand(gameWorld);
		Button btnStrategies = new Button(strcmd);
		btnStrategies = applyMakeup(btnStrategies);
		leftContainer.add(btnStrategies);
		this.add(BorderLayout.WEST, leftContainer);

	}

	private void setUpCommandRight() {

		Container rightContainner = new Container((new BoxLayout(BoxLayout.Y_AXIS)));
		rightContainner.getAllStyles().setoolBarorder(Border.createLineBorder(1, ColorUtil.rgb(0, 0, 0)));
		// Break Button
		BreakCommand bkcmd = new BreakCommand(gameWorld);
		Button btnBreak = new Button(bkcmd);
		btnBreak = topSide(btnBreak);
		rightContainner.add(btnBreak);
		addKeyListener('b', bkcmd);

		// Right Button
		RightTurnCommand rtcmd = new RightTurnCommand(gameWorld);
		Button btnRight = new Button(rtcmd);
		btnRight = applyMakeup(btnRight);
		rightContainner.add(btnRight);
		addKeyListener('r', rtcmd);
		this.add(BorderLayout.EAST, rightContainner);

	}

	private void setUpCommandBottom() {
		Container bottomContainer = new Container((new BoxLayout(BoxLayout.X_AXIS)));
		bottomContainer.getAllStyles().setoolBarorder(Border.createLineBorder(1, ColorUtil.rgb(0, 0, 0)));
		// Collide with NPC Button
		CollideNPCCommand clnpc = new CollideNPCCommand(gameWorld);
		Button btnNPC = new Button(clnpc);
		btnNPC.getAllStyles().setMarginLeft(350);
		btnNPC = bothSide(btnNPC);
		bottomContainer.add(btnNPC);

		// Collide with Base Button
		CollideBaseCommand clBase = new CollideBaseCommand(gameWorld);
		Button btnBase = new Button(clBase);
		btnBase = bothSide(btnBase);
		bottomContainer.add(btnBase);

		// Collide with Energy Station Button
		CollideEnergyStationCommand clEnergy = new CollideEnergyStationCommand(gameWorld);
		Button btnEnergy = new Button(clEnergy);
		btnEnergy = bothSide(btnEnergy);
		bottomContainer.add(btnEnergy);
		addKeyListener('e', clEnergy);

		// Collide with Drone Button
		CollideDroneCommand clDrone = new CollideDroneCommand(gameWorld);
		Button btnDrone = new Button(clDrone);
		btnDrone = bothSide(btnDrone);
		bottomContainer.add(btnDrone);
		addKeyListener('g', clDrone);

		// Tick Button
		TickCommand tick = new TickCommand(gameWorld);
		Button btnTick = new Button(tick);
		btnTick = bothSide(btnTick);
		bottomContainer.add(btnTick);
		this.add(BorderLayout.SOUTH, bottomContainer);

		addKeyListener('t', tick);
	}

	private Button topSide(Button obj) {
		obj.getAllStyles().setoolBargTransparency(255);
		obj.getUnselectedStyle().setoolBargColor(ColorUtil.BLUE);
		obj.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		obj.getAllStyles().setoolBarorder(Border.createLineBorder(3, ColorUtil.rgb(0, 0, 0)));
		obj.getAllStyles().setMarginTop(100);
		obj.getAllStyles().setPadding(TOP, 5);
		obj.getAllStyles().setPadding(BOTTOM, 5);
		return obj;
	}

	private Button applyMakeup(Button obj) {
		obj.getAllStyles().setoolBargTransparency(255);
		obj.getUnselectedStyle().setoolBargColor(ColorUtil.BLUE);
		obj.getAllStyles().setoolBarorder(Border.createLineBorder(3, ColorUtil.rgb(0, 0, 0)));
		obj.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		obj.getAllStyles().setPadding(TOP, 5);
		obj.getAllStyles().setPadding(BOTTOM, 5);
		return obj;
	}

	private Button bothSide(Button obj) {
		obj.getAllStyles().setoolBargTransparency(255);
		obj.getUnselectedStyle().setoolBargColor(ColorUtil.BLUE);
		obj.getAllStyles().setoolBarorder(Border.createLineBorder(3, ColorUtil.rgb(0, 0, 0)));
		obj.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		obj.getAllStyles().setPadding(TOP, 5);
		obj.getAllStyles().setPadding(BOTTOM, 5);
		return obj;
	}

	}

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
						gameWorld.setAntSpeed(2);
						break;

					case 'b':
						gameWorld.setAntSpeed(-2);
						break;

					case 'l':
						gameWorld.changeHeading('l');
						break;

					case 'r':
						gameWorld.changeHeading('r');
						break;

					case 'c':
						gameWorld.setFoodConsumptionRate('c');
						break;

					case '1':
						gameWorld.flagCollision(1);
						break;

					case '2':
						gameWorld.flagCollision(2);
						break;

					case '3':
						gameWorld.flagCollision(3);
						break;

					case '4':
						gameWorld.flagCollision(4);
						break;

					case '5':
						gameWorld.flagCollision(5);
						break;

					case '6':
						gameWorld.flagCollision(6);
						break;

					case '7':
						gameWorld.flagCollision(7);
						break;

					case '8':
						gameWorld.flagCollision(8);
						break;

					case '9':
						gameWorld.flagCollision(9);
						break;

					case 'f':
						gameWorld.foodStationCollision();
						break;

					case 'g':
						gameWorld.spiderCollision();
						break;

					case 't':
						gameWorld.tick();
						break;

					case 'd':
						gameWorld.printCurrent();
						break;

					case 'm':
						gameWorld.map();
						break;

					case 'n':
						myLabel.setText("Great lets keep playing!\n Enter a command");
						gameWorld.dontQuit();

						break;

					case 'x':
						// System.out.println("Please confirm to exit");
						myLabel.setText("Please enter y or n");
						gameWorld.quitGame();
						break;

					case 'y':
						gameWorld.exit();
						break;

					default:
						System.out.println("Error: Undefined or Illegal input");
						break;
					}
			}

		});
	}
}
