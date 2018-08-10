package pe.com.gmd.react.demoReact.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pe.com.gmd.react.demoReact.model.Contacto;
import pe.com.gmd.react.demoReact.service.ContactoService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ContactoControler {
	
	@Autowired
	private ContactoService contactoService;
	
	
	@GetMapping("/contacto")
	public Flux<Contacto> getAllContact(){		
			return contactoService.listAllContact();			
	}
	
	//para actualizar, crear objetos
	@PostMapping("/saveContacto")
	public Mono<Contacto> saveContacto(@Valid @RequestBody Contacto contacto){
		return contactoService.saveContacto(contacto);		
	}
	
	
	@GetMapping("/contacto/{getID}")
	public Mono<ResponseEntity<Contacto>> getContactoByID(@PathVariable(value="getID") String getID){
		return contactoService.getContactoByID(getID).map(
				saveContacto -> ResponseEntity.ok(saveContacto))
				.defaultIfEmpty(ResponseEntity.notFound().build());	
	}
	

	@DeleteMapping("/deleteContacto/{getID}")
	public Mono<ResponseEntity<Void>> deleteContactoByID(@PathVariable(value="getID") String getID){
		return contactoService.getContactoByID(getID).flatMap(
					existingContacto -> 
						contactoService.deleteContactoByID(getID)
						.then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
				).defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));		
	}	
	
}
