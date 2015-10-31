/**
 * 
 */
package com.adsboard.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.adsboard.model.Role;
import com.adsboard.model.User;
import com.adsboard.repository.RoleRepository;

/**
 * @author Oleksandr Lukichov
 *
 */
public class UserServiceTest {

	/**
	 * Test method for {@link com.adsboard.service.UserService#findAll()}.
	 */
	@Test
	public void testFindAll() {
		GenericXmlApplicationContext actx = new GenericXmlApplicationContext();
		actx.load("classpath:applicationContext-core.xml");
		actx.refresh();
		UserService userService = actx.getBean(UserService.class);
		List<User> users = userService.findAll();
		
		assertTrue(4 == users.size());
		actx.close();
	}

	/**
	 * Test method for {@link com.adsboard.service.UserService#findLikeName(java.lang.String)}.
	 */
	@Test
	public void testFindLikeName() {
		GenericXmlApplicationContext actx = new GenericXmlApplicationContext();
		actx.load("classpath:applicationContext-core.xml");
		actx.refresh();
		UserService userService = actx.getBean(UserService.class);
		List<User> users = userService.findLikeName("Er1");
		
		assertEquals("User1", users.get(0).getName());
		actx.close();
	}

	/**
	 * Test method for {@link com.adsboard.service.UserService#findById(int)}.
	 */
	@Test
	public void testFindById() {
		GenericXmlApplicationContext actx = new GenericXmlApplicationContext();
		actx.load("classpath:applicationContext-core.xml");
		actx.refresh();
		UserService userService = actx.getBean(UserService.class);
		User user = userService.findById(3);
		
		assertEquals("User2", user.getName());
		actx.close();
	}

	/**
	 * Test method for {@link com.adsboard.service.UserService#save(com.adsboard.model.User)}.
	 */
	@Test
	public void testSave() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		GenericXmlApplicationContext actx = new GenericXmlApplicationContext();
		actx.load("classpath:applicationContext-core.xml");
		actx.refresh();
		UserService userService = actx.getBean(UserService.class);
		User user = new User();
		user.setEnabled(true);
		user.setName("User5");
		user.setLogin("user5");
		user.setPassword(encoder.encode("12345"));
		
		RoleRepository roleRepository = actx.getBean(RoleRepository.class);
		Role role = roleRepository.findOne(1);
		List<Role> roles = new ArrayList<Role>();
		roles.add(role);
		user.setRoles(roles);
		userService.save(user);
		
		User loadUser = userService.findByLogin("user5");
		
		assertEquals("User5", loadUser.getName());
		actx.close();
		
	}

	/**
	 * Test method for {@link com.adsboard.service.UserService#findByLogin(java.lang.String)}.
	 */
	@Test
	public void testFindByLogin() {
		GenericXmlApplicationContext actx = new GenericXmlApplicationContext();
		actx.load("classpath:applicationContext-core.xml");
		actx.refresh();
		UserService userService = actx.getBean(UserService.class);
		String login = "admin";
		User loadUser = userService.findByLogin(login);
		
		assertEquals(login, loadUser.getLogin());
		actx.close();
	}

	

}
