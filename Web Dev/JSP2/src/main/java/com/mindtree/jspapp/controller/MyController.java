package com.mindtree.jspapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class MyController {
	 @RequestMapping("/register")
	 public String register()
	 {
		 return "index";
	 }
	 
	 @RequestMapping("/display")
	 public String display(@RequestParam("username") String uname, @RequestParam("password") String pwd ,
			 @RequestParam("food") String food , @RequestParam("hobby") String[] hobby ,
			 Model model)
	 {
		 model.addAttribute("username", uname);
		 model.addAttribute("password", pwd);
		 model.addAttribute("food", food);
		 model.addAttribute("hobby", hobby);
		 return "display";
	 }
}
