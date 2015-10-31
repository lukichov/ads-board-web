package com.adsboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adsboard.model.Role;

/**
 * Project <b> Ads board</b>. 
 *
 * This interface is used to manage roles using JpaRepository
 *
 * @author Oleksandr Lukichov
 * @since October 30, 2015
 */
public interface RoleRepository extends JpaRepository<Role, Integer>{

	/**
	 * The method returns the role found by name
	 * 
	 * @param String name
	 * @return Role
	 */
	Role findByName(String name);

}
