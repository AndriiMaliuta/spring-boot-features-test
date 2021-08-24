package com.anma.bh.sb.springtesting;

import com.anma.bh.sb.springtesting.core.models.Post;
import com.anma.bh.sb.springtesting.files.FileStorageProperties;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@Log
@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties({
		FileStorageProperties.class,
		SpringTestingApplication.Dog.class
})
public class SpringTestingApplication {

	@Value("${cat.name}") String name;

	public static void main(String[] args) {
		SpringApplication.run(SpringTestingApplication.class, args);
	}

	@Bean
	CommandLineRunner run() {
		return args -> {
//			Post post = new Post(10, 1, "title 100", "Some body...");
			log.info("&&&&&&&&&&&&& Cat name is " + name);
			log.info("&&&&&&&&&&&&& Dog name is " + new Dog().name);
		};
	}

//	@Bean
//	public RestTemplate restTemplate(RestTemplateBuilder builder) {
//		return builder.build();
//	}

	@ConfigurationProperties(prefix = "dog")
	class Dog {
		String name = "Sharik";
	}

}
