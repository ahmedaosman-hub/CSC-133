package com.mycompany.a3;

import java.util.ArrayList;
import java.util.Iterator;

public class GameObjectCollection implements ICollection {

	private Iterator gameObjectIterator = new Iterator();
	
	private ArrayList<GameObject> gameObjectList = new ArrayList<GameObject>();
	
	private class Iterator implements IIterator{
		private int currentIndex = 0;
		
		@Override
		public boolean hasNext() {
			if(gameObjectList.size() <= 0) {
				return false;
			}
			if(currentIndex == gameObjectList.size()) {
				return false;
			}
			return true;
		}
		
		@Override 
		public Object getNext() {
			currentIndex++; 
			return gameObjectList.get(currentIndex - 1);
			
		}
		
		@Override 
		public IIterator getIterator() {
			return gameObjectIterator;
		}
		
		@Override 
		public void add(Object object) {
			
		}
		
		
	}
	@Override
	public void add(Object object) {
		gameObjectList.add((GameObject) object);
	}
	
	public void remove(GameObject object) {
		gameObjectList.remove(object);
	}
	
	@Override
	public IIterator getIterator() {
		return new Iterator() ;
	}
}