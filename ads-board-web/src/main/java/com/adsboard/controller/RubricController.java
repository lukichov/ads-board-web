package com.adsboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adsboard.service.RubricService;

/**
 * Project <b> Ads board</b>. 
 *
 * This Controller class is used for control of /rubrics pages
 *
 * @author Oleksandr Lukichov
 * @since October 30, 2015
 */
@Controller
public class RubricController {

	@Autowired
	private RubricService rubricService;
	
	/**
	 * The method displays a list of all rubrics
	 * @param Model model
	 * @return String
	 */
	@RequestMapping("/rubrics")
	public String rubrics(Model model){
		model.addAttribute("rubrics", rubricService.findAll());
		return "rubrics";
	}
}
