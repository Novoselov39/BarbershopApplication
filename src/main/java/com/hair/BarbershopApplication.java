package com.hair;

import com.hair.model.Haircut;
import com.hair.model.Hairdresser;

import com.hair.model.Customer;
import com.hair.repository.*;
import com.hair.security.Role;
import com.hair.security.User;
import com.hair.security.UserRole;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
public class BarbershopApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(BarbershopApplication.class, args);

		UserRepository userRepository = ctx.getBean(UserRepository.class);
		User admLogin = new User();
		admLogin.setLogin("admin");
		admLogin.setPassword("$2y$10$7kuGIwT31ZtbLiAKj7Tdnuwy1zAYFjmNCFBHPxyco05BmmeXT/xqK");
		User usLogin1 = new User();
		usLogin1.setLogin("customer");
		usLogin1.setPassword("$2y$10$s4IeU/fe2xieJkcATJ8bjeSTbg4mGp1.fNR1qJvAD6dLj26gF0xru");
		User usLogin2 = new User();
		usLogin2.setLogin("hairdresser");
		usLogin2.setPassword("$2y$10$TQRszM94NG23Pj4SbxNgh.8OKmzIvshXU2Zzw6ujx/8fePDboYm/O");
		admLogin = userRepository.save(admLogin);
		usLogin1 = userRepository.save(usLogin1);
		usLogin2 = userRepository.save(usLogin2);


		RoleRepository roleRepository = ctx.getBean(RoleRepository.class);
		Role admRole = new Role();
		admRole.setRole("admin");
		Role customerRole = new Role();
		customerRole.setRole("customer");
		Role hairdresser = new Role();
		hairdresser.setRole("hairdresser");

		admRole = roleRepository.save(admRole);
		customerRole = roleRepository.save(customerRole);
		hairdresser = roleRepository.save(hairdresser);


		UserRoleRepository userRoleRepository = ctx.getBean(UserRoleRepository.class);
		UserRole userRole1 = new UserRole();
		userRole1.setUserId(userRepository.findByLogin("admin").get().getId());
		userRole1.setRoleId(roleRepository.findByRole("admin").get().getId());
		userRole1 = userRoleRepository.save(userRole1);

		UserRole userRole8 = new UserRole();
		userRole8.setUserId(userRepository.findByLogin("hairdresser").get().getId());
		userRole8.setRoleId(roleRepository.findByRole("hairdresser").get().getId());
		userRole8 = userRoleRepository.save(userRole8);

		UserRole userRole10 = new UserRole();
		userRole10.setUserId(userRepository.findByLogin("customer").get().getId());
		userRole10.setRoleId(roleRepository.findByRole("customer").get().getId());
		userRole10 = userRoleRepository.save(userRole10);


		CustomerRepository customerRepository = ctx.getBean(CustomerRepository.class);
		for (int i = 1; i < 12; i++) {
			Customer person = new Customer();
//			LocalDate startExp = LocalDate.now();
			person.setName("customer_" + i);
			person.setPhone(String.valueOf(ThreadLocalRandom.current().nextLong(10000, 99999)));
			customerRepository.save(person);

		}
		HairdresserRepository hairdresserRepository = ctx.getBean(HairdresserRepository.class);
		for (int i = 1; i < 12; i++) {
			Hairdresser person = new Hairdresser();
			person.setName("hairdresser" + i);
			person.setPhone(String.valueOf(ThreadLocalRandom.current().nextLong(10000, 99999)));
			hairdresserRepository.save(person);

		}
		HaircutRepository haircutRepository = ctx.getBean(HaircutRepository.class);
		for (int i = 1; i < 12; i++) {
			Haircut haircut = new Haircut();
			haircut.setCustomerId(ThreadLocalRandom.current().nextLong(1,12));
			haircut.setHairdresserId(ThreadLocalRandom.current().nextLong(1,12));
			Long days = ThreadLocalRandom.current().nextLong(0, 32);
			haircut.setCreatedAt((LocalDate.now().minusDays(days)));
			haircutRepository.save(haircut);

		}




	}

}
