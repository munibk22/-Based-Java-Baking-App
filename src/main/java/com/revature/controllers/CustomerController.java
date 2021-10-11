package com.revature.controllers;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.models.Customer;
import com.revature.services.CustomerService;

public class CustomerController {
	private static Scanner scan = new Scanner(System.in);
	private static Logger log = LoggerFactory.getLogger(CustomerController.class);
	private static CustomerService customerService = new CustomerService();
	private static boolean pwMatch = false;
	private static String setPassConfirm;
	private static String setPassword;

	public void showAllCustomers() {
		List<Customer> customers = customerService.getAllCustomers();
		for (Customer c : customers) {
			System.out.println(c);
		}
	}

	public void transactionMenuCheck() {

//		submitApp();
	}

	public Customer getTransactionsMenu(Customer customer) {
//		CustomerService customerService = new CustomerService();
		String ans;
		boolean menuController = true;

		System.err.println("Good news, " + customer.getFirstName() + " loggin was successfull!");

		do {
			System.out.println("What would you like to do today?\n");
			System.out.println("1.Make a deposit");
			System.out.println("2.Make a withdrawal");
			System.out.println("3.Transfer from your account");
			System.out.println("4.Balance Inquiry");
			System.out.println("5.Exit menu");

			ans = scan.nextLine();
			switch (ans) {
			case "1":
				System.err.println("Enter amount to deposit:");
				String deposit = scan.nextLine();
				if (Integer.parseInt(deposit) > 0) {
					customerService.setDeposit(customer, deposit);
				} else {
					log.info(customer.getFirstName() + " tried to deposit an amount below 0.");
					System.err.println("Must deposit an amount over $0 \n");
				}

				break;
			case "2":
				System.out.println("Enter amount you would like to withdraw:");
				String response = scan.nextLine();
//				response = Integer.parseInt(response);
				if (Integer.parseInt(response) > customer.getCheckingBalance()) {
					log.warn(customer.getFirstName()
							+ " tried to withdraw an amount greater than avialable in account. ");
					System.err.println("You do not have enough funds to withdraw $" + response + "\n");
				} else {
					customerService.withdraw(customer, response);
				}
				break;
			case "3":
				openTransfer(customer);
				break;
			case "4":
				showBalance(customer);
				break;

			case "5":
				menuController = false;
//				customer.setLoggOff();
				break;
			default:
				log.warn("User entered invalid  choice.");
				System.out.println("Not a valid choice, please try again.");

				break;

			}

		} while (menuController);
//		while (customer.getLoggedIn());
		return customer;

	}

	private void openTransfer(Customer customer) {
		try {
			System.out.println("Enter customer name who you are sending funds:");
			String firstName = scan.nextLine();
			System.out.println("Enter amount you would like to send:");
			String withdraw = scan.nextLine();
//		response = Integer.parseInt(response);
			if (Integer.parseInt(withdraw) > customer.getCheckingBalance()) {
				log.warn(customer.getFirstName() + " tried to withdraw an amount greater than avialable in account. ");
				System.err.println("You do not have enough funds to withdraw $" + withdraw + "\n");
			} else {
				customerService.withdrawTransfer(customer, firstName, withdraw);
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

	}

	private void showBalance(Customer customer) {
		System.out.println("-----------------------------------");
		log.info("Current balance " + customer.getCheckingBalance());
		System.out.println("-----------------------------------");
	}

	public void addCustomer() {

		System.err.println("\n****Registration Form****");

		System.out.println("What is your first name?");
		String setFirstName = scan.nextLine();
//		customer.setFirstName(setFirstName);
		System.out.println("What is your last name?");
		String setLastName = scan.nextLine();
//		customer.setLastName(setLastName);
		System.out.println("Please select a user name:");
		String userName = scan.nextLine();
		System.out.println("What is your address?");
		String setAddress = scan.nextLine();
//		customer.setAddress(setAddress);
		System.out.println("What is your password?");
		setPassword = scan.nextLine();
//		customer.setPassword(setPassword);
		do {
			System.out.println("Please confirm your password");
			setPassConfirm = scan.nextLine();
			passMatch(setPassword, setPassConfirm, setFirstName);
		} while (!pwMatch);
//		Customer customer = new Customer(setFirstName, setLastName, userName, setAddress, setPassword);
//		if (customerService.addCustomer(customer)) {
//			System.out.println("New customer " + customer.getFirstName() + " was added.");
//		} else {
//			System.out.println("Problem adding customer, please try again");
//		}
	}

	public static void showOneCustomer() {
		System.out.println("Enter id of the customer you would like to see?");
		int response = scan.nextInt();
		scan.nextLine();
		Customer customer = customerService.getCustomer(response);

		if (customer != null) {
			System.out.println(customer);
		} else {
			System.out.println("That is not a valid customer name, try again.");
			showOneCustomer();
		}

	}

	public static boolean passMatch(String pw, String confirmPW, String setFirstName) {
		if (pw.equals(confirmPW)) {
			return pwMatch = true;
		} else {
			log.warn("User " + setFirstName + " did not enter a correct matching password.");
			System.err.println("Passwords do not match, please try again.");
			return pwMatch = false;
		}

	}

}
