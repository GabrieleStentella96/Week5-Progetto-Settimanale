package com.epicode.dispostivi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.dispostivi.it.security.auth.users.User;
import com.epicode.dispostivi.repository.DispositiviRepository;
import com.epicode.dispostivi.repository.UtentePageableRepository;

@RestController
@RequestMapping("/dispositivi")
public class UserPageableController {

	@Autowired
	DispositiviRepository dispositiviRepository;
	
	@Autowired
	UtentePageableRepository utentePageablerepository;
	

	@GetMapping
	ResponseEntity<Page<User>> trovaTuttPage(Pageable pagebale) {
	return ResponseEntity.ok(utentePageablerepository.findAll(pagebale) );
	}

}
