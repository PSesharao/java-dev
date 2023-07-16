package com.mindtree.passenger.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.passenger.dto.UserDto;
import com.mindtree.passenger.entity.UserRegister;
import com.mindtree.passenger.repository.UserRepository;
import com.mindtree.passenger.service.UserService;


@Controller
public class SecurityController {

	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String login() {
		return "login";
	}

	@RequestMapping("/home")
	public ModelAndView home(Principal principal) {

		String username = principal.getName();
		UserRegister customer = userRepository.findByName(username).get();
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("image", customer.getImage());
		mv.addObject("name", customer.getName());
		mv.addObject("email", customer.getEmail());
		mv.addObject("role", customer.getRoles());
		return mv;
	}
	
	@RequestMapping("/approve")
	public ModelAndView approve(Principal principal) {

		String username = principal.getName();
		UserRegister customer = userRepository.findByName(username).get();
		ModelAndView mv = new ModelAndView("approve");
		mv.addObject("image", customer.getImage());
		mv.addObject("name", customer.getName());
		mv.addObject("email", customer.getEmail());
		mv.addObject("role", customer.getRoles());
		return mv;
	}
	
	
	@RequestMapping("/city")
	public ModelAndView category(Principal principal) {

		String username = principal.getName();
		UserRegister customer = userRepository.findByName(username).get();
		ModelAndView mv = new ModelAndView("city");
		mv.addObject("image", customer.getImage());
		mv.addObject("name", customer.getName());
		mv.addObject("email", customer.getEmail());
		mv.addObject("role", customer.getRoles());
		return mv;
	}
	
	@RequestMapping("/train")
	public ModelAndView shop(Principal principal) {

		String username = principal.getName();
		UserRegister customer = userRepository.findByName(username).get();
		ModelAndView mv = new ModelAndView("train");
		mv.addObject("id", customer.getId());
		mv.addObject("image", customer.getImage());
		mv.addObject("name", customer.getName());
		mv.addObject("email", customer.getEmail());
		mv.addObject("role", customer.getRoles());
		return mv;
	}
	
	
	@RequestMapping("/passenger")
	public ModelAndView myorders(Principal principal) {

		String username = principal.getName();
		UserRegister customer = userRepository.findByName(username).get();
		ModelAndView mv = new ModelAndView("passenger");
		mv.addObject("id", customer.getId());
		mv.addObject("image", customer.getImage());
		mv.addObject("name", customer.getName());
		mv.addObject("email", customer.getEmail());
		mv.addObject("role", customer.getRoles());
		return mv;
	}
	
	


	@RequestMapping("/register")
	public String register() {

		return "register";
	}

	@ResponseBody
	@RequestMapping("/registeruser")
	public UserRegister registeruser(UserDto userRegister) {
		/*
		 * System.out.println(userRegister.getName());
		 * System.out.println(userRegister.getEmail());
		 * System.out.println(userRegister.getImageFile());
		 * System.out.println(userRegister.getHobbyList());
		 * System.out.println(userRegister.getRoles());
		 */
		return userService.registerUser(userRegister);
		// return userRegister;

	}

	@RequestMapping(value = "/login")
	public String loginPage(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {
		String errorMessge = null;
		if (error != null) {
			errorMessge = "Email or Password is incorrect !!";
		}
		if (logout != null) {
			errorMessge = "You have been successfully logged out !!";
		}
		model.addAttribute("errorMessge", errorMessge);
		return "login";
	}
	
	@RequestMapping(value = "/forbidden")
    public ModelAndView accesssDenied(Principal user) {

        ModelAndView model = new ModelAndView();

        if (user != null) {
            model.addObject("msg", "Hi " + user.getName() 
            + ", you do not have permission to access this page!");
        } else {
            model.addObject("msg", 
            "You do not have permission to access this page!");
        }
        String username = user.getName();
		UserRegister customer = userRepository.findByName(username).get();
        model.addObject("image", customer.getImage());
        model.addObject("name", customer.getName());
        model.addObject("email", customer.getEmail());
        model.addObject("role", customer.getRoles());
        model.setViewName("forbidden");
        return model;

    }

}
