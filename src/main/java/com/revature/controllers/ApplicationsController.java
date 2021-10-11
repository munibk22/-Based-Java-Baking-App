package com.revature.controllers;

//import java.io.IOException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import com.revature.models.RegisterCustomer;

import com.revature.models.Customer;
import com.revature.services.CustomerService;

public class ApplicationsController {
	private static Scanner scan = new Scanner(System.in);
	private static Logger log = LoggerFactory.getLogger(ApplicationsController.class);
	private static CustomerService customerService = new CustomerService();

	public Customer getAppMenu(Customer customer) {
		System.err.println("Welcome " + customer.getFirstName() + " to the new accout application");

		try {
			System.out.println("Please choose from following menu:  \n" + "1.Apply for new account \n"
					+ "2.Back to main menu. \n");
			String response = scan.nextLine();

			if (response.equals("1") || response.equals("yes")) {
				log.info(customer.toString());
				submitApp(customer);
			}

//			System.out.println("\n\n" + "1.Submit Application \n" + "4.Back to main menu. \n");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			log.warn("User entered invalid input");
		}
		return customer;
	}

	private Customer submitApp(Customer customer) {

		System.err.println(
				"Excellent, " + customer.getFirstName() + " ,lets get a few more details before submitting \n");
		System.out.println("Enter last 4 digits of social security number");

		String sSecurity = scan.nextLine();
		customer.setsSecurity(sSecurity);

		System.out.println("Enter starting checking balance");
		int balance = scan.nextInt();
		scan.nextLine();

		customer.setCheckingBalance(balance);

		System.out.println("Review details before submitting:");
		System.err.println("Customer " + customer.getFirstName() + " details:");

		System.err.println("\nPlease confirm your details:");
		System.out.println("Name: " + customer.getFirstName() + " " + customer.getLastName() + ",\n" + "Username: "
				+ customer.getUserName() + ",\n" + "Address: " + customer.getAddress() + ",\n" + "Password: "
				+ customer.getPassWord() + ",\n" + "Starting Balance: " + customer.getCheckingBalance() + ",\n"
				+ "is registered? " + customer.getRegistered() + ",\n" + "is active? " + customer.getIsActive()
				+ ",\n");
		System.out.println("\nDoes everything look correct?");
		String confirmAns = scan.nextLine();

		if (confirmAns.toLowerCase().equals("yes") || confirmAns.equals("1") || confirmAns.equals("ye")) {
			customer.setConfirmAns(confirmAns);

			customer = customerService.createRegCustomer(customer.getFirstName(), customer.getLastName(),
					customer.getUserName(), customer.getPassWord(), customer.getCheckingBalance(),
					customer.getAddress(), customer.getRegistered(), customer.getIsActive());
//			customerService.addCustomer(customer);
			if (customerService.addCustomer(customer)) {
				System.out.println("====New customer " + customer.getFirstName() + " was added.====\n");
				System.err.println("Excellent, most accounts are reviewed with 24 hours, please check bank then \n");
				return customer;
			} else {
				System.out.println("Problem adding customer, please try again");
				return customer;
			}

		} else {
			System.out.println("Alright, lets start over.");
			customer = submitApp(customer);
			return customer;
		}

	}
}
