package com.anma.bh.sb.springtesting;

import com.anma.bh.sb.springtesting.files.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class SpringTestingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringTestingApplication.class, args);
	}

}
