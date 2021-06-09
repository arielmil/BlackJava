/***********************************************************************/
package model;

import java.util.ArrayList;
import java.util.Collections;

/***********************************************************************/

public class List {
	
	public int size;
	private ArrayList<Object> list;
	private boolean empty;
	public static int countRemoved;
	public static int countAdded;
	
	/***************************************************************************
	*  Method: Constructor - list : Initializes the list
	*  ****/
	
	public List() {
		list = new ArrayList<Object>();
		size = 0;
		empty = true;
	}
	/* End Method: Constructor - list */
	
	public Object get(int index) {
		if (index > size) {
			return -1;
		}
		return list.get(index);
	}
	
	public Object acess(Object o) {
		int i = list.indexOf(o);
		return list.get(i);
	}
	
	/****************************************************************************
	*  Method: Object drawL : Removes the Object from the end of the list, returning it
	*  ****/
	
	public Object drawL() {
		if (!empty) {
			Object o = list.remove(size - 1);
			
			if (size == 0) {
				empty = true;
			}
			else {
				empty = false;
			}
			
			countRemoved++;
			
			/* To minimize bloated storage */
			if(Math.abs(countRemoved - countAdded) >= 10) {
				list.trimToSize();
			}
			
			updateSize('r');
			return o;
		}
		
		else {
			return -1;
		}
	}
	/* End Method: Object drawL */
	/*
	***************************************************************************
	*  Method: void insertL : Inserts the object at the end of the list
	*  ****/
	
	public void insertL(Object o) {
		list.add(o);
		updateSize('a');
		empty = false;
	}
	/* End Method: void insertL */
	/*
	***************************************************************************
	*  Method: Boolean empty : Returns the boolean empty (!)
	*  ****/
	
	public Boolean empty() {
		return empty;
	}
	/* End Method: void insertL */
	/*
	***************************************************************************
	*  Method: void shuffle : Shuffles the list 
	*  ****/
	
	public void shuffle() {
		Collections.shuffle(list);
	}
	/* End Method: void shuffle */
	/*
	***************************************************************************
	*  Method: void copyNTimes : Get an int n, and copy the list n times. Inserting all copied elements at the end 
	*  ****/
	
	public void copyNTimes(int times) {
		int original_size = size;
		
		for (int i = 0; i < times; i++) {
			for (int j = 0; j < original_size; j++) {
				this.insertL(get(j));
			}
		}
	}
	
	/* End Method: void copyNTimes */
	/*
	***************************************************************************
	*  Method: int getSize : Returns the size of the list 
	*  ****/
	
	public int getSize() {
		return size;
	}
	/* End Method: int getSize */
	/*
	***************************************************************************
	*  Method: private void updateSize : Every time drawL or insertL is called, this method updates the size variable 
	*  ****/
	
	public void updateSize(char added_or_removed) {
		size = list.size();
		if (added_or_removed == 'a') {
			countAdded++;			
		}
		else {
			countRemoved++;
		}
	}
	/* End Method: private void updateSize */
	
	public void moveFrom(List list) {
		int size = list.getSize();
		for (int i = 0; i < size; i++) {
			this.insertL(list.drawL());
		}
	}
	
	public void clear() {
		list.clear();
		size = 0;
	}
	
	public Object draw(Object o) {
		size--;
		o = list.remove(o);
		return o;
	}
	
	public List drawAll() {
		List list = new List();
		list.moveFrom(this);
		return list;
	}
	
	/*public int indexOf(Object o) {
		return list.indexOf(o);
	}*/
	
}