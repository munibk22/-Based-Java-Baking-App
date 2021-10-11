package com.revature.controllers;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.daos.CustomerDAO;
import com.revature.daos.CustomerDAOImp;
import com.revature.models.Account;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.services.AccountService;
import com.revature.services.AdminService;
import com.revature.services.CustomerService;
import com.revature.services.EmployeeService;

public class EmployeeController {
	private static Scanner scan = new Scanner(System.in);
	private static Logger log = LoggerFactory.getLogger(EmployeeController.class);
//	private static CustomerService customerService = new CustomerService();
	private static boolean pwMatch = false;
	private static String setPassConfirm;
	private static String setPassword;
	private static CustomerDAO customerDAO = new CustomerDAOImp();
	private static EmployeeService employeeService = new EmployeeService();
	private static AdminController adminC = new AdminController();
	private static AdminService adminService = new AdminService();

	public Employee employeeLogin(Employee employee) {

		System.out.println("Enter username");
		String userNameScan = scan.nextLine();
		if (userNameScan.toLowerCase().equals("admin")) {
			adminC.queryAdmin();
		}
		System.out.println("Enter password");
		String passwordScan = scan.nextLine();

		employee = employeeService.getEUserName(userNameScan);
		System.out.println(employee.getLoggedIn());
		if (employee.getUserName().equals(userNameScan) && employee.getPassWord().equals(passwordScan)) {

			employee.setLoggedIn();
			employee.setRegistered(true);
			return employee;
		} else {
			log.error("Incorrect username or password");
		}

		return employee;
	}

	public Employee employeeMenu(Employee employee) {

		String ans;
		boolean menuController = true;

		System.err.println("Good news, " + employee.getFirstName() + " loggin was successfull!\n");

		do {
			System.out.println("What would you like to do today?");
			System.out.println("1.See all customers");
			System.out.println("2.See one customer");
			System.out.println("3.View accounts pending approval");
			System.out.println("4.Account information");
			System.out.println("5.Delete Customer");
			System.out.println("6.Personal information");
			System.out.println("7.Add a customer account");
			System.out.println("8.Exit menu");

			ans = scan.nextLine();
			switch (ans) {
			case "1":
				showAllCustomers();
				break;
			case "2":
				this.showOneCustomer();
				break;
			case "3":
				showStatus();
				break;
			case "4":
				showAllAccounts();
				break;
			case "5":
				deleteCustomer();
				break;
			case "6":

				break;
			case "7":
				addCustomer();
				break;
			case "8":
				menuController = false;
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

		return null;

	}

	private void showStatus() {
		List<Customer> customers = employeeService.getStatus();
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

//		Customer customers =
		employeeService.updateActive(response);

		System.out.println("========== \n");

	}

	public void addCustomer() {
		StartMenuController menuController = new StartMenuController();
		menuController.newCustomerBuilder();
	}

	public void showAllAccounts() {
		List<Account> accounts = employeeService.getAllAccounts();
		System.err.println("\nHere are the recorded accounts:");
		System.out.println("==========");

		for (Account a : accounts) {
			System.out.println(a);
		}
		System.out.println("==========\n");
	}

	public void showAllCustomers() {
		List<Customer> customers = employeeService.getAllCustomers();
		System.err.println("\nHere are the recorded customers:");
		System.out.println("==========");
		for (Customer c : customers) {
			System.out.println(c);
		}
		System.out.println("========== \n");
	}

	public List<Customer> getAllCustomers() {
		return customerDAO.findAll();
	}

	public void showOneCustomer() {
		System.out.println("Enter first name of the customer you would like to see?");
		String response = scan.nextLine();

		Customer customer = employeeService.getName(response);

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

	public void deleteCustomer() {
		System.out.println("Enter id name of the customer you want to remove?");

		int response = scan.nextInt();
		scan.nextLine();
		if (adminService.deleteAccount(response)) {
			log.info("Deletion of accont with ID: " + response + " was a success.\n");
		}
	}

}
