package com.mindtree.springsecurity.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.springsecurity.entity.UserRegister;
import com.mindtree.springsecurity.service.UserService;

@Controller
public class SecurityController {

	@Autowired
	private UserService userService;
	
	/*
	 * @RequestMapping("/") public String startup() { return "startup"; }
	 */
	@RequestMapping("/")
	public String login() {
		return "login";
	}
	
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	/*
	 * @RequestMapping("/") public String begin() { return "begin"; }
	 * 
	 * @RequestMapping("/begin") public String begin1() { return "begin"; }
	 */

	@RequestMapping("/user")
	public String user() {
		//return ("<h1>Welcome User</h1>");
		return "user";
	}

	@RequestMapping("/admin")
	public String admin() {
		//return ("<h1>Welcome Admin</h1>");
		return "admin";
	}
	
	/*
	 * @RequestMapping("/register") public String register() { //return
	 * ("<h1>Welcome</h1>"); // model.addAttribute("user", new UserRegister());
	 * return "register"; }
	 */
	/*
	 * @RequestMapping("/registeruser") public String registeruser(UserRegister
	 * userRegister) {
	 * 
	 * //return ("<h1>Welcome</h1>"); userService.registerUser(userRegister); return
	 * "startup"; }
	 */
	
	@RequestMapping("/registeruser")
	public String registeruser(UserRegister userRegister) {
		
		//return ("<h1>Welcome</h1>");
		userService.registerUser(userRegister);
		return "login";
	}
	
	
	  @RequestMapping(value = "/login")
	    public String loginPage(@RequestParam(value = "error", required = false) String error, 
	                            @RequestParam(value = "logout", required = false) String logout,
	                            Model model) {
	        String errorMessge = null;
	        if(error != null) {
	            errorMessge = "Username or Password is incorrect !!";
	        }
	        if(logout != null) {
	            errorMessge = "You have been successfully logged out !!";
	        }
	        model.addAttribute("errorMessge", errorMessge);
	        return "login";
	    }

}
