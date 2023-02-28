package mx.com.ananda.dormamu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"mx.com.ananda.dormamu.*"})
@EntityScan(basePackages = {"mx.com.ananda.dormamu.*"})
public class DormamuApplication {

	public static void main(String[] args) {
		SpringApplication.run(DormamuApplication.class, args);
	}

}
