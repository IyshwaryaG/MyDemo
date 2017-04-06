/**
 * 
 */
package com.isha.demo.model;

import java.sql.Blob;

/**
 * @author Isha
 *
 */
public class Product {
	private int id;
    private String name;
    private boolean IsAvailable;
    private Blob image;
    
 
    public Product() {
    }
 
    public Product(String name, boolean IsAvailable, Blob image) {
        this.setName(name);
        this.setAvailable(IsAvailable);
        this.setImage(image);
        
    }

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

	public boolean IsAvailable() {
		return IsAvailable;
	}

	public void setAvailable(boolean IsAvailable) {
		this.IsAvailable = IsAvailable;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob blob) {
		this.image = blob;
	}
}
