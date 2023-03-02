package com.company.customerdataservice.repository;

import com.company.customerdataservice.model.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryTests {

    @Autowired
    CustomerRepository customerRepo;

    @Before
    public void setUp() throws Exception {
        customerRepo.deleteAll();
    }

    @Test
    public void addCustomer() {
        //Arrange...
        Customer customer = new Customer();
        customer.setFirstName("Joe");
        customer.setLastName("Smith");
        customer.setPhone("111-222-3456");
        customer.setCompany("BigCo");
        customer.setEmail("joesmith@gmail.com");
        customer.setAddress1("1 Street");
        customer.setAddress2("Street 1");
        customer.setCity("Chicago");
        customer.setState("Illinois");
        customer.setPostalCode("61820");
        customer.setCountry("United States");

        //Act...
        customer = customerRepo.save(customer);

        //Assert...
        Optional<Customer> customer1 = customerRepo.findById(customer.getId());

        assertEquals(customer1.get(), customer);
    }

    @Test
    public void updateCustomer() {
        //Arrange...
        Customer customer = new Customer();
        customer.setFirstName("Joe");
        customer.setLastName("Smith");
        customer.setPhone("111-222-3456");
        customer.setCompany("BigCo");
        customer.setEmail("joesmith@gmail.com");
        customer.setAddress1("1 Street");
        customer.setAddress2("Street 1");
        customer.setCity("Chicago");
        customer.setState("Illinois");
        customer.setPostalCode("61820");
        customer.setCountry("United States");

        customerRepo.save(customer);

        //Act...
        customer.setFirstName("UPDATED");

        customerRepo.save(customer);

        //Assert...
        Optional<Customer> customer1 = customerRepo.findById(customer.getId());

        assertEquals(customer1.get(), customer);
    }

    @Test
    public void deleteCustomer() {
        //Arrange...
        Customer customer = new Customer();
        customer.setFirstName("Joe");
        customer.setLastName("Smith");
        customer.setPhone("111-222-3456");
        customer.setCompany("BigCo");
        customer.setEmail("joesmith@gmail.com");
        customer.setAddress1("1 Street");
        customer.setAddress2("Street 1");
        customer.setCity("Chicago");
        customer.setState("Illinois");
        customer.setPostalCode("61820");
        customer.setCountry("United States");

        customerRepo.save(customer);

        //Act...
        customerRepo.deleteById(customer.getId());

        //Assert...
        Optional<Customer> customer1 = customerRepo.findById(customer.getId());
        assertFalse(customer1.isPresent());
    }

    @Test
    public void findCustomerById() {
        //Arrange...
        Customer customer = new Customer();
        customer.setFirstName("Joe");
        customer.setLastName("Smith");
        customer.setPhone("111-222-3456");
        customer.setCompany("BigCo");
        customer.setEmail("joesmith@gmail.com");
        customer.setAddress1("1 Street");
        customer.setAddress2("Street 1");
        customer.setCity("Chicago");
        customer.setState("Illinois");
        customer.setPostalCode("61820");
        customer.setCountry("United States");

        customerRepo.save(customer);

        //Act...
        //Assert...
        Optional<Customer> customer1 = customerRepo.findById(customer.getId());

        assertEquals(customer1.get(), customer);

    }

    @Test
    public void findCustomerByState() {
        // Create two customers, one in Illinois and one in Ney York. Make our our method returns a list with only the Illinois person
        Customer c1 = new Customer();
        c1.setFirstName("Joe");
        c1.setLastName("Smith");
        c1.setPhone("111-222-3456");
        c1.setCompany("BigCo");
        c1.setEmail("joesmith@gmail.com");
        c1.setAddress1("1 Street");
        c1.setAddress2("Street 1");
        c1.setCity("Chicago");
        c1.setState("Illinois");
        c1.setPostalCode("61820");
        c1.setCountry("United States");

        Customer c2 = new Customer();
        c2.setFirstName("Joe");
        c2.setLastName("Smith");
        c2.setPhone("111-222-3456");
        c2.setCompany("BigCo");
        c2.setEmail("joesmith@gmail.com");
        c2.setAddress1("1 Street");
        c2.setAddress2("Street 1");
        c2.setCity("Chicago");
        c2.setState("New York");
        c2.setPostalCode("61820");
        c2.setCountry("United States");

        customerRepo.save(c1);
        customerRepo.save(c2);

        //Act...
        List<Customer> testList = new ArrayList<>();
        testList.add(c1);

        //Assert...
        List<Customer> customers1 = customerRepo.findAllCustomerByState(c1.getState());

        assertEquals(customers1, testList);
    }
}
