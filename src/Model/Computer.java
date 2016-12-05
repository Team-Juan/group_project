package Model;

/**
 * This Java program maintains a list of computers and information about those computers.
 * @author Team-Juan
 * @version 1.0
 */

public class Computer {
	

	private int compId;
	private String model;
	private String brand;
	private String features;
	private String location;
	
	/**
	 * Default constructor.
	 */
	
	public Computer() {
		compId = 0;
		model = "";
		brand = "";
		features = "";
		location = "";
	}
	
	/**
	 * This creates the computer object.
	 * @param compId This is the ID of the computer in the database.
	 * @param model This is the model of the computer.
	 * @param brand This is the brand name of the computer.
	 * @param features This is the various hardware specifications of the computer.
	 * @param location This is where the location of the computer is.
	 */
	
	public Computer(int compId, String model, String brand, String features, String location) {
		this.compId = compId;
		this.model = model;
		this.brand = brand;
		this.features = features;
		this.location = location;
	}
	
	/**
	 * Gets the ID of the computer object.
	 * @return The computer ID as an int
	 */
	
	public int getCompId() {
		return compId;
	}
	
	/**
	 * Sets the ID of the computer object.
	 * @param compID An int
	 */
	
	public void setCompId(int compId) {
		this.compId = compId;
	}
	
	/**
	 * Gets the model of the computer object.
	 * @return The computer model as a string
	 */
	
	public String getModel() {
		return model;
	}
	
	/**
	 * Sets the model of the computer object.
	 * @param model A string
	 */
	
	public void setModel(String model) {
		this.model = model;
	}
	
	/**
	 * Gets the brand name of the computer object.
	 * @return The computer brand name as a string
	 */
	
	public String getBrand() {
		return brand;
	}
	
	/**
	 * Sets the brand name of the computer object.
	 * @param brand A string
	 */
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	/**
	 * Gets the specifications of the computer object.
	 * @return The computer specifications as a string
	 */
	public String getFeatures() {
		return features;
	}
	
	/**
	 * Sets the specifications of the computer object.
	 * @param features A string
	 */
	
	public void setFeatures(String features) {
		this.features = features;
	}
	
	/**
	 * Gets the location of the computer object.
	 * @return The location of the computer as a string
	 */
	public String getLocation() {
		return location;
	}
	
	/**
	 * Sets the location of the computer object.
	 * @param location A string
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * Specifies the string format of the returned string when called.
	 */
	
	@Override
	public String toString() {
		return String.format("%5d : %s, %s, %s, %s", this.getCompId(), this.getModel(),
				this.getBrand(), this.getFeatures(), this.getLocation());
		
	}
}
