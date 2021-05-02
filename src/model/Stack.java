package model;

import java.util.ArrayList;
import java.util.Collections;

class Stack {
	private int size;
	private ArrayList<Object> stack;
	private boolean empty;
	
	Stack() {
		stack = new ArrayList<Object>();
		size = 0;
		empty = true;
	}
	
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
	
	void insertL(Object o) {
		stack.add(o);
	}
	
	Boolean empty() {
		return empty;
	}
	
	void shuffle() {
		Collections.shuffle(stack);
	}
	
	void copyNTimes(int times) {
		int i,j;
		
		for (i = 0; i < times; i++) {
			for (j = 0; j < size; i++) {
				this.insertL(stack.get(j));
			}
		}
		
		updateSize();
	}
	
	int getSize() {
		return size;
	}
	
	private void updateSize() {
		size = stack.size();
	}
}
