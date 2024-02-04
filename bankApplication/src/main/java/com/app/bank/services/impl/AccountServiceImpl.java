package com.app.bank.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.bank.dto.AccountDto;
import com.app.bank.repositories.AccountRepository;
import com.app.bank.services.AccountService;

public class AccountServiceImpl implements AccountService{
	
	private final AccountRepository accountRepository;

    AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
