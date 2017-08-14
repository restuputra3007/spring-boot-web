package com.restu.labs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {

	@GetMapping(value={"/member/home"})
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("member/home");
		return modelAndView;
	}
}
