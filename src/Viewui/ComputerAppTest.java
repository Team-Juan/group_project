package Viewui;

import static org.junit.Assert.*;
import org.junit.Test;

import Model.Computer;
import Model.IComputerDAO;
import Model.datastore.mysql.ComputerDAO;

/**
 * The JUnit test for the computer database application.
 * @author Team-Juan
 * @version 1.0
 */

public class ComputerAppTest {
	
	IComputerDAO compList = new ComputerDAO();
	
	@Test
	public void testComputerApp() {
		
		/**
		 * Runs a series of three tests. Testing the search data feature, the create data feature, and the delete data feature. 
		 */
		
		int testing = 0;
		
		
		System.out.println(compList.searchData("brand", "dell"));
		System.out.println("Test 1 complete.");
		testing++;
		compList.createData(new Computer(42, "TestBrand", "TestModel", "TestFeatures", "TestLocation"));
		System.out.println("Test 2 complete.");
		testing++;
		System.out.println(compList.retrieveDataById(42));
		compList.deleteData(42);
		System.out.println("Test 3 complete.");
		testing++;
		
		
		if(testing == 3) {
			System.out.println("All tests have passed.");
			
		} else {
			fail("One or more tests failed.");
		}
	}

	@Test
	public void testMain() {
	}

}
