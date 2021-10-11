package com.revature.daos;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Account;
import com.revature.models.Customer;
import com.revature.models.Employee;

public interface EmployeeDAO {
	public List<Customer> findAll();

	public List<Account> findAllAccounts();

	public List<Customer> findByStatus();

	public Customer updateActive(int id);

	public Customer findByName(String firstName);

	public Account findAccount(String account);

	public boolean updateCustomer(Customer customer);

	public boolean addCustomer(Customer customer);

	public ArrayList<Employee> getAllEmployees();

	public Customer findByuserName(String userName);

	public Customer findByPassword(String password);

	public Employee findByUserName(String dept);
}
