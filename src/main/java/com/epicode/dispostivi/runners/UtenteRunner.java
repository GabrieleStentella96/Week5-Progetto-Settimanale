package com.epicode.dispostivi.runners;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.epicode.dispostivi.it.security.auth.roles.ERuolo;
import com.epicode.dispostivi.it.security.auth.roles.Ruolo;
import com.epicode.dispostivi.it.security.auth.roles.RuoloRepository;
import com.epicode.dispostivi.it.security.auth.users.User;
import com.epicode.dispostivi.it.security.auth.users.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class UtenteRunner implements ApplicationRunner {

	
	RuoloRepository roleRepository;
	UserRepository userRepository;
	PasswordEncoder encoder;
	

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Ruolo admin = new Ruolo();
		admin.setRoleName( ERuolo.ROLE_ADMIN);
		roleRepository.save(admin);
		
		Ruolo user = new Ruolo();
		user.setRoleName( ERuolo.ROLE_USER);
		roleRepository.save(user);
		
		Set<Ruolo> ruoliAdministrator = new HashSet<Ruolo>();
		ruoliAdministrator.add(admin);
		
		User userAdmin  = new User();
		userAdmin.setUsername("Timoty43");
		userAdmin.setPassword( encoder.encode("aaaaa"));
		userAdmin.setNome("Timmy");
		userAdmin.setEmail("timmyv@gmail.com");
		userAdmin.setCognome("Verde");
		userAdmin.setRoles(ruoliAdministrator);
		userRepository.save(userAdmin);
		
		Set<Ruolo> ruoliUtente = new HashSet<Ruolo>();
		ruoliUtente.add(user);
		
		User simpleUser = new User();
		simpleUser.setUsername("gianluigi67");
		simpleUser.setNome("gianluigi");
		simpleUser.setEmail("gianluigi@gmail.com");
		simpleUser.setCognome("Marrone");
		simpleUser.setPassword( encoder.encode("bbbbb"));
		simpleUser.setRoles(ruoliUtente);
		userRepository.save(simpleUser);
		
		
		
		
		
		
		
		
	}
}
