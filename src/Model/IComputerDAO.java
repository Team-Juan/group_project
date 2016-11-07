package Model;

import java.util.List;

public interface IComputerDAO {

	void createData(Computer computer);
	List<Computer> searchData(String field, String search);
	
	Computer retrieveDataById(int id);
	
	List<Computer> retrieveAllData();
	
	void updateData(Computer updatedComputer);
	
	void deleteData(int id);
	
	void deleteData(Computer computer);
	
	@Override
	String toString();
	
}
