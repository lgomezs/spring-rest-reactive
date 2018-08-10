package pe.com.gmd.react.demoReact.demoReact.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import pe.com.gmd.react.demoReact.model.Contacto;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ContactoServiceClientTest{

	private static String URL="http://localhost:9080/contacto";
	
	@Test
	public void getAllContacts() {
		RestTemplate restTemplate = new RestTemplate();
		String resp = restTemplate.getForObject(URL+"/getContacto", String.class);
		System.out.println("LISTA DE CONTAOS : "+ resp);
	}
	
	
	@Test
	public void createContact() {
		Contacto contacto = new Contacto();
		contacto.setId("0111");
		contacto.setNames("JAVA RUN TEST");
		contacto.setLastnames("prueba");
		contacto.setFono("122");
		contacto.setEmail("test@hotmail.com");
		RestTemplate restTemplate = new RestTemplate();
		Contacto resultado = restTemplate.postForObject(URL+"/saveContacto",contacto, Contacto.class);		
		System.out.println("Contacto creado : "+ resultado);
	}
	
}
