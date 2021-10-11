package com.revature;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.controllers.AccountController;
import com.revature.controllers.BankMenuController;
import com.revature.controllers.CustomerController;
import com.revature.controllers.EmployeeController;
import com.revature.controllers.StartMenuController;
import com.revature.daos.EmployeeDaoImpl;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.services.CustomerService;
import com.revature.services.EmployeeService;

public class Driver {

	private static Logger log = LoggerFactory.getLogger(Driver.class);
	private static Scanner scan = new Scanner(System.in);
	private static BankMenuController bankMenu = new BankMenuController();
	private static StartMenuController startMenuController = new StartMenuController();
	private static EmployeeService employeeService = new EmployeeService();
	private static CustomerService customerService = new CustomerService();
	private static CustomerController customerController = new CustomerController();
	private static EmployeeController empController = new EmployeeController();
	private static AccountController accountController = new AccountController();
	private static EmployeeDaoImpl emplDao = new EmployeeDaoImpl();

	public static void main(String[] args) {

		// Initial start Menu
		initialPrompt();

		Customer customer = startMenuController.getCustomer();

		initMenu(customer);

	}

	public static void initialPrompt() {
		String ans = null;
		do {

			System.out.println("\n*****Hello, Welcome to Revature2Vanquish Bank***** \n");
			System.err.println("Are you a current employee? yes/no/exit to exit");
			ans = scan.nextLine();
			if (ans.toLowerCase().equals("yes") || ans.toLowerCase().equals("ye")) {
				queryEmployee();
			} else if (ans.toLowerCase().equals("no")) {
				Customer customer = startMenuController.getCustomer();
				initMenu(customer);
			} else if (ans.toLowerCase().equals("exit")) {
				System.exit(0);
			}

		} while (!ans.equals("exit"));

	}

	public static void queryEmployee() {
		Employee employee = new Employee();
		employee = empController.employeeLogin(employee);
		System.out.println(employee);
		if (employee.getLoggedIn()) {
			empController.employeeMenu(employee);
		}

	}

	public static void initMenu(Customer customerReg) {

		while (customerReg.getRegistered()) {
			System.out.println(
					"Customer " + customerReg.getFirstName() + " " + customerReg.getLastName() + " is registered. \n");
			bankMenu.bankMenu(customerReg);

			System.out.println("Do you want to leave the Bank?");
			String response = scan.nextLine();

			switch (response) {
			case "yes":
				// Save customer
				customerReg.setRegistered(false);

				break;
			case "no":
				customerReg.setReg(true);
				break;
			default:
				System.out.println("Not valid choice.");
				break;
			}

		}
		initialPrompt();
	}

}

//log.debug("Fun times are aboot to start! msg");
//
//log.info("This is an awesome application");
//new
//log.error("Log something is going wrong");
//log.warn("The program is aboot to end");
