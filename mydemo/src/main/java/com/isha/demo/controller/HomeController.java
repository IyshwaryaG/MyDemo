package com.isha.demo.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.isha.demo.dao.MenuDAO;
import com.isha.demo.dao.ProductDAO;
import com.isha.demo.model.Menu;
import com.isha.demo.model.Product;

/**
 * This controller routes accesses to the application to the appropriate
 * hanlder methods. 
 *
 *
 */
@Controller
public class HomeController {

	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private MenuDAO menuDAO;
	
	@RequestMapping(value="/product")
	public ModelAndView listProduct(ModelAndView model) throws IOException{
		List<Product> listProduct = productDAO. list();
		model.addObject("listProduct", listProduct);
		//model.setViewName("home");
		
		return model;
	}
	
	@RequestMapping(value="/home")
	public ModelAndView listMenu(ModelAndView model) throws IOException{
		List<Menu> listMenu = menuDAO. list();
		model.addObject("listMenu", listMenu);
		model.setViewName("home");
		
		return model;
	}
	
	@RequestMapping(value = "/newProduct", method = RequestMethod.GET)
	public ModelAndView newProduct(ModelAndView model) {
		Product newProduct = new Product();
		model.addObject("product", newProduct);
		model.setViewName("ProductForm");
		return model;
	}
	
	@RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
	public ModelAndView saveProduct(@ModelAttribute Product product) {
		productDAO.saveOrUpdate(product);		
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/deleteProduct", method = RequestMethod.GET)
	public ModelAndView deleteProduct(HttpServletRequest request) {
		int productId = Integer.parseInt(request.getParameter("id"));
		productDAO.delete(productId);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/editProduct", method = RequestMethod.GET)
	public ModelAndView editProduct(HttpServletRequest request) {
		int productId = Integer.parseInt(request.getParameter("id"));
		Product product = productDAO.get(productId);
		ModelAndView model = new ModelAndView("ProductForm");
		model.addObject("product", product);
		
		return model;
	}
}

