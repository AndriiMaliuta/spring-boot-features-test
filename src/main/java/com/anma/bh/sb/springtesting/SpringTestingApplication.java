package com.anma.bh.sb.springtesting;

import com.anma.bh.sb.springtesting.core.props.TestProps;
import com.anma.bh.sb.springtesting.files.FileStorageProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableJpaRepositories
@EnableConfigurationProperties({
		FileStorageProperties.class,
		TestProps.class
})
public class SpringTestingApplication {
	private final Logger LOG = LoggerFactory.getLogger(SpringTestingApplication.class);

	@Value("${cat.name}")
	String name;

	public static void main(String[] args) {

		SpringApplication.run(SpringTestingApplication.class, args);

//		SpringApplication app = new SpringApplication(SpringTestingApplication.class);
//		app.setBannerMode(Banner.Mode.CONSOLE);
//		app.run(args);
//		ApplicationContext applicationContext = ApplicationContextFactory.DEFAULT.create(...).getParent();

	}

	@Bean
	CommandLineRunner run() {
		return args -> {
			LOG.info("&&&&&&&&&&&&& Cat name is " + name);
		};
	}

//	@Bean
//	public RestTemplate restTemplate(RestTemplateBuilder builder) {
//		return builder.build();
//	}

}
