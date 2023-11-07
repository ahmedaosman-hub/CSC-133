package com.mycompany.a3;

public interface IIterator {
	public boolean hasNext();
	public Object getNext();
	IIterator getIterator();
	void add(Object object);
}