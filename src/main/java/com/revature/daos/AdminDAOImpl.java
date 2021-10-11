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

import com.revature.models.AccountInfo;

import com.revature.models.Customer;
import com.revature.utils.ConnectionUtil;

public class AdminDAOImpl implements AdminDAO {
	private static Logger log = LoggerFactory.getLogger(AdminDAOImpl.class);

	@Override
	public List<AccountInfo> findAllInfo() {

		try (Connection conn = ConnectionUtil.getConnection()) {
//			String sql = "SELECT * FROM account_information";
			String sql = "SELECT * FROM admin c JOIN account_information a ON a.social_security = c.customer_information";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			List<AccountInfo> iList = new ArrayList<>();
//			List<Admin> aList = new ArrayList<>();

			while (result.next()) {
				AccountInfo customerInfo = new AccountInfo();
				customerInfo.setsSecurity(result.getString("social_security"));
				customerInfo.setAddress(result.getString("address"));
				customerInfo.setPassword(result.getString("password"));
				iList.add(customerInfo);
			}
			return iList;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Customer> findAllCustomers() {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM customers";
			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			List<Customer> cList = new ArrayList<>();
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

				cList.add(customer);
			}
			return cList;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean approveAccount(int id) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "UPDATE customers SET active = true WHERE id = ?";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);

			statement.executeUpdate();

			log.info("Customer's account at id " + id + " was approved. \n");

			return true;
		} catch (SQLException e) {
			e.printStackTrace();

		}

		return false;
	}

	@Override
	public boolean deleteAccount(int customerID) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "DELETE FROM customers WHERE id = " + customerID;

			PreparedStatement statement = conn.prepareStatement(sql);

//		statement.setInt(1, newBalance);
			statement.executeUpdate();

			return true;
		} catch (

		SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean depositAccount(Customer customer, int newBalance) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "UPDATE customers SET account_balance = account_balance + ? WHERE id =" + customer.getId();

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, newBalance);
			statement.executeUpdate();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean withdrawAccount(Customer customer, int newBalance) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "UPDATE customers SET account_balance = account_balance - ? WHERE id =" + customer.getId();

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, newBalance);
			statement.executeUpdate();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean withdrawTransfer(String firstName, int withdraw) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "UPDATE customers SET account_balance =  account_balance + ? WHERE first_name = " + "'"
					+ firstName + "'";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, withdraw);
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
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
	public Customer updateActive(int id) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "UPDATE customers SET active = true WHERE id = ?";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);

			statement.executeUpdate();
			Customer customer = new Customer();

			log.info("Customer's account at id " + id + " was approved. \n");

			return customer;
		} catch (SQLException e) {
			e.printStackTrace();

		}

		return null;
	}

}
