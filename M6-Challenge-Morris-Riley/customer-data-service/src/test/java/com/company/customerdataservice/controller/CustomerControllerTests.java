package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTests {

    @MockBean
    private CustomerRepository customerRepository;

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void shouldReturnACustomerOnPostRequest() throws Exception {
        // ARRANGE
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

        // Convert Java Object to JSON
        String inputJson = mapper.writeValueAsString(customer);

        // ACT
        mockMvc.perform(
                        post("/customers")                            // Perform the POST request
                                .content(inputJson)                       // Set the request body
                                .contentType(MediaType.APPLICATION_JSON)  // Tell the server it's in JSON format
                )
                .andDo(print())
                .andExpect(status().isCreated());     // ASSERT (status code is 200)
    }

    @Test
    public void shouldReturnACustomer() throws Exception {
        // Calling this on the first customer in the database (Clarence Grey)

        // ACT
        mockMvc.perform(get("/customers/1"))                // Perform the GET request
                .andDo(print())                          // Print results to console
                .andExpect(status().isOk());              // ASSERT (status code is 200)
    }

    @Test
    public void shouldReturnACustomerList() throws Exception {
        // Calling this on the first customer in the database (Clarence Grey lives in Indiana)

        // ACT
        mockMvc.perform(get("/customers/state/Indiana"))                // Perform the GET request
                .andDo(print())                          // Print results to console
                .andExpect(status().isOk());              // ASSERT (status code is 200)
    }

    @Test
    public void shouldUpdateById() throws Exception {
        // Giving it a customer and expecting no response
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

        String inputJson = mapper.writeValueAsString(customer);

        // ACT
        mockMvc.perform(
                        put("/customers")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldDeleteById() throws Exception {
        // This method returns nothing, test deleting the first person and returning no content

        // ACT
        mockMvc.perform(delete("/customers/1"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}
