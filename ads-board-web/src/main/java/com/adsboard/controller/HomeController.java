package com.adsboard.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adsboard.model.User;
import com.adsboard.service.UserService;

/**
 * Project <b> Ads board</b>. 
 *
 * This Controller class is used for control of home page /index
 *
 * @author Oleksandr Lukichov
 * @since October 30, 2015
 */
@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	
	/**
	 * The method for showing of index page
	 * @param Model model
	 * @param Principal principal
	 * @return String
	 */
	@RequestMapping("/index")
	public String index(Model model, Principal principal) {
		if (principal != null) {
			String login = principal.getName();
			User user = userService.findByLogin(login);
			model.addAttribute("user", user);
		}
		return "index";
	}

}
