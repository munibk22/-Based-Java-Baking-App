package com.revature.services;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.daos.CustomerDAO;
import com.revature.daos.CustomerDAOImp;
import com.revature.models.Customer;

public class CustomerService {
//	Customers customer;
	private static Logger log = LoggerFactory.getLogger(CustomerService.class);
	private static CustomerDAO customerDAO = new CustomerDAOImp();
	private static Scanner scan = new Scanner(System.in);

	public Customer createRegCustomer(String firstName, String lastName, String userName, String password, int balance,
			String address, boolean isRegistered, boolean isActive) {

		return new Customer(firstName, lastName, userName, password, balance, address, isRegistered, isActive);
	}

	public List<Customer> getAllCustomers() {
		return customerDAO.findAll();
	}

	public Customer getCustomer(int id) {
		return customerDAO.findById(id);
	}

	public boolean addCustomer(Customer customer) {
		customerDAO.addCustomer(customer);
		return true;
	}

	public void removeCustomer(String response) {
		customerDAO.deleteCustomer(response);
	}

	public void removeCustomerint(int id) {
		customerDAO.deleteCustomerid(id);
	}

	public boolean setDeposit(Customer customer, String deposit) {

		System.out.println("Previous balance " + customer.getCheckingBalance());

		int parseDeposit = Integer.parseInt(deposit);
		int newBalance = customer.getCheckingBalance() + parseDeposit;

		if (parseDeposit != 0) {

			customer.setCheckingBalance(customer.getCheckingBalance() + parseDeposit);

			System.out.println("-----------------------------------");
			log.info("New balance " + customer.getCheckingBalance() + "\n");

			System.out.println("-----------------------------------");
		} else {
			System.out.println("Must deposit an amount greater than $0");
		}
		return customerDAO.depositAccount(customer, newBalance);

	}

	public boolean withdraw(Customer customer, String withdraw) {

		System.out.println("Previous balance " + customer.getCheckingBalance());
		int parseWithdraw = Integer.parseInt(withdraw);
		int newBalance = customer.getCheckingBalance() + parseWithdraw;
		if (parseWithdraw < customer.getCheckingBalance()) {

			customer.setCheckingBalance(customer.getCheckingBalance() - parseWithdraw);

			System.out.println("-----------------------------------");
			log.info("New balance " + customer.getCheckingBalance() + "\n");
			System.out.println("-----------------------------------");
		} else {
			log.warn("user tried to withdraw more funds than in the accout.");
			System.out.println("Cannot withdraw more than account balance");
		}
		return customerDAO.withdrawAccount(customer, newBalance);
	}

	public boolean setDepositTransfer(Customer customer, String deposit) {

		System.out.println("Previous balance " + customer.getCheckingBalance());
		int parseDeposit = Integer.parseInt(deposit);
		int transferBalance = customer.getCheckingBalance() + parseDeposit;

		if (parseDeposit != 0) {

			customer.setCheckingBalance(customer.getCheckingBalance() - parseDeposit);

			System.out.println("-----------------------------------");
			log.info("New balance " + customer.getCheckingBalance() + "\n");

			System.out.println("-----------------------------------");
		} else {
			System.out.println("Must deposit an amount greater than $0");
		}
		return customerDAO.depositAccount(customer, transferBalance);

	}

	public boolean withdrawTransfer(Customer customer, String firstName, String withdraw) {

		System.out.println("Previous balance " + customer.getCheckingBalance());

		int parseWithdraw = Integer.parseInt(withdraw);
		int newBalance = customer.getCheckingBalance() - parseWithdraw;
		if (parseWithdraw < customer.getCheckingBalance()) {
			customer.setCheckingBalance(customer.getCheckingBalance() - parseWithdraw);
			System.out.println("-----------------------------------");
			log.info("New balance " + customer.getCheckingBalance() + "\n");
			System.out.println("-----------------------------------");
		} else {
			log.warn("user tried to withdraw more funds than in the accout.");
			System.out.println("Cannot withdraw more than account balance");
		}
		customerDAO.withdrawAccount(customer, newBalance);

		return customerDAO.withdrawTransfer(customer, firstName, parseWithdraw);
	}

//	public static void save(Customer customerReg) {
//		customerRDAO.writeCustomer(customerReg);
//
//	}

//	public ArrayList<Customer> getPreviousCustomerR() {
//
//		ArrayList<Customer> allCustomers = customerRDAO.getAllCustomers();
//		for (int i = 0; i < allCustomers.size(); ++i) {
//			if (allCustomers.get(i).getIsActive() == false) {
//				allCustomers.remove(i);
//			}
//		}
//		return allCustomers;
//	}

}
