package com.social.media;

import com.social.media.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.social.media")
public class MediaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediaApplication.class, args);
	}

}
