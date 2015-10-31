/**
 * 
 */
package com.adsboard.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.adsboard.model.User;

/**
 * @author Oleksandr Lukichov
 *
 */
public class UserRepositoryTest {

	/**
	 * Test method for
	 * {@link com.adsboard.repository.UserRepository#findByLogin(java.lang.String)}
	 * .
	 */
	@Test
	public void testFindByLogin() {
		GenericXmlApplicationContext actx = new GenericXmlApplicationContext();
		actx.load("classpath:applicationContext-core.xml");
		actx.refresh();
		UserRepository userRepository = actx.getBean(UserRepository.class);
		User user = userRepository.findByLogin("admin");

		assertEquals("admin", user.getLogin());

		actx.close();
	}

	/**
	 * Test method for
	 * {@link com.adsboard.repository.UserRepository#findByNameContainingIgnoreCase(java.lang.String)}
	 * .
	 */
	@Test
	public void testFindByNameContainingIgnoreCase() {
		GenericXmlApplicationContext actx = new GenericXmlApplicationContext();
		actx.load("classpath:applicationContext-core.xml");
		actx.refresh();
		UserRepository userRepository = actx.getBean(UserRepository.class);
		List<User> users = userRepository.findByNameContainingIgnoreCase("SeR1");

		assertEquals("user1", users.get(0).getLogin());

		actx.close();
	}

}
