package pe.com.gmd.react.demoReact.repository;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

import pe.com.gmd.react.demoReact.model.Contacto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ContactoRepository extends ReactiveCassandraRepository<Contacto, String>{

	Flux<Contacto> findBynames(String names);
	
	@Query("select * from contacto where names=?0 and lastnames=?1")
	Mono<Contacto> findByNameAndLastName(String name,String lastName);
}
