package com.adsboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import com.adsboard.model.Ad;
import com.adsboard.model.Role;
import com.adsboard.model.Rubric;
import com.adsboard.model.User;
import com.adsboard.repository.AdRepository;
import com.adsboard.repository.RoleRepository;
import com.adsboard.repository.RubricRepository;
import com.adsboard.repository.UserRepository;


/**
 * Project <b> Ads board</b>. 
 *
 * This service is used to initially populate the database with test data
 *
 * @author Oleksandr Lukichov
 * @since October 30, 2015
 */
@Transactional
@Service
public class InitDbService {

	@Autowired
	private AdRepository adRepository;

	@Autowired
	private RubricRepository rubricRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	/**
	 * Method inserts in DB test data
	 *
	 * @return
	 */
	@PostConstruct
	public void init(){

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		List<Role> roles = new ArrayList<Role>();

		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);

		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);

		User userAdmin = new User();
		userAdmin.setEnabled(true);
		userAdmin.setLogin("admin");
		userAdmin.setName("Admin Admin");
		userAdmin.setPassword(encoder.encode("admin"));
		roles.add(roleUser);
		roles.add(roleAdmin);
		userAdmin.setRoles(roles);
		userRepository.save(userAdmin);


		User user1 = new User();
		user1.setEnabled(true);
		user1.setName("User1");
		user1.setLogin("user1");
		user1.setPassword(encoder.encode("123"));
		roles = new ArrayList<Role>();
		roles.add(roleUser);
		user1.setRoles(roles);
		userRepository.save(user1);

		User user2 = new User();
		user2.setEnabled(true);
		user2.setName("User2");
		user2.setLogin("user2");
		user2.setPassword(encoder.encode("123"));
		roles = new ArrayList<Role>();
		roles.add(roleUser);
		user2.setRoles(roles);
		userRepository.save(user2);

		User user3 = new User();
		user3.setEnabled(true);
		user3.setName("User3");
		user3.setLogin("user3");
		user3.setPassword(encoder.encode("123"));
		roles = new ArrayList<Role>();
		roles.add(roleUser);
		user3.setRoles(roles);
		userRepository.save(user3);



		Rubric rubric1 = new Rubric();
		rubric1.setRubricName("Sale");
		rubricRepository.save(rubric1);

		Rubric rubric2 = new Rubric();
		rubric2.setRubricName("Buy");
		rubricRepository.save(rubric2);

		Rubric rubric3 = new Rubric();
		rubric3.setRubricName("Rent");
		rubricRepository.save(rubric3);

		Rubric rubric4 = new Rubric();
		rubric4.setRubricName("Service");
		rubricRepository.save(rubric4);

		Rubric rubric5 = new Rubric();
		rubric5.setRubricName("Dating service");
		rubricRepository.save(rubric5);

		Ad ad1 = new Ad();
		ad1.setAdDate(new Date());
		ad1.setAdHeader("Sale an Iphone");
		ad1.setAdText("Iphone-10. Tel.: (044) 123-12-23");
		ad1.setRubric(rubric1);
		ad1.setUser(user1);
		adRepository.save(ad1);

		Ad ad2 = new Ad();
		ad2.setAdDate(new Date());
		ad2.setAdHeader("Rent a flat");
		ad2.setAdText("Rent an apartment inexpensively in your area. Tel.: (044) 123-12-23");
		ad2.setRubric(rubric3);
		ad2.setUser(user2);
		adRepository.save(ad2);

		Ad ad3 = new Ad();
		ad3.setAdDate(new Date());
		ad3.setAdHeader("Buy a bicycle");
		ad3.setAdText("I'll buy a bicycle cheaply. Tel.: (044) 123-12-23");
		ad3.setRubric(rubric2);
		ad3.setUser(user3);
		adRepository.save(ad3);

		Ad ad4 = new Ad();
		ad4.setAdDate(new Date());
		ad4.setAdHeader("Sale a car");
		ad4.setAdText("I will sell a Mercedes car. Tel.: (044) 123-12-23");
		ad4.setRubric(rubric1);
		ad4.setUser(user2);
		adRepository.save(ad4);

		Ad ad5 = new Ad();
		ad5.setAdDate(new Date());
		ad5.setAdHeader("English Lessons");
		ad5.setAdText("I teach English at home. Tel.: (044) 123-12-23");
		ad5.setRubric(rubric4);
		ad5.setUser(user3);
		adRepository.save(ad5);

		Ad ad6 = new Ad();
		ad6.setAdDate(new Date());
		ad6.setAdHeader("Looking for a girl");
		ad6.setAdText("I am looking for a girl under 25 years old. Tel.: (044) 123-12-23");
		ad6.setRubric(rubric5);
		ad6.setUser(user1);
		adRepository.save(ad6);

		Ad ad7 = new Ad();
		ad7.setAdDate(new Date());
		ad7.setAdHeader("Buy an apartment");
		ad7.setAdText("Buy 1-bedroom apartment in Kiev near the metro. Tel.: (044) 123-12-23");
		ad7.setRubric(rubric2);
		ad7.setUser(user2);
		adRepository.save(ad7);

		Ad ad8 = new Ad();
		ad8.setAdDate(new Date());
		ad8.setAdHeader("Rent 2 bedroom apartment");
		ad8.setAdText("I'll rent a 2-room apartment. Payment and order guarantee. Tel.: (044) 123-12-23");
		ad8.setRubric(rubric3);
		ad8.setUser(user3);
		adRepository.save(ad8);

		Ad ad9 = new Ad();
		ad9.setAdDate(new Date());
		ad9.setAdHeader("Looking for a guy");
		ad9.setAdText("Looking for a guy under 30 years. Tel.: (044) 123-12-23");
		ad9.setRubric(rubric5);
		ad9.setUser(user2);
		adRepository.save(ad9);

		Ad ad10 = new Ad();
		ad10.setAdDate(new Date());
		ad10.setAdHeader("Selling laptop");
		ad10.setAdText("Selling laptop Asus, inexpensive. Tel: (044) 123-12-23");
		ad10.setRubric(rubric1);
		ad10.setUser(user3);
		adRepository.save(ad10);

		Ad ad11 = new Ad();
		ad11.setAdDate(new Date());
		ad11.setAdHeader("Buy a monitor");
		ad11.setAdText("Buy a monitor 19-23 inches. Tel: (044) 123-12-23");
		ad11.setRubric(rubric2);
		ad11.setUser(user2);
		adRepository.save(ad11);
	}
}
