package com.deloitte.telecom.service;

import com.deloitte.telecom.dao.ICustomerDao;
import com.deloitte.telecom.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {

    private ICustomerDao customerDao;

    public ICustomerDao getCustomerDao() {
        return customerDao;
    }

    @Autowired
    public void setCustomerDao(ICustomerDao dao) {
        this.customerDao = dao;
    }

    @Override
    public boolean checkCredentialsById(int id, String password) {
        return customerDao.checkCredentialsById(id, password);
    }


    @Override
    public boolean checkCredentialsByMobileNo(String mobileNo, String password) {
        return customerDao.checkCredentialsByMobileNo(mobileNo, password);
    }

    @Override
    public Customer findCustomerById(int id) {
        return customerDao.findCustomerById(id);
    }

    @Override
    public Customer save(Customer Customer) {
        return customerDao.save(Customer);
    }

    @Override
    public Customer findByMobileNo(String mobileNo) {
        Customer Customer = customerDao.findByMobileNo(mobileNo);
        return Customer;
    }

    @Override
    public List<Customer> fetchCustomers(int blockSize) {
        List<Customer> Customers = customerDao.fetchCustomers(blockSize);
        return Customers;
    }

    @Override
    public Customer update(Customer customer) {
    	return customerDao.update(customer);
    }
    /*
    @PostConstruct
    public void init(){
       Customer Customer1=new Customer("satya","satya");
       CustomerDao.save(Customer1);
       Customer Customer2=new Customer("pranav","pranav");
       CustomerDao.save(Customer2);
    }*/
}
