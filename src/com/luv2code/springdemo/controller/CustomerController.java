package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//inject dao here
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String getCustomerList(Model model)
	{
		//get customers from dao
		List<Customer> customerlist = customerDAO.getCustomer();
		
		//add it to model
		model.addAttribute("customers",customerlist);
		
		return("customerslist");
	}

}
