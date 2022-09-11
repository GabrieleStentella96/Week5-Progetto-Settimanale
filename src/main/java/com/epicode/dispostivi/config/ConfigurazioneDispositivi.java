package com.epicode.dispostivi.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.dispostivi.entity.Dispositivi;
import com.epicode.dispostivi.entity.DispositivoLaptop;
import com.epicode.dispostivi.entity.DispositivoSmartphone;
import com.epicode.dispostivi.entity.DispositivoTablet;
import com.epicode.dispostivi.entity.TipoStato;
import com.epicode.dispostivi.it.security.auth.users.User;
import com.epicode.dispostivi.repository.DispositiviRepository;
import com.epicode.dispostivi.repository.UtenteRepository;
import com.epicode.dispostivi.services.DispositiviService;






@Configuration
public class ConfigurazioneDispositivi {
	
//	@Autowired
//	private DispositiviService  dispositiviServiceImp;

	@Autowired
	private UtenteRepository repoUtente;

	@Autowired
	private DispositiviRepository repoDispositivi;
	
	
	@Autowired
	ObjectProvider<DispositivoTablet> tabletProvider;
	
	@Autowired
	ObjectProvider<DispositivoSmartphone> smartPhoneProvider;
	
	@Autowired
	ObjectProvider<DispositivoLaptop> laptopProvider;
	
	@Bean("laptop")
	@Scope("prototype")
	public DispositivoLaptop nuovaLaptop() {
		
		return new DispositivoLaptop();
		
	}
	@Bean("smartphone")
	@Scope("prototype")
public DispositivoSmartphone nuovaSmartPhone() {
		
		return new DispositivoSmartphone();
		
	}
	@Bean("tablet")
	@Scope("prototype")
public DispositivoTablet nuovaTablet() {
	
	return new DispositivoTablet();
	
}
	
	
//	
//	@Bean("dispositiviSmartPhone")
//	@Scope("prototype")
//	public SmartPhone nuovaSmartPhone() {
//		return new SmartPhone();
//	}
//	
//	@Bean("dispositiviLaptop")
//	@Scope("prototype")
//	public Laptop nuovaLaptop() {
//		return new Laptop();
//	}
//	
//	@Bean("dispositiviTablet")
//	@Scope("prototype")
//	public Tablet nuovaTablet() {
//		return new Tablet();
//	}
	
	@Bean("dispositivi")
	public User utente1Dispositivi() {
		
	
		DispositivoLaptop dispositivo1 = laptopProvider.getObject();
		dispositivo1.setSchermo(12);
		dispositivo1.setTipoStato(TipoStato.DISPONSIBILE);
		dispositivo1.setMarca("Apple");
		dispositivo1.setOperatingSystem("IOS");
		repoDispositivi.save(dispositivo1);
		
		DispositivoTablet dispositivo2 = tabletProvider.getObject();
		dispositivo2.setSchermo(14);
		dispositivo2.setTipoStato(TipoStato.ASSENGATO);
		dispositivo2.setMarca("Apple");
		dispositivo2.setWithKeyboard(true);
		repoDispositivi.save(dispositivo2);
		
List<Dispositivi> dispositivi = new ArrayList<Dispositivi>();
		
	dispositivi.add(dispositivo1);
	dispositivi.add(dispositivo2);

		
		User utente = User.builder()
				
				.nome("Jim")
				.cognome("Bean")
				.password("111111")
				.username("jeanbean89")
				.email("jeanbean89@gmail.com")
				.dispositivi(dispositivi)
				.build();
		repoUtente.save(utente);
		return utente;
		
	}
	
	@Bean("dispositivi2")
	public User utente2Dispositivi() {
		
	
		DispositivoLaptop dispositivo1 = (DispositivoLaptop) laptopProvider.getObject();
		dispositivo1.setSchermo(12);
		dispositivo1.setTipoStato(TipoStato.DISPONSIBILE);
		dispositivo1.setMarca("Apple");
		dispositivo1.setOperatingSystem("IOS");
		repoDispositivi.save(dispositivo1);
		
		DispositivoTablet dispositivo2 = (DispositivoTablet) tabletProvider.getObject();
		dispositivo2.setSchermo(14);
		dispositivo2.setTipoStato(TipoStato.ASSENGATO);
		dispositivo2.setMarca("Apple");
		dispositivo2.setWithKeyboard(true);
		repoDispositivi.save(dispositivo2);
		
		DispositivoSmartphone dispositivo3 = (DispositivoSmartphone) smartPhoneProvider.getObject();
		dispositivo3.setSchermo(12);
		dispositivo3.setTipoStato(TipoStato.IN_MANUTENZIONE);
		dispositivo3.setMarca("Samsung");
		dispositivo3.setNummero("086666854721");
		repoDispositivi.save(dispositivo3);
		
List<Dispositivi> dispositivi = new ArrayList<Dispositivi>();
		
	dispositivi.add(dispositivo1);
	dispositivi.add(dispositivo2);
	dispositivi.add(dispositivo3);

		
		User utente = User.builder()
				
				.nome("Mary")
				.username("mmac")
				.email("mmac@yahoo.com")
				.cognome("McGuinness")
				.password("22222")
				.dispositivi(dispositivi)
				.build();
		repoUtente.save(utente);
		return utente;
		
	}
	
	@Bean("dispositivi3")
	public User utente3Dispositivi() {
		
	
		DispositivoSmartphone dispositivo1 = (DispositivoSmartphone) smartPhoneProvider.getObject();
		dispositivo1.setSchermo(12);
		dispositivo1.setTipoStato(TipoStato.IN_MANUTENZIONE);
		dispositivo1.setMarca("Apple");
		dispositivo1.setNummero("08765678721");
		repoDispositivi.save(dispositivo1);
		
		
		
List<Dispositivi> dispositivi = new ArrayList<Dispositivi>();
		
	dispositivi.add(dispositivo1);


		
	User utente = User.builder()
			
			.nome("Owen")
			.username("oh67")
			.email("oh67@yahoo.com")
			.cognome("Hughes")
			.password("5555555")
			.dispositivi(dispositivi)
			.build();
	repoUtente.save(utente);
	return utente;
		
	}
	
	
//	@Bean("dispositiviServiceImp")
//	public DispositiviService dispositivi() {
//		return dispositiviServiceImp;
//	}
}
