package com.restu.labs.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.restu.labs.model.Role;
import com.restu.labs.model.User;
import com.restu.labs.service.RoleService;
import com.restu.labs.service.UserService;

@Controller
public class LoginController {	
	private final Logger logger = LoggerFactory.getLogger(LoginController.class);
		
	@Autowired
	UserService userService;
	
	@Autowired
	RoleService roleService;
	
	@RequestMapping(value={"/","/login"},method=RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@RequestMapping(value={"/registration"},method=RequestMethod.GET)
	public ModelAndView registration(){
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("enum", Role.roleList.values());
		modelAndView.addObject("user",user);
		modelAndView.setViewName("registration");
		return modelAndView;
	}
	
	@RequestMapping(value={"/registration"},method=RequestMethod.POST)
	public ModelAndView registration(@Valid User user,BindingResult bindingResult){
		logger.debug("registration()");
		
		ModelAndView modelAndView = new ModelAndView();
		User userExist = userService.findUserByEmail(user.getEmail());
		
		if(userExist != null){
			bindingResult.rejectValue("email", "error.user","There is already a user registered with the email provided");
		}
		
		if(bindingResult.hasErrors()){
			modelAndView.setViewName("registration");
		} else {
			//System.out.println("INFO Role selected {} "+user.getNameRole());
			Role role1 = roleService.findRoleByRole(user.getNameRole());
			user.setRoles(role1);
			userService.saveUser(user);
			modelAndView.addObject("successMessage","User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("registration");
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value={"/admin/home"},method=RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("users",userService.findAllUser());
		modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
		modelAndView.setViewName("admin/home");
		
		return modelAndView;
	}
	
	@RequestMapping(value={"/administrator/edit/"},method=RequestMethod.GET)
	public ModelAndView showEdit(){
		logger.debug("showEdit()");
		ModelAndView modelAndView = new ModelAndView();
		System.out.print("id nya : ");
		modelAndView.setViewName("admin/edit");
		return modelAndView;
	}
}
