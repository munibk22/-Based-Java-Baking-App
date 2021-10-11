package com.revature.controllers;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.Driver;
import com.revature.models.AccountInfo;
import com.revature.models.Admin;
import com.revature.models.Customer;
import com.revature.services.AdminService;

public class AdminController {
	private static Scanner scan = new Scanner(System.in);
	private static Logger log = LoggerFactory.getLogger(AdminController.class);
	private static AdminService adminService = new AdminService();

	public void queryAdmin() {
		System.err.println("****Welcome to to Admin login****");

		String ans;
		boolean menuController = true;

		System.err.println("Good news, " + " loggin was successfull!\n");

		do {
			System.out.println("What would you like to do today?");
			System.out.println("1.Make a deposit");
			System.out.println("2.Make a withdrawal");
			System.out.println("3.Transfer funds between accounts");
			System.out.println("4.Remove a customer");
			System.out.println("5.See all customers");
			System.out.println("6.View accounts pending approval");
			System.out.println("7.View Account information");
			System.out.println("8.View account balances");
			System.out.println("9.Personal information");
			System.out.println("10.Exit menu");

			ans = scan.nextLine();
			switch (ans) {
			case "1":
				makeDeposit();
				break;
			case "2":
				makeWithDraw();
				break;
			case "3":
				transfer();
				break;
			case "4":
				deleteCustomer();
				break;
			case "5":
				showAllCustomers();
				break;
			case "6":
				showStatus();
				break;
			case "7":
				showAccountInfo();
				break;
			case "8":

				break;
			case "9":

				break;
			case "10":
				Driver.initialPrompt();
				break;

			case "13":
				menuController = false;
//				customer.setLoggOff();
				break;
			default:
				log.warn("User entered invalid  choice.");
				System.err.println("Not a valid choice, please try again.\n");
				break;

			}

		} while (menuController);

	}

	private void makeWithDraw() {
		System.err.println("Enter amount to withdraw:");
		String withdraw = scan.nextLine();

		System.err.println("Enter customer id:");
		int customerID = scan.nextInt();
		scan.nextLine();
		if (Integer.parseInt(withdraw) > 0) {
			if (adminService.createWithDraw(customerID, withdraw)) {
				log.info("Withdraw of " + withdraw + " was a success.\n");
			}
		} else {
			log.info("admin tried to withdraw an amount below 0.");
			System.err.println("Must withdraw an amount over $0 \n");
		}

	}

	private void makeDeposit() {
		System.err.println("Enter amount to deposit:");
		String deposit = scan.nextLine();

		System.err.println("Enter customer id:");
		int customerID = scan.nextInt();
		scan.nextLine();
		if (Integer.parseInt(deposit) > 0) {
			if (adminService.createDeposit(customerID, deposit)) {
				log.info("Deposit of " + deposit + " was a success.\n");
			}
		} else {
			log.info("admin tried to deposit an amount below 0.");
			System.err.println("Must deposit an amount over $0 \n");
		}

	}

	private void showAccountInfo() {
		List<AccountInfo> info = adminService.getAllAccountInfo();

		for (AccountInfo i : info) {

			System.out.println(info);
		}

	}

	private void showStatus() {
		List<Customer> customers = adminService.getStatus();
		System.err.println("\nHere are the customer accounts pending approval:");
		System.out.println("==========");
		for (Customer c : customers) {
			System.out.println(c);
		}
		System.out.println("========== \n");

		System.out.println("Do you want to approve any accounts?");
		String response = scan.nextLine();
		if (response.equals("yes")) {

			approveAccounts();
		}

	}

	private void approveAccounts() {
		System.err.println("\nEnter customer id");

		int response = Integer.parseInt(scan.nextLine());
//		scan.nextLine();

		adminService.updateActive(response);

		System.out.println("========== \n");

	}

	private void showAllCustomers() {
		List<Customer> customers = adminService.getAllCustomers();

		for (Customer c : customers) {
			System.out.println(c);
		}
	}

	private void deleteCustomer() {
		System.err.println("Enter the customer id of account you want to delete:");
		int customerID = scan.nextInt();
		scan.nextLine();

		if (adminService.deleteAccount(customerID)) {
			log.info("Deletion of accont with ID: " + customerID + " was a success.\n");
		}

	}

	private void transfer() {
		try {
			System.out.println("Enter customer name who you are sending funds:");
			String firstName = scan.nextLine();
			System.out.println("Enter amount you would like to send:");
			String withdraw = scan.nextLine();
			;
			adminService.withdrawTransfer(firstName, withdraw);

		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

	}

}
