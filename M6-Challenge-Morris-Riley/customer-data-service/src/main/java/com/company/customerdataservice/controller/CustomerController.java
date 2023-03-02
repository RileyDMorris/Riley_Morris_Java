package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    @Autowired
    CustomerRepository repo;

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        Optional<Customer> returnVal = repo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    @GetMapping("/customers/state/{state}")
    public List<Customer> getCustomerByState(@PathVariable String state) {
        Optional<List<Customer>> returnVal = Optional.ofNullable(repo.findAllCustomerByState(state));
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createCustomer(@RequestBody Customer Customer) {
        return repo.save(Customer);
    }

    @PutMapping("/customers")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@RequestBody Customer Customer) {
        repo.save(Customer);
    }

    @DeleteMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable int id) {
        repo.deleteById(id);
    }
}
