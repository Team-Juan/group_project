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

public class ComputerDAO implements IComputerDAO {

	protected String fileName = null;
	protected final List<Computer> myList;
	
	public ComputerDAO() {
		Properties props = new Properties();
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
		for (Computer computer : myList) {
			if (computer.getCompId() == id) {
                myList.remove(computer);
                break;
            }
		}
		writeList();
	}
	
	@Override
    public void deleteData(Computer computer) {
        myList.remove(computer);
        writeList();
    }

    private void readList() {
        Path path = Paths.get(fileName);
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String brand = data[1];
                String model = data[2];
                String features = data[3];
                String location = data[4];
                Computer computer = new Computer(id, brand, model, features, location);
                myList.add(computer);
            }
        } catch (IOException ioe) {
            System.out.println("Read file error with " + ioe.getMessage());
        }
    }

    private void writeList() {
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for (Computer computer : myList) {
                writer.write(String.format("%d,%s,%s,%s,%.2f\n",
                        computer.getCompId(),
                        computer.getBrand(),
                        computer.getModel(),
                        computer.getFeatures(),
                        computer.getLocation()));
            }
        } catch (IOException ioe) {
            System.out.println("Write file error with " + ioe.getMessage());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Computer computer : myList) {
            sb.append(String.format("%5d : %s, %s, %s, %.2f\n",
            		computer.getCompId(),
                    computer.getBrand(),
                    computer.getModel(),
                    computer.getFeatures(),
                    computer.getLocation()));
        }

        return sb.toString();
    }
}
