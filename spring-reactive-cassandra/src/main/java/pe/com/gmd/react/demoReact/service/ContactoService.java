package pe.com.gmd.react.demoReact.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.gmd.react.demoReact.model.Contacto;
import pe.com.gmd.react.demoReact.repository.ContactoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ContactoService {

	@Autowired
	private ContactoRepository contactoRepository;
	
	public Flux<Contacto> listarAllContacto(){
		return contactoRepository.findAll();
	}
	
	public Mono<Contacto> saveContacto(Contacto contacto){
		return contactoRepository.save(contacto);
	}
	
	public Mono<Contacto> getContactoByID(String id){
		return contactoRepository.findById(id);
	}
	
	public Mono<Void> deleteContactoByID(String id){
		return contactoRepository.deleteById(id);
	}
	
	public Flux<Contacto> findBynames(String names){
		return contactoRepository.findBynames(names);
	}
	
	public Mono<Contacto> findByNameAndLastName(String name,String lastName){
		return contactoRepository.findByNameAndLastName(name,lastName);
	}
}
