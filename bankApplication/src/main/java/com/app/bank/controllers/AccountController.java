package com.app.bank.controllers;


import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.bank.dto.AccountDto;
import com.app.bank.services.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

	private final AccountService accountService;

    AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
	
    //add Account 
    
    @PostMapping	
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
    	
    	return new ResponseEntity<>(accountService.createAccount(accountDto),HttpStatus.CREATED);
    }
    
   @GetMapping("/{id}") 
  public ResponseEntity<AccountDto> getAccount(@PathVariable Long id){
	   
	   AccountDto accountDto =accountService.getAccountById(id);
    	
    	return ResponseEntity.ok(accountDto);
    }
    
   
   @PutMapping("/{id}/deposit")
   public ResponseEntity<AccountDto> depositAmount(@PathVariable Long id, @RequestBody Map<String, Double> request){
	   
	   double amount=request.get("amount");
	   AccountDto accountDto =accountService.depositAmount(id, amount);
	   return ResponseEntity.ok(accountDto);
   }
    
    
    
}
