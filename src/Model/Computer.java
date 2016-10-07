package Model;

public class Computer {

	private int compId;
	private String model;
	private String brand;
	private String features;
	private String location;
	
	public Computer() {
		compId = 0;
		model = "";
		brand = "";
		features = "";
		location = "";
	}
	
	public Computer(int compId, String model, String brand, String features, String location) {
		this.compId = compId;
		this.model = model;
		this.brand = brand;
		this.features = features;
		this.location = location;
	}
	
	public int getCompId() {
		return compId;
	}
	
	public void setCompId(int compId) {
		this.compId = compId;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getFeatures() {
		return features;
	}
	
	public void setFeatures(String features) {
		this.features = features;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	@Override
	public String toString() {
		return String.format("%5d : %s, %s, %s, %s", this.getCompId(), this.getModel(),
				this.getBrand(), this.getFeatures(), this.getLocation());
		
	}
}
