package pe.com.gmd.react.demoReact.contacto;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import pe.com.gmd.react.demoReact.model.Contacto;
import pe.com.gmd.react.demoReact.service.ContactoService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ContactoTest {

	private static String URL="http://localhost:9080";
		
	@Test
	public void getAllContacts() {
		RestTemplate restTemplate = new RestTemplate();
		String resp = restTemplate.getForObject(URL+"/contacto", String.class);
		System.out.println("LISTA DE CONTAOS : "+ resp);
	}
	
	@Test
	public void createContact() {
		Contacto contacto = new Contacto();
		contacto.setNames("JAVA RUN TEST");
		contacto.setLastnames("prueba");
		contacto.setFono("122");
		contacto.setEmail("test@hotmail.com");
		RestTemplate restTemplate = new RestTemplate();
		Contacto resultado = restTemplate.postForObject(URL+"/saveContacto",contacto, Contacto.class);		
		System.out.println("Contacto creado : "+ resultado);
	}
	
	@Test
	public void getContactID() {
		Map<String, String> param = new HashMap<String,String>();
		param.put("id", "5b450f45fb6fc043c8ceed07");
		RestTemplate restTemplate = new RestTemplate();
		Contacto resultado = restTemplate.getForObject(URL+"/contacto/{id}",Contacto.class,param);		
		System.out.println("Contacto obtenido es : "+ resultado);
	}
	
	@Test
	public void deleteContactID() {
		Map<String, String> param = new HashMap<String,String>();
		param.put("id", "5b452ed946efa41e100ebf71");
		RestTemplate restTemplate = new RestTemplate();		
		restTemplate.delete(URL+"/deleteContacto/{id}",param);		
		System.out.println("Contacto ha sido eliminado ");
	}
	
	
}
