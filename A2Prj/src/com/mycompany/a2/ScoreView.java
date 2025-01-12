package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;

public class ScoreView extends Container implements Observer {
	
    private GameWorld gameWorld; 

    private Label livesLabel;          // Label to display "Lives: "
    private Label livesValue;          // Label to display the number of lives
    private Label clockLabel;          // Label to display "Clock: "
    private Label clockValue;          // Label to display the current clock value
    private Label lastFlagLabel;       // Label to display "Last Flag Reached: "
    private Label lastFlagValue;       // Label to display the last flag reached
    private Label foodLevelLabel;      // Label to display "Player Food Level: "
    private Label foodLevelValue;      // Label to display the food level
    private Label healthLevelLabel;    // Label to display "Damage Level: "
    private Label healthLevelValue;    // Label to display the ant's health level
    private Label soundLabel;          // Label to display "Sound: "
    private Label soundValue;          // Label to display whether sound is ON or OFF

    public ScoreView(Observable gw) {
        gameWorld = ((GameWorld) gw);      // Set the gameWorld (GameWorld) from the provided observable
        gw.addObserver(this);          // Register this view as an observer of the gameWorld
        this.setLayout(new FlowLayout(Component.CENTER));
        this.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.BLACK));
        this.setupLabels();            // Initialize and set up labels for displaying game information

        // Add labels to the view
        this.add(clockLabel);
        this.add(clockValue);
        this.add(livesLabel);
        this.add(livesValue);
        this.add(lastFlagLabel);
        this.add(lastFlagValue);
        this.add(foodLevelLabel);
        this.add(foodLevelValue);
        this.add(healthLevelLabel);
        this.add(healthLevelValue);
        this.add(soundLabel);
        this.add(soundValue);
    }

    public void setupLabels() {
        // Set up labels for displaying game information

    	// Show the current clock value
        clockLabel = new Label("Time: ");
        clockValue = new Label("" + gameWorld.getClock());
        clockLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
        
        // Show the number of lives left
        livesLabel = new Label("Lives Left: ");
        livesValue = new Label("" + gameWorld.getLives());
        livesLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
        livesValue.getAllStyles().setFgColor(ColorUtil.BLUE);

        

        // Show the last flag reached
        lastFlagLabel = new Label("Last Flag Reached: ");
        lastFlagValue = new Label("" + gameWorld.getAntFlagReached());
        lastFlagLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
        lastFlagValue.getAllStyles().setFgColor(ColorUtil.BLUE);

        // Show the food level
        foodLevelLabel = new Label("Food Level: ");
        foodLevelValue = new Label("" + gameWorld.getFoodLevel());
        foodLevelLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
        foodLevelValue.getAllStyles().setFgColor(ColorUtil.BLUE);

        // Show the health level
        healthLevelLabel = new Label("Health Level: ");
        healthLevelValue = new Label("" + gameWorld.getAntHealthLevel());
        healthLevelLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
        healthLevelValue.getAllStyles().setFgColor(ColorUtil.BLUE);

        // Show whether sound is ON or OFF
        soundLabel = new Label("Sound: ");
        soundValue = new Label("" + gameWorld.isSound());
        soundLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
        soundValue.getAllStyles().setFgColor(ColorUtil.BLUE);
    }

    public void updateWorld() {
        // Update the values of the labels with the current game information
        livesValue.setText("" + gameWorld.getLives());
        livesValue.getParent().revalidate();
        clockValue.setText("" + gameWorld.getClock());
        clockValue.getParent().revalidate();
        lastFlagValue.setText("" + gameWorld.getAntFlagReached());
        lastFlagValue.getParent().revalidate();
        foodLevelValue.setText("" + gameWorld.getFoodLevel());
        foodLevelLabel.getParent().revalidate();
        healthLevelValue.setText("" + gameWorld.getAntHealthLevel());
        healthLevelValue.getParent().revalidate();
        soundValue.setText("" + gameWorld.isSound());
        soundValue.getParent().revalidate();
    }

    @Override
    public void update(Observable observable, Object data) {
        // Update the view with the latest game information when the gameWorld changes
        this.updateWorld();
    }
}
