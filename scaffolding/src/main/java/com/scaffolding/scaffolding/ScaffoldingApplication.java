package com.scaffolding.scaffolding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ScaffoldingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScaffoldingApplication.class, args);
	}

    @Bean
    RestTemplate restTemplate(){  //se ha quitado el "public"
        return new RestTemplate();
    }

}
