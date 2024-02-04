package com.app.bank.entities.mapper;

import com.app.bank.dto.AccountDto;
import com.app.bank.entities.Account;

public class AccountMapper {
	
	
	public static Account mapToAccount(AccountDto accountDto) {
		
		Account account = new Account(
				accountDto.getId(),
				accountDto.getAccountHolder(),
				accountDto.getBalance()
			
				);
		
		return account;
	}
	
	
	public static AccountDto mapToAccountDto(Account account) {
		
		AccountDto accountDto = new AccountDto(
				account.getId(),
				account.getAccountHolder(),
				account.getBalance()
			
				);
		
		return accountDto;
	}
	
}
