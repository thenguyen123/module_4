package com.example.thuc_hanh_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

@SpringBootApplication
public class ThucHanh2Application {

	public static void main(String[] args) {
		SpringApplication.run(ThucHanh2Application.class, args);
	}
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasenames("validation-message");
		return messageSource;
	}
}
