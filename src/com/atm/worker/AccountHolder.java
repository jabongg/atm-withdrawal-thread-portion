package com.atm.worker;

import com.atm.model.Account;

public class AccountHolder extends Thread {

	// the resource object which will be shared among threads.
	private Account account;
	private String accountHolder;
	private Integer amountToWithDraw;

	public AccountHolder(Account account, String accountHolder, Integer amountToWithDraw) {
		super();
		this.account = account;
		this.accountHolder = accountHolder;
		this.amountToWithDraw = amountToWithDraw;
	}

	// override run() method
	@Override
	public void run() {
		System.out.println("Initial balance in account is :" + account.getBalance());

		for (int i = 0; i < 3; i++) {
			withdrawAmount(amountToWithDraw, accountHolder, account);
		}
	}

	private synchronized void withdrawAmount(Integer amount, String accountHolder, Account account) {
		
		// check if there is enough amount in account to withdraw the money requested.
		if (amount <= account.getBalance()) {

			try {
				Thread.sleep(4000);
				account.withdraw(amount);
				
				// update the balance after withdrawal
				System.out.println("Amount " + amount + " withdrwan successfully by " + accountHolder
						+ ". Current balance is :" + account.getBalance());
				
				// account.getBalance() is not showing properly... its not well updated.
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else {
			System.out.println(
					"Requested money " + amount + " CAN NOT be withdrawn, by " + accountHolder + "as there is only "
							+ account.getBalance() + " remained. Current balance is :" + account.getBalance());
		}

	}

}
