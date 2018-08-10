package pe.com.gmd.react.demoReact.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import pe.com.gmd.react.demoReact.model.Contacto;

@Repository
public interface ContactoRepository extends ReactiveMongoRepository<Contacto, String>{

}
