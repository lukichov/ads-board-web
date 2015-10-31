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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.adsboard.model.Ad;
import com.adsboard.model.User;
import com.adsboard.service.AdService;
import com.adsboard.service.RubricService;
import com.adsboard.service.UserService;

/**
 * Project <b> Ads board</b>. 
 *
 * This Controller class is used for control of /myads pages
 * Implements the display and CRUD operations with ads of user
 *
 * @author Oleksandr Lukichov
 * @since October 30, 2015
 */
@Controller
public class MyAdsController {

	@Autowired
	private AdService adService;

	@Autowired
	private UserService userService;

	@Autowired
	private RubricService rubricService;

	@ModelAttribute("ad")
	public Ad constructAd() {
		return new Ad();
	}

	/**
	 * The method displays a list of all user ads found by the user
	 * 
	 * @param Model model
	 * @param Principal principal
	 * @return String
	 */
	@RequestMapping("/myads")
	public String viewMyAds(Model model, Principal principal) {
		String login = principal.getName();
		User user = userService.findByLogin(login);
		model.addAttribute("ads", adService.findByUser(user));
		model.addAttribute("rubrics", rubricService.findAll());
		return "myads";
	}

	/**
	 * The method is implements save operation of new ad
	 *  
	 * @param Model model
	 * @param Ad ad
	 * @param BindingResult result
	 * @param Principal principal
	 * @return String
	 */
	@RequestMapping(value = "/myads", method = RequestMethod.POST)
	public String doAddAd(Model model, @Valid @ModelAttribute("ad") Ad ad, BindingResult result, Principal principal) {
		if (result.hasErrors()) {
			return viewMyAds(model, principal);
		}
		String login = principal.getName();
		adService.save(ad, login);
		return "redirect:/myads.html";
	}

	/**
	 * The method is implements delete operation of ad found by ad id
	 * @param int adId
	 * @return String
	 */
	@RequestMapping("/myads/remove/{adId}")
	public String removeAd(@PathVariable int adId) {
		Ad ad = adService.findById(adId);
		adService.delete(ad);
		return "redirect:/myads.html";
	}

	/**
	 * The method is displays the edit form for ad found by ad id
	 * 
	 * @param Model model
	 * @param int adId
	 * @return String
	 */
	@RequestMapping("/myads/edit/{adId}")
	public String editAd(Model model, @PathVariable int adId) {
		Ad ad = adService.findById(adId);
		model.addAttribute("ad", ad);
		model.addAttribute("rubrics", rubricService.findAll());
		return "ad-edit";
	}

	/**
	 * The method is implements save operation for edited ad
	 * 
	 * @param Ad ad
	 * @param Principal principal
	 * @param RedirectAttributes redirectAttributes
	 * @return String
	 */
	@RequestMapping(value = "/myads/edit/{adId}", method = RequestMethod.POST)
	public String updateAd(@ModelAttribute("ad") Ad ad, Principal principal, RedirectAttributes redirectAttributes) {
		String login = principal.getName();
		adService.save(ad, login);

		return "redirect:/myads.html";
	}

}
