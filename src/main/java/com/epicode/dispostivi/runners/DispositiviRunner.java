package com.epicode.dispostivi.runners;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.epicode.dispostivi.services.DispositiviService;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Component
@Order(1)
@Slf4j
@AllArgsConstructor
public class DispositiviRunner implements ApplicationRunner {
	

	private DispositiviService dispositiviService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("----------Runner:------------");
		dispositiviService.stampaVideoDispositivi();
		
	}

}
