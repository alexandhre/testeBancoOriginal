package com.customerapplication.CustomerApplication;

import com.customerapplication.CustomerApplication.entity.Customer;
import com.customerapplication.CustomerApplication.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/api/customer")
public class CustomerApplication {

	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping
	public Iterable<Customer> list() {
		return customerRepository.findAll();
	}

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

}
