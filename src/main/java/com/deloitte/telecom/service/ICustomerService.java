package com.deloitte.telecom.service;

import com.deloitte.telecom.entities.Customer;

import java.util.List;

public interface ICustomerService {
    boolean checkCredentialsById(int id, String password);

    boolean checkCredentialsByMobileNo(String mobileNo, String password);

    Customer findCustomerById(int id);

    Customer save(Customer Customer);

    Customer findByMobileNo(String mobileNo);

    List<Customer> fetchCustomers(int blockSize);
    public Customer update(Customer customer);
}
