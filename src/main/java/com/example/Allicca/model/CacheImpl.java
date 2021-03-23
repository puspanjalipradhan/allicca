package com.example.Allicca.model;


import java.util.HashMap;

public class CacheImpl implements Cache{
    private static HashMap<Long, Customer> memoryData=new HashMap<>();

    public Customer getCustomer(Long id){
        return memoryData.get(id);
    }

    public Customer setCustomer(Customer customer){
        return memoryData.put(customer.getId(), customer );
    }

    public boolean containsCustomer(Long id){
        return memoryData.containsKey(id);
    }
}
