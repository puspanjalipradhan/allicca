package com.example.Allicca.contoller;

import com.example.Allicca.controller.CustomerController;
import com.example.Allicca.model.Cache;
import com.example.Allicca.model.Customer;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

    @Mock
    Cache cache;

    @InjectMocks
    CustomerController customerController;

    @Test
    public void shouldReturnCustomerDetails(){
        //Given
        Customer customer=createCustomerInfo();
        //When
        ResponseEntity entity= customerController.customerDetail(customer);

         assertEquals(201, entity.getStatusCode().value());

    }
    @Test
    public void shouldFetchCustomer(){

        //given
        long id = 1;
        when(cache.containsCustomer(any())).thenReturn(true);
        when(cache.getCustomer(any())).thenReturn(createCustomerInfo());

        //when
        ResponseEntity entity= customerController.fetchCustomer(id);

        assertEquals(201, entity.getStatusCode().value());

    }

    @Test
    public void fetchCustomerDataNotAvailable(){

        //given
        long id = 2;
        when(cache.containsCustomer(any())).thenReturn(false);


        //when
        ResponseEntity entity= customerController.fetchCustomer(id);


        //then
        assertEquals(404, entity.getStatusCode().value());

    }

    private Customer createCustomerInfo(){
        Customer customer=new Customer();
        customer.setFirstName("HAA");
        customer.setLastName("Pa");
        customer.setDob("67");
        customer.setId(1L);
        return customer;
    }

}
