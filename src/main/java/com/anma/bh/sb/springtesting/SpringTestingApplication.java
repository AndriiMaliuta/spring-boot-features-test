package com.anma.bh.sb.springtesting;

import com.anma.bh.sb.springtesting.core.models.Post;
import com.anma.bh.sb.springtesting.files.FileStorageProperties;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@Log
@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class SpringTestingApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringTestingApplication.class, args);
		log.info(">>>>>>>>>>>>>>>>>>> App name = " + context.getApplicationName());
		log.info(">>>>>>>>>>>>>>>>>>> App display name = " + context.getDisplayName());
		log.info(">>>>>>>>>>>>>>>>>>> App ID == " + context.getId());
	}

//	@Bean
//	CommandLineRunner run() {
//		return args -> {
//			Post post = new Post(10, 1, "title 100", "Some body...");
//			log.info("********** Post created! ");
//			log.info(post.toString());
//		};
//	}

//	@Bean
//	public RestTemplate restTemplate(RestTemplateBuilder builder) {
//		return builder.build();
//	}

}
