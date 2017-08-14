package com.restu.labs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.restu.labs.model.User;
import com.restu.labs.service.UserService;

@Controller
public class AdminController {
	Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	UserService userService;
	
//	@ModelAttribute
//	public void addAttributes(Model model){
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		User user = userService.findUserByEmail(auth.getName());
//		model.addAttribute("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
//	}

	@GetMapping(value={"/admin/edit"})
	public ModelAndView showEdit(@RequestParam("id") long id){
		logger.debug("showEdit()");
		ModelAndView modelAndView = new ModelAndView();
		System.out.print("id nya : "+id);
		User user = userService.findUserById(id);
		System.out.print("id nya : "+user);
		modelAndView.addObject("user", user);
		modelAndView.setViewName("admin/edit");
		return modelAndView;
	}
	
	@GetMapping(value={"/admin/delete"})
	public String deleteUser(@RequestParam("id") long id){
		User user = userService.findUserById(id);
		userService.deleteUser(user);
		return "redirect:home";
	}
}
