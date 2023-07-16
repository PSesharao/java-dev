package com.mindtree.jspapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.jspapp.model.UserLog;
import com.mindtree.jspapp.repository.UserLogRepository;

@Controller
@RequestMapping
public class UserLogController {
	
	@Autowired
	private UserLogRepository userLogRepository;
	
	 @RequestMapping("/adduser")
	 public String addUser()
	 {
		 return "index";
	 }
	 

	 @RequestMapping("/search")
	 public String search()
	 {
		 return "search";
	 }
	 
	 @RequestMapping("/success")
	 public String suceessAdd(UserLog user)
	 {
		 userLogRepository.save(user);
		 return "success";
	 }
	 
	 @RequestMapping("/getuser")
	 public ModelAndView getUserLog(@RequestParam String userId)
	 {
		 ModelAndView mv = new ModelAndView() ;
		 mv.setViewName("display");
		 UserLog user = userLogRepository.findById(userId).orElse(null);
		 mv.addObject("user", user);
		 return mv;
	 }
}
