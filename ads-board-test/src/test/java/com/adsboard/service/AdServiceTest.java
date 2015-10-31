/**
 * 
 */
package com.adsboard.service;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.adsboard.model.Ad;
import com.adsboard.model.Rubric;
import com.adsboard.model.User;

/**
 * @author Oleksandr Lukichov
 *
 */
public class AdServiceTest {

	/**
	 * Test method for {@link com.adsboard.service.AdService#findAll()}.
	 */
	@Test
	public void testFindAll() {
		GenericXmlApplicationContext actx = new GenericXmlApplicationContext();
		actx.load("classpath:applicationContext-core.xml");
		actx.refresh();
		AdService adService = actx.getBean(AdService.class);
		List<Ad> ads = adService.findAll();

		assertTrue(11 == ads.size());

		actx.close();
	}

	/**
	 * Test method for
	 * {@link com.adsboard.service.AdService#findAllPagedAndSorted()}.
	 */
	@Test
	public void testFindAllPagedAndSorted() {
		GenericXmlApplicationContext actx = new GenericXmlApplicationContext();
		actx.load("classpath:applicationContext-core.xml");
		actx.refresh();
		AdService adService = actx.getBean(AdService.class);
		List<Ad> ads = adService.findAllPagedAndSorted();

		assertTrue(11 == ads.size());

		actx.close();
	}

	/**
	 * Test method for {@link com.adsboard.service.AdService#findById(int)}.
	 */
	@Test
	public void testFindById() {
		GenericXmlApplicationContext actx = new GenericXmlApplicationContext();
		actx.load("classpath:applicationContext-core.xml");
		actx.refresh();
		AdService adService = actx.getBean(AdService.class);
		Ad ad = adService.findById(1);

		assertEquals("Продам Айфон", ad.getAdHeader());

		actx.close();
	}

	/**
	 * Test method for
	 * {@link com.adsboard.service.AdService#findByUser(com.adsboard.model.User)}
	 * .
	 */
	@Test
	public void testFindByUser() {
		GenericXmlApplicationContext actx = new GenericXmlApplicationContext();
		actx.load("classpath:applicationContext-core.xml");
		actx.refresh();
		AdService adService = actx.getBean(AdService.class);
		UserService userService = actx.getBean(UserService.class);
		User user = userService.findByLogin("user2");
		List<Ad> ads = adService.findByUser(user);

		assertTrue(5 == ads.size());
		actx.close();
	}

	/**
	 * Test method for
	 * {@link com.adsboard.service.AdService#save(com.adsboard.model.Ad, java.lang.String)}
	 * .
	 */
	@Test
	public void testSave() {
		GenericXmlApplicationContext actx = new GenericXmlApplicationContext();
		actx.load("classpath:applicationContext-core.xml");
		actx.refresh();
		AdService adService = actx.getBean(AdService.class);
		String login = "user1";

		Ad ad = adService.findById(1);
		ad.setAdDate(new Date());
		ad.setAdHeader("Test test test test");
		ad.setAdText("Test test test test Test test test test Test test test test");
		ad.setRubricId(1);
		adService.save(ad, login);

		Ad loadAd = adService.findById(1);

		assertEquals("Test test test test", loadAd.getAdHeader());
		assertEquals(login, loadAd.getUser().getLogin());

		actx.close();
	}

	/**
	 * Test method for
	 * {@link com.adsboard.service.AdService#delete(com.adsboard.model.Ad)}.
	 */
	@Ignore // problem to check by spring security
	@Test
	public void testDelete() {
		GenericXmlApplicationContext actx = new GenericXmlApplicationContext();
		actx.load("classpath:applicationContext-core.xml");
		actx.refresh();
		AdService adService = actx.getBean(AdService.class);
		Ad ad = adService.findById(1);

		adService.delete(ad);
		List<Ad> ads = adService.findAll();

		assertTrue(10 == ads.size());

		actx.close();
	}

	/**
	 * Test method for
	 * {@link com.adsboard.service.AdService#findByRubricId(int)}.
	 */
	@Test
	public void testFindByRubricId() {
		GenericXmlApplicationContext actx = new GenericXmlApplicationContext();
		actx.load("classpath:applicationContext-core.xml");
		actx.refresh();
		AdService adService = actx.getBean(AdService.class);
		List<Ad> ads = adService.findByRubricId(2);

		assertTrue(3 == ads.size());
		actx.close();

	}

	/**
	 * Test method for
	 * {@link com.adsboard.service.AdService#findByLikeUserAndRubric(java.lang.String, com.adsboard.model.Rubric)}
	 * .
	 */
	@Test
	public void testFindByLikeUserAndRubric() {
		GenericXmlApplicationContext actx = new GenericXmlApplicationContext();
		actx.load("classpath:applicationContext-core.xml");
		actx.refresh();
		RubricService rubricService = actx.getBean(RubricService.class);
		AdService adService = actx.getBean(AdService.class);
		Rubric rubric = rubricService.findOne(2);
		String findName = "SeR2";
		List<Ad> ads = adService.findByLikeUserAndRubric(findName, rubric);

		assertTrue(2 == ads.size());
		actx.close();
	}

	/**
	 * Test method for
	 * {@link com.adsboard.service.AdService#findByLikeUser(java.lang.String)}
	 * .
	 */
	@Test
	public void testFindByLikeUser() {
		GenericXmlApplicationContext actx = new GenericXmlApplicationContext();
		actx.load("classpath:applicationContext-core.xml");
		actx.refresh();
		AdService adService = actx.getBean(AdService.class);
		String findName = "eR3";
		List<Ad> ads = adService.findByLikeUser(findName);
		
		assertTrue(4 == ads.size());
		actx.close();
	}

	/**
	 * Test method for
	 * {@link com.adsboard.service.AdService#findByLoginAndRubric(java.lang.String, com.adsboard.model.Rubric)}
	 * .
	 */
	@Test
	public void testFindByLoginAndRubric() {
		GenericXmlApplicationContext actx = new GenericXmlApplicationContext();
		actx.load("classpath:applicationContext-core.xml");
		actx.refresh();
		RubricService rubricService = actx.getBean(RubricService.class);
		AdService adService = actx.getBean(AdService.class);
		Rubric rubric = rubricService.findOne(1);
		String login = "user1";
		List<Ad> ads = adService.findByLikeUserAndRubric(login, rubric);

		assertTrue(1 == ads.size());
		actx.close();
	}

}
