package com.app.bank.services;

import com.app.bank.dto.AccountDto;


public interface AccountService {

	AccountDto createAccount (AccountDto accountDto);
	AccountDto getAccountById(Long id);
	AccountDto depositAmount(Long id,double amount);
}
