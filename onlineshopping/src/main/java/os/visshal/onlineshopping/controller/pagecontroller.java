package os.visshal.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import os.visshal.osbackend.dao.CategoryDAO;
import os.visshal.osbackend.dto.Category;

@Controller
public class pagecontroller
{
	@Autowired
	private CategoryDAO categoryDAO;
	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() 
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("userClickHome", true);
	
		//passing list of categories
		mv.addObject("categories", categoryDAO.list());
		return mv;
	}
	@RequestMapping(value = "/about")
	public ModelAndView about() 
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About us");
		mv.addObject("userClickAbout", true);
		return mv;
	}
	@RequestMapping(value = "/contact")
	public ModelAndView contact() 
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact us");
		mv.addObject("userClickContact", true);
		return mv;
	}
	
	/*methods to load all the products and based on category*/
	
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() 
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		
		//passing list of categories
		mv.addObject("userClickAllProducts", true);
		mv.addObject("categories", categoryDAO.list());
		return mv;
	}
	
	@RequestMapping(value = "/show/Category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id")int id)  
	{
		ModelAndView mv = new ModelAndView("page");
		Category category = null;
		category = categoryDAO.get(id);
	
		//category DAO to fetch the single category
		mv.addObject("title", category.getName());
				
		//passing list of categories
		mv.addObject("categories", categoryDAO.list());
		
		//passing the single category object
		mv.addObject("category", category);
		
		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}
	
	
	
}
