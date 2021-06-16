// Ariel Mileguir
// Pedro Gabriel 

package modelTest;

import model.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
	* Method: void testCopyNTimes
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
	
	/* End Method: testCopyNTimes */
	/*
	****************************************************************************
	* 
	* Method: void insertLOneTime
	*  ****/
	
	@Test 
    public void testInsertLOneTime() {
        List actual_list = new List();
        int object = 2;
        
        actual_list.insertL(object);
        
        assertEquals("Method testInsertL Size was unsuccessfull", 1,actual_list.getSize());
        assertEquals("Method testInsertL Element Add was unsuccessfull",object,actual_list.get(0));
	}    
	/* End Method: testInsertLOneTime */
	/*
	****************************************************************************
	* 
	* Method: void insertLTwoTimes
	*  ****/
	
	@Test 
    public void testInsertLTwoTimes() {
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
	/* End Method: testInsertLTwoTimes */
	/*
	****************************************************************************
	* 
	* Method: void testDrawLWithObject
	*  ****/
	
	@Test 
    public void testDrawLWithObject() {
        List actual_list = new List();
        List expected_list = new List();
        int object_1 = 2;
        int expected_object;
        
        
        actual_list.insertL(object_1);
        expected_list.insertL(object_1);
        
        expected_object = (int)actual_list.drawL();
        
        assertEquals("Method testGetIndexGreaterThanSize Draw Equals was unsuccessfull", expected_object,object_1);
                
    }
	
	/* End Method: testDrawLWithObject */
	/****************************************************************************
	* 
	* Method: void testDrawLWithoutObject
	*  ****/
	
	@Test 
    public void testDrawLWithoutObject() {
        List actual_list = new List();
        int object_1 = -1;
        int expected_object;
               
        expected_object = (int)actual_list.drawL();
        
        assertEquals("Method testGetIndexGreaterThanSize Draw Equals was unsuccessfull", expected_object,object_1);
                
    }
	
	/* End Method: testDrawLWithoutObject */
	/*
	****************************************************************************
	* 
	* Method: void GetSize
	*  ****/
	
	@Test 
    public void testGetSize() {
        List actual_list = new List();
        int expected_size = 1;
        int object = 1;
        		
        actual_list.insertL(object);
                           
        assertEquals("Method testGetIndexLowerThanSize was unsuccessfull", expected_size,actual_list.getSize());
        
    }
	
	/* End Method: testGetSize */
	/*
	****************************************************************************
	* 
	* Method: void testUpdateSizeIncrease
	*  ****/
	
	@Test 
    public void testUpdateSizeIncrease() {
        List actual_list = new List();
        int object = 1;
        		
        actual_list.insertL(object);
        actual_list.insertL(object);
                                         
        assertEquals("Method testUpdateSize Increase was unsuccessfull", 2,actual_list.size);
        
        
    }
	
	/* End Method: testUpdateSizeIncrease */
	/*
	****************************************************************************
	* 
	* Method: void testUpdateSizeIncrease
	*  ****/
	
	@Test 
    public void testUpdateSizeDecrease() {
        List actual_list = new List();
        int object = 1;
        		
        actual_list.insertL(object);
        actual_list.insertL(object);
        actual_list.drawL();
        
        assertEquals("Method testUpdateSize Increase was unsuccessfull", 1,actual_list.size);
        
        
    }
	
	/* End Method: testUpdateSizeDecrease */
	/*
	****************************************************************************
	* 
	* Method: void testClear
	*  ****/
	
	@Test 
    public void testClear() {
        List actual_list = new List();
        int object = 1;
        
        actual_list.insertL(object);
        actual_list.clear();
       
        
        assertEquals("Method testUpdateSize Increase was unsuccessfull", 0,actual_list.size);
        
        
    }
	
	/* End Method: testClear */
	/*
	****************************************************************************
	* 
	* Method: void testdrawAll
	*  ****/
	
	@Test 
    public void testDrawAll() {
        List actual_list = new List();
        List drawed_list = new List();
        List expected_list = new List();
        int object_1 = 1;
        int object_2 = 2;
        
        
        actual_list.insertL(object_1);
        actual_list.insertL(object_2);
        drawed_list.insertL(object_1);
        drawed_list.insertL(object_2);
        expected_list = drawed_list.drawAll();
        
        assertEquals("Method testdrawAll was unsuccessfull because of Object(1)", expected_list.get(1),object_1);
        assertEquals("Method testdrawAll was unsuccessfull because of Object(0)", expected_list.get(0),object_2);
        
        
    }
	
	/* End Method: testdrawAll */
	/*
	****************************************************************************
	* 
	* Method: void testDrawContainsObject
	*  ****/
	
	@Test 
    public void testDrawContainsObject() {
        List actual_list = new List();
        int object_1 = 1;
        int object_2 = 2;
        boolean isRemoved;
        int expected_size = 1;
        
        actual_list.insertL(object_1);
        actual_list.insertL(object_2);
        
        isRemoved = actual_list.draw(object_1);
        
        assertTrue("Method testdrawAll was unsuccessfull because of Object(1)", isRemoved);
        assertEquals("Method testDrawContainsObject was unsuccessfull because of Size",expected_size,actual_list.getSize());
        
    }
	
	/* End Method: testDrawContainsObject */
	/*
	****************************************************************************
	* 
	* Method: void testDrawDontContainObject
	*  ****/
	
	@Test 
    public void testDrawDontContainObject() {
        List actual_list = new List();
        int object_1 = 1;
        int object_2 = 2;
        int object_3 = 3;
        boolean isRemoved;
        int expected_size = 2;
        
        actual_list.insertL(object_1);
        actual_list.insertL(object_2);
        
        isRemoved = actual_list.draw(object_3);
        
        assertFalse("Method testdrawAll was unsuccessfull because of Object(1)", isRemoved);
        assertEquals("Method testDrawContainsObject was unsuccessfull because of Size",expected_size,actual_list.getSize());
        assertEquals("Method testDrawDontContainObject was unsuccessfull because of Object(0)",object_1,actual_list.get(0));
        assertEquals("Method testDrawDontContainObject was unsuccessfull because of Object(0)",object_2,actual_list.get(1));
    }
	
	/* End Method: testDrawContainsObject */
	/*
	****************************************************************************
	* 
	* Method: void testEmpty
	*  ****/
	
	@Test 
    public void testEmpty() {
        List actual_list = new List();        
        
        assertTrue("Method testEmpty was unsuccessfull", actual_list.empty());
        
        
    }
	
	/* End Method: testClear */
	/*
	****************************************************************************
	* 
	* Method: void testAcess
	*  ****/
	
	@Test 
    public void testAcess() {
		List actual_list = new List();
        int object_1 = 1;
        int object_2 = 2;
        int expected_object = 2;
        
        actual_list.insertL(object_1);
        actual_list.insertL(object_2);       
        
        assertEquals("Method testAcess was unsuccessfull", expected_object,actual_list.acess(object_2));
        
        
    }
	
	/* End Method: testClear */

}

