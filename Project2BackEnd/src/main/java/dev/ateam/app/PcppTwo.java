package dev.ateam.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("dev.ateam.entities")
@ComponentScan("dev.ateam")
@EnableJpaRepositories("dev.ateam.repositories")
public class PcppTwo {

	public static void main(String[] args) {
		SpringApplication.run(PcppTwo.class, args);
	}

}
