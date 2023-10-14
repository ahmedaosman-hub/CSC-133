package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

public class ScoreView extends Container implements Observer {
	private GameWorld gameWorld;
	private Label lifeValueLabel;
	private Label clockValueLabel;
	private Label lastFlagReachedValueLabel;
	private Label foodLevelValueLabel;
	private Label damageLevelValueLabel;
	private Label soundValueLabel;
	public ScoreView() {
		setLayout();
		setClockLabel();
		setLifeValueLabel();
		setLastFlagReachedValueLabel();
		setFoodLevelValueLabel();
		setDamageLevelValueLabel();
		setSoundLabel();
	}

	public void setLayout() {
		this.setLayout(new BoxLayout(BoxLayout.X_AXIS));
	}
	
	public void setClockLabel() {
		Label clockLabel = new Label("Time:");
		clockLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		clockValueLabel = new Label("0");
		clockValueLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		clockValueLabel.getAllStyles().setPadding(RIGHT, 2);
		this.add(clockLabel);
		this.add(clockValueLabel);
	}
	
	public void setLifeValueLabel() {
		Label lifeLabel = new Label("Lives Left:");
		lifeLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		lifeLabel.getAllStyles().setPadding(1, 1, 1, 1);
		lifeValueLabel = new Label("0");
		lifeValueLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		lifeValueLabel.getAllStyles().setPadding(RIGHT, 2);
		this.add(lifeLabel);
		this.add(lifeValueLabel);
	}
	
	public void setLastFlagReachedValueLabel() {
		Label lastFlagLabel = new Label("Player Last Flag Reached:");
		lastFlagLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		lastFlagLabel.getAllStyles().setPadding(1,1,1,1);
		lastFlagReachedValueLabel = new Label("0");
		lastFlagReachedValueLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		lastFlagReachedValueLabel.getAllStyles().setPadding(RIGHT, 2);
		this.add(lastFlagLabel);
		this.add(lastFlagReachedValueLabel);
	}
	
	public void setFoodLevelValueLabel() {
		Label foodLabel = new Label("Player Food Level:");
		foodLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		foodLabel.getAllStyles().setPadding(1,1,1,1);
		foodLevelValueLabel = new Label("0");
		foodLevelValueLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		foodLevelValueLabel.getAllStyles().setPadding(RIGHT, 2);
		this.add(foodLabel);
		this.add(foodLevelValueLabel);
	}
	
	public void setDamageLevelValueLabel() {
		Label damageLabel = new Label("Player Damage Level: ");
		damageLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		damageLabel.getAllStyles().setPadding(1,1,1,1);
		damageLevelValueLabel = new Label("0");
		damageLevelValueLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		damageLevelValueLabel.getAllStyles().setPadding(RIGHT, 5);
		this.add(damageLabel);
		this.add(damageLevelValueLabel);
	}
	
	public void setSoundLabel() {
		Label soundLabel = new Label("Sound: ");
		soundLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		soundLabel.getAllStyles().setPadding(1,1,1,1);
		soundValueLabel = new Label("OFF");
		soundValueLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		soundValueLabel.getAllStyles().setPadding(RIGHT, 5);       
		this.add(soundLabel);
		this.add(soundValueLabel);
	}
	
	@Override
	public void update(Observable observer, Object data) {
		gameWorld = (GameWorld) data;
		this.lifeValueLabel.setText(" "+gameWorld.getLife());
		this.clockValueLabel.setText(" "+gameWorld.getTime());;
		this.lastFlagReachedValueLabel.setText(" "+gameWorld.getLastFlagReached());;
		this.foodLevelValueLabel.setText(" "+gameWorld.getFoodLevel());;
		this.damageLevelValueLabel.setText(" "+gameWorld.getDamageLevel());
		if(gameWorld.getSound() ) {
				this.soundValueLabel.setText("ON");
				System.out.println("Sound ON");
			}else 
				this.soundValueLabel.setText("OFF");
		this.repaint();
	}
	
}