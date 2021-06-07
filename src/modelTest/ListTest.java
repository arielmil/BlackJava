package modelTest;

import model.*;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ListTest {

	private static final int DEFAULT_TIMEOUT = 5000;
	
	/****************************************************************************
	* 
	* Method: void testGetIndexBiggerThanSize: Tests case if the index is bigger than size
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testGetIndexBiggerThanSize() {
        List actual_list = new List();
        int actual_index = 1;
        int expected_index = -1;
        
        assertEquals("Method isBroke was unsuccessfull",expected_index,actual_list.get(actual_index));

    }
	
	/* End Method: testGetIndexBiggerThanSize */
	/*
	****************************************************************************
	* 
	* Method: void testGetIndexSmallerThanSize
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testGetIndexSmallerThanSize() {
        List actual_list = new List();
        int actual_index = 0;
        int expected_number = 10;
        
        actual_list.insertL(expected_number);        
        assertEquals("Method isBroke was unsuccessfull",expected_number,actual_list.get(actual_index));

    }	
	
	/* End Method: testGetIndexSmallerThanSize */
	/*
	****************************************************************************
	* 
	* Method: void testMoveFrom
	*  ****/
	
	@Test 
    public void testMoveFrom() {
        List actual_list_from = new List();
        List actual_list_to = new List();
        int expected_size = 3;
        
        for (int i = 0; i < expected_size;i++) {
        	actual_list_from.insertL(i);
        }
        
        actual_list_to.moveFrom(actual_list_from);
        
        assertEquals("Method testMoveFrom Size was unsuccessfull",expected_size,actual_list_to.size); 
        
        for (int i = 0; i < expected_size;i++) {
        	assertEquals("Method testMoveFrom Element was unsuccessfull",expected_size-1-i,actual_list_to.get(i));
        }

    }
	
	/* End Method: testMoveFrom */
	/*
	****************************************************************************
	* 
	* Method: void testMoveFrom
	*  ****/
	
	@Test 
    public void testCopyNTimes() {
        List actual_list = new List();
        int expected_times = 3;
        int expected_size = 8;
        
        for (int i = 0; i < 2;i++) {
        	actual_list.insertL(i);
        }
        
        actual_list.copyNTimes(expected_times);
        
        assertEquals("Method testCopyNTimes was unsuccessfull",expected_size,actual_list.size); 
        
    }
	
	/* End Method: testMoveFrom */
	/*
	****************************************************************************
	* 
	* Method: void insertL
	*  ****/
	
	@Test 
    public void testInsertL() {
        List actual_list = new List();
        int object = 2;
        int object_2 = 3;
        
        actual_list.insertL(object);
        
        assertEquals("Method testInsertL Size was unsuccessfull", 1,actual_list.getSize());
        assertEquals("Method testInsertL Element Add was unsuccessfull",object,actual_list.get(0));
        
        actual_list.insertL(object_2);
        
        assertEquals("Method testInsertL Size was unsuccessfull", 2,actual_list.getSize());
        assertEquals("Method testInsertL Element Add was unsuccessfull",object_2,actual_list.get(1));
        
    }
	
	/* End Method: testMoveFrom */
}
