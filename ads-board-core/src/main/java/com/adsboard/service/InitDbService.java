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
		rubric1.setRubricName("Продажа");
		rubricRepository.save(rubric1);
		
		Rubric rubric2 = new Rubric();
		rubric2.setRubricName("Покупка");
		rubricRepository.save(rubric2);
		
		Rubric rubric3 = new Rubric();
		rubric3.setRubricName("Аренда");
		rubricRepository.save(rubric3);
		
		Rubric rubric4 = new Rubric();
		rubric4.setRubricName("Услуги");
		rubricRepository.save(rubric4);
		
		Rubric rubric5 = new Rubric();
		rubric5.setRubricName("Знакомства");
		rubricRepository.save(rubric5);
		
		Ad ad1 = new Ad();
		ad1.setAdDate(new Date());
		ad1.setAdHeader("Продам Айфон");
		ad1.setAdText("Продам Айфон-10. Тел.: (044) 123-12-23");
		ad1.setRubric(rubric1);
		ad1.setUser(user1);
		adRepository.save(ad1);
		
		Ad ad2 = new Ad();
		ad2.setAdDate(new Date());
		ad2.setAdHeader("Сдам квартиру");
		ad2.setAdText("Сдам квартиру недорого в вашем районе. Тел.: (044) 123-12-23");
		ad2.setRubric(rubric3);
		ad2.setUser(user2);
		adRepository.save(ad2);
		
		Ad ad3 = new Ad();
		ad3.setAdDate(new Date());
		ad3.setAdHeader("Куплю велосипед");
		ad3.setAdText("Куплю велосипед недорого. Тел.: (044) 123-12-23");
		ad3.setRubric(rubric2);
		ad3.setUser(user3);
		adRepository.save(ad3);
		
		Ad ad4 = new Ad();
		ad4.setAdDate(new Date());
		ad4.setAdHeader("Продам автомобиль");
		ad4.setAdText("Продам автомобиль Мерседес. Тел.: (044) 123-12-23");
		ad4.setRubric(rubric1);
		ad4.setUser(user2);
		adRepository.save(ad4);
		
		Ad ad5 = new Ad();
		ad5.setAdDate(new Date());
		ad5.setAdHeader("Уроки английского");
		ad5.setAdText("Обучаю английскому языку у Вас на дому. Тел.: (044) 123-12-23");
		ad5.setRubric(rubric4);
		ad5.setUser(user3);
		adRepository.save(ad5);
		
		Ad ad6 = new Ad();
		ad6.setAdDate(new Date());
		ad6.setAdHeader("Познакомлюсь с девушкой");
		ad6.setAdText("Познакомлюсь с девушкой до 25 лет. Тел.: (044) 123-12-23");
		ad6.setRubric(rubric5);
		ad6.setUser(user1);
		adRepository.save(ad6);
		
		Ad ad7 = new Ad();
		ad7.setAdDate(new Date());
		ad7.setAdHeader("Куплю квартиру");
		ad7.setAdText("Куплю 1к квартиру в Киеве возле метро. Тел.: (044) 123-12-23");
		ad7.setRubric(rubric2);
		ad7.setUser(user2);
		adRepository.save(ad7);
		
		Ad ad8 = new Ad();
		ad8.setAdDate(new Date());
		ad8.setAdHeader("Сниму 2к квартиру");
		ad8.setAdText("Сниму 2-к квартиру. Оплату и порядок гарантирую. Тел.: (044) 123-12-23");
		ad8.setRubric(rubric3);
		ad8.setUser(user3);
		adRepository.save(ad8);
		
		Ad ad9 = new Ad();
		ad9.setAdDate(new Date());
		ad9.setAdHeader("Познакомлюсь с парнем");
		ad9.setAdText("Познакомлюсь с парнем до 30 лет. Тел.: (044) 123-12-23");
		ad9.setRubric(rubric5);
		ad9.setUser(user2);
		adRepository.save(ad9);
		
		Ad ad10 = new Ad();
		ad10.setAdDate(new Date());
		ad10.setAdHeader("Продам ноутбук");
		ad10.setAdText("Продам ноутбук Asus, недорого. Тел.: (044) 123-12-23");
		ad10.setRubric(rubric1);
		ad10.setUser(user3);
		adRepository.save(ad10);
		
		Ad ad11 = new Ad();
		ad11.setAdDate(new Date());
		ad11.setAdHeader("Куплю монитор");
		ad11.setAdText("Куплю монитор 19-23 дюйма. Тел.: (044) 123-12-23");
		ad11.setRubric(rubric2);
		ad11.setUser(user2);
		adRepository.save(ad11);
	}
}
