package com.sumitaccess007;

import com.sumitaccess007.model.Customer;
import com.sumitaccess007.repository.CustomerRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootAccessDataJpaApplication {

	private static final Logger LOG = LogManager.getLogger(SpringBootAccessDataJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAccessDataJpaApplication.class, args);
		System.out.println("Hello Spring Boot");
	}

	@Bean
	public CommandLineRunner dataAccessDemo(CustomerRepository customerRepository)
	{
		return args -> {
			// Save Few Customers First
			customerRepository.save(new Customer(1,"Sumit", "Sharma", "sumit@gmail.com"));
			customerRepository.save(new Customer(2,"Amit", "Sangwal", "amit@gmail.com"));
			customerRepository.save(new Customer(3,"Mohit", "Verma", "mohit@gmail.com"));
			customerRepository.save(new Customer(4,"Tarun", "Verma", "tarun@gmail.com"));

			// Fetch all the customers
			LOG.info("Find Customers with findAll():-");
			LOG.info("-------------------------------");
			customerRepository.findAll().forEach(customer -> {
				LOG.info(customer.toString());
			});
			LOG.info("");

			// Fetch an individual customer by Id
			LOG.info("Find Customer with findById(3L):-");
			LOG.info("-------------------------------");
			Customer customer = customerRepository.findById(3L);
			LOG.info(customer.toString());
			LOG.info("");

			// Fetch Customer by LastName
			LOG.info("Find Customer by findByLastName(\"Verma\"):-");
			LOG.info("--------------------------------------------");
			customerRepository.findByLastName("Verma").forEach(verma -> {
				LOG.info(verma.toString());
			});
			LOG.info("");
		};
	}

}
