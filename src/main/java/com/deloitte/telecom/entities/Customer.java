package com.deloitte.telecom.entities;

import javax.persistence.*;

@Entity
@Table(name = "Customers")
public class Customer {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    
   private double balance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String password;

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password=password;
    }

    @Column(unique = true)
    private String mobileNo;

    public String getMobileNo(){
        return mobileNo;
    }

    public void setMobileNo(String no){
        this.mobileNo=no;
    }

    public Customer(){

    }

    public Customer( String name,String password){
        this.name=name;
        this.password=password;
    }

    @Override
    public int hashCode() {
    	return id;
    }

    @Override
    public boolean equals(Object obj) {
    	if (this == obj)
    		return true;
    	if (obj == null || ! (obj instanceof Customer))
    		return false;
    	Customer cust = (Customer)obj;
    	return this.id==(cust.id);
    }

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", password=" + password
				+ ", mobileNo=" + mobileNo + "]";
	}

	
}
