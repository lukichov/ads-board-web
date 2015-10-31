package com.adsboard.service;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.adsboard.model.Ad;
import com.adsboard.model.Rubric;
import com.adsboard.model.User;
import com.adsboard.repository.AdRepository;
import com.adsboard.repository.RubricRepository;
import com.adsboard.repository.UserRepository;

/**
 * Project <b> Ads board</b>. 
 *
 * This Service class uses for managing ads
 *
 * @author Oleksandr Lukichov
 * @since October 30, 2015
 */
@Transactional
@Service
public class AdService {

	@Autowired
	private AdRepository adRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;

	@Autowired
	private RubricRepository rubricRepository;

	/**
	 * The method returns a list of all ads	
 	 * 
	 * @return List<Ad>
	 */
	public List<Ad> findAll() {
		return adRepository.findAll();
	}

	/**
	 * The method returns a list of all ads in sorted by adDate order
 	 * 
	 * @return List<Ad>
	 */
	public List<Ad> findAllPagedAndSorted() {
		return adRepository.findAll(new PageRequest(0, 20, Direction.DESC, "adDate")).getContent();
	}

	/**
	 * The method returns the ad found by id
 	 * 
	 * @param int id
	 * @return Ad
	 */
	public Ad findById(int id) {
		return adRepository.findOne(id);
	}

	/**
	 * The method returns a list of ads selected by the user,
	 * in sorted by adDate order
 	 *
	 * @param User user
	 * @return List<Ad>
	 */
	public List<Ad> findByUser(User user) {
		return adRepository.findByUser(user, new PageRequest(0, 20, Direction.DESC, "adDate"));
	}

	
	/**
	 * Method for saving edited ad by user login (current user) 
	 * 
	 * @param Ad ad
	 * @param String login
	 */
	public void save(Ad ad, String login) {
		User user = userRepository.findByLogin(login);
		ad.setUser(user);
		ad.setAdDate(new Date());
		Rubric rubric = rubricRepository.findOne(ad.getRubricId());
		ad.setRubric(rubric);
		adRepository.saveAndFlush(ad);
	}

	/**
	 * Method for deleting the ad. 
 	 * User can delete only its ads, 
 	 * or any ads if user has role ROLE_ADMIN
 	 * 
	 * @param Ad ad
	 */
	@PreAuthorize("#ad.user.login == authentication.name or hasRole('ROLE_ADMIN')")
	public void delete(Ad ad) {
		adRepository.delete(ad);
	}

	/**
	 * Method for finding ads by rubricId 
	 *
	 * @param int rubricId
	 * @return List<Ad>
	 */
	public List<Ad> findByRubricId(int rubricId) {
		Rubric rubric = rubricRepository.findOne(rubricId);
		return adRepository.findByRubric(rubric, new PageRequest(0, 20, Direction.DESC, "adDate"));
		
	}
	
	/**
	 * Method for finding ads in which the username like likeName
	 * and by rubric 
	 *
	 * @param String likeName
	 * @param Rubric rubric
	 * @return List<Ad>
	 */
	public List<Ad> findByLikeUserAndRubric(String likeName, Rubric rubric) {
		List<User> users = userService.findLikeName(likeName);
		List<Ad> allAds = new LinkedList<Ad>();
		for (User user : users) {
			allAds.addAll(adRepository.findByUserAndRubric(user, rubric));
		}
		Collections.sort(allAds);
		return allAds;
	}

	/**
	 * Method for finding ads by user name like likeName
	 *
	 * @param String likeName
	 * @return List<Ad>
	 */
	public List<Ad> findByLikeUser(String likeName) {
		List<User> users = userService.findLikeName(likeName);
		List<Ad> allAds = new LinkedList<Ad>();
		for (User user : users) {
			allAds.addAll(adRepository.findByUser(user));
		}
		Collections.sort(allAds);
		return allAds;
	}

	/**
	 * Method for finding ads by login and by rubric
	 *
	 * @param String login
	 * @param Rubric rubric
	 * @return List<Ad>
	 */
	public List<Ad> findByLoginAndRubric(String login, Rubric rubric) {
		User user = userService.findByLogin(login);
		List<Ad> allAds = new LinkedList<Ad>();
		allAds.addAll(adRepository.findByUserAndRubric(user, rubric));
		Collections.sort(allAds);
		return allAds;
	}

}
