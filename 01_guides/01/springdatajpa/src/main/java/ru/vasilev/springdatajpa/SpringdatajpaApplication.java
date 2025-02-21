package ru.vasilev.springdatajpa;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ru.vasilev.springdatajpa.model.Customer;
import ru.vasilev.springdatajpa.repository.CustomerRepository;

@SpringBootApplication
public class SpringdatajpaApplication {
	private static final Logger log = LoggerFactory.getLogger(SpringdatajpaApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SpringdatajpaApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		CommandLineRunner runner = (args)->{
			repository.save(new Customer("Sergey", "Vasilev"));
			repository.save(new Customer("Stepan", "Stepanov"));
			repository.save(new Customer("Andrey", "Andreev"));
			repository.save(new Customer("Artyom", "Vasilev"));
			repository.save(new Customer("Ksenya", "Vasileva"));
			repository.save(new Customer("Robert", "Vasilev"));
			repository.save(new Customer("Ivan", "Petrov"));
			repository.save(new Customer("Aleksandr", "Vasilev"));
			repository.save(new Customer("Ekaterina", "Vasileva"));
			repository.save(new Customer("Elena", "Vasileva"));
			repository.save(new Customer("Mikhail", "Mikhaylov"));
			
			log.info("Customers found by findAll()");
			log.info("----------------------------");
			repository.findAll().forEach(customer -> log.info(customer.toString()));
			
			Customer found = repository.findById(1L);
			log.info("Customer found by findById(1L)");
			log.info("------------------------------");
			log.info(found.toString());
			
			List<Customer> vasilev = repository.findByLastName("Vasilev");
			log.info("Customers found by findByLastName(\"Vasilev\")");
			log.info("----------------------------------------------");
			vasilev.forEach(v -> log.info(v.toString()));
		};
		return runner;
	}
}