package Model.datastore.file;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import Model.Computer;
import Model.IComputerDAO;

public class ComputerDAO {

	protected String fileName = null;
	protected final List<Computer> myList;
	
	public ComputerDAO() {
		Porperties props = new Properties();
		try {
			props.load(new FileInputStream("res/file/db.properties"));
			this.fileName = props.getProperty("DB_FILENAME");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.myList = new ArrayList<>();
		try {
			Files.createFile(Paths.get(fileName));
        } catch (FileAlreadyExistsException fae) {
            ;
        } catch (IOException ioe) {
            System.out.println("Create file error with " + ioe.getMessage());
        }
        readList();
    }
	
	@Override
	public void createData(Computer computer) {
		myList.add(computer);
		writeList();
	}
	
	@Override
	public Computer retrieveDataById(int id) {
		for (Computer computer : myList) {
			if (computer.getCompId() == id) {
				return computer;
			}
		}
		return null;
	}
	
	@Override
	public List<Computer> retrieveAllData() {
		return myList;
	}
	
	@Override
	public void updateData(Computer updatedComputer) {
		for (Computer computer : myList) {
			if (computer.getCompId() == updatedComputer.getCompId()) {
				computer.setModel(updatedComputer.getModel());
				computer.setBrand(updatedComputer.getBrand());
				computer.setFeatures(updatedComputer.getFeatures());
				computer.setLocation(updatedComputer.getLocation());
				break;
			}
		}
		writeList();
	}
	
	@Override
	public void deleteData(int id) {
		
	}
}
