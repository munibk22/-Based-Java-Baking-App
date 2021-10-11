package com.revature.models;

public class Application {

	private int checkingBalance;
	private int savingBalance;

	public Application() {
		super();
	}

	public Application(int checkingBalance, int savingBalance) {
		super();

		this.checkingBalance = checkingBalance;
		this.savingBalance = savingBalance;
	}

	public int getCheckingBalance() {
		return checkingBalance;
	}

	public void setCheckingBalance(int checkingBalance) {
		if (checkingBalance >= 100) {
			this.checkingBalance = checkingBalance;
		} else {
			System.out.println("Starting balance must be over $100");
		}
	}

	public int getSavingBalance() {
		return savingBalance;
	}

	public void setSavingBalance(int savingBalance) {
		this.savingBalance = savingBalance;
	}

}
