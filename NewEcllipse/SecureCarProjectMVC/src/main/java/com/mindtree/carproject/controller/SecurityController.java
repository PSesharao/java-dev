package com.mindtree.carproject.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.carproject.dto.CustomerDto;
import com.mindtree.carproject.entity.Customer;
import com.mindtree.carproject.repository.CustomerRepository;
import com.mindtree.carproject.service.CustomerService;



@Controller
public class SecurityController {

	
	@Autowired
	private CustomerRepository userRepository;

	@Autowired
	private CustomerService userService;

	@RequestMapping("/")
	public String login() {
		return "login";
	}

	@RequestMapping("/home")
	public ModelAndView home(Principal principal) {

		String username = principal.getName();
		Customer customer = userRepository.findByName(username).get();
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("image", customer.getImage());
		mv.addObject("name", customer.getName());
		mv.addObject("email", customer.getEmail());
		mv.addObject("address", customer.getAddress());
		return mv;
	}
	
	@RequestMapping("/color")
	public ModelAndView color(Principal principal) {

		String username = principal.getName();
		Customer customer = userRepository.findByName(username).get();
		ModelAndView mv = new ModelAndView("color");
		mv.addObject("image", customer.getImage());
		mv.addObject("name", customer.getName());
		mv.addObject("email", customer.getEmail());
		mv.addObject("address", customer.getAddress());
		return mv;
	}
	
	@RequestMapping("/model")
	public ModelAndView model(Principal principal) {

		String username = principal.getName();
		Customer customer = userRepository.findByName(username).get();
		ModelAndView mv = new ModelAndView("model");
		mv.addObject("image", customer.getImage());
		mv.addObject("name", customer.getName());
		mv.addObject("email", customer.getEmail());
		mv.addObject("address", customer.getAddress());
		return mv;
	}
	
	
	
	
	@RequestMapping("/brand")
	public ModelAndView brand(Principal principal) {

		String username = principal.getName();
		Customer customer = userRepository.findByName(username).get();
		ModelAndView mv = new ModelAndView("brand");
		mv.addObject("image", customer.getImage());
		mv.addObject("name", customer.getName());
		mv.addObject("email", customer.getEmail());
		mv.addObject("address", customer.getAddress());
		return mv;
	}
	
	@RequestMapping("/shop")
	public ModelAndView shop(Principal principal) {

		String username = principal.getName();
		Customer customer = userRepository.findByName(username).get();
		ModelAndView mv = new ModelAndView("shopping");
		mv.addObject("id", customer.getId());
		mv.addObject("image", customer.getImage());
		mv.addObject("name", customer.getName());
		mv.addObject("email", customer.getEmail());
		mv.addObject("address", customer.getAddress());
		return mv;
	}
	
	
	@RequestMapping("/showroom")
	public ModelAndView showroom(Principal principal) {

		String username = principal.getName();
		Customer customer = userRepository.findByName(username).get();
		ModelAndView mv = new ModelAndView("showroom");
		mv.addObject("id", customer.getId());
		mv.addObject("image", customer.getImage());
		mv.addObject("name", customer.getName());
		mv.addObject("email", customer.getEmail());
		mv.addObject("address", customer.getAddress());
		return mv;
	}
	
	
	

	@RequestMapping("/preparemodel")
	public ModelAndView product(Principal principal) {

		String username = principal.getName();
		Customer customer = userRepository.findByName(username).get();
		ModelAndView mv = new ModelAndView("preparemodel");
		mv.addObject("image", customer.getImage());
		mv.addObject("name", customer.getName());
		mv.addObject("email", customer.getEmail());
		mv.addObject("address", customer.getAddress());
		return mv;
	}
	

	@RequestMapping("/solditems")
	public ModelAndView solditems(Principal principal) {

		String username = principal.getName();
		Customer customer = userRepository.findByName(username).get();
		ModelAndView mv = new ModelAndView("solditems");
		mv.addObject("image", customer.getImage());
		mv.addObject("name", customer.getName());
		mv.addObject("email", customer.getEmail());
		mv.addObject("address", customer.getAddress());
		return mv;
	}
	

	

	@ResponseBody
	@RequestMapping("/getUser")
	public Customer getuser(Principal principal) {
		return userRepository.findByName(principal.getName()).get();
		
	}

	

	@RequestMapping("/register")
	public String register() {

		return "register";
	}

	@ResponseBody
	@RequestMapping("/registeruser")
	public Customer registeruser(CustomerDto userRegister) {
		/*
		 * System.out.println(userRegister.getName());
		 * System.out.println(userRegister.getEmail());
		 * System.out.println(userRegister.getImageFile());
		 * System.out.println(userRegister.getHobbyList());
		 * System.out.println(userRegister.getRoles());
		 */
		return userService.createCustomer(userRegister);
		// return userRegister;

	}

	@RequestMapping(value = "/login")
	public String loginPage(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {
		String errorMessge = null;
		if (error != null) {
			errorMessge = "Username or Password is incorrect !!";
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
		Customer customer = userRepository.findByName(username).get();
        model.addObject("image", customer.getImage());
        model.addObject("name", customer.getName());
        model.addObject("email", customer.getEmail());
        model.addObject("address", customer.getAddress());
        model.setViewName("forbidden");
        return model;

    }

}
