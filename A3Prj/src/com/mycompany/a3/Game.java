package com.mycompany.a3;

// Import necessary libraries
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.UITimer;
import com.codename1.ui.Toolbar;

// The Game class serves as both the controller and the view
public class Game extends Form implements Runnable {
	private GameWorld gw;
	private MapView mv;
	private ScoreView sv;

	private Command pauseCommand;
	private Button pauseButton;

	private boolean selected = true;
	private static int mapX;
	private static int mapY;
	private BGSound bgSound = new BGSound("background.mp3");

	public Game() {
		// Create instances of GameWorld, MapView, and ScoreView
		gw = new GameWorld();
		mv = new MapView(gw);
		sv = new ScoreView(gw);

		// Set up the layout of the Game form using BorderLayout
		this.setLayout(new BorderLayout());

		// Create command objects for various game commands
		Command exitCommand = new CommandExit(gw);
		Command accelerateCommand = new CommandAccelerate(gw);
		Command leftCommand = new CommandLeftHeading(gw);
		Command brakeCommand = new CommandBrake(gw);
		Command rightCommand = new CommandRightHeading(gw);
		Command foodCommand = new CommandFoodStationCollision(gw);
		Command tickCommand = new CommandTick(gw);
		Command positionCommand = new CommandPosition(gw);
		Command pauseCommand = new CommandPause(gw);

		// Add key bindings for specific keys to invoke commands
		addKeyListener('x', exitCommand);
		addKeyListener('a', accelerateCommand);
		addKeyListener('b', brakeCommand);
		addKeyListener('l', leftCommand);
		addKeyListener('r', rightCommand);
		addKeyListener('f', foodCommand);

		// Create a west container for command buttons
		Container westContainer = new Container();
		westContainer.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.GRAY));
		westContainer.setLayout(new BoxLayout(2));

		// Create buttons for various commands and add them to the west container
		// (e.g., Accelerate, Left, Change Strategies)
		// Set commands for these buttons
		// Customize button styles
		// Add buttons to the container
		Button accelerateButton = new Button("Accelerate");
		accelerateButton.setCommand(accelerateCommand);
		westContainer.add(accelerateButton);
		accelerateButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		accelerateButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		accelerateButton.getAllStyles().setBgTransparency(255);
		accelerateButton.getAllStyles().setMarginBottom(10);

		Button leftButton = new Button("Left");
		leftButton.setCommand(leftCommand);
		westContainer.addComponent(leftButton);
		leftButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		leftButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		leftButton.getAllStyles().setBgTransparency(255);
		leftButton.getAllStyles().setMarginBottom(10);

		Container eastContainer = new Container();
		eastContainer.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.GRAY));
		eastContainer.setLayout(new BoxLayout(2));

		// Create buttons for Brake and Right commands and add them to the east
		// container
		// Set commands for these buttons
		// Customize button styles
		// Add buttons to the container
		Button brakeButton = new Button("Brake");
		brakeButton.setCommand(brakeCommand);
		eastContainer.addComponent(brakeButton);
		brakeButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		brakeButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		brakeButton.getAllStyles().setBgTransparency(255);
		brakeButton.getAllStyles().setMarginBottom(10);

		Button rightButton = new Button("Right");
		rightButton.setCommand(rightCommand);
		eastContainer.add(rightButton);
		rightButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		rightButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		rightButton.getAllStyles().setBgTransparency(255);
		rightButton.getAllStyles().setMarginBottom(10);

		// Create a center container
		Container centerContainer = new Container();
		centerContainer.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.GRAY));

		// Create a south container for more command buttons
		Container southContainer = new Container();
		southContainer.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.GRAY));
		southContainer.setLayout(new FlowLayout(Component.CENTER));

		// Create buttons for various commands and add them to the south container
		// Set commands for these buttons
		// Customize button styles
		// Add buttons to the container

		pauseButton = new Button("Pause");
		southContainer.addComponent(pauseButton);
		pauseButton.setCommand(pauseCommand);
		pauseButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		pauseButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		pauseButton.getAllStyles().setBgTransparency(255);
		pauseButton.getAllStyles().setMarginRight(5);

		Button positionButton = new Button("Position");
		southContainer.addComponent(positionButton);
		positionButton.setCommand(positionCommand);
		positionButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		positionButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		positionButton.getAllStyles().setBgTransparency(255);
		positionButton.getAllStyles().setMarginRight(5);
		positionButton.getDisabledStyle().setFgColor(ColorUtil.BLUE);
		positionButton.getDisabledStyle().setBgColor(ColorUtil.WHITE);

		// Set up the toolbar for the GUI
		Toolbar toolbar = new Toolbar();
		this.setToolbar(toolbar);
		toolbar.setTitle("TheJourney Game");

		// Add command items to the side menu
		// (e.g., Accelerate, Sound, About, Exit)
		// Set commands for these items
		toolbar.addCommandToSideMenu(accelerateCommand);
		Command soundCommand = new CommandSound(gw);
		CheckBox soundCheck = new CheckBox("Sound");
		soundCheck.setCommand(soundCommand);
		toolbar.addComponentToSideMenu(soundCheck);
		Command aboutCommand = new CommandAbout(gw);
		toolbar.addCommandToSideMenu(aboutCommand);

		toolbar.addCommandToSideMenu(exitCommand);

		// Add a Help button to the right side of the title bar area

		Command helpButton = new CommandHelp(gw);
		toolbar.addCommandToRightBar(helpButton);

		// Add containers and components to the Game form using BorderLayout

		this.add(BorderLayout.WEST, westContainer);
		this.add(BorderLayout.EAST, eastContainer);
		this.add(BorderLayout.SOUTH, southContainer);
		this.add(BorderLayout.NORTH, sv);
		this.add(BorderLayout.CENTER, mv);
		gw.setMapHeight(mv.getComponentForm().getHeight());
		gw.setMapWidth(mv.getComponentForm().getWidth());

		this.show();

		gw.setWidthHeight(mv.getComponentForm().getX(), mv.getComponentForm().getY());
		// Set the dimensions for the map in GameWorld
		gw.setMapHeight(mv.getComponentForm().getHeight());
		gw.setMapWidth(mv.getComponentForm().getWidth());
		gw.init();
		UITimer timer = new UITimer(this);
		timer.schedule(20, true, this);

		play();
	}

	private void play() {
	}     

	public void playSounds() {
		if (gw.isSound()) {
			if (gw.isFoodCol()) {
				gw.setFoodCol(false);
				Sound foodSound = new Sound("food.wav", "audio/wav");
				if (!gw.isPause())
					foodSound.play();

			}
			if (gw.isCrashCol()) {
				gw.setCrashCol(false);
				Sound crashSound = new Sound("crash.wav", "audio/wav");
				if (!gw.isPause())
					crashSound.play();
			}

			if (gw.isEndCollision()) {
				gw.setCrashCol(false);
				Sound endSound = new Sound("end.wav", "audio/wav");
				if (!gw.isPause())
					endSound.play();
			}
			if (gw.isPause()) {
				bgSound.pause();
			} else {

				bgSound.play(gw.isPause());
			}

		} else {
			bgSound.pause();
		}

	}

	@Override
	public void run() {
		if (gw.isPause()) {
			pauseButton.setText("Play");
			bgSound.pause();
		} else {
			pauseButton.setText("Pause");
			playSounds();
			gw.tick(1);
		}
	}

}
