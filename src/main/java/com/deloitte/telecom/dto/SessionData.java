package com.deloitte.telecom.dto;

import com.deloitte.telecom.entities.Customer;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.context.annotation.ScopedProxyMode;


@Component
@SessionScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionData {

    private Customer Customer;

    public void setCustomer(Customer Customer){
        this.Customer=Customer;
    }

    public Customer getCustomer(){
        return Customer;
    }




}
