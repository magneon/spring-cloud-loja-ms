package br.com.softcube.microservices.loja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LojaMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LojaMsApplication.class, args);
	}

}
