package com.atm.model;

public class Account {

	private Integer balance = 6000;
	
	/**
	 * this method returns the current balance in the account.
	 * @return
	 */
	public Integer getBalance() {
		return balance;
	}
	
	/**
	 * updates balance after withdrawal
	 * @param amount
	 */
	public void withdraw(Integer amount) {
		/*
		 * trying to handle this balance update, so that any change by other thread is immediately
		 * visible to other thread... 
		 * 
		 * but it seems not working. how to do ???
		 * 
		 */
		synchronized(this) {
			balance = balance - amount;

		}
	}

	@Override
	public String toString() {
		return "Account [balance=" + balance + "]";
	}
	
	
}
