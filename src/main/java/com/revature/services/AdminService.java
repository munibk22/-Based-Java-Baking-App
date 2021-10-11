package com.revature.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.controllers.AdminController;
import com.revature.daos.AdminDAO;
import com.revature.daos.AdminDAOImpl;
import com.revature.daos.CustomerDAO;
import com.revature.daos.CustomerDAOImp;
import com.revature.models.AccountInfo;
import com.revature.models.Admin;
import com.revature.models.Customer;

public class AdminService {
	private static AdminDAO adminDao = new AdminDAOImpl();
	private static CustomerDAO customerDao = new CustomerDAOImp();
	private static Logger log = LoggerFactory.getLogger(AdminService.class);

	public List<Customer> getAllCustomers() {

		return adminDao.findAllCustomers();
	}

	public List<AccountInfo> getAllAccountInfo() {
		return adminDao.findAllInfo();

	}

	public boolean createDeposit(int customerID, String deposit) {
		int parseDeposit = Integer.parseInt(deposit);

		Customer customer = customerDao.findById(customerID);

		int newBalance = customer.getCheckingBalance() + parseDeposit;

		if (parseDeposit != 0) {

			customer.setCheckingBalance(newBalance);

			System.out.println("-----------------------------------");
			log.info("New balance " + customer.getCheckingBalance() + "\n");

			System.out.println("-----------------------------------");
		} else {
			System.out.println("Must deposit an amount greater than $0");
		}
		return adminDao.depositAccount(customer, newBalance);

	}

	public boolean createWithDraw(int customerID, String withdraw) {
		int parseDeposit = Integer.parseInt(withdraw);

		Customer customer = customerDao.findById(customerID);

		int newBalance = customer.getCheckingBalance() + parseDeposit;

		if (parseDeposit != 0) {

			customer.setCheckingBalance(newBalance);

			System.out.println("-----------------------------------");
			log.info("New balance " + customer.getCheckingBalance() + "\n");

			System.out.println("-----------------------------------");
		} else {
			System.out.println("Must deposit an amount greater than $0");
		}
		return adminDao.withdrawAccount(customer, newBalance);

	}

	public boolean deleteAccount(int customerID) {
		return adminDao.deleteAccount(customerID);
	}

	public boolean withdrawTransfer(String firstName, String withdraw) {
		int parseWithdraw = Integer.parseInt(withdraw);

		return adminDao.withdrawTransfer(firstName, parseWithdraw);

	}

	public List<Customer> getStatus() {

		return adminDao.findByStatus();
	}

	public void updateActive(int response) {
		adminDao.updateActive(response);

	}

}
