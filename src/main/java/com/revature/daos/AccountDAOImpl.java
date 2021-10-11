package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Account;
import com.revature.utils.ConnectionUtil;

public class AccountDAOImpl implements AccountDAO {

	@Override
	public List<Account> findAll() {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * from accounts";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);

			List<Account> accntList = new ArrayList<>();

			while (result.next()) {
				Account account = new Account();
				account.setAccountNo(result.getString("accountNo"));
				account.setCheckingBalance(result.getInt("checking_balance"));
				account.setSavingBalance(result.getInt("saving_balance"));
				accntList.add(account);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Account findAccount(String accountNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addAccont(Account account) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Account updateAccount(int amount) {
		// TODO Auto-generated method stub
		return null;
	}

	public int deleteAccount(String accountNo) {

		String SQL = "DELETE FROM accounts WHERE accountno = ?";

		int affectedrows = 0;

		try (Connection conn = ConnectionUtil.getConnection()) {

			PreparedStatement pstmt = conn.prepareStatement(SQL);

			pstmt.setString(1, accountNo);

			affectedrows = pstmt.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return affectedrows;
	}

}
