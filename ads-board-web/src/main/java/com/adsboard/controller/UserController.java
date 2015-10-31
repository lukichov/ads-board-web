package com.adsboard.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adsboard.model.User;
import com.adsboard.service.UserService;

/**
 * Project <b> Ads board</b>. 
 *
 * This Controller class is used for control of pages /myads and /register and /account
 * Implements the display and CRUD operations with users
 *
 * @author Oleksandr Lukichov
 * @since October 30, 2015
 */
@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@ModelAttribute("user")
	public User construct(){
		return new User();		
	}
	
	/**
	 * The method displays a list of users
	 * 
	 * @param Model model
	 * @return String
	 */
	@RequestMapping("/users")
	public String users(Model model){
		model.addAttribute("users", userService.findAll());
		return "users";
	}
	
	/**
	 * The method displays a user details page for user found by the user id
	 * 
	 * @param Model model
	 * @param int id
	 * @return String
	 */
	@RequestMapping("/users/{id}")
	public String detail(Model model, @PathVariable int id){
		model.addAttribute("user", userService.findById(id));
		return "user-detail";
	}
	
	/**
	 * The method displays a registration form 
	 * 
	 * @return String
	 */
	@RequestMapping("/register")
	public String showUserRegister(){
		return "user-register";
	}
	
	/**
	 * The method is implements of save operation of new user
	 * 
	 * @param User user
	 * @param BindingResult result
	 * @return String
	 */
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String doRegister(@Valid @ModelAttribute("user") User user, BindingResult result) {
		if (result.hasErrors()) {
			return "user-register";
		}
		userService.save(user);
		return "redirect:/register.html?success=true";
	}
	
	/**
	 * The method displays an account page of current user
	 * 
	 * @param Model model
	 * @param Principal principal
	 * @return String
	 */
	@RequestMapping("/account")
	public String account(Model model, Principal principal){
		String login = principal.getName();
		model.addAttribute("user", userService.findByLogin(login));
		return "user-detail";
	}
	
	/**
	 * The method is implements of delete operation of user found by user id
	 * 
	 * @param userId
	 * @return String
	 */
	@RequestMapping("/users/remove/{userId}")
	public String removeAd(@PathVariable int userId){
		userService.delete(userId);
		return "redirect:/users.html";
	}
}
