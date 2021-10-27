package com.simplilearn.webapp.model;

public class Product {

	//Going to write multiple properties
	
	private int id;
	
	private String name;
	
	private String description;
	
	private double price;
	
	
    //Parametrised constructor 
	public Product(int id, String name, String description, double price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}
 
   //Non-parameterized constructor
	public Product() {
		
	}
	
	
	//getter and setter
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	//Generate toString 
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + "]";
	}
	
	

	
	
	
	

	
}
