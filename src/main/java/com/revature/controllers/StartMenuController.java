package com.revature.controllers;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.models.Customer;
import com.revature.services.CustomerService;
import com.revature.services.EmployeeService;

public class StartMenuController {

	private Logger log = LoggerFactory.getLogger(StartMenuController.class);
	private static Scanner scan = new Scanner(System.in);
	private static String setPassword;
	private static String setPassConfirm;
	private static boolean pwMatch = false;
	private static CustomerService customerService = new CustomerService();
	private static EmployeeService employeeService = new EmployeeService();
	private static Customer customer = new Customer();
	private static BankMenuController bankMenu = new BankMenuController();

	public Customer getCustomer() {

		System.out.println("Are you a current Customer?");
		String response = scan.nextLine();
		if (response.equals("yes")) {
			System.err.println("Welcome to customer login\n");

//			Customer customer = 
			customerLogin(customer);
			return customer;

		} else if (response.toLowerCase().equals("no")) {
			System.out.println("\nGreat, let's get started with Registration. ");
			Customer customerReg = newCustomerBuilder();
			return customerReg;
		} else {
			System.out.println("That is not a valid option, please choose again. \n");
			return getCustomer();
		}
	}
//catch(IllegalArgumentException e)
//	{
//			log.warn("User entered invalid  choice.");
//			e.printStackTrace();
//			System.out.println("Not a valid choice, please try again.");
////				return getCustomer();
//		}
//		} while (!(ans == "yes") || !(ans == "no") || !(ans == "Yes") || !(ans == "No"));

//	return null;

//	}

	private Customer customerLogin(Customer customer) {
		ApplicationsController appController = new ApplicationsController();

//		Customer customer = new Customer();
		System.out.println("Enter username");
		String userNameScan = scan.nextLine();
		System.out.println("Enter password");
		String passwordScan = scan.nextLine();

		customer = employeeService.getUserName(userNameScan);
		if (customer.getIsActive() == false) {
//			log.warn("Customer tried to access account before approval.");
//			System.out.println("You must submit an application for approval before logging on.");
//			customer = appController.getAppMenu(customer);
			customer.setRegistered(true);
			bankMenu.bankMenu(customer);

		} else if (customer.getUserName().equals(userNameScan) && customer.getPassWord().equals(passwordScan)) {
			System.out.println("****login was a success****");
			customer.setReg(true);
			customer.setRegistered(true);
			transactionMenu(customer);
			return customer;
		} else {
			log.error("User name not found");
		}
		return customer;
	}

	public void transactionMenu(Customer customer) {

//		customer.setLoggedIn();
		customer.setLoggedIn();
		boolean menuController = true;
		CustomerController customerController = new CustomerController();

		while (menuController) {

			if (customer.getLoggedIn()) {
//				System.out
//						.println(customer.getFirstName() ++ customer.getLastName() + " was logged in successfully! \n");
				customer = customerController.getTransactionsMenu(customer);
			}
			menuController = false;

		}

	}

	public Customer newCustomerBuilder() {

		Customer customer = new Customer();
		System.err.println("\n****Registration Form****");

		System.out.println("What is your first name?");
		String setFirstName = scan.nextLine();
		customer.setFirstName(setFirstName);
		System.out.println("What is your last name?");
		String setLastName = scan.nextLine();
		customer.setLastName(setLastName);
		System.out.println("Please select a user name:");
		String userName = scan.nextLine();
		customer.setUserName(userName);
		System.out.println("What is your address?");
		String setAddress = scan.nextLine();
		customer.setAddress(setAddress);
		System.out.println("What is your password?");
		setPassword = scan.nextLine();
		customer.setPassword(setPassword);
		do {
			System.out.println("Please confirm your password");
			setPassConfirm = scan.nextLine();
			passMatch(setPassword, setPassConfirm, setFirstName);
		} while (!pwMatch);

		System.err.println("\nPlease confirm your details:");
		System.out.println("Name: " + setFirstName + " " + setLastName + ",\n" + "Username: " + userName + ",\n"
				+ "Address: " + setAddress + ",\n" + "Password: " + setPassword);
		System.out.println("\nDoes everything look correct?");
		String confirmAns = scan.nextLine();
//		customer.setConfirm(confirmAns);saveCustomerReg
		if (confirmAns.toLowerCase().equals("yes") || confirmAns.equals("1") || confirmAns.equals("ye")) {
			customer.setConfirmAns(confirmAns);
			customer.setRegistered(true);
		} else {
			System.out.println("Alright, lets start over.");
			customer = newCustomerBuilder();

		}

		if (customer.getRegistered()) {

			log.info("Customer " + customer.getFirstName() + " " + customer.getLastName() + " is registered. \n");
		}

		return customer;
	}

	private boolean passMatch(String pw, String confirmPW, String setFirstName) {
		if (pw.equals(confirmPW)) {
			return StartMenuController.pwMatch = true;
		} else {
			log.warn("User " + setFirstName + " did not enter a correct matching password.");
			System.err.println("Passwords do not match, please try again.");
			return StartMenuController.pwMatch = false;
		}

	}

//	public void saveCustomerReg(Customer customerReg) {
//		CustomerService.save(customerReg);
//
//	}
}
