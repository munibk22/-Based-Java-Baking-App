package com.revature.controllers;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.models.Account;
import com.revature.models.Customer;
import com.revature.services.AccountService;
import com.revature.services.CustomerService;

public class AccountController {
	private static Scanner scan = new Scanner(System.in);
	private static Logger log = LoggerFactory.getLogger(ApplicationsController.class);
	private static String answer;
	private static AccountService accountService = new AccountService();
	private static CustomerService customerService = new CustomerService();

	public void accountMenu(Customer customer) {
		boolean menuController = true;

		System.err.println("Welcome " + customer.getFirstName() + " to the new account menu");

		try {
			System.out.println(

					"You can: \n" + "1.Apply for new account \n" + "2.See checking balance  \n"
							+ "3.See savings balance  \n" + "4.Deposit Funds \n" + "5.Withdraw Funds \n"
							+ "6.Transfer Funds \n" + "7.SHow all accounts \n" + "8.Back to main menu. \n");

			answer = scan.nextLine();
			switch (answer) {
			case "1":
				System.err.println("Enter amount to deposit:");
				String deposit = scan.nextLine();
				if (Integer.parseInt(deposit) > 0) {
					customerService.setDeposit(customer, deposit);
				} else {
					log.info(customer.getFirstName() + " tried to deposit an amount below 0.");
					System.err.println("Must deposit an amount over $0 \n");
				}

//			System.out.println("Customer has deposited " + deposit + "into " + customer.getBalance());
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

				break;
			case "4":

				break;

			case "5":

				break;
			case "6":

				break;
			case "7":
				showAllAccounts();
				break;
			case "8":
				System.out.println("====You exit your account====");
				menuController = false;
//				customer.setLoggOff();
				break;
			default:
				log.warn("User entered invalid  choice.");
				System.out.println("Not a valid choice, please try again.");

				break;

			}

			System.out.println("Enter last 4 digits of social security number");
			String sSecurity = scan.nextLine();
//			customer.setSocial(sSecurity);
			System.out.println("Enter starting checking balance");
			int balance = scan.nextInt();
//			customer.setBalance(balance);

			System.out.println("Review details before submitting:");
			System.err.println("Customer " + customer.getFirstName() + " details:");
			System.out.println(customer.toString());

//			System.out.println("\nYou can: \n" + "1.Submit Application \n" + "4.Back to main menu. \n");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			log.warn("User entered invalid input");
		}

	}

	// Methods
	private void showAllAccounts() {
		System.out.println("Here the recorded accounts:");
		List<Account> accounts = accountService.findAllAccounts();
		for (Account a : accounts) {
			System.out.println(a);
		}
	}
}
