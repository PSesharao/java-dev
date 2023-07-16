package com.mindtree.springsecurity.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mindtree.springsecurity.entity.UserRegister;
import com.mindtree.springsecurity.service.UserService;

@Controller
public class SecurityController {

	@Autowired
	private UserService userService;
	

	@RequestMapping("/secure/")
	@PreAuthorize("hasAnyRole('USER','ADMIN')")
	//@RequestMapping("/")
	public String home() {
		//return ("<h1>Welcome</h1>");
		return "show";
	}

	@PreAuthorize("hasAnyRole('USER','ADMIN')")
	@GetMapping("/secure/user")
	public String user() {
		//return ("<h1>Welcome User</h1>");
		return "user";
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping("/secure/admin")
	public String admin() {
		//return ("<h1>Welcome Admin</h1>");
		return "admin";
	}
	
	@RequestMapping("/register")
	public String register() {
		//return ("<h1>Welcome</h1>");
		return "register";
	}
	
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
