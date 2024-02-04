package com.app.bank.services.impl;



import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.bank.dto.AccountDto;
import com.app.bank.entities.Account;
import com.app.bank.entities.mapper.AccountMapper;
import com.app.bank.repositories.AccountRepository;
import com.app.bank.services.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	
	private final AccountRepository accountRepository;

    AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		
		Account account = AccountMapper.mapToAccount(accountDto);
		Account accountSaved=accountRepository.save(account);
		
		
		return AccountMapper.mapToAccountDto(accountSaved);
	}

	@Override
	public AccountDto getAccountById(Long id) {
		
		Account account = accountRepository
				.findById(id)
				.orElseThrow(()-> new RuntimeException("Account not exist"));
		
		return  AccountMapper.mapToAccountDto(account);
	}

	@Override
	public AccountDto depositAmount(Long id, double amount) {
		Account account = accountRepository
				.findById(id)
				.orElseThrow(()-> new RuntimeException("Account not exist"));
		double total=account.getBalance()+amount;
		account.setBalance(total);
		Account savedAcount=accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAcount);
	}

	@Override
	public AccountDto withDraw(Long id, double amount) {
		Account account = accountRepository
				.findById(id)
				.orElseThrow(()-> new RuntimeException("Account not exist"));
		
		if(account.getBalance() < amount) {
			throw new RuntimeException("Insuffisant amount");
		}
		double total= account.getBalance()- amount;
		account.setBalance(total);
		Account savedAcount=accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAcount);
	}

}
