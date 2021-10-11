package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.daos.EmployeeDAO;
import com.revature.daos.EmployeeDaoImpl;
import com.revature.models.Account;
import com.revature.models.Customer;

public class EmployeeService {
	private static EmployeeDAO employeeDao = new EmployeeDaoImpl();

	public void updateActive(int id) {

		employeeDao.updateActive(id);

	};

	public ArrayList<Employee> getEmployees() {
		ArrayList<Employee> employees = employeeDao.getAllEmployees();
		// int empIndex=
		for (int i = 0; i < employees.size(); i++) {

		}
		return employees;
	}

	public List<Account> getAllAccounts() {

		return employeeDao.findAllAccounts();

	}

	public List<Customer> getAllCustomers() {

		return employeeDao.findAll();

	}

	public List<Customer> getStatus() {

		return employeeDao.findByStatus();

	}

	public void removeCustomer(Employee employee, Customer customer) {

	}

	public boolean addCustomer(Customer customer) {
		return employeeDao.addCustomer(customer);
	};

	public Customer getUserName(String userName) {
		return employeeDao.findByuserName(userName);
	}

	public Customer getName(String firstName) {
		return employeeDao.findByName(firstName);
	}

	public Employee getEUserName(String userName) {
		return employeeDao.findByUserName(userName);
	}

}
