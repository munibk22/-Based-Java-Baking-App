package com.revature.controllers;

import java.util.Scanner;
import com.revature.Driver;
import com.revature.models.Customer;
import com.revature.models.Customer;
import com.revature.services.CustomerService;

public class RegisterMenuController {
//	public Customers customer1=new Customers();
	public StartMenuController start;
	public Scanner scan = new Scanner(System.in);

	public Customer registrationMenu() {
		Customer customer1 = new Customer();

		System.err.println("\n****Registration Form****");

		System.out.println("What is your naasdfasdfme?");
		String setName = scan.nextLine();
		customer1.setFirstName(setName);
		System.out.println("What is your address?");
		String setAddress = scan.nextLine();
		customer1.setAddress(setAddress);
		System.out.println("What is your password?");
		String setPassword = scan.nextLine();
		customer1.setPassword(setPassword);
		System.out.println("Please confirm your password");
		String setPassConfirm = scan.nextLine();
//		customer1.setPassConfirm(setPassConfirm);
//		customer1 = new Register(nameAns, addressAns, passAns, passConfirmAns);
		System.err.println("\nPlease confirm your details:");
		System.out.println(customer1.getCustomer());
		System.out.println("Does everything look correct?");
		String confirmAns = scan.nextLine();
		customer1.setConfirm(confirmAns);
//		Customers customer = new Customers(nameAns, passAns, addressAns, 100, 0);

//		if (customer1.isRegistered()) {
//			System.out.println("Customer " + customer1.getName() + " is registered.");
		return customer1;
//			System.err.println("\nExcellent, " + customer1.getName() + ", what would you like to do next:");
//			System.out.println("1.Apply for new account  \n" + "2.Return to main menu \n" + "3.Leave Bank");
//			String ans = scan.nextLine();
//			switch (ans) {
//			case "1":
//				ApplicationsController appmenu = new ApplicationsController();
//				appmenu.appMenu();
//				return customer1;
//			case "2":
//				Driver.initMenu.startMenu();
//				break;
//			case "3":
//				System.exit(0);
//				break;
//			default:
//				Driver.initMenu.startMenu();
//				break;
//			}
//		} else {
//			log.warn("Registration failed");
//			registrationMenu();
//		}

//		}
//		return customer1;
	}
}
