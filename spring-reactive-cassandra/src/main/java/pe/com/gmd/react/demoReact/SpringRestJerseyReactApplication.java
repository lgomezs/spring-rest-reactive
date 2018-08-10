package pe.com.gmd.react.demoReact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@EntityScan("pe.com.gmd.react.demoReact.repository")
@ComponentScan("pe.com.gmd.react.demoReact")
@SpringBootApplication
public class SpringRestJerseyReactApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestJerseyReactApplication.class, args);
	}
	
}
