package com.adsboard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.adsboard.model.User;

/**
 * Project <b> Ads board</b>. 
 *
 * This interface is used to manage users using JpaRepository
 *
 * @author Oleksandr Lukichov
 * @since October 30, 2015
 */
public interface UserRepository extends JpaRepository<User, Integer>{

	/**
	 * The method returns the user found by login
	 * @param String login
	 * @return User
	 */
	User findByLogin(String login);
		
	/**
	 * The method returns a list of users with names like this, case ignoring
	 * @param String findName
	 * @return List<User>
	 */
	List<User> findByNameContainingIgnoreCase(String findName); 
}
