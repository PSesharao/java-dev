package com.mindtree.shoppingmvc.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.shoppingmvc.config.MyUserDetails;
import com.mindtree.shoppingmvc.dto.CustomerDto;
import com.mindtree.shoppingmvc.entity.Customer;
import com.mindtree.shoppingmvc.repository.CustomerRepository;
import com.mindtree.shoppingmvc.service.CustomerService;

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
	
	
	@RequestMapping("/category")
	public ModelAndView category(Principal principal) {

		String username = principal.getName();
		Customer customer = userRepository.findByName(username).get();
		ModelAndView mv = new ModelAndView("category");
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
		ModelAndView mv = new ModelAndView("shop");
		mv.addObject("id", customer.getId());
		mv.addObject("image", customer.getImage());
		mv.addObject("name", customer.getName());
		mv.addObject("email", customer.getEmail());
		mv.addObject("address", customer.getAddress());
		return mv;
	}
	
	
	@RequestMapping("/myorders")
	public ModelAndView myorders(Principal principal) {

		String username = principal.getName();
		Customer customer = userRepository.findByName(username).get();
		ModelAndView mv = new ModelAndView("myorders");
		mv.addObject("id", customer.getId());
		mv.addObject("image", customer.getImage());
		mv.addObject("name", customer.getName());
		mv.addObject("email", customer.getEmail());
		mv.addObject("address", customer.getAddress());
		return mv;
	}
	
	
	

	@RequestMapping("/product")
	public ModelAndView product(Principal principal) {

		String username = principal.getName();
		Customer customer = userRepository.findByName(username).get();
		ModelAndView mv = new ModelAndView("product");
		mv.addObject("image", customer.getImage());
		mv.addObject("name", customer.getName());
		mv.addObject("email", customer.getEmail());
		mv.addObject("address", customer.getAddress());
		return mv;
	}

	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "/getUser") public Customer getCustomer() { String
	 * username = myuserD.getUsername(); Customer customer =
	 * userRepository.findByName(username).get(); return customer; }
	 */

	@ResponseBody
	@RequestMapping("/getUser")
	public Customer getuser(Principal principal) {
		return userRepository.findByName(principal.getName()).get();
		// return model;
	}

	/*
	 * @RequestMapping("/home") public String home() {
	 * 
	 * return "home"; }
	 */

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
		Customer customer = userRepository.findByName(username).get();
        model.addObject("image", customer.getImage());
        model.addObject("name", customer.getName());
        model.addObject("email", customer.getEmail());
        model.addObject("address", customer.getAddress());
        model.setViewName("forbidden");
        return model;

    }

}
