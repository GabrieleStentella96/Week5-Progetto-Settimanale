package com.epicode.dispostivi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.dispostivi.it.security.auth.users.User;
import com.epicode.dispostivi.repository.DispositiviRepository;
import com.epicode.dispostivi.repository.UtenteRepository;
import com.epicode.dispostivi.services.DispositiviService;





@RestController
@RequestMapping("/dispositivi")
public class DispositiviController {

	@Autowired
//	@Qualifier("dispositiviServiceImp")
	private DispositiviService dipositiviService;
	
	@Autowired
	private DispositiviRepository dispositiviRepository;
	
	@Autowired
	private UtenteRepository utenteRepository;
	

//	
//	@PostMapping
//	public ResponseEntity<Libro> creaLibro(@RequestBody Librodto dto) {
//		
//		
//			
//		return new ResponseEntity<Libro>(libroservice.crea(dto), HttpStatus.OK);
//		
//		
//	}
//	
//	@PutMapping("/{id}")
//	public ResponseEntity<String> inserisci(@PathVariable Long id, @RequestBody Librodto dto) {
//		
//	
//			libroservice.modifica(id, dto);
//			
//		return new ResponseEntity<String>("Libro modificato con sucesso", HttpStatus.OK);
//		
//}
//	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<User> trovaById(@PathVariable Long id) { 
		
		
			return ResponseEntity.ok(dipositiviService.trovaperId(id));
		
	}
//	
//	
//	
//	
//	@GetMapping
//	@PreAuthorize("hasRole('ADMIN')")
//	public ResponseEntity<List<Libro>> trovaTutti() { 
//		return ResponseEntity.ok(libroservice.trovaTutti());
//	
//	}
//	
//	@DeleteMapping("/{id}")
//	@PreAuthorize("isAuthenticated()")
//	public ResponseEntity<String> cancella(@PathVariable Long id) { 
//	
//		libroservice.cancella(id);
//		 return ResponseEntity.ok("Libro eliminato");
//	
//		
//		
//	
//	}

}
