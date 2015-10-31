package com.adsboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Project <b> Ads board</b>. 
 *
 * This Controller class is used for control of /login page
 *
 * @author Oleksandr Lukichov
 * @since October 30, 2015
 */
@Controller
public class LoginController {

	/**
	 * The method for showing of login page
	 * @return String
	 */
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}
