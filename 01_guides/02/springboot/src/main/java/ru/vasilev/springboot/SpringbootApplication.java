package ru.vasilev.springboot;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return run -> {
			System.out.println("Let's get all bean definitions");
			String[] beans = ctx.getBeanDefinitionNames();
			Arrays.sort(beans);
			
			for(String bean : beans) {
				System.out.println(bean);
			}
		};
	}
}