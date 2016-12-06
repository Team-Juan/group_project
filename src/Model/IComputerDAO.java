package Model;

import java.util.List;


/**
 * The interface for the computer database application.
 * @author Team-Juan
 * @version 1.0
 */
public interface IComputerDAO {
	
	/**
	 * Creates a new comuter object in the database.
	 * @param computer The computer object to be created.
	 */

	void createData(Computer computer);
	
	/**
	 * A method to search for data in the database.
	 * @param field The field column to search for.
	 * @param search The specific data to search for.
	 * @return A list of matching search criteria.
	 */
	List<Computer> searchData(String field, String search);
	
	/**
	 * Display the data for the specified compID.
	 * @param id The compID
	 * @return The computer object matching the compID
	 */
	
	Computer retrieveDataById(int id);
	
	/**
	 * Displays all rows in the database table.
	 * @return A list of all rows in the database table.
	 */
	
	List<Computer> retrieveAllData();
	
	/**
	 * Updates a computer in the database table.
	 * @param updatedComputer The computer object to update.
	 */
	
	void updateData(Computer updatedComputer);
	
	/**
	 * Deletes the computer that matches the specified id.
	 * @param id The compID to delete.
	 */
	
	void deleteData(int id);
	
	/**
	 * Deletes the computer object.
	 * @param computer Deletes the specified computer object.
	 */
	
	void deleteData(Computer computer);
	
	/**
	 * This formats the return string of the program.
	 * @return The formatted string
	 */
	
	@Override
	String toString();
	
}
