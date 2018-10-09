package com.anthem.hrsoap.startup;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anthem.hrsoap.config.AppConfig;
import com.anthem.hrsoap.service.DailyDilbertService;

@SpringBootApplication
public class SpringBootStandaloneApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStandaloneApplication.class, args);
	}

	public void run(String... args) throws Exception {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		 
		ctx.register(AppConfig.class);
		ctx.refresh();

		DailyDilbertService dailyDilbertService= (DailyDilbertService)ctx.getBean("dailyDilbertService");
	    dailyDilbertService.getDailyDilbert();	
		
	}

}