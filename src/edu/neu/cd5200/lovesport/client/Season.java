package edu.neu.cd5200.lovesport.client;

public class Season {

	private String id;
	private String year;
	private String type;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Season(String id, String year, String type) {
		super();
		this.id = id;
		this.year = year;
		this.type = type;
	}
	public Season() {
		super();
	}
	
	
}
