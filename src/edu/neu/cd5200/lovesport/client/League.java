package edu.neu.cd5200.lovesport.client;

public class League {
	private String id;
	private String name;
	private String alias;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public League(String id, String name, String alias) {
		super();
		this.id = id;
		this.name = name;
		this.alias = alias;
	}
	public League() {
		super();
	}
}
