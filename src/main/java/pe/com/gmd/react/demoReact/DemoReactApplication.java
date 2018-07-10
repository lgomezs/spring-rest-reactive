package pe.com.gmd.react.demoReact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import pe.com.gmd.react.demoReact.repository.ContactoRepository;

@EntityScan("pe.com.gmd.react.demoReact.repository")
@ComponentScan("pe.com.gmd.react.demoReact")
@EnableReactiveMongoRepositories(basePackageClasses=ContactoRepository.class)
@SpringBootApplication
public class DemoReactApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoReactApplication.class, args);
	}
}
