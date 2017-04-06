package com.isha.demo.dao;

import java.util.List;

import com.isha.demo.model.Product;

public interface ProductDAO {
	
	public void saveOrUpdate(Product product);
    
    public void delete(int productId);
     
    public Product get(int productId);
     
    public List<Product> list();

}
