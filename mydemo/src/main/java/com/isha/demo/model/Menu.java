package com.isha.demo.model;

import java.sql.Blob;

public class Menu {
	private int id;
    private String name;
    private double price;
    private String size;
	public int getId() {
		return id;
	}
	public Menu(){
		
	}
	public Menu(String name, double price, String size) {
        this.setName(name);
        this.setPrice(price);
        this.setSize(size);
        
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
}
