package com.adsboard.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adsboard.model.Rubric;
import com.adsboard.repository.RubricRepository;

/**
 * Project <b> Ads board</b>. 
 *
 * This Service class uses for managing rubrics
 *
 * @author Oleksandr Lukichov
 * @since October 30, 2015
 */
@Transactional
@Service
public class RubricService {

	@Autowired
	private RubricRepository rubricRepository;
	
	/**
	 * Method returns a list of all rubrics	
 	 *
	 * @return List<Rubric>
	 */
	public List<Rubric> findAll(){
		return rubricRepository.findAll();		
	}
	
	/**
	 * Method returns the rubric found by rubricId	
 	 *
	 * @param Rubric rubricId
	 * @return Rubric
	 */
	public Rubric findOne(Integer rubricId){
		return rubricRepository.findOne(rubricId);
	}
}
