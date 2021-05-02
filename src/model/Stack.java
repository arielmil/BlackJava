/***********************************************************************/
package model;

import java.util.ArrayList;
import java.util.Collections;

/***********************************************************************/

class Stack {
	
	private int size;
	private ArrayList<Object> stack;
	private boolean empty;
	
	/***************************************************************************
	*  Method: Constructor - Stack : Initializes the Stack
	*  ****/
	
	Stack() {
		stack = new ArrayList<Object>();
		size = 0;
		empty = true;
	}
	/* End Method: Constructor - Stack */
	/*
	***************************************************************************
	*  Method: Object drawL : Removes the Object from the end of the Stack, returning it
	*  ****/
	
	Object drawL() {
		if (!empty) {
			Object o = stack.remove(size - 1);
			
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
	*  Method: void insertL : Inserts the object at the end of the Stack
	*  ****/
	
	void insertL(Object o) {
		stack.add(o);
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
	*  Method: void shuffle : Shuffles the Stack 
	*  ****/
	
	void shuffle() {
		Collections.shuffle(stack);
	}
	/* End Method: void shuffle */
	/*
	***************************************************************************
	*  Method: void copyNTimes : Get an int n, and copy the Stack n times. Inserting all copied elements at the end 
	*  ****/
	
	void copyNTimes(int times) {
		int i,j;
		
		for (i = 0; i < times; i++) {
			for (j = 0; j < size; i++) {
				this.insertL(stack.get(j));
			}
		}
		
		updateSize();
	}
	/* End Method: void copyNTimes */
	/*
	***************************************************************************
	*  Method: int getSize : Returns the size of the Stack 
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
		size = stack.size();
	}
	/* End Method: private void updateSize */
}