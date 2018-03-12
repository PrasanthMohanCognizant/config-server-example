package com.cloud.example.configserverexample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

public class ConfigServerExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerExampleApplication.class, args);
	}
}

@RestController
@RefreshScope
class MessageRestController{

	@Value("${message: Hello default}")
	private String message;

	@GetMapping("/")
	public String greetings(){
		return this.message;
	}

}
