package pe.com.gmd.react.demoReact.cassandraConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractReactiveCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories;

@Configuration
@EnableReactiveCassandraRepositories
public class CassandraConfig extends AbstractReactiveCassandraConfiguration {

	@Value("${jsa.cassandra.keyspace-name}")
	String keySpace;

	@Value("${jsa.cassandra.contact-points}")
	String contactPoints;

	public String getKeySpace() {
		return keySpace;
	}

	public void setKeySpace(String keySpace) {
		this.keySpace = keySpace;
	}

	public String getContactPoints() {
		return contactPoints;
	}

	public void setContactPoints(String contactPoints) {
		this.contactPoints = contactPoints;
	}

	@Override
	protected String getKeyspaceName() {
		return keySpace;
	}

}
