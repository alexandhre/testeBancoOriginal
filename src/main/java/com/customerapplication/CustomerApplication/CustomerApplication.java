package com.customerapplication.CustomerApplication;

import com.customerapplication.CustomerApplication.entity.Customer;
import com.customerapplication.CustomerApplication.repository.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/customer")
public class CustomerApplication {

	@Autowired
	private CustomerDao customerDao;

	@PostMapping
	public Customer save(@RequestBody Customer customer){
		return customerDao.save(customer);
	}

	@GetMapping
	public List<Customer> getAllCustomers(){
		return customerDao.findAll();
	}

	@GetMapping("/{id}")
	public Customer findCustomer(@PathVariable int id){
		return customerDao.findCustomerById(id);
	}

	@DeleteMapping("/{id}")
	public String remove(@PathVariable int id){
		return customerDao.deleteCustomer(id);
	}
	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

}
