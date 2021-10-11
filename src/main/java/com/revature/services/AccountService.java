package com.revature.services;

import java.util.List;

import com.revature.daos.AccountDAO;
import com.revature.daos.AccountDAOImpl;
import com.revature.models.Account;

public class AccountService {
	private static AccountDAO accountDao = new AccountDAOImpl();

	public List<Account> findAllAccounts() {
		return accountDao.findAll();
	}
}
