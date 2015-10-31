package com.adsboard.repository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.adsboard.model.Rubric;

public class RubricRepositoryTest {

	@Test
	public void testFindByRubricName() {
		GenericXmlApplicationContext actx = new GenericXmlApplicationContext();
		actx.load("classpath:applicationContext-core.xml");
		actx.refresh();
		RubricRepository rubricRepository = actx.getBean(RubricRepository.class);
		Rubric rubric = rubricRepository.findOne(2);
		
		assertEquals("Покупка", rubric.getRubricName());
		actx.close();
	}

}
