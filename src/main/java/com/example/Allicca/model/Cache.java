package com.example.Allicca.model;

public interface Cache {
    Customer getCustomer(Long id);

    Customer setCustomer(Customer customer);

    boolean containsCustomer(Long id);
}
