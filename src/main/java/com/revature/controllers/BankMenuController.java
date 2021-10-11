package com.revature.controllers;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.models.Customer;

public class BankMenuController {

	private static Scanner scan = new Scanner(System.in);
	private static Logger log = LoggerFactory.getLogger(BankMenuController.class);

	public void bankMenu(Customer customer) {

		while (customer.getReg()) {

			ApplicationsController appController = new ApplicationsController();
			System.out.println("***** Welcome " + customer.getFirstName() + " to Revature2Vanquish Bank***** \n");

			System.out.println("What would you like to do today?");
			System.out.println("1.Apply for a new account" + "\n2.Login" + "\n3.Exit the Bank" + "\n4.Exit the Game");

			String answer = scan.nextLine();

			switch (answer) {

			case "1":
				System.out.println(
						"Excellent, " + customer.getFirstName() + " let's get started with your new account. \n");
				customer = appController.getAppMenu(customer);
				break;
			case "2":
				if (customer.getIsActive() == false) {
					System.err.println(
							"User must be approved for an account before loggin in, please select option 1 in main menu \n");

				} else {
					System.out.println("Great, let's login to your account.");
					login(customer);
				}

				break;
			case "3":
				System.out.println("Thank you for visiting!");
				customer.setReg(false);

				break;
			case "4":
				System.out.println("Thank you for visiting!");
				System.exit(0);
				break;
			default:
				log.warn("User entered invalid  choice.");
				System.out.println("Not a valid choice, please try again.");
				bankMenu(customer);
				break;
			}

		}
	}

	public void login(Customer customer) {

		customer.setLoggedIn();
		boolean menuController = true;
		CustomerController customerController = new CustomerController();

		while (menuController) {
			if (customer.getLoggedIn()) {
				System.out
						.println(customer.getFirstName() + customer.getLastName() + " was logged in successfully! \n");
				customer = customerController.getTransactionsMenu(customer);
			}
			menuController = false;

		}

	}
}
