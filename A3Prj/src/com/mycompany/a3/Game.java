package com.mycompany.a2;

// Import necessary libraries
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import java.lang.String;

// The Game class serves as both the controller and the view
public class Game extends Form {
	private GameWorld gw;
	private MapView mv;
	private ScoreView sv;

	public Game() {
        // Create instances of GameWorld, MapView, and ScoreView
        gw = new GameWorld();
        mv = new MapView(gw);
        sv = new ScoreView(gw);

        // Add MapView and ScoreView as observers of GameWorld
        gw.addObserver(mv);
        gw.addObserver(sv);

        // Set up the layout of the Game form using BorderLayout
        this.setLayout(new BorderLayout());

        // Create command objects for various game commands
        Command exitCommand = new CommandExit(gw);
        Command accelerateCommand = new CommandAccelerate(gw);
        Command leftCommand = new CommandLeftHeading(gw);
        Command brakeCommand = new CommandBrake(gw);
        Command rightCommand = new CommandRightHeading(gw);
        Command spidercollideCommand = new CommandSpiderCollision(gw);
        Command foodConsumptionCommand = new CommandFoodConsumption(gw);
        Command foodCommand = new CommandFoodStationCollision(gw);
        Command tickCommand = new CommandTick(gw);

        // Add key bindings for specific keys to invoke commands
        addKeyListener('x', exitCommand);
        addKeyListener('a', accelerateCommand);
        addKeyListener('b', brakeCommand);
        addKeyListener('l', leftCommand);
        addKeyListener('r', rightCommand);
        addKeyListener('c', foodConsumptionCommand);
        addKeyListener('f', foodCommand);
        addKeyListener('g', spidercollideCommand);
        addKeyListener('t', tickCommand);

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
		

        // Create buttons for Brake and Right commands and add them to the east container
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
        
        

        Button flagButton = new Button("Collide with Flag");
        flagButton.getAllStyles().setFgColor(ColorUtil.WHITE);
        flagButton.getAllStyles().setBgColor(ColorUtil.BLUE);
        flagButton.getAllStyles().setBgTransparency(255);	
        flagButton.getAllStyles().setMarginRight(5);
		southContainer.addComponent(flagButton);
		
		Button spiderCollide = new Button("Collide with Spider");
		southContainer.addComponent(spiderCollide);
		spiderCollide.setCommand(spidercollideCommand);
		spiderCollide.getAllStyles().setFgColor(ColorUtil.WHITE);
		spiderCollide.getAllStyles().setBgColor(ColorUtil.BLUE);
		spiderCollide.getAllStyles().setBgTransparency(255);	
		spiderCollide.getAllStyles().setMarginRight(5);
		
        
		Button foodButton = new Button("Collide with Food Station");
		southContainer.add(foodButton);
		foodButton.setCommand(foodCommand);
		foodButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		foodButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		foodButton.getAllStyles().setBgTransparency(255);	
		foodButton.getAllStyles().setMarginRight(5);
        
		Button tickButton = new Button("Tick");
		tickButton.setCommand(tickCommand);
		southContainer.add(tickButton);
		tickButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		tickButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		tickButton.getAllStyles().setBgTransparency(255);	
		tickButton.getAllStyles().setMarginRight(5);        
        
        
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
		this.add(BorderLayout.NORTH, mv);
		this.add(BorderLayout.CENTER, sv);
		
		
		
        // Initialize and show the GUI
		
		gw.init();
		this.show();
		
        // Set the dimensions for the map in GameWorld
		gw.setMapHeight(mv.getComponentForm().getHeight());
		gw.setMapWidth(mv.getComponentForm().getWidth());
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
        	switch(sCommand.charAt(0)) {

     
		
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
			gw.setFoodConsumptionRate(2);
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
			gw.tick();;
			break;
		
		case 'd':
			gw.display();
			break;
		
		case 'm':
			gw.map();
			break;
			
			case 'x':
				myLabel.setText("Please enter y or n");
				gw.quitGame();
				break;
		
		case 'n':
			gw.dontQuit();
			myLabel.setText("Enter a Command:");
			break;
		
		case 'y':
			gw.exit();
			break;
        	}
        	}
        	
        	
        });
    }
}

