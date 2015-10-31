/**
 * 
 */
package com.adsboard.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

import com.adsboard.model.Ad;
import com.adsboard.model.Rubric;
import com.adsboard.model.User;

/**
 * @author Oleksandr Lukichov
 *
 */
public class AdRepositoryTest {

	/**
	 * Test method for
	 * {@link com.adsboard.repository.AdRepository#findByUser(com.adsboard.model.User, org.springframework.data.domain.Pageable)}
	 * .
	 */
	@Test
	public void testFindByUserUserPageable() {
		GenericXmlApplicationContext actx = new GenericXmlApplicationContext();
		actx.load("classpath:applicationContext-core.xml");
		actx.refresh();
		AdRepository adRepository = actx.getBean(AdRepository.class);
		UserRepository userRepository = actx.getBean(UserRepository.class);
		User user = userRepository.findOne(2);
		Pageable pageable = new PageRequest(0, 20, Direction.DESC, "adDate");
		List<Ad> ads = adRepository.findByUser(user, pageable);

		assertTrue(2 == ads.size());

		actx.close();
	}

	/**
	 * Test method for
	 * {@link com.adsboard.repository.AdRepository#findByRubric(com.adsboard.model.Rubric, org.springframework.data.domain.Pageable)}
	 * .
	 */
	@Test
	public void testFindByRubric() {
		GenericXmlApplicationContext actx = new GenericXmlApplicationContext();
		actx.load("classpath:applicationContext-core.xml");
		actx.refresh();
		AdRepository adRepository = actx.getBean(AdRepository.class);
		RubricRepository rubricRepository = actx.getBean(RubricRepository.class);
		Rubric rubric = rubricRepository.findOne(1);
		Pageable pageable = new PageRequest(0, 20, Direction.DESC, "adDate");
		List<Ad> ads = adRepository.findByRubric(rubric, pageable);
		
		assertTrue(3 == ads.size());
		
		actx.close();
	}

	/**
	 * Test method for
	 * {@link com.adsboard.repository.AdRepository#findByUser(com.adsboard.model.User)}
	 * .
	 */
	@Test
	public void testFindByUserUser() {
		GenericXmlApplicationContext actx = new GenericXmlApplicationContext();
		actx.load("classpath:applicationContext-core.xml");
		actx.refresh();
		AdRepository adRepository = actx.getBean(AdRepository.class);
		UserRepository userRepository = actx.getBean(UserRepository.class);
		User user = userRepository.findOne(2);
		List<Ad> ads = adRepository.findByUser(user);

		assertTrue(2 == ads.size());

		actx.close();
	}

	/**
	 * Test method for
	 * {@link com.adsboard.repository.AdRepository#findByUserAndRubric(com.adsboard.model.User, com.adsboard.model.Rubric)}
	 * .
	 */
	@Test
	public void testFindByUserAndRubric() {
		GenericXmlApplicationContext actx = new GenericXmlApplicationContext();
		actx.load("classpath:applicationContext-core.xml");
		actx.refresh();
		AdRepository adRepository = actx.getBean(AdRepository.class);
		UserRepository userRepository = actx.getBean(UserRepository.class);
		User user = userRepository.findOne(2);
		RubricRepository rubricRepository = actx.getBean(RubricRepository.class);
		Rubric rubric = rubricRepository.findOne(1);
		List<Ad> ads = adRepository.findByUserAndRubric(user, rubric);

		assertTrue(1 == ads.size());
		Ad ad = ads.get(0);
		assertEquals("Продам Айфон", ad.getAdHeader());
		
		actx.close();
	}

}
