package com.adsboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adsboard.model.Rubric;

/**
 * Project <b> Ads board</b>. 
 *
 * This interface is used to manage rubric using JpaRepository
 *
 * @author Oleksandr Lukichov
 * @since October 30, 2015
 */
public interface RubricRepository extends JpaRepository<Rubric, Integer>{

	/**
	 * The method returns the rubric found by rubric name
	 * 
	 * @param String rubricName
	 * @return Rubric
	 */
	Rubric findByRubricName(String rubricName);

}
