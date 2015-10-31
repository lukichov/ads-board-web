/**
 * 
 */
package com.adsboard.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.adsboard.model.Rubric;

/**
 * @author Oleksandr Lukichov
 *
 */
public class RubricServiceTest {

	/**
	 * Test method for {@link com.adsboard.service.RubricService#findAll()}.
	 */
	@Test
	public void testFindAll() {
		GenericXmlApplicationContext actx = new GenericXmlApplicationContext();
		actx.load("classpath:applicationContext-core.xml");
		actx.refresh();
		RubricService rubricService = actx.getBean(RubricService.class);
		List<Rubric> rubrics = rubricService.findAll();
		
		assertTrue(5 == rubrics.size());
		actx.close();
	}

	/**
	 * Test method for {@link com.adsboard.service.RubricService#findOne(java.lang.Integer)}.
	 */
	@Test
	public void testFindOne() {
		GenericXmlApplicationContext actx = new GenericXmlApplicationContext();
		actx.load("classpath:applicationContext-core.xml");
		actx.refresh();
		RubricService rubricService = actx.getBean(RubricService.class);
		Rubric rubric = rubricService.findOne(5);
		
		assertEquals("Знакомства", rubric.getRubricName());
		actx.close();
	}

}
