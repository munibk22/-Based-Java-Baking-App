package com.revature.models;

public class Account {
	private String accountNo;
	private static int saccNo = 1000;
	private int checkingBalance;
	private int savingBalance;

	// Contructor
	public Account(int checkingBalance, int savingBalance) {
		super();
		this.accountNo = Integer.toString((int) (Math.random() * saccNo++));
		System.out.println("Accout " + this.accountNo + " was approved!");

	}

	// No args contructor
	public Account() {
		super();

	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public static int getSaccNo() {
		return saccNo;
	}

	public static void setSaccNo(int saccNo) {
		Account.saccNo = saccNo;
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

	// toString
	@Override
	public String toString() {
		return "Account [accountNo= " + accountNo + ", checkingBalance= " + checkingBalance + ", savingBalance= "
				+ savingBalance + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNo == null) ? 0 : accountNo.hashCode());
		result = prime * result + checkingBalance;
		result = prime * result + savingBalance;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountNo == null) {
			if (other.accountNo != null)
				return false;
		} else if (!accountNo.equals(other.accountNo))
			return false;
		if (checkingBalance != other.checkingBalance)
			return false;
		if (savingBalance != other.savingBalance)
			return false;
		return true;
	}

}
