package Viewui;

import org.junit.Test;

import Model.IComputerDAO;
import Model.datastore.mysql.ComputerDAO;

public class ComputerAppTest {
	
	IComputerDAO compList = new ComputerDAO();

	@Test
	public void testComputerApp() {
		System.out.println(compList.searchData("brand", "dell"));
	}

	@Test
	public void testMain() {
		System.out.println(compList.searchData("features", "i5"));
	}

}
