package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.TextArea;
import com.codename1.ui.layouts.BorderLayout;

public class MapView extends Container implements Observer{
	private TextArea gameText;
	private static int height;
	private static int width;
	private GameWorld gw;
	public MapView() {
		this.getAllStyles().setBorder(Border.createLineBorder(10, ColorUtil.rgb(255, 0, 0)));
		this.setLayout(new BorderLayout());
		gameText = new TextArea();
		gameText.setEditable(false);
		gameText.getAllStyles().setBgTransparency(0);
		MapView.height = this.getHeight();
		MapView.width = this.getWidth();
		this.setWidth(1000);
		this.setHeight(1000);
		this.add(BorderLayout.NORTH, gameText);
	}
	
	public static void setMapHeight(int height) {
		MapView.height = height;
	}
	
	public static int getMapHeight() {
		return height;
	}
	
	public static void setMapWidth(int width) {
		MapView.width = width;
	}
	public static int getMapWidth() {
		return width;
	}
	
	@Override 
	public void update(Observable observable, Object data) {
		gameWorld = (GameWorld) data;
		IITerator itr = gameWorld.getCollection().getIterator();
		String display = "";
		while (itr.hasNext()) {
			display = display + itr.getNext().toString()+"\n";
		}
		gameText.setText(display);
		this.repaint();
	}

}
