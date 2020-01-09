package com.deloitte.telecom.controller;
import com.deloitte.telecom.dao.ICustomerDao;
import com.deloitte.telecom.dto.SessionData;
import com.deloitte.telecom.entities.Customer;
import com.deloitte.telecom.exceptions.MobileNoAlreadyExistsException;
import com.deloitte.telecom.exceptions.NotEnoughBalance;
import com.deloitte.telecom.service.ICustomerService;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HelloController {
    private static Logger Log= LoggerFactory.getLogger(HelloController.class);

    private ICustomerService service;

    public ICustomerService getService() {
        return service;
    }

    @Autowired
    public void setService(ICustomerService service) {
        this.service = service;
    }

    private SessionData sessionData;

    @Autowired
    public void setSessionData(SessionData data) {
        this.sessionData = data;

    }

    public SessionData getSessionData() {
        return sessionData;
    }


    @GetMapping("/customerinput")
    public ModelAndView customerInput() {
        return new ModelAndView("customerinput");
    }

    @GetMapping("/logincheck")
    public RedirectView loginCheck(@RequestParam("phone") String phone,
                                   @RequestParam("password") String password) {
        boolean correct = service.checkCredentialsByMobileNo(phone, password);
        if (!correct) {
            return new RedirectView("/customerinput");
        }
        Customer customer = service.findByMobileNo(phone);
        sessionData.setCustomer(customer);
        return new RedirectView("/home");
    }


    @GetMapping("/home")
    public Object home() {
        if (sessionData.getCustomer() == null) {
            return new RedirectView("/customerinput");
        }
        Customer customer = sessionData.getCustomer();
        ModelAndView mv = new ModelAndView("home", "Customer", customer);
        return mv;
    }


    @GetMapping("/processregister")
    public RedirectView processRegister(@RequestParam("name") String name,
                                        @RequestParam("phone")String phone,
                                        @RequestParam("password") String password) {
    	Customer customer = new Customer(name, password);
        customer.setMobileNo(phone);
        customer.setBalance(0.0);
        customer = service.save(customer);
        sessionData.setCustomer(customer);
        return new RedirectView("/home");
    }

    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("/register");

    }
    
    @GetMapping("/checkbalance")
    public ModelAndView checkbalance() {
    	Customer customer = sessionData.getCustomer();
        ModelAndView mv = new ModelAndView("checkbalance", "Customer", customer);
        return mv;

    }
    
    @GetMapping("/recharge")
    public ModelAndView recharge() {
    	return new ModelAndView("recharge");
    }
    
    @GetMapping("/rechargecheck")
    public  RedirectView rechargeCheck(@RequestParam("balance") double balance) {
    	Customer customer = sessionData.getCustomer();
    	customer.setBalance(customer.getBalance()+balance);
    	customer = service.update(customer);
        sessionData.setCustomer(customer);
        return new RedirectView("/home");
    }
    
    @GetMapping("/transfer")
    public ModelAndView transfer() {
    	return new ModelAndView("transfer");
    }
    
    @GetMapping("/transfercheck")
    public  RedirectView transferCheck(@RequestParam("phone")String phone,@RequestParam("balance") double balance) {
    	Customer debitCustomer = sessionData.getCustomer();
    	if(debitCustomer.getBalance()>=balance)
    	{
    		debitCustomer.setBalance(debitCustomer.getBalance()-balance);
        	Customer  creditCustomer = service.findByMobileNo(phone);
        	creditCustomer.setBalance(creditCustomer.getBalance()+balance);
        	debitCustomer = service.update(debitCustomer);
        	creditCustomer = service.update(creditCustomer);
        	sessionData.setCustomer(debitCustomer);
            return new RedirectView("/home");
    	}
    	else
    	{
    		throw new NotEnoughBalance("Not Enough Balance");
    	}
    }
    
    @GetMapping("/signout")
    public RedirectView signout() {
        sessionData.setCustomer(null);
        return new RedirectView("/customerinput");
    }

    @GetMapping("/error")
    public ModelAndView error(){
        return new ModelAndView("error","message","something went wrong");
    }

    @ExceptionHandler(MobileNoAlreadyExistsException.class)
    public ModelAndView handleIfMobileNumberAlreadyExists(MobileNoAlreadyExistsException e){
      return new ModelAndView("error","message","mobilenumber already exists");
    }
    
    @ExceptionHandler(NotEnoughBalance.class)
    public ModelAndView handleIfNotEnoughBalance(NotEnoughBalance e){
      return new ModelAndView("error","message","Not Enough Balance");
    }

    @ExceptionHandler(value = Throwable.class)
    public ModelAndView catchAll(Throwable e){
        e.printStackTrace();
      return new ModelAndView("error","message","Something went wrong");
    }


}
