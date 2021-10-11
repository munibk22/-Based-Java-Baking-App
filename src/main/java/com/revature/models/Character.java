package com.revature.models;

import java.sql.Date;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.Driver;
import com.revature.controllers.RegisterMenuController;
import com.revature.controllers.StartMenuController;

public abstract class Character {
	private Logger log = LoggerFactory.getLogger(Character.class);
	private Scanner scan = new Scanner(System.in);
	private RegisterMenuController register = new RegisterMenuController();
	public StartMenuController startMenu;

	private String firstName;
	private String lastName;
	private String password;
	private String passConfirm;
	private boolean passMatch = false;
	private boolean isLoggedIn = false;
	private boolean isActive = false;
	private boolean isRegistered = false;
	private String timeStamp;
	Account account;
//	private static int saccNo = 1000;
	private Date dateCreated;
	private int checkingBalance;
	private String UserName;

	public Character(String firstName, String lastName, String password, int checkingBalance, boolean isRegistered,
			boolean isActive) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.isRegistered = isRegistered;
		this.isActive = isActive;
		this.checkingBalance = checkingBalance;
		// this.setRegistered(setConfirm(confirmAns));
	}

	public Character() {
		super();
	}

	// Setters

	public void setLoggedIn() {
		this.isLoggedIn = true;
//		while (this.isLoggedIn == false) {
//			System.out.println("Enter your name");
//			String name = scan.nextLine();
//			if (this.firstName.equals(name)) {
//				this.isLoggedIn = true;
//			} else {
//				System.out.println("incorrect user name fool.");
//			}

//		}
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public void setLoggOff() {
		this.isLoggedIn = false;
	}

	public void setFirstName(String setName) {
		this.firstName = setName;
	}

	public void setLastName(String setLastName) {
		this.lastName = setLastName;
	}

	public void setPassword(String setPassword) {
		this.password = setPassword;
//		while (this.password == null) {
//			if (setPassword.length() <= 2) {
//				log.warn("User tried to create password less than 2 characters");
//				System.err.println("Password must be more than 2 characters long");
//				System.out.println("What is your password?");
//				String setPassword2 = scan.nextLine();
//				setPassword(setPassword2);
//
//			} else {
//				this.password = setPassword;
//			}

//		}

	}

	// Getters
	public String getLastName() {
		return this.lastName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public boolean getLoggedIn() {
		return this.isLoggedIn;
	}

	public String getPassWord() {
		return this.password;
	}

	public String getPassConfirm() {
		return passConfirm;
	}

	// toString
	@Override
	public String toString() {
		return "Character [firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
				+ ", isLoggedIn=" + isLoggedIn + "]";
	}

	// HashCode & Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + (isLoggedIn ? 1231 : 1237);
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((log == null) ? 0 : log.hashCode());
		result = prime * result + ((passConfirm == null) ? 0 : passConfirm.hashCode());
		result = prime * result + (passMatch ? 1231 : 1237);
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((register == null) ? 0 : register.hashCode());
		result = prime * result + ((scan == null) ? 0 : scan.hashCode());
		result = prime * result + ((startMenu == null) ? 0 : startMenu.hashCode());
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
		Character other = (Character) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (isLoggedIn != other.isLoggedIn)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (log == null) {
			if (other.log != null)
				return false;
		} else if (!log.equals(other.log))
			return false;
		if (passConfirm == null) {
			if (other.passConfirm != null)
				return false;
		} else if (!passConfirm.equals(other.passConfirm))
			return false;
		if (passMatch != other.passMatch)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (register == null) {
			if (other.register != null)
				return false;
		} else if (!register.equals(other.register))
			return false;
		if (scan == null) {
			if (other.scan != null)
				return false;
		} else if (!scan.equals(other.scan))
			return false;
		if (startMenu == null) {
			if (other.startMenu != null)
				return false;
		} else if (!startMenu.equals(other.startMenu))
			return false;
		return true;
	}

	/**
	 * @return the isActive
	 */
	public boolean getIsActive() {
		return isActive();
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(boolean isActive) {
		this.setActive(isActive);
	}

	/**
	 * @return the isRegistered
	 */
	public boolean getRegistered() {
		return isRegistered;
	}

	/**
	 * @param isRegistered the isRegistered to set
	 */
	public void setRegistered(boolean isRegistered) {
		this.isRegistered = isRegistered;
//		return isRegistered;
	}

	public void setConfirm(String setConfirm) {
		this.setRegistered(true);

	}

	/**
	 * @return the timeStamp
	 */
	public String getTimeStamp() {
		return timeStamp;
	}

	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	/**
	 * @return the dateCreated
	 */
//	public String getDateCreated() {
//		return dateCreated;
//	}

	/**
	 * @param date the dateCreated to set
	 */
	public void setDateCreated(Date date) {
		this.dateCreated = date;
	}

	/**
	 * @return the checkingBalance
	 */
	public int getCheckingBalance() {
		return checkingBalance;
	}

	/**
	 * @param checkingBalance the checkingBalance to set
	 */
	public void setCheckingBalance(int checkingBalance) {
		this.checkingBalance = checkingBalance;
	}

	/**
	 * @return the isActive
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

//	public String setPassConfirm(String setPassConfirm) {
//	while (!this.passMatch) {
//		if (!(this.password.equals(setPassConfirm))) {
//			log.warn("Passwords do not match, try again.");
//
////			System.err.println("Passwords do not match, try again.");
//			System.out.println("Confirm password");
//			String passAns = scan.nextLine();
//			setPassConfirm(passAns);
//
//		} else {
//			this.passMatch = true;
//
//		}
//	}
//	return setPassConfirm;
//
//}

//	private Register app;

//	private int savingBalance;
//
//
//	public Customers(String name, String password, String address, int checkingBalance, int savingBalance) {
//		super();
//		this.name = name;
//		this.password = password;
//		this.address = address;
//		this.app = app;
//		if (checkingBalance >= 100) {
//			this.checkingBalance = checkingBalance;
//		} else {
//			log.warn(this.name + ", tried to start a checking accout with less than $100");
//		}
//
//		this.savingBalance = savingBalance;
//
//	}
//
//	public int getCheckingBalance() {
//		return checkingBalance;
//	}
//
//	public void setCheckingBalance(int checkingBalance) {
//		if (checkingBalance >= 1) {
//			this.checkingBalance = checkingBalance;
//		} else {
//			log.warn(this.name + " , you must deposit positive amount at setter");
//		}
//	}
//
//	public int getSavingBalance() {
//		return savingBalance;
//	}
//
//	public void setSavingBalance(int savingBalance) {
//		this.savingBalance = savingBalance;
//	}

}
