package com.revature.daos;

import java.util.List;

import com.revature.models.AccountInfo;
import com.revature.models.Admin;
import com.revature.models.Customer;

public interface AdminDAO {

	public List<AccountInfo> findAllInfo();

	public List<Customer> findAllCustomers();

	public List<Customer> findByStatus();

	public boolean approveAccount(int id);

	public boolean deleteAccount(int customerID);

	public boolean depositAccount(Customer customer, int newBalance);

	public boolean withdrawAccount(Customer customer, int newBalance);

	public boolean withdrawTransfer(String firstName, int withdraw);

	public boolean updateCustomer(Customer customer);

	public Customer updateActive(int id);
}
