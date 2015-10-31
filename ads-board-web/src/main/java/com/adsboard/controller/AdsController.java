package com.adsboard.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.adsboard.model.Ad;
import com.adsboard.model.AdFilter;
import com.adsboard.model.Rubric;
import com.adsboard.model.User;
import com.adsboard.service.AdService;
import com.adsboard.service.RubricService;
import com.adsboard.service.UserService;

/**
 * Project <b> Ads board</b>. 
 *
 * This Controller class is used for control of /ads pages
 * Implements the display of of ads lists filtered by criteria
 *
 * @author Oleksandr Lukichov
 * @since October 30, 2015
 */
@Controller
public class AdsController {

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

	@ModelAttribute("adFilter")
	public AdFilter constructAdFilter() {
		return new AdFilter();
	}

	/**
	 * The method for filtering and showing of ads. 
	 * Implements filtering of ads: by like username, by the rubric, all ads, my ads
	 * by the sort criterias adds to the model one of lists of ads objects
	 *  
	 * @param Model model
	 * @param AdFilter adFilterSettings
	 * @param Principal principal
	 * @return String 
	 */
	@RequestMapping(value = "/ads", method = RequestMethod.GET)
	public String ads(Model model, @ModelAttribute("adFilterSettings") AdFilter adFilterSettings, Principal principal) {
		if (model != null && adFilterSettings != null && adFilterSettings.getRubricId() != null) { // Check
																									// RubricId
																									// is
																									// set
			Integer rubricId = adFilterSettings.getRubricId();
			if (rubricId > 0) { // rubricId > 0 - mean what selected one of
								// rubrics

				Rubric rubric = rubricService.findOne(rubricId);
				if (adFilterSettings.getUsername() != null) { // check what
																// username is
																// entered
					String likeName = adFilterSettings.getUsername();
					model.addAttribute("ads", adService.findByLikeUserAndRubric(likeName, rubric));
				} else { // username is not entered (in filter form cheked "Show
							// my ads"
					String login = principal.getName();
					model.addAttribute("ads", adService.findByLoginAndRubric(login, rubric));
					adFilterSettings.setChecked(true);
				}

			} else { // rubricId == 0 - mean what selected all rubrics
				if (adFilterSettings.getUsername() != null) { // check what
					// username is
					// entered
					String likeName = adFilterSettings.getUsername();
					model.addAttribute("ads", adService.findByLikeUser(likeName));
				} else { // username is not entered (in filter form cheked "Show
							// my ads"
					String login = principal.getName();
					User user = userService.findByLogin(login);
					model.addAttribute("ads", adService.findByUser(user));
					adFilterSettings.setChecked(true);
				}
			}

		} else { // if adFilterSettings has a null value (We entered to the ads
					// page at first time)
			model.addAttribute("ads", adService.findAllPagedAndSorted());
		}

		model.addAttribute("rubrics", rubricService.findAll());
		model.addAttribute("adFilter", new AdFilter());
		return "ads";
	}

	/**
	 * The method for the case of first time entering to the ads page 
	 * Add to redirectAttributes an adFilterSettings object
	 * 
	 * @param Model model
	 * @param AdFilter adFilter
	 * @param Principal principal
	 * @param RedirectAttributes redirectAttributes
	 * @return String
	 */
	@RequestMapping(value = "/ads", method = RequestMethod.POST)
	public String adsFilter(Model model, @ModelAttribute("adFilter") AdFilter adFilter, Principal principal,
			RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("adFilterSettings", adFilter);
		return "redirect:/ads.html";
	}

	/**
	 * The method for showing the ad details which found by the ad id
	 * @param Model model
	 * @param int id
	 * @return String
	 */
	@RequestMapping("/ads/{id}")
	public String detail(Model model, @PathVariable int id) {
		model.addAttribute("ad", adService.findById(id));
		return "ad-detail";
	}

	/**
	 * The method for showing a list of ads which found by the user id
	 * @param Model model
	 * @param int userId
	 * @return String
	 */
	@RequestMapping("/ads/user/{userId}")
	public String adsByUser(Model model, @PathVariable int userId) {
		User user = userService.findById(userId);
		model.addAttribute("ads", adService.findByUser(user));

		model.addAttribute("rubrics", rubricService.findAll());
		model.addAttribute("adFilter", new AdFilter());
		return "ads";
	}

	/**
	 * The method for showing a list of ads which found by the rubric id
	 * @param Model model
	 * @param int rubricId
	 * @return String
	 */
	@RequestMapping("/ads/rubric/{rubricId}")
	public String adsByRubric(Model model, @PathVariable int rubricId) {
		model.addAttribute("ads", adService.findByRubricId(rubricId));
		return "ads";
	}
	
}
