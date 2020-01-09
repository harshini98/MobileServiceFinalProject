package com.deloitte.telecom.dao;

import com.deloitte.telecom.entities.Customer;
import com.deloitte.telecom.exceptions.MobileNoAlreadyExistsException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CustomerDaoImpl implements ICustomerDao {

    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public boolean checkCredentialsById(int id, String password) {
        Customer Customer = entityManager.find(Customer.class, id);
        if (Customer == null) {
            return false;
        }
        return Customer.getPassword().equals(password);
    }


    @Override
    public boolean checkCredentialsByMobileNo(String mobileNo, String password) {
        Customer Customer = findByMobileNo(mobileNo);
        if (Customer == null) {
            return false;
        }
        return Customer.getPassword().equals(password);
    }


    @Override
    public Customer findCustomerById(int id) {
        Customer Customer = entityManager.find(Customer.class, id);
        return Customer;
    }

    @Override
    public Customer findByMobileNo(String mobileNo) {
        try {
            String jql = "from Customer where mobileNo=:mob";
            TypedQuery<Customer> query = entityManager.createQuery(jql, Customer.class);
            query.setParameter("mob", mobileNo);
            Customer result = query.getSingleResult();
            return result;
        }catch (NoResultException e){
            return null;
        }
    }


    @Override
    public List<Customer> fetchCustomers(int blockSize) {
        String jql = "from Customer";
        TypedQuery<Customer> query = entityManager.createQuery(jql, Customer.class);
        query.setMaxResults(blockSize);
        List<Customer> list = query.getResultList();
        return list;
    }


    public boolean mobileNumberExists(String mobileNo) {
        Customer Customer = findByMobileNo(mobileNo);
        return Customer != null;
    }

    @Override
    public Customer save(Customer Customer) {
        System.out.println("inside save,Customer=" + Customer);
        String phone = Customer.getMobileNo();
        boolean exists = mobileNumberExists(phone);
        if (exists) {
            throw new MobileNoAlreadyExistsException("mobile no exists");
        }
        Customer = getEntityManager().merge(Customer);
        return Customer;
    }
    
    @Override
    public Customer update(Customer customer)
    {
    	 customer = getEntityManager().merge(customer);
         return customer;
    }
}
