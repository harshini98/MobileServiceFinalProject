package com.deloitte.telecom.exceptions;

public class NotEnoughBalance extends RuntimeException {
	   public NotEnoughBalance(String msg) {
	        super(msg);
	    }
}
