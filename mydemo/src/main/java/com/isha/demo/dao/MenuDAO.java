package com.isha.demo.dao;

import java.util.List;

import com.isha.demo.model.Menu;



public interface MenuDAO {
//public void saveOrUpdate(Menu menu);
    
    //public void delete(int MenuId);
	public Menu get(int MenuId);
    
    public List<Menu> list();
}
