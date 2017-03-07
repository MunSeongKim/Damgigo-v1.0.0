package com.damgigo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.damgigo.domain.User_test;
import com.damgigo.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	UserService userService;
	
/*	@ModelAttribute
	CustomerForm setUpForm(){
		return new CustomerForm();
	}*/
	
	@RequestMapping(method = RequestMethod.GET)
	String list(Model model){
		List<User_test> users = userService.findAll();
		model.addAttribute("users", users);
		return "users/main";
	}
	
/*	@RequestMapping(value = "create", method = RequestMethod.POST)
	String create(@Validated CustomerForm form, BindingResult result, Model model){
		if( result.hasErrors() ){
			return list(model);
		}
		
		Customer customer = new Customer();
		BeanUtils.copyProperties(form, customer);
		customerService.create(customer);
		
		return "redirect:/customers";
	}*/
}
