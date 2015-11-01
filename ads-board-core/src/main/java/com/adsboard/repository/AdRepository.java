package com.adsboard.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.adsboard.model.Ad;
import com.adsboard.model.Rubric;
import com.adsboard.model.User;

/**
 * Project <b> Ads board</b>. 
 *
 * This interface is used to manage ads using JpaRepository
 *
 * @author Oleksandr Lukichov
 * @since October 30, 2015
 */
public interface AdRepository extends JpaRepository<Ad, Integer>{

	/**
	 * The method returns a list of ads selected by the user, 
	 * and sorted according to the pageble settings 
	 * @param User user
	 * @param Pageable pageable
	 * @return List<Ad>
	 */
	List<Ad> findByUser(User user, Pageable pageable);
	
	/**
	 * The method returns a list of ads selected by the rubric, 
	 * and sorted according to the pageble settings 
	 * @param Rubric rubric
	 * @param Pageable pageable
	 * @return List<Ad>
	 */
	List<Ad> findByRubric(Rubric rubric, Pageable pageable);
	
	/**
	 * The method returns a list of ads selected by the user.
	 * Uses in deleting ads of user
	 * @param User user
	 * @return List<Ad>
	 */
	List<Ad> findByUser(User user);
	
	/**
	 * The method returns a list of ads selected by the user
	 * and by the rubric and sorted according to the pageble settings 
	 * @param User user
	 * @param Rubric rubric
	 * @return List<Ad>
	 */
	List<Ad> findByUserAndRubric(User user, Rubric rubric, Pageable pageable);

	/**
	 * The method returns a list of ads selected by the by the rubric
	 * and by List of users
	 * 
	 * @param User user
	 * @param Rubric rubric
	 * @return List<Ad>
	 */
	List<Ad> findByRubricAndUserIn(Rubric rubric, List<User> users, Pageable pageable);

	/**
	 * The method returns a list of ads selected by the list of users
	 * and by the rubric and sorted according to the pageble settings 
	 * @param User user
	 * @param Rubric rubric
	 * @return List<Ad>
	 */
	List<Ad> findByUserIn(List<User> users, Pageable pageable);
	
	
}
