package com.devsuperior.uri2602;

import com.devsuperior.uri2602.dtos.CustomerMinDTO;
import com.devsuperior.uri2602.entities.Customer;
import com.devsuperior.uri2602.projections.CustomerNameMinProjection;
import com.devsuperior.uri2602.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2602Application {
	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(Uri2602Application.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void run() {
		List<CustomerNameMinProjection> result = customerRepository.searchByState("RS");
		List<CustomerMinDTO> dtos = result.stream().map(item -> new CustomerMinDTO(item)).collect(Collectors.toList());
		for (CustomerMinDTO customerMinDTO: dtos){
			System.out.println(customerMinDTO.getName());
		}
		System.out.println("acabou!");
	}
}
