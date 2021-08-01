package com.ning;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

	@Autowired
	private UserService service; 
	
	@Autowired
	private ProductService proservice; 
	
	@RequestMapping("/")
	public String home(Model model) {
		//List<ResUser> listUsers = service.listAll();
		//model.addAttribute("listUsers", listUsers);
		//List<Product> listProducts = proservice.listAll();
		//model.addAttribute("listProducts", listProducts);	
		return "index";
	}
	

	
	
	
	@RequestMapping("/new")
	public String showNewProductPage(Model model) {
		ResUser user = new ResUser();
		model.addAttribute("user", user);	
		return "new_user";
	}
	
	//@RequestMapping(value = "/save", method = RequestMethod.POST)
	@PostMapping("/save")
	public String saveUser(@ModelAttribute("user") ResUser user, Model model) {
		service.save(user);
		System.out.println(user);
		return "register_success";
	}
	@RequestMapping("/order")
	public String view(Model model) {
		List<Product> listProducts = proservice.listAll();
		model.addAttribute("listProducts", listProducts);	
		ResUser user = service.get(1);
		model.addAttribute("user", user);
		return "order";
	}
	

	@RequestMapping("/confirm")
	public String confirmorder( Model model) {
		ResUser user = service.get(1);
		model.addAttribute("user", user);
		System.out.println(user);
		//List<ResUser> listUsers = service.listAll();
		//model.addAttribute("listUsers", listUsers);
		//List<Product> listProducts = proservice.listAll();
	//	model.addAttribute("listProducts", listProducts);
		//model.addAllAttributes("user", user);
		return "confirm";
	}
	
	@RequestMapping("/viewcart")
	public String viewcart( Model model) {
		ResUser user = service.get(1);
		model.addAttribute("user", user);
		System.out.println(user);
		//List<ResUser> listUsers = service.listAll();
		//model.addAttribute("listUsers", listUsers);
		//List<Product> listProducts = proservice.listAll();
	//	model.addAttribute("listProducts", listProducts);
		//model.addAllAttributes("user", user);
		return "viewcart";
	}
	
	
	@RequestMapping("/add/{id}")
	public String addDish(@PathVariable(name = "id") int id,  Model model ) {
		Product product = proservice.get(id);
		model.addAttribute("product", product);	
		ResUser user = service.get(1);
		model.addAttribute("user", user);
		System.out.println("user name:" + user.getName());
		user.addDish(product);
		service.save(user);
		
		//List<ResUser> listUsers = service.listAll();
		//model.addAttribute("listUsers", listUsers);
		//List<Product> listProducts = proservice.listAll();
	//	model.addAttribute("listProducts", listProducts);
		//model.addAllAttributes("user", user);
		return "redirect:/order";
	}
	
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_product");
		Product product = proservice.get(id);
		mav.addObject("product", product);
		
		return mav;
	}


	
	

	
	/*

	
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Product> listProducts = pservice.listAll();
		model.addAttribute("listProducts", listProducts);
		
		return "show";
	}
	/*
	
	
	@RequestMapping("/delete/{id}")
	public String deleteUser(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/";		
	}
	*/
}
