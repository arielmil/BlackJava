/***********************************************************************/
package model;

import java.util.ArrayList;
import java.util.Collections;

/***********************************************************************/

class List {
	
	private int size;
	private ArrayList<Object> list;
	private boolean empty;
	
	/***************************************************************************
	*  Method: Constructor - list : Initializes the list
	*  ****/
	
	List() {
		list = new ArrayList<Object>();
		size = 0;
		empty = true;
	}
	/* End Method: Constructor - list */
	
	Object get(int index) {
		if (index > size) {
			return -1;
		}
		return list.get(index);
	}
	
	/****************************************************************************
	*  Method: Object drawL : Removes the Object from the end of the list, returning it
	*  ****/
	
	Object drawL() {
		if (!empty) {
			Object o = list.remove(size - 1);
			
			if (size == 0) {
				empty = true;
			}
			else {
				empty = false;
			}
			
			updateSize();
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
	
	void insertL(Object o) {
		list.add(o);
	}
	/* End Method: void insertL */
	/*
	***************************************************************************
	*  Method: Boolean empty : Returns the boolean empty (!)
	*  ****/
	
	Boolean empty() {
		return empty;
	}
	/* End Method: void insertL */
	/*
	***************************************************************************
	*  Method: void shuffle : Shuffles the list 
	*  ****/
	
	void shuffle() {
		Collections.shuffle(list);
	}
	/* End Method: void shuffle */
	/*
	***************************************************************************
	*  Method: void copyNTimes : Get an int n, and copy the list n times. Inserting all copied elements at the end 
	*  ****/
	
	void copyNTimes(int times) {
		int i,j;
		
		for (i = 0; i < times; i++) {
			for (j = 0; j < size; i++) {
				this.insertL(get(j));
			}
		}
		
		updateSize();
	}
	/* End Method: void copyNTimes */
	/*
	***************************************************************************
	*  Method: int getSize : Returns the size of the list 
	*  ****/
	
	int getSize() {
		return size;
	}
	/* End Method: int getSize */
	/*
	***************************************************************************
	*  Method: private void updateSize : Every time drawL or insertL is called, this method updates the size variable 
	*  ****/
	
	private void updateSize() {
		size = list.size();
	}
	/* End Method: private void updateSize */
	
	void moveFrom(List list) {
		int i;
		for (i = 0; i < list.getSize(); i++) {
			this.insertL(list.drawL());
		}
	}
	
}