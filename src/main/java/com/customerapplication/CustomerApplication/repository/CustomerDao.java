package com.customerapplication.CustomerApplication.repository;

import com.customerapplication.CustomerApplication.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDao {

    public static final String HASH_KEY = "Customer";
    @Autowired
    private RedisTemplate template;

    public Customer save(Customer customer){
        template.opsForHash().put(HASH_KEY, customer.getId(), customer);
        return customer;
    }

    public List<Customer> findAll(){
       return template.opsForHash().values(HASH_KEY);
    }

    public Customer findCustomerById(int id){
        return (Customer) template.opsForHash().get(HASH_KEY,id);
    }

    public String deleteCustomer(int id){
        template.opsForHash().delete(HASH_KEY,id);
        return "Customer removed!";
    }
}
