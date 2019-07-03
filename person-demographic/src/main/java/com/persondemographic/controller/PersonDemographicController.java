package com.persondemographic.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.persondemographic.model.User;
import com.persondemographic.service.UserService;

@Controller
@RequestMapping("/")
public class PersonDemographicController {

	@Autowired
	UserService userService;
	
    @RequestMapping
    public String home()
    {
     return "home";
    }
    
    @RequestMapping("/createUser")
    public ModelAndView createUser()
    {
    	ModelAndView mav = new ModelAndView("createUser");
    	mav.addObject("user",new User());
    	
    	
     return mav;
    }

    @PostMapping("/doCreateUser")
    public ModelAndView doCreateUser(User user)
    {
    	ModelAndView mav = new ModelAndView("createUser");
    	try {
    		user.setCreationDate(new Date());
    		this.userService.createUser(user);
        	mav.addObject("user",new User());
        	mav.addObject("userRegistered","User "+user.getName()+" correctly registered");
        		
    	}
    			catch (DuplicateKeyException e) {
    	        	mav.addObject("userAlreadyRegistered","PPS number is already registered");
    	          	mav.addObject("user",user);
    	            	     
    		    }
    		 
     return mav;
    }

    
    @RequestMapping("/listUsers")
    public ModelAndView listUsers()
    {	
    	ModelAndView mav = new ModelAndView("listUsers");
    	mav.addObject("users",this.userService.listUsers());
    	return mav;
    }

	
}
