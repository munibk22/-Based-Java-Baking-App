package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.models.Account;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.utils.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDAO {
	private Logger log = LoggerFactory.getLogger(EmployeeDaoImpl.class);

	@Override
	public List<Customer> findAll() {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM customers";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);
			List<Customer> list = new ArrayList<>();

			while (result.next()) {
				Customer customer = new Customer();
				customer.setId(result.getInt("id"));
				customer.setFirstName(result.getString("first_name"));
				customer.setLastName(result.getString("last_name"));
				customer.setUserName(result.getString("user_name"));
				customer.setPassword(result.getString("password"));
				customer.setCheckingBalance(result.getInt("account_balance"));
				customer.setIsActive(result.getBoolean("active"));
				customer.setRegistered(result.getBoolean("registered"));
				customer.setDateCreated(result.getDate("account_created"));
				list.add(customer);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Account> findAllAccounts() {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM accounts;";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);
			List<Account> alist = new ArrayList<>();

			while (result.next()) {
				Account account = new Account();

				account.setAccountNo(result.getString("accountno"));
				account.setCheckingBalance(result.getInt("checking_balance"));
				account.setSavingBalance(result.getInt("saving_balance"));
				alist.add(account);

			}
			return alist;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Customer updateActive(int id) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "UPDATE customers SET active = true WHERE id = ?";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);

			statement.executeUpdate();
			Customer customer = new Customer();

//			while (result.next()) {
//				customer.setId(result.getInt("id"));
//				customer.setFirstName(result.getString("first_name"));
//				customer.setLastName(result.getString("last_name"));
//				customer.setUserName(result.getString("user_name"));
//				customer.setPassword(result.getString("password"));
//				customer.setCheckingBalance(result.getInt("account_balance"));
//				customer.setIsActive(result.getBoolean("active"));
//				customer.setRegistered(result.getBoolean("registered"));
//				customer.setDateCreated(result.getDate("account_created"));
//
//			}
			log.info("Customer's account at id " + id + " was approved. \n");

			return customer;
		} catch (SQLException e) {
			e.printStackTrace();

		}

		return null;

	}

	@Override
	public Customer findByName(String firstName) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM customers WHERE first_name = ?";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, firstName);

			ResultSet result = statement.executeQuery();
//			List<Customer> list = new ArrayList<>();
			Customer customer = new Customer();

			while (result.next()) {
				customer.setId(result.getInt("id"));
				customer.setFirstName(result.getString("first_name"));
				customer.setLastName(result.getString("last_name"));
				customer.setUserName(result.getString("user_name"));
				customer.setPassword(result.getString("password"));
				customer.setCheckingBalance(result.getInt("account_balance"));
				customer.setIsActive(result.getBoolean("active"));
				customer.setRegistered(result.getBoolean("registered"));
				customer.setDateCreated(result.getDate("account_created"));

			}
			return customer;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Customer findByuserName(String userName) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM customers WHERE user_name = ?";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, userName);
			ResultSet result = statement.executeQuery();
			List<Customer> list = new ArrayList<>();
			Customer customer = new Customer();

			while (result.next()) {
				customer.setId(result.getInt("id"));
				customer.setFirstName(result.getString("first_name"));
				customer.setLastName(result.getString("last_name"));
				customer.setUserName(result.getString("user_name"));
				customer.setPassword(result.getString("password"));
				customer.setCheckingBalance(result.getInt("account_balance"));
				customer.setIsActive(result.getBoolean("active"));
				customer.setRegistered(result.getBoolean("registered"));
				customer.setDateCreated(result.getDate("account_created"));

			}
			return customer;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Employee findByUserName(String userName) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM employees WHERE user_name = ?";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, userName);
			ResultSet result = statement.executeQuery();

			Employee employee = new Employee();

			while (result.next()) {
				employee.setId(result.getInt("id"));
				employee.setFirstName(result.getString("first_name"));
				employee.setLastName(result.getString("last_name"));
				employee.setPassword(result.getString("password"));
				employee.setDepartment(result.getString("department"));
				employee.setIsActive(result.getBoolean("approve"));
				employee.setUserName(result.getString("user_name"));
				employee.setDateCreated(result.getDate("account_created"));
				employee.setCheckingBalance(result.getInt("account_balance"));

			}
			return employee;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public Account findAccount(String account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateCustomer(Customer customer2) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM customers WHERE user_name = ?";

			PreparedStatement statement = conn.prepareStatement(sql);
//			statement.setString(1, customer2);
			ResultSet result = statement.executeQuery(sql);
			List<Customer> list = new ArrayList<>();
			Customer customer = new Customer();

			while (result.next()) {
				customer.setId(result.getInt("id"));
				customer.setFirstName(result.getString("first_name"));
				customer.setLastName(result.getString("last_name"));
				customer.setUserName(result.getString("user_name"));
				customer.setPassword(result.getString("password"));
				customer.setCheckingBalance(result.getInt("account_balance"));
				customer.setIsActive(result.getBoolean("active"));
				customer.setRegistered(result.getBoolean("registered"));
				customer.setDateCreated(result.getDate("account_created"));

			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean addCustomer(Customer customer2) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO customers (first_name, last_name, user_name, password, account_balance , active , registered) +"
					+ "VALUES(?,?,?,?,?,?,?)";

			PreparedStatement statement = conn.prepareStatement(sql);

			int index = 0;
			statement.setString(++index, customer2.getFirstName());
			statement.setString(++index, customer2.getLastName());
			statement.setString(++index, customer2.getUserName());
			statement.setString(++index, customer2.getPassWord());
			statement.setInt(++index, customer2.getCheckingBalance());
			statement.setBoolean(++index, customer2.getIsActive());
			statement.setBoolean(++index, customer2.getRegistered());

			statement.executeQuery();

//			Customer customer = new Customer();//
//			while (result.next()) {
//				customer.setId(result.getInt("id"));
//				customer.setFirstName(result.getString("first_name"));
//				customer.setLastName(result.getString("last_name"));
//				customer.setUserName(result.getString("user_name"));
//				customer.setPassword(result.getString("password"));
//				customer.setCheckingBalance(result.getInt("account_balance"));
//				customer.setIsActive(result.getBoolean("active"));
//				customer.setRegistered(result.getBoolean("registered"));
//				customer.setDateCreated(result.getDate("account_created"));
//
//			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public ArrayList<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> findByStatus() {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM customers WHERE active=false";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);
			List<Customer> list = new ArrayList<>();

			while (result.next()) {
				Customer customer = new Customer();
				customer.setId(result.getInt("id"));
				customer.setFirstName(result.getString("first_name"));
				customer.setLastName(result.getString("last_name"));
				customer.setUserName(result.getString("user_name"));
				customer.setPassword(result.getString("password"));
				customer.setCheckingBalance(result.getInt("account_balance"));
				customer.setIsActive(result.getBoolean("active"));
				customer.setRegistered(result.getBoolean("registered"));
				customer.setDateCreated(result.getDate("account_created"));
				list.add(customer);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Customer findByPassword(String password) {
		// TODO Auto-generated method stub
		return null;
	}

}

//public ArrayList<Employee> getAllEmployees() {
//
//	ArrayList<Employee> employeeList = new ArrayList<>();
//
//	try (Scanner scan = new Scanner(new File("src//main//resources//employees.txt"))) {
//
//		while (scan.hasNextLine()) {
//			String employeeString = scan.nextLine();
//			String[] employeeDeets = employeeString.split(" , ");
////			employeeList.add(new Employee(employeeDeets[0], employeeDeets[1], employeeDeets[2], employeeDeets[3],
////					Integer.valueOf(employeeDeets[4])));
//
//		}
//
//	} catch (NullPointerException e) {
//		System.out.println("Could not locate file:" + e.getMessage());
//	} catch (IOException e) {
//		log.error("Something went wrong retrieving employees:" + e.getMessage());
//	}
//
//	return employeeList;
//
//}
