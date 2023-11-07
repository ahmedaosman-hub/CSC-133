package com.mycompany.a2;

public interface IIterator {
	public boolean hasNext();
	public Object getNext();
	IIterator getIterator();
	void add(Object object);
}