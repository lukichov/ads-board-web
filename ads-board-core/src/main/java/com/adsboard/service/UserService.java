package com.adsboard.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.adsboard.model.Ad;
import com.adsboard.model.Role;
import com.adsboard.model.User;
import com.adsboard.repository.AdRepository;
import com.adsboard.repository.RoleRepository;
import com.adsboard.repository.UserRepository;

/**
 * Project <b> Ads board</b>. 
 *
 * This Service class uses for managing users
 *
 * @author Oleksandr Lukichov
 * @since October 30, 2015
 */
@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private AdRepository adRepository;

	/**
	 * Method returns a list of all users	
 	 *
	 * @return List<User>
	 */
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	/**
	 * Method returns a list of users which names like finding name	
 	 *
	 * @param String name
	 * @return List<User>
	 */
	public List<User> findLikeName(String name) {
		return userRepository.findByNameContainingIgnoreCase(name);
	}

	/**
	 * Method returns the user found by id	
 	 *
	 * @param int id
	 * @return User
	 */
	public User findById(int id) {
		return userRepository.findOne(id);
	}

	/**
	 * Method for saving user in DB
 	 *
	 * @param User user
	 */
	public void save(User user) {
		user.setEnabled(true);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleRepository.findByName("ROLE_USER"));
		user.setRoles(roles);
		userRepository.save(user);
	}

	/**
	 * Method returns the user found by login	
 	 *
	 * @param String login
	 * @return User
	 */
	public User findByLogin(String login) {
		User user = userRepository.findByLogin(login);
		return findById(user.getId());
	}

	/**
	 * Method for deleting user by user id
	 * Only authorized user with role ROLE_ADMIN can delete a user 
 	 *
	 * @param userId
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void delete(int userId) {
		User user = userRepository.findOne(userId);
		List<Ad> ads = adRepository.findByUser(user);
		adRepository.deleteInBatch(ads);
		userRepository.delete(userId);
	}

}
