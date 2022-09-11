package com.epicode.dispostivi.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.dispostivi.entity.Dispositivi;
import com.epicode.dispostivi.entity.DispositivoLaptop;
import com.epicode.dispostivi.entity.DispositivoSmartphone;
import com.epicode.dispostivi.entity.DispositivoTablet;
import com.epicode.dispostivi.it.security.auth.users.User;
import com.epicode.dispostivi.repository.DispositiviRepository;
import com.epicode.dispostivi.repository.UtenteRepository;


import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DispositiviService {
	
	@Autowired
	DispositiviRepository dispositiviRepository;
	
	@Autowired
	UtenteRepository utenteRepository;
	
	@Autowired
	@Qualifier("smartphone")
	private DispositivoSmartphone smartphone;
	
	@Autowired
	@Qualifier("laptop")
	private DispositivoLaptop laptop;
	
	@Autowired
	@Qualifier("tablet")
	private DispositivoTablet tablet;
	
	
	@Autowired
	@Qualifier("dispositivi")
	private User dispositivi;
	
	@Autowired
	@Qualifier("dispositivi2")
	private User dispositivi2;
	
	@Autowired
	@Qualifier("dispositivi3")
	private User dispositivi3;
	
	
	public User creaDispositivi() {
		return dispositivi;
	}
	
	public User creaDispositivi2() {
		return dispositivi2;
	}
	
	public User creaDispositivi3() {
		return dispositivi3;
	}
	
//	@Autowired
//	@Qualifier("dispositiviSmartPhone")
//	private SmartPhone dispositiviSmartPhone;
//	
//	@Autowired
//	@Qualifier("dispositiviTablet")
//	private Tablet dispositiviTablet;
//	
//	@Autowired
//	@Qualifier("dispositiviLaptop")
//	private Laptop dispositiviLaptop;
	
	

	public User trovaperId(Long id) {
//		if(!libroRepository.existsById(id)) {
//			throw new EntityNotFoundException("Libro non trovato");
//		}
		return utenteRepository.findById(id).get();
	}
	


	
	public void stampaVideoDispositivi() {
		User utente1dispositivi = creaDispositivi();
		log.info("-----Dispositivi delle Utente 1-----------");
		log.info("Dispositivi *" +utente1dispositivi.toString());
		
		log.info("-------------------------------");
		
		
		User utente2dispositivi  = creaDispositivi2();
		log.info("-----Dispositivi delle Utente 2-----------");
		log.info("Dispositivi *" +utente2dispositivi.toString());
		
		log.info("-------------------------------");
		
		User utente3dispositivi = creaDispositivi3();
		log.info("-----Dispositivi delle Utente 2-----------");
		log.info("Dispositivi *" +utente3dispositivi.toString());
		
		log.info("-------------------------------");
	}
	


}
