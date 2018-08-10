package pe.com.gmd.react.demoReact.model;

import java.io.Serializable;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;


@Table("contacto")
public class Contacto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PrimaryKey
	private String id;
	@Column
	private String names;
	@Column
	private String lastnames;
	@Column
	private String email;	
	@Column
	private String fono;
	
	

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getLastnames() {
		return lastnames;
	}

	public void setLastnames(String lastnames) {
		this.lastnames = lastnames;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFono() {
		return fono;
	}

	public void setFono(String fono) {
		this.fono = fono;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	

}
