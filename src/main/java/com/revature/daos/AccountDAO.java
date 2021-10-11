package com.revature.daos;

import java.util.List;

import com.revature.models.Account;

public interface AccountDAO {

	public List<Account> findAll();

	public Account findAccount(String accountNo);

	public boolean addAccont(Account account);

	public Account updateAccount(int amount);

	public int deleteAccount(String accountNo);
}
