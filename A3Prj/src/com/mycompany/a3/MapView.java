package com.mycompany.a3;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.plaf.Border;

public class MapView extends Container implements Observer{
	
	private GameWorld model;
	public MapView(Observable myModel) {
		model = (GameWorld) myModel;
		myModel.addObserver(this);
		this.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.BLACK));
	}
		
	public void update(Observable o, Object arg) {
		repaint();
	}
	
	public void repaint() {
		paint();
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		if (model != null) {
		for (GameObject obj: model.getGameObjects()) {
			obj.draw(g,  getParent().getAbsoluteX(), getParent().getAbsoluteY());
		}
		}
	}
}
	
	