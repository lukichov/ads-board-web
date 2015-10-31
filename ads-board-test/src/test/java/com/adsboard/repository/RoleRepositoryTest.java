package com.adsboard.repository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.adsboard.model.Role;

public class RoleRepositoryTest {

	@Test
	public void test() {
		GenericXmlApplicationContext actx = new GenericXmlApplicationContext();
		actx.load("classpath:applicationContext-core.xml");
		actx.refresh();
		RoleRepository roleRepository = actx.getBean(RoleRepository.class);
		Role role = roleRepository.findOne(2);
		
		assertEquals("ROLE_ADMIN", role.getName());
		actx.close();
	}

}
