package com.atm.client;

import com.atm.model.Account;
import com.atm.worker.AccountHolder;

public class AtmTestDriver {

	public static void main(String[] args) {
		Account account = new Account();
		AccountHolder t1 = new AccountHolder(account, "Marylin", 3000);
		AccountHolder t2 = new AccountHolder(account, "Mike", 2000);
		
		// start the both threads
		t1.start();
		t2.start();

	}
	
	/*
	 * 	random OUTPUT snapshot here: (without withdraw() method to be synchronized.)
	 * 
	 *  Initial balance in account is :6000
		Initial balance in account is :6000
	  	Amount 3000 withdrwan successfully by Marylin. Current balance is :3000
		Amount 2000 withdrwan successfully by Mike. Current balance is :1000
		Requested money 2000 CAN NOT be withdrawn, as there is only 1000 remained. Current balance is :1000
		Requested money 2000 CAN NOT be withdrawn, as there is only 1000 remained. Current balance is :1000
		Amount 3000 withdrwan successfully by Marylin. Current balance is :-2000
		Requested money 3000 CAN NOT be withdrawn, as there is only -2000 remained. Current balance is :-2000
	 */
	
	
	/*
	 * With synchronized keyword : 
	 * 
	 * Output:
	 * (still not working... as expected)
	 * 
	 *	Initial balance in account is :6000
		Initial balance in account is :6000
		Amount 2000 withdrwan successfully by Mike. Current balance is :1000
		Amount 3000 withdrwan successfully by Marylin. Current balance is :1000
		Requested money 2000 CAN NOT be withdrawn, by Mikeas there is only 1000 remained. Current balance is :1000
		Requested money 2000 CAN NOT be withdrawn, by Mikeas there is only 1000 remained. Current balance is :1000
		Requested money 3000 CAN NOT be withdrawn, by Marylinas there is only 1000 remained. Current balance is :1000
		Requested money 3000 CAN NOT be withdrawn, by Marylinas there is only 1000 remained. Current balance is :1000 
	 */
}
