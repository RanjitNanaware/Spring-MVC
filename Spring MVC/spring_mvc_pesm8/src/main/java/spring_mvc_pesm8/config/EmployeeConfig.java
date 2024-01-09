package spring_mvc_pesm8.config;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"spring_mvc_pesm8"})
public class EmployeeConfig {

	@Bean
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("ranjit").createEntityManager();
	}
	
}
